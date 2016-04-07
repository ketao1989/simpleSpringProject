/*
 * Copyright (c) 2016 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.api;

import com.taocoder.spring.model.Version;

import java.util.List;

/**
 * @author: tao.ke Date: 14-5-26 Time: 上午11:00
 * @version: \$Id$
 */
public interface VersionBiz {

    /**
     * 获取版本信息
     */
    Version queryVersionById(int id);

    /**
     * 获取所有版本信息列表
     */
    List<Version> queryAllVersions();

    int UpdateVersionDesc(int id , String desc);

}
