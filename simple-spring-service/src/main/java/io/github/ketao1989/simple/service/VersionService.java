/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.simple.service;

import io.github.ketao1989.model.Version;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author: tao.ke Date: 14-5-26 Time: 下午3:06
 * @version: \$Id$
 */
public interface VersionService {

    /**
     * 根据 id 查询版本信息
     * 
     * @param id
     * @return
     */
    Version queryVersionById(int id);

    /**
     * 查询所有版本信息
     * 
     * @return
     */
    List<Version> queryAllVersions();

    /**
     * 查询所有的版本id
     * 
     * @return
     */
    List<Integer> queryAllVersionIds();


    int UpdateVersionDesc(int id , String desc);

}
