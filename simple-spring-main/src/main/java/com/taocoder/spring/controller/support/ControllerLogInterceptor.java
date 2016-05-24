/*
 * Copyright (c) 2015 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.controller.support;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taocoder.spring.common.json.JsonUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Annotation;

/**
 * @author tao.ke Date: 16/5/24 Time: 下午11:34
 */
public class ControllerLogInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        for (Annotation annotation : invocation.getMethod().getAnnotations()){
            if (annotation.annotationType().isAssignableFrom(ResponseBody.class)){
                Object ret = invocation.proceed();
                LOGGER.info("aop log--{}", JsonUtils.encode(ret));
                return ret;
            }
        }
        return  invocation.proceed();

    }
}
