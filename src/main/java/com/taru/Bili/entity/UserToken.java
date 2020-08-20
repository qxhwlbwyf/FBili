package com.taru.Bili.entity;

public class UserToken {
    private Token token;
    private Object data;
    public UserToken(){

    }
    public UserToken(Token token,Object data){
        this.data=data;
        this.token=token;
    }
    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
