package com.streaming.app.streaming.shared.domain;

import com.streaming.app.streaming.shared.domain.filter.Filter;
import com.streaming.app.streaming.shared.domain.sort.SortBy;
import lombok.Data;

import java.util.List;


@Data
public class PaginationRequest {

    private int page;
    private int size;
    private String sortBy;
    private List<Filter> filters;
    private SortBy sort;


    public PaginationRequest(int pageNumber, int pageSize, String sortBy, SortBy sort, List<Filter> filters) {
        this.filters = filters;
        this.sort = sort;
        this.sortBy = sortBy;
        this.page = pageNumber;
        this.size = pageSize;
    }

    public PaginationRequest(int pageNumber, int pageSize, String sortBy, SortBy sort) {
        this.sort = sort;
        this.sortBy = sortBy;
        this.page = pageNumber;
        this.size = pageSize;
    }

    public PaginationRequest(int pageNumber, int pageSize) {
        this.page = pageNumber;
        this.size = pageSize;
    }

    // we do this because we want that the pagination start from index 0, but for our clients
    // our pagination start from 1 --> page = 1
    public int getPage() {
        return page - 1;
    }

    public int getOffset() {
        return (page - 1) * size;
    }

}

