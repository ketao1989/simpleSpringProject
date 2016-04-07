/*
* Copyright (c) 2016 taocoder.com. All Rights Reserved.
*/
package com.taocoder.spring.service.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author tao.ke Date: 15-1-8 Time: 下午4:36
 * @version \$Id$
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        return DynamicDataSourceHolder.getDataSource();
    }
}
