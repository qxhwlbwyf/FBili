package com.taru.Bili.service.Impl;

import com.taru.Bili.dao.IUserDao;
import com.taru.Bili.entity.News;
import com.taru.Bili.entity.User;
import com.taru.Bili.entity.UserFollower;
import com.taru.Bili.entity.Video;
import com.taru.Bili.entity.Vo.UserVo;
import com.taru.Bili.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao iUserDao;

    @Override
    public User land(User user) {
        return iUserDao.land(user);
    }
    @Override
    public void land1(Integer id){
        iUserDao.land1(id);
    };
    @Override
    public User land2(Integer id) {
        return iUserDao.land2(id);
    }
    @Override
    public void register(User user) {
        iUserDao.register(user);
    }

    @Override
    public void logout(User user) {
        iUserDao.logout(user);
    }

    @Override
    public void delete(User user) {
        iUserDao.delete(user);
    }

    @Override
    public User selectId(Integer id) {
        return iUserDao.selectId(id);
    }

    @Override
    public List<User> selectUser(String username) {
        return iUserDao.selectUser(username);
    }



    @Override
    public void addFollow(Integer uid, Integer followerid) {
        iUserDao.addFollow(uid,followerid);
    }

    @Override
    public void deleteFollow(Integer uid, Integer followerid) {
        iUserDao.deleteFollow(uid,followerid);
    }

    @Override
    public UserVo selectFollow(Integer uid) {
        return iUserDao.selectFollow(uid);
    }

    @Override
    public List<News> selectNews(Integer uid) {
        return iUserDao.selectNews(uid);
    }



//    @Override
//    public User land(String uname, String upass) {
//        //声明接口new实现
//        ISql s=new SqlImpl();//数据库查询实现（可转换IO流）
//        User user=s.land(uname, upass);
//        return user;
//    }
//
//    @Override
//    public int register(User user) {
//        ISql s=new SqlImpl();
//        int i=s.register(user);
//        return i;
//    }
//
//    @Override
//    public int logout(User user) {
//        ISql s=new SqlImpl();
//        int i=s.logout(user);
//        return i;
//    }
//
//    @Override
//    public int delete(User user) {
//        ISql s=new SqlImpl();
//        int i=s.delete(user);
//        return i;
//    }
//
//    @Override
//    public User selectId(String id) {
//        ISql s=new SqlImpl();
//        User user=s.selectId(id);
//        return user;
//    }
//
//    @Override
//    public List<User> selectUser(String username) {
//        ISql s=new SqlImpl();
//        List<User> list=s.selectUser(username);
//        return list;
//    }
//
//    @Override
//    public List<Video> selectVideo(String videoname,int m,int n) {
//        ISql s=new SqlImpl();
//        List<Video> list=s.selectVideo(videoname,m,n);
//        return list;
//    }
//
//    @Override
//    public List<Video> selectSort(String sort) {
//        ISql s=new SqlImpl();
//        List<Video> list=s.selectSort(sort);
//        return list;
//    }
//
//    @Override
//    public Video watchvideo(String vid) {
//        ISql s=new SqlImpl();
//        Video video=s.watchvideo(vid);
//        return video;
//    }
//
//    @Override
//    public int updateHits(String vid) {
//        ISql s=new SqlImpl();
//        int i=s.updateHits(vid);
//        return i;
//    }
//
//    @Override
//    public int deleteVideo(String vid) {
//        ISql s=new SqlImpl();
//        int i=s.deleteVideo(vid);
//        return i;
//    }
//
//    @Override
//    public int addVideo(Video video) {
//        ISql s=new SqlImpl();
//        int i=s.addVideo(video);
//        return i;
//    }
//
//    @Override
//    public int collection(String uid, String vid) {
//        ISql s=new SqlImpl();
//        int i=s.collection(uid,vid);
//        return i;
//    }
//
//    @Override
//    public List<Video> selectCollection(String uid) {
//        ISql s=new SqlImpl();
//        List<Video> list=s.selectCollection(uid);
//        return list;
//    }
//
//    @Override
//    public int remove(String uid,String vid) {
//        ISql s=new SqlImpl();
//        int i=s.remove(uid,vid);
//        return i;
//    }
//
//    @Override
//    public int addFollow(String uid, String followerid) {
//        ISql s=new SqlImpl();
//        int i=s.addFollow(uid,followerid);
//        return i;
//    }
//
//    @Override
//    public int deleteFollow(String uid, String followerid) {
//        ISql s=new SqlImpl();
//        int i=s.deleteFollow(uid,followerid);
//        return i;
//    }
//
//    @Override
//    public List<User> selectFollow(String uid) {
//        ISql s=new SqlImpl();
//        List<User> list=s.selectFollow(uid);
//        return list;
//    }
//
//    @Override
//    public List<Video> selectNews(String uid) {
//        ISql s=new SqlImpl();
//        List<Video> list=s.selectNews(uid);
//        return list;
//    }

}
