/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.simple.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import io.github.ketao1989.model.Version;
import io.github.ketao1989.simple.service.VersionService;
import io.github.ketao1989.dao.VersionDao;
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

    @Override
    public Version queryVersionById(int id) {
        return versionDao.queryVersionById(id);
    }

    @Override
    public List<Version> queryAllVersions() {
        return versionDao.queryAllVersions();
    }

    @Override
    public List<Integer> queryAllVersionIds() {
        List<Version> versions = queryAllVersions();
        return Lists.transform(versions, new Function<Version, Integer>() {
            @Override
            public Integer apply(Version input) {
                return input.getId();
            }
        });
    }
}
