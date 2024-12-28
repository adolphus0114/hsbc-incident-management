package com.adolphus.incident.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adolphus.incident.common.Page;
import com.adolphus.incident.common.Result;
import com.adolphus.incident.controller.vo.IncidentCreateRequestVO;
import com.adolphus.incident.controller.vo.IncidentSearchRequestVO;
import com.adolphus.incident.controller.vo.IncidentSearchResponseVO;
import com.adolphus.incident.controller.vo.IncidentUpdateRequestVO;
import com.adolphus.incident.model.entity.Incident;
import com.adolphus.incident.service.IncidentService;
import com.adolphus.incident.util.PageUtil;

/**
 * Incident manange controller
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
@RequestMapping("incident")
@RestController
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    /**
     * Api for create incident
     * @return
     */
    @PostMapping
    public Result<Void> create(@RequestBody IncidentCreateRequestVO requestVO){
        Incident incident = new Incident();
        BeanUtils.copyProperties(requestVO, incident);
        incidentService.save(incident);
        return Result.success();
    }

    /**
     * Api for create incident
     * @return
     */
    @PutMapping
    public Result<Void> update(@RequestBody IncidentUpdateRequestVO requestVO){
        Incident incident = new Incident();
        BeanUtils.copyProperties(requestVO, incident);
        incidentService.update(incident);
        return Result.success();
    }

    /**
     * Api for create incident
     * @return
     */
    @GetMapping("/{id}")
    public Result<IncidentSearchResponseVO> get(@PathVariable(required = true) Long id){
        Incident incident = incidentService.get(id);
        IncidentSearchResponseVO responseVO = new IncidentSearchResponseVO();
        BeanUtils.copyProperties(incident, responseVO);
        return Result.success(responseVO);
    }

    /**
     * Api for create incident
     * @return
     */
    @GetMapping
    public Result<Page<IncidentSearchResponseVO>> search(IncidentSearchRequestVO requestVO){
        Page<IncidentSearchResponseVO> page = PageUtil.toPage(incidentService.search(requestVO.getPageNumber(), requestVO.getPageSize()), IncidentSearchResponseVO.class);
        return Result.success(page);
    }

    /**
     * Api for delete incident
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable(required = true) Long id){
        incidentService.delete(id);
        return Result.success();
    }
}
