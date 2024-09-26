package com.streaming.app.streaming.shared.domain;

import lombok.Data;


@Data
public class PaginationRequest {

    private int page;
    private int size;
    private String sortBy;

    public PaginationRequest(int pageNumber, int pageSize, String sortBy) {
        this.sortBy = sortBy;
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

