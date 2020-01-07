package com.wjc.demo.common.config;

import com.dingtalk.api.DefaultDingTalkClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.common.config
 * @ClassName: DingTalkConfig
 * @Description: 钉钉开放平台设置
 * @Author: wangjc
 * @CreateDate: 2020/1/6 0006 13:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/6 0006 13:06
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@Configuration
public class DingTalkConfig {

    /**
     * 钉钉接口客户端
     * @return
     */
    @Bean
    public DefaultDingTalkClient getDefaultDingTalkClient(){
        DefaultDingTalkClient client = new DefaultDingTalkClient("");
        return client;
    }
}
