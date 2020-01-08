package com.wjc.demo.controller;

import com.dingtalk.oapi.lib.aes.DingTalkEncryptException;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptor;
import com.wjc.demo.entity.DingTalkProps;
import com.wjc.demo.event.CallbackEventHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
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
public class CallbackController {
    /**
     * 回调接口验证处理
     */
    @Resource(name = "checkUrlEventHandle")
    private CallbackEventHandle checkUrl;

    @Autowired
    private DingTalkProps props;

    private Map<String, CallbackEventHandle> handleMap = new HashMap<>();

    @PostMapping("callback")
    public Map<String, String> checkUrl(@RequestParam("EventType") String eventType, Map<String, String> map){
        try{
            if (StringUtils.isEmpty(eventType)){
                throw new Exception("不合法的调用:事件回调类型参数不能为空");
            }
            long time = System.currentTimeMillis();
            // 钉钉加密/解密工具
            DingTalkEncryptor dingTalkEncryptor = new DingTalkEncryptor(props.getToken(),
                    props.getAesKey(),
                    props.getCorpId());
            // 增加回调事件的处理
            handleMap.put("check_url",(x)-> checkUrl.callbackHandle(map));
            handleMap.put("check_url3",(x)-> "success");
            userEventHandle(map);
            // 回调事件处理
            CallbackEventHandle handel = handleMap.get(eventType);
            if(handel == null){
                throw new Exception("此eventType:" + eventType + " 未注册事件处理");
            }
            String result = handel.callbackHandle(map);
            // 返回加密后信息
            return dingTalkEncryptor.getEncryptedMap(result,time,"123456");
        } catch (DingTalkEncryptException e) {
            log.error("加密返回信息异常", e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 增加通讯录回调事件处理
     * @param map
     */
    private void userEventHandle(Map<String, String> map){
        handleMap.put("check_url1", (x)-> checkUrl.callbackHandle(map));
    }
}
