package com.wjc.demo.event.handle;

import com.alibaba.fastjson.JSONObject;
import com.wjc.demo.common.constant.Constant;
import com.wjc.demo.event.CallbackEventHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.event.handle
 * @ClassName: UserLeaveOrgEventHandle
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/9 0009 11:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/9 0009 11:15
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@Component("userLeaveOrg")
@Slf4j
public class UserLeaveOrgEventHandle implements CallbackEventHandle {

    @Override
    public String callbackHandle(Map<String, String> map) {
        log.info("用户离职 回调成功: {}" , JSONObject.toJSONString(map));
        return Constant.CALLBACK_SUCCESS;
    }
}
