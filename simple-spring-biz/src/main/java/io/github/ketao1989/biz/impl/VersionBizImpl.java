/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import io.github.ketao1989.common.Constant;
import io.github.ketao1989.model.Version;
import io.github.ketao1989.simple.api.VersionBiz;
import io.github.ketao1989.simple.service.VersionService;

/**
 * @author: tao.ke Date: 14-5-26 Time: 上午11:17
 * @version: \$Id$
 */
@Service("versionBizImpl")
public class VersionBizImpl implements VersionBiz {

    @Resource
    private VersionService versionServiceImpl;

    public Version queryVersionById(int id) {
        // 业务相关的组合，调用service层

        // 首先判断id是否存在
//        List<Integer> ids = versionServiceImpl.queryAllVersionIds();
//        if (ids != null && ids.contains(id)) {
//            return versionServiceImpl.queryVersionById(id);
//        }
//        id = Constant.DEFAULT_VERSION_ID;
        return versionServiceImpl.queryVersionById(id);

    }

    public List<Version> queryAllVersions() {
        return versionServiceImpl.queryAllVersions();
    }

    public int UpdateVersionDesc(int id, String desc) {
        return versionServiceImpl.UpdateVersionDesc(id,desc);
    }


}
