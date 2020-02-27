package com.bwie.wangyanmin20200224.model.bean;

/*
 *@auther:王彦敏
 *@Date: 2020/2/26
 *@Time:16:40
 *@Description:
 * */
public class RegisterBean {

    /**
     * message : 注册成功
     * status : 0000
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
