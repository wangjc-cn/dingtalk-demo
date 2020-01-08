package com.wjc.demo.service;

import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import com.wjc.demo.entity.DingTalkProps;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service
 * @ClassName: DingTalkApiService
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/4 0004 15:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/4 0004 15:53
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public interface DingTalkDefaultApi {
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
    OapiGettokenResponse getAccessToken() throws ApiException;
}
