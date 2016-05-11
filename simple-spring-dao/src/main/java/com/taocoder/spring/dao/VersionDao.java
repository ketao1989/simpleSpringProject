/*
 * Copyright (c) 2016 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.dao;

import com.taocoder.spring.common.DBSource;
import com.taocoder.spring.model.Version;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: tao.ke Date: 14-5-26 Time: 上午11:28
 * @version: \$Id$
 */
public interface VersionDao {

    /**
     * 根据id 查询对应的version信息
     * 
     * @param id
     * @return
     */
    @DBSource("master")
    Version queryVersionById(@Param("id") int id);

    /**
     * 查询所有的版本信息
     * 
     * @return
     */
    @DBSource("slave")
    List<Version> queryAllVersions(RowBounds rowBounds);

    /**
     * 更新id的描述字段
     * 
     * @param id
     * @param description
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRED)
    int updateVersion(@Param("id") int id, @Param("description") String description);

}
