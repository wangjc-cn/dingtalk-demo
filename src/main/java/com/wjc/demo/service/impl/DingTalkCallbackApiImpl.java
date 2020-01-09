package com.wjc.demo.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import com.wjc.demo.common.constant.ApiConstant;
import com.wjc.demo.common.constant.Constant;
import com.wjc.demo.common.utils.EncodeUtil;
import com.wjc.demo.entity.DingTalkProps;
import com.wjc.demo.service.DingTalkCallbackApi;
import com.wjc.demo.service.DingTalkDefaultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service.impl
 * @ClassName: DingTalkCallBackApiImpl
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/6 0006 16:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/6 0006 16:13
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@Component
public class DingTalkCallbackApiImpl implements DingTalkCallbackApi {
    @Autowired
    private DefaultDingTalkClient client;

    @Autowired
    private DingTalkDefaultApi defaultApi;

    @Autowired
    private DingTalkProps props;

    @Override
    public OapiCallBackRegisterCallBackResponse callBackRgst(List<String> callBackTag) throws ApiException {
        OapiGettokenResponse accessTokenRes = defaultApi.getAccessToken();
        client.resetServerUrl(ApiConstant.CALL_BACK_RGST + accessTokenRes.getAccessToken());
        OapiCallBackRegisterCallBackRequest request = new OapiCallBackRegisterCallBackRequest();
        request.setUrl(props.getCallBackUrl());
        request.setAesKey(props.getAesKey());
        request.setToken(props.getToken());
        request.setCallBackTag(callBackTag);
        request.setHttpMethod(Constant.HTTP_POST);
        return client.execute(request);
    }

    @Override
    public OapiCallBackUpdateCallBackResponse callBackUpd(List<String> callBackTag) throws ApiException {
        OapiGettokenResponse acToken = defaultApi.getAccessToken();
        client.resetServerUrl(ApiConstant.CALL_BACK_UPD + acToken.getAccessToken());
        OapiCallBackUpdateCallBackRequest request = new OapiCallBackUpdateCallBackRequest();
        request.setUrl(props.getCallBackUrl());
        request.setAesKey(props.getAesKey());
        request.setToken(props.getToken());
        request.setCallBackTag(callBackTag);
        OapiCallBackUpdateCallBackResponse response = client.execute(request);
        return client.execute(request);
    }

    @Override
    public OapiCallBackDeleteCallBackResponse callBackDel() throws ApiException {
        OapiGettokenResponse acToken = defaultApi.getAccessToken();
        client.resetServerUrl(ApiConstant.CALL_BACK_DEL + acToken.getAccessToken());
        OapiCallBackDeleteCallBackRequest request = new OapiCallBackDeleteCallBackRequest();
        request.setHttpMethod(Constant.HTTP_GET);
        return client.execute(request);
    }

    @Override
    public OapiCallBackGetCallBackResponse getCallBack() throws ApiException {
        OapiGettokenResponse accessTokenRes = defaultApi.getAccessToken();
        client.resetServerUrl(ApiConstant.CALL_BACK_INFO + accessTokenRes.getAccessToken());
        OapiCallBackGetCallBackRequest request = new OapiCallBackGetCallBackRequest();
        request.setHttpMethod(Constant.HTTP_GET);
        return client.execute(request);
    }

    /**
     * @method  getFailedCallBack
     * @description 描述一下方法的作用
     * @date: 2020/1/8 0008 14:32
     * @author: wangjc
     * @param : []
     * @return
     */
    @Override
    public OapiCallBackGetCallBackFailedResultResponse getFailedCallBack() throws ApiException {
        OapiGettokenResponse accessTokenRes = defaultApi.getAccessToken();
        client.resetServerUrl(ApiConstant.CALL_BACK_FAIL_LIST + accessTokenRes.getAccessToken());
        OapiCallBackGetCallBackFailedResultRequest request = new OapiCallBackGetCallBackFailedResultRequest();
        request.setHttpMethod(Constant.HTTP_GET);
        return client.execute(request);
    }
}
