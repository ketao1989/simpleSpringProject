package io.github.ketao1989.support.filter;

import javax.servlet.annotation.WebFilter;

/**
 * @author: tao.ke Date: 15-5-15 Time: 下午3:51
 * @version: \$Id$
 */
@WebFilter(filterName = "mdcLogFilter", urlPatterns = { "*.htm", "*.json" })
public class MdcLogFilterImpl extends MdcLogFilter {

    @Override
    protected String buildRequestStr() {
        return System.currentTimeMillis() + Thread.currentThread().getName() + "======";
    }
}
