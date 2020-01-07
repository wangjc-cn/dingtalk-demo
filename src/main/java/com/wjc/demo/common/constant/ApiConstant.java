package com.wjc.demo.common.constant;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.common.constant
 * @ClassName: ApiConstant
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/4 0004 16:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/4 0004 16:56
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public class ApiConstant {
    /**
     * 钉钉接口服务host
     */
    public static final String DING_TALK_HOST = "https://oapi.dingtalk.com";

    /**
     * access_token 参数名
     */
    public static final String ACCESS_TOKEN_PARAM = "?access_token=";

    /**
     * 获取access_token接口
     */
    public static final String DING_TALK_TOKEN = DING_TALK_HOST + "/gettoken";

    /**
     * 用户创建接口
     */
    public static final String USER_ADD = DING_TALK_HOST + "/user/create" + ACCESS_TOKEN_PARAM;
    /**
     * 用户删除接口
     */
    public static final String USER_DEL = DING_TALK_HOST + "/user/delete" + ACCESS_TOKEN_PARAM;
    /**
     * 用户更新接口
     */
    public static final String USER_UPD = DING_TALK_HOST + "/user/update" + ACCESS_TOKEN_PARAM;
    /**
     * 部门用户列表接口
     */
    public static final String DEPT_USER_LIST = DING_TALK_HOST +  "/user/simplelist" + ACCESS_TOKEN_PARAM;
    /**
     * 获取部门用户id列表
     */
    public static final String DEPT_USERID_LIST = DING_TALK_HOST +  "/user/getDeptMember" + ACCESS_TOKEN_PARAM;
    /**
     * 获取用户详情接口
     */
    public static final String USER_INFO = DING_TALK_HOST +  "/user/get" + ACCESS_TOKEN_PARAM;
    /**
     * 获取部门用户详情
     */
    public static final String DEPT_USER_INFO = DING_TALK_HOST +  "/user/listbypage" + ACCESS_TOKEN_PARAM;
    /**
     * 获取管理员列表
     */
    public static final String ADMIN_LIST = DING_TALK_HOST +  "/user/get_admin" + ACCESS_TOKEN_PARAM;
    /**
     * 获取管理员通讯录权限范围
     */
    public static final String ADMIN_SCOPE = DING_TALK_HOST +  "/user/get_admin_scope" + ACCESS_TOKEN_PARAM;
    /**
     * 根据unionid获取userid
     */
    public static final String GET_USERID_BY_UNIONID = DING_TALK_HOST +  "/user/getUseridByUnionid" + ACCESS_TOKEN_PARAM;
    /**
     * 根据手机号获取userid
     */
    public static final String GET_USERID_BY_MOBILE = DING_TALK_HOST +  "/user/get_by_mobile" + ACCESS_TOKEN_PARAM;
    /**
     * 获取企业员工人数
     */
    public static final String GET_ORG_USER_COUNT = DING_TALK_HOST + "/user/get_org_user_count" + ACCESS_TOKEN_PARAM;
    /**
     * 未登录钉钉的员工列表
     */
    public static final String UNLOGIN_USER_LIST = DING_TALK_HOST + "/topapi/inactive/user/get" + ACCESS_TOKEN_PARAM;


    /**
     * 创建部门
     */
    public static final String DEPT_ADD = DING_TALK_HOST + "/department/create" + ACCESS_TOKEN_PARAM;
    /**
     * 删除部门
     */
    public static final String DEPT_DEL = DING_TALK_HOST + "/department/delete" + ACCESS_TOKEN_PARAM;
    /**
     * 更新部门
     */
    public static final String DEPT_UPD = DING_TALK_HOST + "/department/update" + ACCESS_TOKEN_PARAM;
    /**
     * 获取子部门ID列表
     */
    public static final String DEPT_IDS_LIST = DING_TALK_HOST +  "/department/list_ids" + ACCESS_TOKEN_PARAM;
    /**
     * 获取部门列表
     */
    public static final String DEPT_LIST = DING_TALK_HOST +  "/department/list" + ACCESS_TOKEN_PARAM;
    /**
     * 获取部门详情
     */
    public static final String DEPT_INFO =DING_TALK_HOST +  "/department/get" + ACCESS_TOKEN_PARAM;
    /**
     * 查询部门的所有上级父部门路径
     */
    public static final String DEPT_PARENT_IDS_BY_DEPT =DING_TALK_HOST
            +  "/department/list_parent_depts_by_dept"
            + ACCESS_TOKEN_PARAM;
    /**
     * 查询指定用户的所有上级父部门路径
     */
    public static final String DEPT_PARENT_IDS_BY_USERID =DING_TALK_HOST
            + "/department/list_parent_depts"
            + ACCESS_TOKEN_PARAM;
    /**
     * 创建角色
     */
    public static final String ROLE_ADD = DING_TALK_HOST + "/role/add_role" + ACCESS_TOKEN_PARAM;
    /**
     *更新角色
     */
    public static final String ROLE_UPD = DING_TALK_HOST + "/role/update_role" + ACCESS_TOKEN_PARAM;
    /**
     * 删除角色
     */
    public static final String ROLE_DEL = DING_TALK_HOST + "/role/deleterole" + ACCESS_TOKEN_PARAM;
    /**
     * 获取角色列表
     */
    public static final String ROLE_LIST =DING_TALK_HOST +  "/topapi/role/list" + ACCESS_TOKEN_PARAM;
    /**
     * 获取角色下的员工列表
     */
    public static final String ROLE_USER_LIST =DING_TALK_HOST +  "/topapi/role/simplelist" + ACCESS_TOKEN_PARAM;
    /**
     * 获取角色组
     */
    public static final String ROLE_LIST_BY_GROUPID = DING_TALK_HOST + "/topapi/role/getrolegroup" + ACCESS_TOKEN_PARAM;
    /**
     * 获取角色详情
     */
    public static final String ROLE_INFO = DING_TALK_HOST +  "/role/getrole" + ACCESS_TOKEN_PARAM;
    /**
     * 创建角色组
     */
    public static final String ROLE_GROUP_ADD = DING_TALK_HOST +  "/role/add_role_group" + ACCESS_TOKEN_PARAM;
    /**
     * 批量增加员工角色
     */
    public static final String ROLE_USER_BATCH_ADD = DING_TALK_HOST
            + "/topapi/role/addrolesforemps"
            + ACCESS_TOKEN_PARAM;
    /**
     * 批量删除员工角色
     */
    public static final String ROLE_USER_BATCH_DEL = DING_TALK_HOST
            + "/topapi/role/removerolesforemps"
            + ACCESS_TOKEN_PARAM;
    /**
     * 设定角色成员管理范围
     */
    public static final String ROLE_SCOPE_UPD = DING_TALK_HOST
            + "/topapi/role/scope/update"
            + ACCESS_TOKEN_PARAM;


    /**
     *注册业务事件回调接口
     */
    public static final String CALL_BACK_RGST = DING_TALK_HOST
            + "/call_back/register_call_back"
            + ACCESS_TOKEN_PARAM;
    /**
     * 查询事件回调接口
     */
    public static final String CALL_BACK_INFO = DING_TALK_HOST + "/call_back/get_call_back" + ACCESS_TOKEN_PARAM;
    /**
     * 更新事件回调接口
     */
    public static final String CALL_BACK_UPD = DING_TALK_HOST + "/call_back/update_call_back" + ACCESS_TOKEN_PARAM;
    /**
     * 删除事件回调接口
     */
    public static final String CALL_BACK_DEL = DING_TALK_HOST + "/call_back/delete_call_back" + ACCESS_TOKEN_PARAM;

    /**
     * 获取回调失败的结果
     */
    public static final String CALL_BACK_FAIL_LIST = DING_TALK_HOST
            + "/call_back/get_call_back_failed_result"
            + ACCESS_TOKEN_PARAM;

}
