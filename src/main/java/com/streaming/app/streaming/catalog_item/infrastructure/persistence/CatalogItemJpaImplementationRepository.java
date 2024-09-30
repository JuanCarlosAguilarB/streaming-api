package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item.domain.*;
import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.*;

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


    @Override
    public Optional<CatalogItemResponse> findByCreatedOrder(CatalogItemCreatedOrder order) {
        return repository.findByCreationOrder(order.value()).map(CatalogItemMapper::toResponse);
    }

    @Override
    public PageResult<CatalogItemResponse> findByTitle(CatalogItemTitle title, PaginationRequest paginationRequest) {

//        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy(), ));
//
//        Page<CatalogItemEntity> page = repository.findByTitleContainingIgnoreCase(title.value(), pageable);
//        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
//                page.stream().map(CatalogItemMapper::toResponse).toList(),
//                paginationRequest.getPage(),
//                paginationRequest.getSize(),
//                page.getTotalElements()
//        );
//
//        return response;
        return null;
    }

    @Override
    public PageResult<CatalogItemResponse> findByGenreId(CatalogItemGenreId genreId, PaginationRequest paginationRequest) {
//        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
//        Page<CatalogItemEntity> page = repository.findByGenreId(genreId.value(), pageable);
//
//        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
//                page.stream().map(CatalogItemMapper::toResponse).toList(),
//                paginationRequest.getPage(),
//                paginationRequest.getSize(),
//                page.getTotalElements()
//        );
//
//        return response;
        return null;
    }

    @Override
    public PageResult<CatalogItemResponse> findByTypeId(CatalogItemTypeId typeId, PaginationRequest paginationRequest) {
//        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
//        Page<CatalogItemEntity> page = repository.findByTypeId(typeId.value(), pageable);
//
//        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
//                page.stream().map(CatalogItemMapper::toResponse).toList(),
//                paginationRequest.getPage(),
//                paginationRequest.getSize(),
//                page.getTotalElements()
//        );
        return null;
//        return response;
    }

    @Override
    public PageResult<CatalogItemResponse> findByAverageScoreBetween(CatalogItemAverageScore minScore, CatalogItemAverageScore maxScore, PaginationRequest paginationRequest) {
//        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
//        Page<CatalogItemEntity> page = repository.findByAverageScoreBetween(minScore.value(), maxScore.value(), pageable);
//
//        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
//                page.stream().map(CatalogItemMapper::toResponse).toList(),
//                paginationRequest.getPage(),
//                paginationRequest.getSize(),
//                page.getTotalElements()
//        );
//
//        return response;
    return null;

    }


    @Override
    public PageResult<CatalogItemResponse> findByTitleAndTypeIdAndGenreId(CatalogItemTitle title, CatalogItemGenreId genreId, CatalogItemTypeId typeId, PaginationRequest paginationRequest) {

//        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
//        Page<CatalogItemEntity> page = repository.findByTitleAndTypeIdAndGenreId(title.value(), typeId.value(), genreId.value(), pageable);
//
//        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
//                page.stream().map(CatalogItemMapper::toResponse).toList(),
//                paginationRequest.getPage(),
//                paginationRequest.getSize(),
//                page.getTotalElements()
//        );
        return null;
//        return response;
    }

//    @Override
//    public PageResult<CatalogItemResponse> findAll(PaginationRequest paginationRequest) {
//
//        HashMap<String, String> sort = getSort(paginationRequest.getSortBy(), paginationRequest.getSort());
//        HashMap<String, Object> filter = getFilter(paginationRequest.getFilters());
//
//        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
//
//
//
//        Page<CatalogItemEntity> page = repository.findAll(pageable);
//
//        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
//                page.stream().map(CatalogItemMapper::toResponse).toList(),
//                paginationRequest.getPage(),
//                paginationRequest.getSize(),
//                page.getTotalElements()
//        );
//
//        return response;
//    }

    @Override
    public PageResult<CatalogItemResponse> findAll(PaginationRequest paginationRequest) {
        HashMap<String, String> sort = getSort(paginationRequest.getSortBy(), paginationRequest.getSort());
        HashMap<String, Object> filter = getFilter(paginationRequest.getFilters());

        System.out.println(paginationRequest.getFilters());
//        System.out.println(sort);
        System.out.println(filter);
//        System.out.println(paginationRequest.getSortBy());
//        System.out.println(paginationRequest.getSort());


        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize());

        Page<CatalogItemEntity> page = findWithFiltersAndSort(filter, sort, pageable);

        PageResult<CatalogItemResponse> response = new PageResult<>(
                page.stream().map(CatalogItemMapper::toResponse).toList(),
                paginationRequest.getPage(),
                paginationRequest.getSize(),
                page.getTotalElements()
        );

        return response;
    }

    private HashMap<String, String> getSort(String sortBy, String sortDirection) {
        HashMap<String, String> sortByMap = new HashMap<>();

        if (sortDirection == null || (!sortDirection.equals("ASC") && !sortDirection.equals("DESC"))) {
            sortDirection = "DESC";
        }

        if (sortBy == null || sortBy.isEmpty()) {
            sortByMap.put("title", sortDirection);
            return sortByMap;
        }

        if (sortBy.equals("title") || sortBy.equals("genreId") || sortBy.equals("typeId") || sortBy.equals("averageScore")) {
            sortByMap.put(sortBy, sortDirection);
        } else {
            sortByMap.put("title", sortDirection);
        }

        return sortByMap;
    }

private HashMap<String, Object> getFilter(HashMap<String, Object> filters) {
    HashMap<String, Object> filterByMap = new HashMap<>();

    filters.forEach((key, value) -> {
        switch (key) {
            case "title":
                ensureNotSqlInjection((String) value);
                filterByMap.put(key, (String) value);
                break;
            case "genreId":
                filterByMap.put(key, (Integer) value);
                break;
            case "typeId":
                filterByMap.put(key, (Integer) value);
                break;
            case "averageScore":
                filterByMap.put(key, (Double) value);
                break;
        };
      });
    return filterByMap;

    }

    private void ensureNotSqlInjection(String value) {
        if (value.contains(";") || value.contains("'") || value.contains("\"")) {
            throw new IllegalArgumentException("Name cannot contain illegal characters");
        }
    }


    public Page<CatalogItemEntity> findWithFiltersAndSort(HashMap<String, Object> filters, HashMap<String, String> sort, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CatalogItemEntity> cq = cb.createQuery(CatalogItemEntity.class);
        Root<CatalogItemEntity> catalogItem = cq.from(CatalogItemEntity.class);

        // Build dynamic filter conditions
        Predicate[] predicates = buildFilters(cb, catalogItem, filters);
        cq.where(predicates);

        // Apply dynamic sorting
        if (!sort.isEmpty()) {
            List<Order> orders = new ArrayList<>();
            sort.forEach((field, direction) -> {
                if (direction.equalsIgnoreCase("ASC")) {
                    orders.add(cb.asc(catalogItem.get(field)));
                } else {
                    orders.add(cb.desc(catalogItem.get(field)));
                }
            });
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

    private Predicate[] buildFilters(CriteriaBuilder cb, Root<CatalogItemEntity> root, HashMap<String, Object> filters) {
        List<Predicate> predicates = new ArrayList<>();

        filters.forEach((key, value) -> {
            switch (key) {
                case "title":
//                    predicates.add(cb.like(root.get("title"), "%" + value + "%"));
                    predicates.add(cb.like(cb.lower(root.get("title")), "%" + value.toString().toLowerCase() + "%"));
                    break;
                case "genreId":
                    predicates.add(cb.equal(root.get("genreId"), value));
                    break;
                case "typeId":
                    predicates.add(cb.equal(root.get("typeId"), value));
                    break;
                case "averageScore":
                    predicates.add(cb.greaterThanOrEqualTo(root.get("averageScore"), (Double) value));
                    break;
                default:
                    break;
            }
        });

        return predicates.toArray(new Predicate[0]);
    }

    private long countTotalRecords(HashMap<String, Object> filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CatalogItemEntity> root = cq.from(CatalogItemEntity.class);

        // Apply filters
        Predicate[] predicates = buildFilters(cb, root, filters);
        cq.select(cb.count(root)).where(predicates);

        return entityManager.createQuery(cq).getSingleResult();
    }


}
