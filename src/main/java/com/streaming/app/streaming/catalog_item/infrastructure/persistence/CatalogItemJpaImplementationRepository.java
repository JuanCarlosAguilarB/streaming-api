package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item.domain.CatalogItem;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemCreatedOrder;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemRepository;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemResponse;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import com.streaming.app.streaming.shared.domain.filter.Filter;
import com.streaming.app.streaming.shared.domain.sort.SortBy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.streaming.app.streaming.catalog_item.infrastructure.persistence.CatalogItemMapper.toEntity;

@Repository
@AllArgsConstructor
public class CatalogItemJpaImplementationRepository implements CatalogItemRepository {

    private final CatalogItemJpaRepository repository;
    private final EntityManager entityManager;

    @Override
    public void save(CatalogItem catalogItem) {
        CatalogItemEntity entity = toEntity(catalogItem);
        repository.save(entity);
    }

    @Override
    public Long count() {
        return repository.count();
    }


//    @Override
//    public Optional<CatalogItemResponse> findByCreatedOrder(CatalogItemCreatedOrder order, Optional<List<Filter>> filters) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<CatalogItemEntity> cq = cb.createQuery(CatalogItemEntity.class);
//        Root<CatalogItemEntity> catalogItem = cq.from(CatalogItemEntity.class);
//
//        List<Predicate> predicates = new ArrayList<>();
//
//        predicates.add(cb.equal(catalogItem.get("creationOrder"), order.value()));
//
//        if (filters.isPresent()) {
//            predicates.addAll(Arrays.asList(buildFilters(cb, catalogItem, filters.get())));
//        }
//
//        cq.where(predicates.toArray(new Predicate[0]));
//
//        TypedQuery<CatalogItemEntity> query = entityManager.createQuery(cq);
//        query.setMaxResults(1);  // Limitar el resultado a uno
//
//        return query.getResultList().stream().findFirst().map(CatalogItemMapper::toResponse);
//    }

    @Override
    public Optional<CatalogItemResponse> findByCreatedOrder(CatalogItemCreatedOrder order, Optional<List<Filter>> filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CatalogItemEntity> cq = cb.createQuery(CatalogItemEntity.class);
        Root<CatalogItemEntity> catalogItem = cq.from(CatalogItemEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filters.isPresent() && !filters.get().isEmpty()) {
            predicates.addAll(Arrays.asList(buildFilters(cb, catalogItem, filters.get())));

            cq.orderBy(cb.asc(cb.function("RANDOM", Double.class)));  // Función RANDOM() con asc para orden aleatorio
        } else {
            predicates.add(cb.equal(catalogItem.get("creationOrder"), order.value()));

            cq.orderBy(cb.asc(catalogItem.get("creationOrder")));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<CatalogItemEntity> query = entityManager.createQuery(cq);
        query.setMaxResults(1);  // Limitar el resultado a 1

        return query.getResultList().stream().findFirst().map(CatalogItemMapper::toResponse);
    }



    @Override
    public PageResult<CatalogItemResponse> findAll(PaginationRequest paginationRequest) {

        SortBy sort = paginationRequest.getSort();
        List<Filter> filters = paginationRequest.getFilters();

        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize());

        Page<CatalogItemEntity> page = findWithFiltersAndSort(filters, sort, pageable);

        PageResult<CatalogItemResponse> response = new PageResult<>(
                page.stream().map(CatalogItemMapper::toResponse).toList(),
                paginationRequest.getPage(),
                paginationRequest.getSize(),
                page.getTotalElements()
        );

        return response;
    }

//    private HashMap<String, String> getSort(String sortBy, String sortDirection) {
//        HashMap<String, String> sortByMap = new HashMap<>();
//
//        if (sortDirection == null || (!sortDirection.equals("ASC") && !sortDirection.equals("DESC"))) {
//            sortDirection = "DESC";
//        }
//
//        if (sortBy == null || sortBy.isEmpty()) {
//            sortByMap.put("title", sortDirection);
//            return sortByMap;
//        }
//
//        if (sortBy.equals("title") || sortBy.equals("genreId") || sortBy.equals("typeId") || sortBy.equals("averageScore")) {
//            sortByMap.put(sortBy, sortDirection);
//        } else {
//            sortByMap.put("title", sortDirection);
//        }
//
//        return sortByMap;
//    }


    public Page<CatalogItemEntity> findWithFiltersAndSort(List<Filter> filters, SortBy sort, Pageable pageable) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CatalogItemEntity> cq = cb.createQuery(CatalogItemEntity.class);
        Root<CatalogItemEntity> catalogItem = cq.from(CatalogItemEntity.class);

        // Build dynamic filter conditions
        Predicate[] predicates = buildFilters(cb, catalogItem, filters);
        cq.where(predicates);

        if (sort != null) {
            List<Order> orders = new ArrayList<>();
            if (sort.direction().equalsIgnoreCase("ASC")) {
                orders.add(cb.asc(catalogItem.get(sort.sort())));
            } else {
                orders.add(cb.desc(catalogItem.get(sort.sort())));
            }

            cq.orderBy(orders);
        }

        TypedQuery<CatalogItemEntity> query = entityManager.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        // Fetch the results and count total elements
        List<CatalogItemEntity> resultList = query.getResultList();
        long totalRecords = countTotalRecords(filters);

        return new PageImpl<>(resultList, pageable, totalRecords);
    }

    private Predicate[] buildFilters(CriteriaBuilder cb, Root<CatalogItemEntity> root, List<Filter> filters) {
        List<Predicate> predicates = new ArrayList<>();

        filters.forEach((filter) -> {
            switch (filter.name()) {
                case "title":
//                    predicates.add(cb.like(root.get("title"), "%" + value + "%"));
                    predicates.add(cb.like(cb.lower(root.get("title")), "%" + filter.value().toString().toLowerCase() + "%"));
                    break;
                case "genreId":
                    predicates.add(cb.equal(root.get("genreId"), filter.value()));
                    break;
                case "typeId":
                    predicates.add(cb.equal(root.get("typeId"), filter.value()));
                    break;
                case "averageScore":
//                    predicates.add(cb.greaterThanOrEqualTo(root.get("averageScore"), (Double) filter.value()));

                    Double minScore = (double) filter.value();
                    Double maxScore = minScore + 0.99;
                    predicates.add(cb.between(root.get("averageScore"), minScore, maxScore));
                    break;
                default:
                    break;
            }
        });

        return predicates.toArray(new Predicate[0]);
    }

    private long countTotalRecords(List<Filter> filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CatalogItemEntity> root = cq.from(CatalogItemEntity.class);

        // Apply filters
        Predicate[] predicates = buildFilters(cb, root, filters);
        cq.select(cb.count(root)).where(predicates);

        return entityManager.createQuery(cq).getSingleResult();
    }


}
