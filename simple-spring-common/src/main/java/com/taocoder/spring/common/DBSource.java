/*
 * Copyright (c) 2016 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tao.ke Date: 15-1-8 Time: 下午4:32
 * @version \$Id$
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DBSource {

    /**
     * 指定数据源使用哪个配置
     */
    String value();
}
