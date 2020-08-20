package com.taru.Bili.service;

import com.alibaba.fastjson.JSONObject;
import com.taru.Bili.entity.News;
import com.taru.Bili.entity.User;
import com.taru.Bili.entity.UserFollower;
import com.taru.Bili.entity.Video;
import com.taru.Bili.entity.Vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    /**
     * 登陆
     */
    public User land(User user);
    void land1(Integer id);
    User land2(Integer id);
    /**
     * 注册
     */
    public void register(User user);
    /**
     * 退出
     */
    public void logout(User user);
    /**
     * 注销
     */
    public void delete(User user);
    /**
     * 通过ID查找用户
     */
    public User selectId(Integer id);
    /**
     * 名称查询用户
     */
    public List<User> selectUser(String username);

    /**
     * 关注人
     */
    public void addFollow(Integer uid,Integer followerid);
    /**
     * 取消关注人
     */
    public void deleteFollow(Integer uid,Integer followerid);
    /**
     * 查询关注人
     */
    public UserVo selectFollow(Integer uid);
    /**
     * 查看动态
     */
    public List<News> selectNews(Integer uid);
}
