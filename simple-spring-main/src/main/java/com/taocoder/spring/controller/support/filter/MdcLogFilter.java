package com.taocoder.spring.controller.support.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * 全局拦截，添加访问信息，使用servlet 3.0 的注解配置
 * 
 * @author: tao.ke Date: 15-5-15 Time: 下午3:19
 * @version: \$Id$
 */

public class MdcLogFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MdcLogFilter.class);

    public static final String REQUEST_ID = "REQUEST_ID";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        MDC.put(REQUEST_ID, buildRequestStr());
        logger.info("current request id is :{} .", MDC.get(REQUEST_ID));
        chain.doFilter(request, response);
        // try catch better
        MDC.clear();
    }

    @Override
    public void destroy() {

    }

    /**
     * 子类可以重写该字符串，展示在log中
     * 
     * @return
     */
    protected String buildRequestStr() {
        return System.currentTimeMillis() + Thread.currentThread().getName();
    }
}
