package com.wjc.demo.service;

import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import com.wjc.demo.entity.DingTalkProps;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service
 * @ClassName: DingTalkApiService
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/4 0004 15:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/4 0004 15:53
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public interface DingTalkDefaultApi {
    /**
     * 获取access_token
     *
     * @return
     */
    OapiGettokenResponse getAccessToken() throws ApiException;
}
