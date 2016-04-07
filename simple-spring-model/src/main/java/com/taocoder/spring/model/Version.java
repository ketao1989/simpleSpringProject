/*
 * Copyright (c) 2016 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: tao.ke Date: 14-5-26 Time: 上午11:01
 * @version: \$Id$
 */
public class Version implements Serializable {

    private static final long serialVersionUID = -5772981014618698881L;

    /**
     * version 的数据库id
     */
    private int id;

    /**
     * version 版本号
     */
    private String versionNum;

    /**
     * 版本相关描述信息
     */
    private String description;

    /**
     * 版本信息更新时间
     */
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
