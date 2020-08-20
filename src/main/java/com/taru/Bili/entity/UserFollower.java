package com.taru.Bili.entity;

import java.util.List;

public class UserFollower {
    private Integer id;
    private String username;        //用户名
    private String password;        //密码
    private String headimg;         //头像
    private String birth;           //生日 格式是xxxx-xx-xx
    private String autograph;       //个性签名
    private Integer sex;             //性别
    private Integer deleted;         //是否删除
    private Integer status;          //登录状态
    List<News> News;
    public UserFollower(){}
    public UserFollower(Integer id, String username, String password, String headimg, String birth, String autograph, Integer sex, Integer deleted, Integer status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.headimg = headimg;
        this.birth = birth;
        this.autograph = autograph;
        this.sex = sex;
        this.deleted = deleted;
        this.status = status;
    }
    public UserFollower(Integer id, String username, String password, String headimg, String birth, String autograph, Integer sex, Integer deleted, Integer status, List<com.taru.Bili.entity.News> news) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.headimg = headimg;
        this.birth = birth;
        this.autograph = autograph;
        this.sex = sex;
        this.deleted = deleted;
        this.status = status;
        News = news;
    }

    public List<com.taru.Bili.entity.News> getNews() {
        return News;
    }

    public void setNews(List<com.taru.Bili.entity.News> news) {
        News = news;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
