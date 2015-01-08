/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.common;

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
