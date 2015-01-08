/*
* Copyright (c) 2014 Qunar.com. All Rights Reserved.
*/
package io.github.ketao1989.simple.service.dataSource;

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
