package com.adolphus.incident.controller.vo;

/**
 * Incident search request
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
public class IncidentSearchRequestVO {
    /** current page number */
    private int pageNumber;
    /** page size */
    private int pageSize;
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
}
