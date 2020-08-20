package com.taru.Bili.entity;

import java.util.Date;

public class Video {
    private Integer vid;
    private String videoname;       //视频名称
    private String videosrc;        //视频文件路径
    private String imagesrc;        //图片文件路径
    private Integer uid;             //上传者id
    private Integer sortid;            //视频分类（数字类型）
    private Integer hits;            //点击量
    private Integer deleted;         //是否删除
    private String modifiedTime;   //修改时间


    public Video(){

    }
    public Video(Integer vid,String videoname,String videosrc,String imagesrc,Integer uid,Integer hits,Integer sortid,Integer deleted,String modifiedTime){
        this.vid=vid;
        this.videoname=videoname;
        this.uid=uid;
        this.videosrc=videosrc;
        this.imagesrc=imagesrc;
        this.hits=hits;
        this.sortid=sortid;
        this.deleted=deleted;
        this.modifiedTime=modifiedTime;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public String getVideosrc() {
        return videosrc;
    }

    public void setVideosrc(String videosrc) {
        this.videosrc = videosrc;
    }

    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }



}
