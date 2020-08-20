//package com.taru.Bili.dao.Impl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.taru.Bili.dao.ISql;
//import com.taru.Bili.entity.User;
//import com.taru.Bili.entity.Video;
//import com.taru.Bili.util.DbUtil;
//import com.taru.Bili.util.StringUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class SqlImpl implements ISql {
//    //登录
//    @Override
//    public User land(String uname, String upass) {
//        String sql="select * from bili_user u where u.username=? and u.password=? and u.`status`=1";
//        List<Map<String,Object>> list= DbUtil.query(sql,uname,upass);
//        User user=null;
//        if(list!=null&&list.size()>0){
//            Map<String,Object> map=list.get(0);//获取查询到的第一行数据
//            user=new User();//实例化
//            user.setId(StringUtil.valueOf(map.get("id")));//嵌套一层工具方法，防止空指针
//            user.setUsername(StringUtil.valueOf(map.get("username")));
//            user.setPassword(StringUtil.valueOf(map.get("password")));
//            user.setBirth(StringUtil.valueOf(map.get("birth")));
//            user.setHeadimg(StringUtil.valueOf(map.get("headimg")));
//            user.setSex(StringUtil.valueOf(map.get("sex")));
//            user.setAutograph(StringUtil.valueOf(map.get("autograph")));
//            user.setDeleted(StringUtil.valueOf(map.get("deleted")));
//            user.setModified_time(StringUtil.valueOf(map.get("modified_time")));
//        }
//        String sql1="update bili_user as bu set bu.status=0 where bu.id=?";
//        DbUtil.update(sql1,user.getId());
//        DbUtil.close();
//        return user;
//    }
//    //注册
//    @Override
//    public int register(User user) {
//        int i;
//        String sql="insert into `bili_user` (username,`password`,headimg,birth,autograph,sex,status) values (?,?,?,?,?,?,1)";
//        if(user.getPassword().equals("")||user.getUsername().equals("")){
//          i=0;
//        }else{
//            i=DbUtil.update(sql,user.getUsername(),user.getPassword(),user.getHeadimg(),
//                    user.getBirth(),user.getAutograph(),user.getSex());
//            DbUtil.close();
//        }
//        return i;
//    }
//    //退出
//    @Override
//    public int logout(User user) {
//        int i;
//        String sql="UPDATE `bili_user` AS bu SET bu.STATUS =  1  WHERE bu.id=?";
//        String id=user.getId();
//        i=DbUtil.update(sql,id);
//        return i;
//    }
//    //注销
//    @Override
//    public int delete(User user) {
//        int i;
//        String sql="UPDATE `bili_user` AS bu SET bu.deleted =  1 where bu.id=? ";
//        String id=user.getId();
//        i=DbUtil.update(sql,id);
//        return i;
//    }
//    //通过ID查找用户
//    @Override
//    public User selectId(String id) {
//        String sql="SELECT * FROM `bili_user` as bu where bu.id=?";
//        List<Map<String,Object>> list= DbUtil.query(sql,id);
//        User user=null;
//        if(list!=null&&list.size()>0){
//            Map<String,Object> map=list.get(0);//获取查询到的第一行数据
//            user=new User();//实例化
//            user.setId(StringUtil.valueOf(map.get("id")));//嵌套一层工具方法，防止空指针
//            user.setUsername(StringUtil.valueOf(map.get("username")));
//            user.setPassword(StringUtil.valueOf(map.get("password")));
//            user.setBirth(StringUtil.valueOf(map.get("birth")));
//            user.setHeadimg(StringUtil.valueOf(map.get("headimg")));
//            user.setSex(StringUtil.valueOf(map.get("sex")));
//            user.setAutograph(StringUtil.valueOf(map.get("autograph")));
//            user.setDeleted(StringUtil.valueOf(map.get("deleted")));
//            user.setModified_time(StringUtil.valueOf(map.get("modified_time")));
//        }
//        DbUtil.close();
//        return user;
//    }
//    //名称查询用户
//    @Override
//    public List<User> selectUser(String username) {
//        String uname;
//        if(username.equals("")){
//            uname="%";
//        }else{
//            uname="%"+username+"%";
//        }
//        String sql="select * from bili_user u where u.username like ? and u.deleted=0";
//        List<Map<String,Object>> list= DbUtil.query(sql,uname);
//        List<User> users=new ArrayList<User>();
//        User user=null;
//        if(list!=null&&list.size()>0){
//            user=new User();//实例化
//            for (Map<String,Object> map:list){
//                user.setId(StringUtil.valueOf(map.get("id")));//嵌套一层工具方法，防止空指针
//                user.setUsername(StringUtil.valueOf(map.get("username")));
//                user.setPassword(StringUtil.valueOf(map.get("password")));
//                user.setBirth(StringUtil.valueOf(map.get("birth")));
//                user.setHeadimg(StringUtil.valueOf(map.get("headimg")));
//                user.setSex(StringUtil.valueOf(map.get("sex")));
//                user.setAutograph(StringUtil.valueOf(map.get("autograph")));
//                user.setDeleted(StringUtil.valueOf(map.get("deleted")));
//                user.setModified_time(StringUtil.valueOf(map.get("modified_time")));
//                users.add(user);
//            }
//
//        }
//        DbUtil.close();
//        return users;
//    }
//
//    //查询视频
//    @Override
//    public List<Video> selectVideo(String videoname,int m,int n) {
//        String vname;
//        if(videoname.equals("")){
//            vname="%";
//        }else{
//            vname="%"+videoname+"%";
//        }
//        String sql="select * from bili_video as bv where videoname like ? and bv.deleted=0 limit ?,?";
//        List<Map<String,Object>> list= DbUtil.query(sql,vname,m,n);
//        List<Video> video=new ArrayList<Video>();
//        if(list!=null&&list.size()>0){
//            Video v=null;
//            for (Map<String,Object> map:list){
//                v=new Video();//实例化
//                v.setVid(StringUtil.valueOf(map.get("vid")));//嵌套一层工具方法，防止空指针
//                v.setUid(StringUtil.valueOf(map.get("uid")));
//                v.setVideoname(StringUtil.valueOf(map.get("videoname")));
//                v.setVideosrc(StringUtil.valueOf(map.get("videosrc")));
//                v.setImagesrc(StringUtil.valueOf(map.get("imagesrc")));
//                v.setHits(StringUtil.valueOf(map.get("hits")));
//                v.setSort(StringUtil.valueOf(map.get("sort")));
//                v.setDeleted(StringUtil.valueOf(map.get("deleted")));
//                v.setModified_time(StringUtil.valueOf(map.get("modified_time")));
//                video.add(v);
//            }
//        }
//        DbUtil.close();
//        return video;
//    }
//    //根据分类查询
//    @Override
//    public List<Video> selectSort(String sort) {
//        String sql="SELECT * FROM `bili_video` as bv where bv.sort=?";
//        List<Map<String,Object>> list= DbUtil.query(sql,sort);
//        List<Video> video=new ArrayList<Video>();
//        if(list!=null&&list.size()>0){
//            Video v=null;
//            for (Map<String,Object> map:list){
//                v=new Video();//实例化
//                v.setVid(StringUtil.valueOf(map.get("vid")));//嵌套一层工具方法，防止空指针
//                v.setUid(StringUtil.valueOf(map.get("uid")));
//                v.setVideoname(StringUtil.valueOf(map.get("videoname")));
//                v.setVideosrc(StringUtil.valueOf(map.get("videosrc")));
//                v.setImagesrc(StringUtil.valueOf(map.get("imagesrc")));
//                v.setHits(StringUtil.valueOf(map.get("hits")));
//                v.setSort(StringUtil.valueOf(map.get("sort")));
//                v.setDeleted(StringUtil.valueOf(map.get("deleted")));
//                v.setModified_time(StringUtil.valueOf(map.get("modified_time")));
//                video.add(v);
//            }
//        }
//        DbUtil.close();
//        return video;
//    }
//    //观看视频
//    @Override
//    public Video watchvideo(String vid) {
//        String sql="SELECT * FROM `bili_video` as bv where bv.vid=?";
//        List<Map<String,Object>> list= DbUtil.query(sql,vid);
//        Video v=null;
//        if(list!=null&&list.size()>0){
//            Map<String,Object> map=list.get(0);//获取查询到的第一行数据
//            v=new Video();//实例化
//            v.setVid(StringUtil.valueOf(map.get("vid")));//嵌套一层工具方法，防止空指针
//            v.setUid(StringUtil.valueOf(map.get("uid")));
//            v.setVideoname(StringUtil.valueOf(map.get("videoname")));
//            v.setVideosrc(StringUtil.valueOf(map.get("videosrc")));
//            v.setImagesrc(StringUtil.valueOf(map.get("imagesrc")));
//            v.setHits(StringUtil.valueOf(map.get("hits")));
//            v.setSort(StringUtil.valueOf(map.get("sort")));
//            v.setDeleted(StringUtil.valueOf(map.get("deleted")));
//            v.setModified_time(StringUtil.valueOf(map.get("modified_time")));
//        }
//        DbUtil.close();
//        return v;
//    }
//
//    //记录点击量
//    @Override
//    public int updateHits(String vid) {
//        String sql="UPDATE `bili_video` AS bu SET bu.hits = bu.hits+1  WHERE bu.vid = ?";
//        int i=DbUtil.update(sql,vid);
//        return i;
//    }
//    //下架视频
//    @Override
//    public int deleteVideo(String vid) {
//        int i;
//        String sql="UPDATE `bili_video` AS bv SET bv.deleted =  1 where bv.vid=?";
//        i=DbUtil.update(sql,vid);
//        return i;
//    }
//    //上架视频
//    @Override
//    public int addVideo(Video video) {
//        int i;
//        String sql="insert into `bili_video` (videoname,videosrc,imagesrc,uid,sort) values (?,?,?,?,?)";
//        if(video.getVideoname().equals("")||video.getUid().equals("")||video.getVideosrc().equals("")||video.getImagesrc().equals("")||video.getSort().equals("")){
//            i=0;
//        }else{
//            i=DbUtil.update(sql,video.getVideoname(),video.getVideosrc(),video.getImagesrc(),video.getUid(),video.getSort());
//            DbUtil.close();
//        }
//        return i;
//    }
//    //收藏视频
//    @Override
//    public int collection(String uid, String vid) {
//        int i;
//        String sql="insert into `bili_user_video_collection` (uid,vid) values (?,?)";
//        if(uid.equals("")||vid.equals("")){
//            i=0;
//        }else{
//            i=DbUtil.update(sql,uid,vid);
//            DbUtil.close();
//        }
//        return i;
//    }
//    //查询收藏
//    @Override
//    public List<Video> selectCollection(String uid) {
//        String sql="select * from( SELECT buv.uid,buv.vid,bv.videoname,bv.videosrc,bv.uid userid,bv.vid videoid,bv.sort,bv.modified_time,bv.hits,bv.deleted FROM bili_user_video_collection AS buv LEFT JOIN bili_video AS bv ON buv.vid = bv.vid)as b where b.uid=? and b.deleted=0";
//        List<Map<String,Object>> list= DbUtil.query(sql,uid);
//        List<Video> video=new ArrayList<Video>();
//        if(list!=null&&list.size()>0){
//            Video v=null;
//            for (Map<String,Object> map:list){
//                v=new Video();//实例化
//                v.setVid(StringUtil.valueOf(map.get("videoid")));//嵌套一层工具方法，防止空指针
//                v.setUid(StringUtil.valueOf(map.get("userid")));
//                v.setVideoname(StringUtil.valueOf(map.get("videoname")));
//                v.setVideosrc(StringUtil.valueOf(map.get("videosrc")));
//                v.setImagesrc(StringUtil.valueOf(map.get("imagesrc")));
//                v.setHits(StringUtil.valueOf(map.get("hits")));
//                v.setSort(StringUtil.valueOf(map.get("sort")));
//                v.setDeleted(StringUtil.valueOf(map.get("deleted")));
//                v.setModified_time(StringUtil.valueOf(map.get("modified_time")));
//                video.add(v);
//            }
//        }
//        DbUtil.close();
//        return video;
//    }
//
//    //取消收藏
//    @Override
//    public int remove(String uid,String vid) {
//        String sql="delete buvc from bili_user_video_collection as buvc where buvc.uid=? and buvc.vid=?";
//        int i;
//        i=DbUtil.update(sql,uid,vid);
//        return i;
//    }
//    //添加关注
//    @Override
//    public int addFollow(String uid, String followerid) {
//        int i;
//        String sql="insert into `bili_user_user_follow` (uid,followerid) values (?,?)";
//        if(uid.equals("")||followerid.equals("")){
//            i=0;
//        }else{
//            i=DbUtil.update(sql,uid,followerid);
//            DbUtil.close();
//        }
//        return i;
//    }
//    //取消关注
//    @Override
//    public int deleteFollow(String uid, String followerid) {
//        String sql="delete buuf from bili_user_user_follow as buuf where buuf.uid=? and buuf.followerid=?";
//        int i;
//        i=DbUtil.update(sql,uid,followerid);
//        return i;
//    }
//    //查询关注
//    @Override
//    public List<User> selectFollow(String uid) {
//        String sql="select * from( SELECT buuf.uid,buuf.followerid,bu.id,bu.username,bu.headimg,bu.autograph,bu.`status`,bu.deleted FROM bili_user_user_follow AS buuf LEFT JOIN bili_user AS bu ON buuf.followerid = bu.id)as b where b.uid=? and b.deleted=0";
//        List<Map<String,Object>> list=DbUtil.query(sql,uid);
//        List<User> users=new ArrayList<User>();
//        if(list!=null&&list.size()>0){
//            User user=null;
//            for (Map<String,Object> map:list){
//                user=new User();//实例化
//                user.setId(StringUtil.valueOf(map.get("id")));//嵌套一层工具方法，防止空指针
//                user.setUsername(StringUtil.valueOf(map.get("username")));
//                user.setHeadimg(StringUtil.valueOf(map.get("headimg")));
//                user.setAutograph(StringUtil.valueOf(map.get("autograph")));
//                user.setDeleted(StringUtil.valueOf(map.get("deleted")));
//                user.setStatus(StringUtil.valueOf(map.get("status")));
//                users.add(user);
//            }
//        }
//        DbUtil.close();
//        return users;
//    }
//    //查看动态
//    @Override
//    public List<Video> selectNews(String uid) {
//        String sql="select * from( SELECT buuf.uid,buuf.followerid,bv.videoname,bv.videosrc,bv.vid videoid,bv.sort,bv.modified_time,bv.hits,bv.imagesrc,bv.deleted FROM bili_user_user_follow AS buuf LEFT JOIN bili_video AS bv ON buuf.followerid = bv.uid)as b where b.uid=? and b.deleted=0";
//        List<Map<String,Object>> list=DbUtil.query(sql,uid);
//        List<Video> video=new ArrayList<Video>();
//        if(list!=null&&list.size()>0){
//            Video v=null;
//            for (Map<String,Object> map:list){
//                v=new Video();//实例化
//                v.setVid(StringUtil.valueOf(map.get("videoid")));//嵌套一层工具方法，防止空指针
//                v.setUid(StringUtil.valueOf(map.get("followerid")));
//                v.setVideoname(StringUtil.valueOf(map.get("videoname")));
//                v.setVideosrc(StringUtil.valueOf(map.get("videosrc")));
//                v.setImagesrc(StringUtil.valueOf(map.get("imagesrc")));
//                v.setHits(StringUtil.valueOf(map.get("hits")));
//                v.setSort(StringUtil.valueOf(map.get("sort")));
//                v.setDeleted(StringUtil.valueOf(map.get("deleted")));
//                v.setModified_time(StringUtil.valueOf(map.get("modified_time")));
//                video.add(v);
//            }
//        }
//        DbUtil.close();
//        return video;
//    }
//}
