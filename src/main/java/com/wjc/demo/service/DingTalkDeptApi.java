package com.wjc.demo.service;

import com.dingtalk.api.request.OapiDepartmentListIdsRequest;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.response.OapiDepartmentListIdsResponse;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.taobao.api.ApiException;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.service
 * @ClassName: DingTalkDeptApiService
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/4 0004 16:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/4 0004 16:00
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public interface DingTalkDeptApi {
     /**
      * @method  deptIdsList
      * @description 查询部门id列表
      * @date: 2020/1/9 0009 9:34
      * @author: wangjc
      * @param :
      * @return
      */
    OapiDepartmentListIdsResponse deptIdsList(OapiDepartmentListIdsRequest request) throws ApiException;

     /**
      * @method  deptList
      * @description 查询部门列表
      * @date: 2020/1/9 0009 9:34
      * @author: wangjc
      * @param :
      * @return
      */
    OapiDepartmentListResponse deptList(OapiDepartmentListRequest request) throws ApiException;
}
