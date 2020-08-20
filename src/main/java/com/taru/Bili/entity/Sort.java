package com.taru.Bili.entity;

import java.util.List;

public class Sort {
    Integer id;
    String sortName;
    List<Video> Videos;

public Sort(){

}
    public Sort(Integer id, String sortName) {
        this.id = id;
        this.sortName = sortName;
    }
    public Sort(Integer id, String sortName, List<Video> Videos) {
        this.id = id;
        this.sortName = sortName;
        this.Videos = Videos;
    }

    public List<Video> getVideos() {
        return Videos;
    }

    public void setVideos(List<Video> Videos) {
        this.Videos = Videos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}
