package com.taru.Bili.dao;

import com.alibaba.fastjson.JSONObject;
import com.taru.Bili.entity.User;
import com.taru.Bili.entity.Video;

import java.util.List;

/*
 * 接口，实现方法
 * 连接数据库实体类
 * 起登陆，注册等功能
 */
public interface ISql {
    /**
     * 登陆
     */
    public User land(String uname, String upass);
    /**
     * 注册
     */
    public int register(User user);
    /**
     * 退出
     */
    public int logout(User user);
    /**
     * 注销
     */
    public int delete(User user);
    /**
     * 通过ID查找用户
     */
    public User selectId(String id);
    /**
     * 名称查询用户
     */
    public List<User> selectUser(String username);
    /**
     * 查询视频
     */
    public List<Video> selectVideo(String videoname,int m,int n);
    /**
     * 根据分类查询视频
     */
    public List<Video> selectSort(String sort);
    /**
     * 查看视频
     */
    public Video watchvideo(String vid);
    /**
     * 增加点击量
     */
    public int updateHits(String vid);
    /**
     * 下架视频
     */
    public int deleteVideo(String vid);
    /**
     * 上传视频
     */
    public int addVideo(Video video);
    /**
     * 收藏视频
     */
    public int collection(String uid,String vid);
    /**
     * 查询收藏
     */
    public List<Video> selectCollection(String uid);
    /**
     * 取消收藏
     */
    public int remove(String uid,String vid);
    /**
     * 关注人
     */
    public int addFollow(String uid,String followerid);
    /**
     * 取消关注人
     */
    public int deleteFollow(String uid,String followerid);
    /**
     * 查询关注人
     */
    public List<User> selectFollow(String uid);
    /**
     * 查看动态
     */
    public List<Video> selectNews(String uid);
}
