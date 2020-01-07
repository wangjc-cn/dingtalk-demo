package com.wjc.demo.common.exception;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.common.exception
 * @ClassName: UserException
 * @Description: 用户自定义异常
 * @Author: wangjc
 * @CreateDate: 2020/1/3 0003 11:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/3 0003 11:14
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public class UserException extends Exception{
    private String errCode;

    private String message;

    public UserException(String message) {
        this.message = message;
    }

    public UserException(String message, String errCode) {
        this.message = message;
        this.errCode = errCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public String getErrCode() {
        return this.errCode;
    }
}
