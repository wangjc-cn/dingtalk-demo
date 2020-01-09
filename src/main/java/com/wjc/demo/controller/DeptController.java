package com.wjc.demo.controller;

import com.dingtalk.api.request.OapiDepartmentListIdsRequest;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.taobao.api.ApiException;
import com.wjc.demo.service.DingTalkDeptApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.controller
 * @ClassName: DeptController
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/9 0009 9:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/9 0009 9:38
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DingTalkDeptApi deptApi;

    @PostMapping("idsList")
    public Object deptIdsList() throws ApiException {
        OapiDepartmentListIdsRequest request = new OapiDepartmentListIdsRequest();
        request.setId("1");
        return deptApi.deptIdsList(request);
    }

    @PostMapping("list")
    public Object deptList() throws ApiException {
        OapiDepartmentListRequest request = new OapiDepartmentListRequest();
        return deptApi.deptList(request);
    }
}
