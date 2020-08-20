package com.taru.Bili.entity;

import java.util.Date;
import java.util.List;

public class User {
    private Integer id;
    private String username;        //用户名
    private String password;        //密码
    private String headimg;         //头像
    private String birth;           //生日 格式是xxxx-xx-xx
    private String autograph;       //个性签名
    private Integer sex;             //性别
    private Integer deleted;         //是否删除
    private Integer status;          //登录状态
    private String modifiedTime;   //修改（注册）时间

    public User(){

    }
    public User(Integer id, String username, String password, String headimg, String birth, String autograph, Integer sex, Integer deleted, Integer status, String modifiedTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.headimg = headimg;
        this.birth = birth;
        this.autograph = autograph;
        this.sex = sex;
        this.deleted = deleted;
        this.status = status;
        this.modifiedTime = modifiedTime;

    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }





}
