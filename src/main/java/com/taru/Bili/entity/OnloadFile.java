package com.taru.Bili.entity;

public class OnloadFile {
    String videosrc;
    String imagesrc;

    public OnloadFile(){}

    public OnloadFile(String videosrc, String imagesrc) {
        this.videosrc = videosrc;
        this.imagesrc = imagesrc;
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
}
