package com.fh.common;

/**
 * @author winter
 * @create 2020-09-27 10:55
 */
public enum ServerEnum {
    SUCCESS(1111,"成功"),
    ERROR(2222,"失败"),
    ERROE_LOGIN(2000,"登录错误,请重新登录")
    ;
    private Integer code;
    private String message;
    ServerEnum(){
    }
    ServerEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
