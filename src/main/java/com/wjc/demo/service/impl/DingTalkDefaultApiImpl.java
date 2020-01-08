package com.wjc.demo.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import com.wjc.demo.common.constant.ApiConstant;
import com.wjc.demo.common.constant.Constant;
import com.wjc.demo.entity.DingTalkProps;
import com.wjc.demo.service.DingTalkDefaultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service.impl
 * @ClassName: DingTalkDefaultApiImpl
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/6 0006 13:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/6 0006 13:11
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@Component
public class DingTalkDefaultApiImpl implements DingTalkDefaultApi {

    @Autowired
    private DefaultDingTalkClient dingTalkClient;

    @Autowired
    private DingTalkProps props;

     /**
      * @method  getAccessToken
      * @description 获取钉钉开放平台access_token
      *              [注意]正常情况下access_token有效期为7200秒，
      *              有效期内重复获取返回相同结果，并自动续期。
      * @date: 2020/1/8 0008 14:50
      * @author: wangjc
      * @param :
      * @return
      */
    @Override
    public OapiGettokenResponse getAccessToken() throws ApiException {
        dingTalkClient.resetServerUrl(ApiConstant.DING_TALK_TOKEN);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(props.getAppKey());
        request.setAppsecret(props.getAppSecret());
        request.setHttpMethod(Constant.HTTP_GET);
        OapiGettokenResponse response = dingTalkClient.execute(request);
        return response;
    }
}
