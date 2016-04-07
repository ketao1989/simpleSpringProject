/*
 * Copyright (c) 2016 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.service.dataSource;

/**
 * @author tao.ke Date: 15-1-8 Time: 下午4:45
 * @version \$Id$
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> dsHolder = new ThreadLocal<String>();

    public static String getDataSource() {
        return dsHolder.get();
    }

    public static void putDataSource(String value) {
        dsHolder.set(value);
    }

    public static void clear(){
        dsHolder.remove();
    }
}
