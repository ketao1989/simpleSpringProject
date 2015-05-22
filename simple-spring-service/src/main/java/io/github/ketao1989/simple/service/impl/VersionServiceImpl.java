/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.simple.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import io.github.ketao1989.model.Version;
import io.github.ketao1989.simple.service.VersionService;
import io.github.ketao1989.dao.VersionDao;
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
