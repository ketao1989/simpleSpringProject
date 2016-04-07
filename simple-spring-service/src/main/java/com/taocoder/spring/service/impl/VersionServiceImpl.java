/*
 * Copyright (c) 2016 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.taocoder.spring.model.Version;
import com.taocoder.spring.service.VersionService;
import com.taocoder.spring.dao.VersionDao;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: tao.ke Date: 14-5-26 Time: 上午11:26
 * @version: \$Id$
 */
@Service
public class VersionServiceImpl implements VersionService {

    private final Logger logger = LoggerFactory.getLogger(VersionServiceImpl.class);

    @Resource
    private VersionDao versionDao;


    public Version queryVersionById(int id) {
        logger.info("queryVersionById:{}",id);
        return versionDao.queryVersionById(id);
    }


    public List<Version> queryAllVersions() {
        logger.info("queryAllVersions");
        return versionDao.queryAllVersions(new RowBounds(1,1));
    }


    public List<Integer> queryAllVersionIds() {
        List<Version> versions = queryAllVersions();
        return Lists.transform(versions, new Function<Version, Integer>() {
            public Integer apply(Version input) {
                return input.getId();
            }
        });
    }

    public int UpdateVersionDesc(int id , String desc){

        return versionDao.updateVersion(id,desc);
    }
}
