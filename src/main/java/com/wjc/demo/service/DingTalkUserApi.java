package com.wjc.demo.service;

import com.dingtalk.api.request.OapiUserCreateRequest;
import com.dingtalk.api.response.OapiUserCreateResponse;
import com.taobao.api.ApiException;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service
 * @ClassName: DingTalkUserApiService
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/4 0004 15:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/4 0004 15:59
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public interface DingTalkUserApi {
    /**
     * 创建用户
     * 请求方式：POST（HTTPS）
     * 请求地址：https://oapi.dingtalk.com/user/create?access_token=ACCESS_TOKEN
     * @param request
     * @return
     */
    OapiUserCreateResponse userAdd(OapiUserCreateRequest request) throws ApiException;
}
