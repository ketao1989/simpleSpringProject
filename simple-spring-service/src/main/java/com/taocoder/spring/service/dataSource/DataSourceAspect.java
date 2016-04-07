/*
 * Copyright (c) 2016 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.service.dataSource;

import com.taocoder.spring.common.DBSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author tao.ke Date: 15-1-8 Time: 下午4:52
 * @version \$Id$
 */
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    public void before(JoinPoint point) {

        Object target = point.getTarget();
        String method = point.getSignature().getName();

        Class<?>[] classz = target.getClass().getInterfaces();

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DBSource.class)) {
                DBSource data = m.getAnnotation(DBSource.class);
                DynamicDataSourceHolder.putDataSource(data.value());
                logger.info("-------数据源：{}------",data.value());
            }

        } catch (Exception e) {
            logger.error("=======================AOP注册拦截失败了！",e);
        }
    }

    public void after(JoinPoint point){

        Object target = point.getTarget();
        String method = point.getSignature().getName();

        Class<?>[] classz = target.getClass().getInterfaces();

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DBSource.class)) {
                DynamicDataSourceHolder.clear();
                logger.info("-------清除ThreadLocal------");
            }

        } catch (Exception e) {
            logger.error("=======================AOP注册拦截失败了！",e);
        }
    }
}
