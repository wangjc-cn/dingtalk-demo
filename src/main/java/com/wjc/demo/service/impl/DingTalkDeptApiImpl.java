package com.wjc.demo.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiDepartmentListIdsRequest;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.response.OapiDepartmentListIdsResponse;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import com.wjc.demo.common.constant.ApiConstant;
import com.wjc.demo.common.constant.Constant;
import com.wjc.demo.service.DingTalkDefaultApi;
import com.wjc.demo.service.DingTalkDeptApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service.impl
 * @ClassName: DingTalkDeptApiImpl
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/9 0009 9:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/9 0009 9:26
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@Component
public class DingTalkDeptApiImpl implements DingTalkDeptApi {

    @Autowired
    private DefaultDingTalkClient dingTalkClient;

    @Autowired
    private DingTalkDefaultApi defaultApi;

    @Override
    public OapiDepartmentListIdsResponse deptIdsList(OapiDepartmentListIdsRequest request) throws ApiException {
        OapiGettokenResponse accessToken = defaultApi.getAccessToken();

        dingTalkClient.resetServerUrl(ApiConstant.DEPT_IDS_LIST + accessToken.getAccessToken());
        request.setHttpMethod(Constant.HTTP_GET);
        OapiDepartmentListIdsResponse response = dingTalkClient.execute(request);
        return response;
    }

    @Override
    public OapiDepartmentListResponse deptList(OapiDepartmentListRequest request) throws ApiException {
        OapiGettokenResponse accessToken = defaultApi.getAccessToken();

        dingTalkClient.resetServerUrl(ApiConstant.DEPT_IDS_LIST + accessToken.getAccessToken());
        request.setHttpMethod("GET");
        OapiDepartmentListResponse response = dingTalkClient.execute(request, accessToken.getAccessToken());
        return null;
    }
}
