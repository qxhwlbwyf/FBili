package com.taru.Bili.dao;

import com.taru.Bili.entity.Sort;
import com.taru.Bili.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IVideoDao {
    /**
     * 查询个人上传视频
     */
    List<Video> selectUserVideo(Integer uid);
    /**
     * 查询视频
     */
    public List<Video> selectVideo(@Param("videoname") String videoname);
    /**
     * 查询 分类
     */
    List<Sort> selectSort();
    /**
     * 根据分类查询视频
     */
    public List<Video> selectBySort(Integer sortid);
    /**
     * 查看视频
     */
    public Video watchvideo(Integer vid);
    /**
     * 增加点击量
     */
    public void updateHits(Integer vid);
    /**
     * 下架视频
     */
    public void deleteVideo(Integer vid);
    /**
     * 上传视频
     */
    public void addVideo(Video video);
    /**
     * 收藏视频
     */
    public void collection(@Param("uid")Integer uid,@Param("vid")Integer vid);
    /**
     * 查询收藏
     */
    public List<Video> selectCollection(Integer uid);
    /**
     * 取消收藏
     */
    public void remove(@Param("uid")Integer uid,@Param("vid")Integer vid);
}
