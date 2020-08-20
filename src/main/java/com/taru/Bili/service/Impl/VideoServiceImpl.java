package com.taru.Bili.service.Impl;

import com.taru.Bili.dao.IVideoDao;
import com.taru.Bili.entity.Sort;
import com.taru.Bili.entity.Video;
import com.taru.Bili.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements IVideoService {
    @Autowired
    IVideoDao  iVideoDao;
    @Override
    public List<Video> selectUserVideo(Integer uid) {
        return iVideoDao.selectUserVideo(uid);
    }
    @Override
    public List<Video> selectVideo(String videoname) {
        return iVideoDao.selectVideo(videoname);
    }

    @Override
    public List<Sort> selectSort() {
        return iVideoDao.selectSort();
    }

    @Override
    public List<Video> selectBySort(Integer sortid) {
        return iVideoDao.selectBySort(sortid);
    }

    @Override
    public Video watchvideo(Integer vid) {
        return iVideoDao.watchvideo(vid);
    }

    @Override
    public void updateHits(Integer vid) {
        iVideoDao.updateHits(vid);
    }

    @Override
    public void deleteVideo(Integer vid) {
        iVideoDao.deleteVideo(vid);
    }

    @Override
    public void addVideo(Video video) {
        iVideoDao.addVideo(video);
    }

    @Override
    public void collection(Integer uid, Integer vid) {
        iVideoDao.collection(uid, vid);
    }

    @Override
    public List<Video> selectCollection(Integer uid) {
        return iVideoDao.selectCollection(uid);
    }

    @Override
    public void remove(Integer uid, Integer vid) {
        iVideoDao.remove(uid, vid);
    }
}
