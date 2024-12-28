package com.adolphus.incident.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adolphus.incident.model.entity.Incident;

/**
 * Incident repository
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
@Repository
public interface IncidentRepository extends JpaRepository<Incident,Long> {

}
