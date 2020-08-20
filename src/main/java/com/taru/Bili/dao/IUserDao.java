package com.taru.Bili.dao;

import com.taru.Bili.entity.News;
import com.taru.Bili.entity.User;
import com.taru.Bili.entity.UserFollower;
import com.taru.Bili.entity.Video;
import com.taru.Bili.entity.Vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    /**
     * 登陆
     */
    User land(User user);
    void land1(Integer id);
    User land2(Integer id);
    /**
     * 注册
     */
    void register(User user);
    /**
     * 退出
     */
    void logout(User user);
    /**
     * 注销
     */
    void delete(User user);
    /**
     * 通过ID查找用户
     */
    User selectId(Integer id);
    /**
     * 名称查询用户
     */
    List<User> selectUser(String username);

    /**
     * 关注人
     */
    void addFollow(@Param("uid") Integer uid,@Param("followerid") Integer followerid);
    /**
     * 取消关注人
     */
    void deleteFollow(@Param("uid") Integer uid,@Param("followerid") Integer followerid);
    /**
     * 查询关注人
     */
    UserVo selectFollow(Integer uid);
    /**
     * 查看动态
     */
    List<News> selectNews(Integer uid);
}
