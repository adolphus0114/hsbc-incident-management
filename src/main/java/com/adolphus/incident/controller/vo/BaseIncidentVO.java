package com.adolphus.incident.controller.vo;

import java.util.Date;

/**
 * Base incident vo
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
public class BaseIncidentVO {
    /** Incident title */
    private String title;
    /** type */
    private String type;
    /** location */
    private String location;
    /** description */
    private String description;
    /** create user */
    private String createUser;
    /** create datetime */
    private Date createDatetime;
    /** update user */
    private String updateUser;
    /** update datetime */
    private Date updateDatetime;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public Date getCreateDatetime() {
        return createDatetime;
    }
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }
    public String getUpdateUser() {
        return updateUser;
    }
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    public Date getUpdateDatetime() {
        return updateDatetime;
    }
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
}
