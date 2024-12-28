package com.adolphus.incident.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.adolphus.Application;
import com.adolphus.incident.controller.vo.IncidentCreateRequestVO;
import com.adolphus.incident.controller.vo.IncidentUpdateRequestVO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test case for controller
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IncidentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * test create incident
     * @throws Exception
     */
    @Test
    @Order(1)
    public void testCreate() throws Exception {
        IncidentCreateRequestVO requestVO = new IncidentCreateRequestVO();
        requestVO.setTitle("test incident");
        requestVO.setType("security incident");
        requestVO.setLocation("shanghai");
        requestVO.setDescription("this is a demo.");

        mockMvc.perform(MockMvcRequestBuilders.post("/incident")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(requestVO))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
            .andDo(MockMvcResultHandlers.print());
    }

    /**
     * test update incident success
     * @throws Exception
     */
    @Test
    @Order(2)
    public void testUpdateSuccess() throws Exception {
        IncidentUpdateRequestVO requestVO = new IncidentUpdateRequestVO();
        requestVO.setId(1L);
        requestVO.setTitle("test update incident");
        requestVO.setType("health incident");

        mockMvc.perform(MockMvcRequestBuilders.put("/incident")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(requestVO))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
            .andDo(MockMvcResultHandlers.print());
    }

    /**
     * test update incident failed
     */
    @Test
    @Order(3)
    public void testUpdateFailed() throws Exception {
        IncidentUpdateRequestVO requestVO = new IncidentUpdateRequestVO();
        requestVO.setId(2L);
        requestVO.setTitle("test update incident failed.");

        mockMvc.perform(MockMvcRequestBuilders.put("/incident")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(requestVO))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("1"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("id 2 is not exists."))
            .andDo(MockMvcResultHandlers.print());
    }

    /**
     * test get incident by id
     * @throws Exception
     */
    @Test
    @Order(4)
    public void testGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/incident/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.title").value("test update incident"))
            .andDo(MockMvcResultHandlers.print());
    }

    /**
     * test delete incident success
     * @throws Exception
     */
    @Test
    @Order(5)
    public void testDeleteSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/incident/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
            .andDo(MockMvcResultHandlers.print());
    }

    /**
     * test delete incident failed
     * @throws Exception
     */
    @Test
    @Order(6)
    public void testDeleteFailed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/incident/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("1"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("id 1 is not exists."))
            .andDo(MockMvcResultHandlers.print());
    }

    /**
     * test search incident by pageNumber and pageSize
     * @throws Exception
     */
    @Test
    @Order(7)
    public void testSearch() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/incident?pageNumber=1&pageSize=10")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.total").value("0")) // the first created incident is deleted
            .andDo(MockMvcResultHandlers.print());
        
        // create two incidents
        testCreate();
        testCreate();
        mockMvc.perform(MockMvcRequestBuilders.get("/incident?pageNumber=1&pageSize=10")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.total").value("2")) // now there are 2 incidents
            .andDo(MockMvcResultHandlers.print());
    }
}
