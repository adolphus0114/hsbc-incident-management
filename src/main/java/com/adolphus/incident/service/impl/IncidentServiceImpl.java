package com.adolphus.incident.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.adolphus.incident.exception.BusinessError;
import com.adolphus.incident.exception.BusinessException;
import com.adolphus.incident.model.entity.Incident;
import com.adolphus.incident.model.repo.IncidentRepository;
import com.adolphus.incident.service.IncidentService;


/**
 * Implementation of IncidentService
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
@Service
public class IncidentServiceImpl implements IncidentService {

    private static final Logger logger = LoggerFactory.getLogger(IncidentServiceImpl.class);

    @Autowired
    private IncidentRepository repository;

    @Override
    public void save(Incident incident) {
        repository.save(incident);
    }

    @Override
    public void delete(Long id) {
        boolean exists = repository.existsById(id);
        if(!exists){
            logger.error(BusinessError.ID_NOT_EXISTS.message(), id);
            throw BusinessException.build(BusinessError.ID_NOT_EXISTS, id);
        }

        repository.deleteById(id);
    }

    @Override
    public void update(Incident incident) {
        boolean exists = repository.existsById(incident.getId());
        if(!exists){
            throw BusinessException.build(BusinessError.ID_NOT_EXISTS, incident.getId());
        }
        repository.save(incident);
    }

    @Override
    public Incident get(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Page<Incident> search(int pageNumber, int pageSize) {
        return repository.findAll(PageRequest.of(pageNumber-1, pageSize));
    }

}
