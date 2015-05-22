package io.github.ketao1989.dao.plugins;

import io.github.ketao1989.common.exception.BusinessException;
import io.github.ketao1989.common.json.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author: tao.ke Date: 15-5-21 Time: 下午10:08
 * @version: \$Id$
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class }) })
public class NoConditionModifyInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(NoConditionModifyInterceptor.class);

    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object params = invocation.getArgs()[1];
        BoundSql boundSql = mappedStatement.getBoundSql(params);
        String sql = boundSql.getSql();

        boolean valid = true;

        if (SqlCommandType.SELECT == mappedStatement.getSqlCommandType()) {
            valid = doCheckSqlForQuery(sql, invocation);
        } else {
            valid = doCheckSqlForUpdate(sql);
        }

        if (valid) {
            return invocation.proceed();
        } else {
            // 监控报警

            // 日志信息
            logger.error("bad sql because of no condition where update or query. sql is :{}", sql);
            // 抛出异常
            throw new BusinessException("bad sql because of no condition where update or query");
        }

    }

    /**
     * 检查sql有木有限制条件
     * 
     * @param sql
     * @param invocation
     * @return
     */
    private boolean doCheckSqlForQuery(String sql, Invocation invocation) {

        // 加where判断
        if (StringUtils.contains(sql, "where")) {
            return true;
        }

        // 使用limit限制
        if (StringUtils.contains(sql, "limit")) {
            return true;
        }

        // 使用mybatis的分页功能
        RowBounds rowBounds = (RowBounds) invocation.getArgs()[2];
        if (rowBounds != null) {
            return true;
        }

        return false;
    }

    /**
     * 检查sql是否没有where条件
     * 
     * @param sql
     */
    private boolean doCheckSqlForUpdate(String sql) {

        return StringUtils.contains(sql, "where");

    }

    public Object plugin(Object target) {

        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}
