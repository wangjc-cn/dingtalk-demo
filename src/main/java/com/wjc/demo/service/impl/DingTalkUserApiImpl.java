package com.wjc.demo.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiUserCreateRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserCreateResponse;
import com.taobao.api.ApiException;
import com.wjc.demo.common.constant.ApiConstant;
import com.wjc.demo.entity.DingTalkProps;
import com.wjc.demo.service.DingTalkDefaultApi;
import com.wjc.demo.service.DingTalkUserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service.impl
 * @ClassName: DingTalkUserApiImpl
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/6 0006 13:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/6 0006 13:45
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@Component
public class DingTalkUserApiImpl implements DingTalkUserApi {

    @Autowired
    private DefaultDingTalkClient dingTalkClient;

    @Autowired
    private DingTalkDefaultApi defaultApi;

    @Autowired
    private DingTalkProps props;

    @Override
    public OapiUserCreateResponse userAdd(OapiUserCreateRequest request) throws ApiException {
        OapiGettokenResponse accessTokenRes = defaultApi.getAccessToken();
        dingTalkClient.resetServerUrl(ApiConstant.USER_ADD + accessTokenRes.getAccessToken());

        // 需要用字符串， "[100,200]" 这种格式
        List<Long> departments = new ArrayList<Long>();
        departments.add(100L);
        departments.add(200L);
        //request.setDepartment(JSON.toJSONString(departments));
        OapiUserCreateResponse response = dingTalkClient.execute(request);
        return response;
    }
}
