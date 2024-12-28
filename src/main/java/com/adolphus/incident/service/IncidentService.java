package com.adolphus.incident.service;


import org.springframework.data.domain.Page;

import com.adolphus.incident.model.entity.Incident;

/**
 * Incident service interface
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
public interface IncidentService {
    /**
     * save new incident
     * @param incident
     * @return
     */
    void save(Incident incident);
    /**
     * delete exists incident
     * @param id
     * @return
     */
    void delete(Long id);
    /**
     * update exists incident
     * @param incident
     * @return
     */
    void update(Incident incident);
    /**
     * get one incident by id
     * @param id
     * @return
     */
    Incident get(Long id);
    /**
     * search incident list by given condition
     * @return
     */
    Page<Incident> search(int pageNumber, int pageSize);
}
