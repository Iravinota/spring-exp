package com.ws.experiment.springboot.druid;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * 继承FilterEventAdapter，实现对druid的扩展<br/>
 * resources/META-INF/druid-filter.properties中增加filter配置
 *
 * @author Eric
 * @create 2020-01-02_22:42
 */
@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info(">>>>>>>>Before Connection");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info(">>>>>>>>After Connection");
    }
}
