package com.taru.Bili.entity.Vo;

import com.taru.Bili.entity.User;
import com.taru.Bili.entity.UserFollower;
import com.taru.Bili.entity.Video;

import java.util.List;
//拓展User属性
public class UserVo extends User {
//    用户关注多个用户
    List<UserFollower> Followers;

    public List<UserFollower> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<UserFollower> followers) {
        Followers = followers;
    }
}
