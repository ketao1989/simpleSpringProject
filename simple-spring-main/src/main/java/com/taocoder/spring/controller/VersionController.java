/*
 * Copyright (c) 2016 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.controller;

import javax.annotation.Resource;

import com.taocoder.spring.api.VersionBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taocoder.spring.model.Version;
import com.taocoder.spring.controller.support.ApiResult;

import java.util.List;

/**
 * @author: tao.ke Date: 14-5-23 Time: 上午10:52
 * @version: \$Id$
 */
@Controller
@RequestMapping("version")
public class VersionController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private VersionBiz versionBizImpl;

    @RequestMapping("query.json")
    @ResponseBody
    public ApiResult query(@RequestParam(value = "id", defaultValue = "0", required = false) int id) {

        ApiResult<Object> apiResult = new ApiResult<Object>();
        if (id == 0) {
            logger.warn("请求版本信息的id未指定！");
            apiResult.setCode(-1);
            apiResult.setRet(false);
            apiResult.setErrmsg("版本id 没有指定！");
            List<Version> version = versionBizImpl.queryAllVersions();
            apiResult.setData(version);
            return apiResult;

        } else {
            logger.info("指定请求版本id：{}的信息", id);
            Version version = versionBizImpl.queryVersionById(id);
            apiResult.setCode(0);
            apiResult.setRet(true);
            apiResult.setData(version);
            return apiResult;
        }
    }

    @RequestMapping("updateDesc.json")
    @ResponseBody
    public ApiResult updateDesc(@RequestParam(value = "id", defaultValue = "0", required = false) int id,@RequestParam(value = "desc")String desc){
        versionBizImpl.UpdateVersionDesc(id,desc);
        return new ApiResult();
    }
}
