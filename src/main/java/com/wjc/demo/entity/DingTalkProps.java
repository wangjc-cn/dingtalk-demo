package com.wjc.demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.entity
 * @ClassName: DingTalkProps
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/6 0006 13:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/6 0006 13:14
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "dingtalk")
public class DingTalkProps {
    /**
     * 钉钉后台的appKey
     */
    private String appKey;
    /**
     * 钉钉后台的app秘钥
     */
    private String appSecret;
    /**
     * 钉钉后台的唯一码
     */
    private String corpId;
    /**
     * 回调地址
     */
    private String callBackUrl;
    /**
     * aes加密key
     */
    private String aesKey;
    /**
     * 回调校验的token
     */
    private String token;
    /**
     * 应用的SuiteKey，登录开发者后台，点击应用管理，进入应用详情可见
     */
    private String suiteKey;
}

