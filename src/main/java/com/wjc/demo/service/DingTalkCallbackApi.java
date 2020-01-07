package com.wjc.demo.service;

import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service
 * @ClassName: DingTalkCallBackApiService
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/4 0004 16:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/4 0004 16:26
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public interface DingTalkCallbackApi {
    /**
     * 注册回调
     * 请求方式：POST（HTTPS）
     * 请求地址：https://oapi.dingtalk.com/call_back/register_call_back?access_token=ACCESS_TOKEN
     *
     * @param callBackTag
     * @return
     */
    OapiCallBackRegisterCallBackResponse callBackRgst(List<String> callBackTag) throws ApiException ;

    /**
     *
     * 更新事件回调接口
     * 请求方式：POST（HTTPS）
     * 请求地址：https://oapi.dingtalk.com/call_back/update_call_back?access_token=ACCESS_TOKEN
     *
     * @param callBackTag
     * @return
     */
    OapiCallBackUpdateCallBackResponse callBackUpd(List<String> callBackTag) throws ApiException ;

    /**
     * 删除事件回调接口
     * 请求方式：GET（HTTPS）
     * 请求地址：https://oapi.dingtalk.com/call_back/delete_call_back?access_token=ACCESS_TOKEN
     *
     * @return
     */
    OapiCallBackDeleteCallBackResponse callBackDel() throws ApiException ;

    /**
     * 查询事件回调接口
     * 请求方式：GET（HTTPS）
     * 请求地址：https://oapi.dingtalk.com/call_back/get_call_back?access_token=ACCESS_TOKEN
     *
     * @return
     */
    OapiCallBackGetCallBackResponse getCallBack() throws ApiException ;

    /**
     * 获取回调失败的结果
     * 钉钉服务器给回调接口推送时，有可能因为各种原因推送失败(比如网络异常)，此时钉钉将保留此次变更事件。用户可以通过此回调接口获取推送失败的变更事件。
     * 请求方式：GET（HTTPS）
     * 请求地址：https://oapi.dingtalk.com/call_back/get_call_back_failed_result?access_token=ACCESS_TOKEN
     *
     * @return
     */
    OapiCallBackGetCallBackFailedResultResponse getFailedCallBack() throws ApiException;
}
