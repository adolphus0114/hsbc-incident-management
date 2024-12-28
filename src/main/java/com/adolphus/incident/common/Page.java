package com.adolphus.incident.common;

import java.util.List;

/**
 * 
 * @author Zhang Chi
 * @date 2024-12-27
 */
public class Page<T> {
    private int pageNumber;
    private int pageSize;
    private long total;
    private List<T> list;

    public Page(int pageNumber, int pageSize, long total, List<T> list) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    
}
