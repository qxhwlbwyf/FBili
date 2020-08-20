package com.taru.Bili.entity;

public class Collection {
    private Integer cid;
    private Integer uid;
    private Integer vid;

    public Collection (){

    }
    public Collection( Integer cid,Integer uid,Integer vid){
        this.cid=cid;
        this.uid=uid;
        this.vid=vid;
    }
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }




}
