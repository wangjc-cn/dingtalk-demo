package com.wjc.demo.controller;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserCreateResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptException;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.taobao.api.ApiException;
import com.wjc.demo.entity.DingTalkProps;
import com.wjc.demo.service.DingTalkUserApi;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.taobao.api.internal.toplink.endpoint.MessageType.ValueFormat.Date;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.controller
 * @ClassName: DingController
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/4 0004 13:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/4 0004 13:43
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@RestController
@RequestMapping("test")
public class DingController {

    @Autowired
    private DingTalkUserApi userApi;

    @Autowired
    private DingTalkProps props;

    @PostMapping("getAccessToken")
    public OapiGettokenResponse dingTest() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        DefaultDingTalkClient client1 = new DefaultDingTalkClient("");
        client1.resetServerUrl("https://oapi.dingtalk.com/gettoken");

        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("dingoqq0rxovy7m5kfmj");
        request.setAppsecret("WOmY4g-PcOBn3eyLDD-caXEP__Xodfv9d_AvYyllgyvgTe5YpREGSC-yZHwaM3Ud");

        OapiGettokenResponse response = client.execute(request);
        System.out.println(response.getAccessToken());
        OapiGettokenResponse response1 = client1.execute(request);
        System.out.println(response1.getErrcode());
        System.out.println(response1.getAccessToken());
        OapiUserGetRequest req = new OapiUserGetRequest();
//        req.setUserid("userid1");
//        req.setHttpMethod("GET");
        //OapiUserGetResponse rsp = client.execute(req, accessToken);

        return response;
    }

    @PostMapping("userAdd")
    public OapiUserCreateResponse userAdd(String userid,String mobile, String name) throws ApiException {
        OapiUserCreateResponse oapiUserCreateResponse = userApi.userAdd(userid, mobile, name);
        return oapiUserCreateResponse;
    }

    /**
     *   {
     *   "msg_signature":"111108bb8e6dbce3c9671d6fdb69d15066227608",
     *   "timeStamp":"1783610513",
     *   "nonce":"123456",
     *   "encrypt":"1ojQf0NSvw2WPvW7LijxS8UvISr8pdDP+rXpPbcLGOmIBNbWetRg7IP0vdhVgkVwSoZBJeQwY2zhROsJq/HJ+q6tp1qhl9L1+ccC9ZjKs1wV5bmA9NoAWQiZ+7MpzQVq+j74rJQljdVyBdI/dGOvsnBSCxCVW0ISWX0vn9lYTuuHSoaxwCGylH9xRhYHL9bRDskBc7bO0FseHQQasdfghjkl"
     *   }
     * @param eventType
     * @return
     */
    @PostMapping("callback")
    public Map<String, String> checkUrl(@RequestParam("EventType") String eventType, Map<String, String> map){
        Map<String, String> res = null;
        DingTalkEncryptor dingTalkEncryptor = null;
        long time = System.currentTimeMillis();

        // 验证是否有效的回调接口
        if("check_url".equals(eventType)){
            // 生成加密信息
            try {
                dingTalkEncryptor = new DingTalkEncryptor(props.getToken(),
                        props.getAesKey(),
                        props.getCorpId());
                res = dingTalkEncryptor.getEncryptedMap("success",time,"123456");
            } catch (DingTalkEncryptException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            new DingController().dingTest();
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
