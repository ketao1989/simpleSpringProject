/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.simple.api;

import io.github.ketao1989.model.Version;

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

}
