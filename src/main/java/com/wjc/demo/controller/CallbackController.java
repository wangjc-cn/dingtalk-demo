package com.wjc.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptException;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptor;
import com.taobao.api.ApiException;
import com.wjc.demo.common.constant.Constant;
import com.wjc.demo.entity.DingTalkProps;
import com.wjc.demo.event.CallbackEventHandle;
import com.wjc.demo.service.DingTalkCallbackApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.controller
 * @ClassName: CallbackController
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/7 0007 12:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/7 0007 12:54
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("callback")
public class CallbackController {
    /**
     * 回调接口验证处理
     */
    @Resource(name = "checkUrlEventHandle")
    private CallbackEventHandle checkUrl;

    @Resource(name = "userAddOrg")
    private CallbackEventHandle userAddOrg;

    @Resource(name = "userLeaveOrg")
    private CallbackEventHandle userLeaveOrg;

    @Resource(name = "userModifyOrg")
    private CallbackEventHandle userModifyOrg;

    @Autowired
    private DingTalkCallbackApi callbackApi;

    @Autowired
    private DingTalkProps props;

    private Map<String, CallbackEventHandle> handleMap = new HashMap<>();

    private String[] eventTypes = {"user_add_org",
            "user_modify_org",
            "user_leave_org",
            "user_active_org"
    };

    @RequestMapping("handle")
    public Map<String, String> eventHanle(@RequestParam(value = "signature", required = false) String signature,
                                          @RequestParam(value = "timestamp", required = false) String timestamp,
                                          @RequestParam(value = "nonce", required = false) String nonce,
                                          @RequestBody(required = false) JSONObject json){
        Map<String, String> rst = new HashMap<>();
        String params = " signature:"+signature + " timestamp:"+timestamp +" nonce:"+nonce+" json:"+json;
        log.info("回调方法执行,参数为: {}" , params);
        log.info("jsonObject : {}", json.toJSONString());
        try{
//            if (StringUtils.isEmpty(eventType)){
//                throw new Exception("不合法的调用:事件回调类型参数不能为空");
//            }
            // 钉钉加密/解密工具
            DingTalkEncryptor dingTalkEncryptor = new DingTalkEncryptor(props.getToken(),
                    props.getAesKey(),
                    props.getCorpId());

            String encryptMsg = json.getString("encrypt");
            String plainText = dingTalkEncryptor.getDecryptMsg(signature, timestamp, nonce, encryptMsg);
            log.info("plainText = {}", plainText);
            JSONObject obj = JSON.parseObject(plainText);

            //根据回调数据类型做不同的业务处理
            String eventType = obj.getString("EventType");

            long time = System.currentTimeMillis();
            // 增加回调事件的处理
            handleMap.put("check_url",(x)-> checkUrl.callbackHandle(rst));
            handleMap.put("check_url3",(x)-> "success");
            userEventHandle(rst);
            // 回调事件处理
            CallbackEventHandle handel = handleMap.get(eventType);
            if(handel == null){
                throw new Exception("此eventType:" + eventType + " 未注册事件处理");
            }
            String result = handel.callbackHandle(rst);
            // 返回加密后信息
            return dingTalkEncryptor.getEncryptedMap(result,time,"123456");
        } catch (DingTalkEncryptException e) {
            log.error("加密返回信息异常", e);
            rst.put("500",e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            rst.put("500", "都是个jj");
        }
        return rst;
    }

    @RequestMapping("rgst")
    public Object rgstCallback() throws ApiException {
        return callbackApi.callBackRgst(Arrays.asList(eventTypes));
    }

    @RequestMapping("del")
    public Object delete() throws ApiException {
        return callbackApi.callBackDel();
    }

    @RequestMapping("upd")
    public Object update() throws ApiException {
        return callbackApi.callBackUpd(Arrays.asList(eventTypes));
    }

    @RequestMapping("get")
    public Object getCallback() throws ApiException {
        return callbackApi.getCallBack();
    }

    @RequestMapping("faildList")
    public Object faildList() throws ApiException {
        return callbackApi.getFailedCallBack();
    }

    /**
     * 增加通讯录回调事件处理
     * @param map
     */
    private void userEventHandle(Map<String, String> map){
        handleMap.put("user_add_org", (x)-> userAddOrg.callbackHandle(map));
        handleMap.put("user_leave_org", (x)-> userLeaveOrg.callbackHandle(map));
        handleMap.put("user_modify_org", (x)-> userModifyOrg.callbackHandle(map));
        handleMap.put("user_active_org", (x) -> {
            log.info("用户激活 回调成功: {}", JSONObject.toJSONString(map));
            return Constant.CALLBACK_SUCCESS;
        });
    }
}
