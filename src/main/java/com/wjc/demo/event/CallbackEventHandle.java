package com.wjc.demo.event;

import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service
 * @ClassName: 回调事件的事件处理接口
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/7 0007 12:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/7 0007 12:13
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public interface CallbackEventHandle {
    /**
     * 回调处理
     * @param map  参数
     * @return 成功后 返回 "success" 字符串
     */
    String callbackHandle(Map<String,String> map);
}
