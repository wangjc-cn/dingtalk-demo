package com.wjc.demo.event.handle;

import com.wjc.demo.common.constant.Constant;
import com.wjc.demo.event.CallbackEventHandle;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.event.handle
 * @ClassName: CheckUrlEvent
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/7 0007 12:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/7 0007 12:41
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@Component
public class CheckUrlEventHandle implements CallbackEventHandle {

    @Override
    public String callbackHandle(Map<String, String> map) {
        return Constant.CALLBACK_SUCCESS;
    }
}
