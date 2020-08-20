package com.taru.Bili.common;

public class JsonResult {
    private int code;
    private String message;
    private Object data;

    public JsonResult(){

    }
    //成功时返回的
    public JsonResult(int code, String messahe, Object data){
        this.code=code;
        this.message=messahe;
        this.data=data;
    }
    //失败时返回的
    public JsonResult(int code, String messahe){
        this.code=code;
        this.message=messahe;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



}
