package com.adolphus.incident.controller.vo;

/**
 * incident search response vo
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
public class IncidentSearchResponseVO extends BaseIncidentVO{
    /** incident id */
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
