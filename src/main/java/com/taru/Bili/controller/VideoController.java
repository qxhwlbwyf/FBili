package com.taru.Bili.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taru.Bili.common.JsonResult;
import com.taru.Bili.entity.Sort;
import com.taru.Bili.entity.Video;
import com.taru.Bili.entity.OnloadFile;
import com.taru.Bili.service.Impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class VideoController {
    @Autowired
    VideoServiceImpl videoService;
    @Resource(name="videosrc")
    String videosrc;
    @Resource(name="imagesrc")
    String imagesrc;
    //查询个人上传视频
    @RequestMapping(value = "/api/personal",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectUserVideo(Integer uid){
        JsonResult js=null;
        try{
            List<Video> list=videoService.selectUserVideo(uid);
            js=new JsonResult(200,"查询成功",list);
        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误",ex.getMessage());
        }
        return  js;
    }
    //查询视频列表
    @RequestMapping(value = "/api/video",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectVideo(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pagenum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pagesize,
                                  @RequestParam(value = "videoname",required = false,defaultValue = "")String videoname){
        JsonResult js=null;
        List<Video> list=null;
        try{
            PageHelper.startPage(pagenum,pagesize);
            list=videoService.selectVideo(videoname);
            PageInfo pageInfo=new PageInfo(list);
            if(list.size()>0){
                js=new JsonResult(200,"查询成功",pageInfo);
            }else{
                js=new JsonResult(404,"查询失败");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //查询分类
    @RequestMapping(value = "/api/sort",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectSort(){
        JsonResult js=null;
        try{
            List<Sort> list=videoService.selectSort();
            if(list.size()>0){
                js=new JsonResult(200,"查询分类成功",list);
            }else{
                js=new JsonResult(404,"查询失败");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"内部错误");
        }
        return js;
    }


    //根据分类查询
    @RequestMapping(value = "/api/video/sort",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectVideoBySort(Integer sortid){
        JsonResult js=null;
        List<Video> list=null;
        try{
            list=videoService.selectBySort(sortid);
            if(list.size()>0){
                js=new JsonResult(200,"查询成功",list);
            }else{
                js=new JsonResult(404,"查询失败");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //查看视频
    @RequestMapping(value = "/api/video/{vid}",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult watchVideo(@PathVariable("vid") Integer vid){
        JsonResult js=null;
        Video video=null;
        try{
            video=videoService.watchvideo(vid);
            if(video!=null){
                js=new JsonResult(200,"查询成功",video);
            }else {
                js=new JsonResult(404,"视频ID错误");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //记录点击次数
    @RequestMapping(value = "/api/video/hits",method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult updateHits(@RequestBody Video video){
        Integer vid=video.getVid();
        JsonResult js=null;
        try{
            videoService.updateHits(vid);
            js=new JsonResult(200,"记录成功");
        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //上架视频--上传视频
    @RequestMapping(value = "/api/video/addvideo",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult onloadVideo(@RequestParam(value = "video") MultipartFile vidoeFile){
        OnloadFile onload=new OnloadFile();
        JsonResult js=null;
        //shipin获取上传文件的名称
        String fileName = vidoeFile.getOriginalFilename();
        //解决文件重名问题
        String videoName = UUID.randomUUID().toString().substring(0,5)+fileName.substring(fileName.lastIndexOf("."));
        File file=new File(videosrc);
        File file1=new File(imagesrc);
        if(file.exists()){
            file.mkdirs();
        }
        if(file1.exists()){
            file1.mkdirs();
        }
        //获取上传文件的路径
        String path = videosrc+File.separator+videoName;
        String pathh="/video/"+videoName;
        onload.setVideosrc(pathh);
        try {
            vidoeFile.transferTo(new File(path));
            js=new JsonResult(200,"上传成功！",onload);
        } catch (IOException e) {
            e.printStackTrace();
            js=new JsonResult(500,"服务器内部错误",e.getMessage());
            System.out.println("video文件上传有错");
        }
        return js;
    }
    //上架视频--上传图片
    @RequestMapping(value = "/api/video/addimage",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult onloadImage(@RequestParam(value = "image") MultipartFile imageFile){
        OnloadFile onload=new OnloadFile();
        JsonResult js=null;
        //tupian获取上传文件的名称
        String fileName1 = imageFile.getOriginalFilename();
        //解决文件重名问题
        String imageName = UUID.randomUUID().toString().substring(0,5)+fileName1.substring(fileName1.lastIndexOf("."));
        //获取上传文件的路径
        String path1 = imagesrc+File.separator+imageName;
        String pathh1="/image/"+imageName;
        onload.setImagesrc(pathh1);
        try {
            imageFile.transferTo(new File(path1));
            js=new JsonResult(200,"上传成功！",onload);
        } catch (IOException e) {
            e.printStackTrace();
            js=new JsonResult(500,"服务器内部错误",e.getMessage());
            System.out.println("video文件上传有错");
        }
        return js;
    }
    //上架视频--存入数据库
    @RequestMapping(value = "/api/video/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addVideo(@RequestParam(value = "videoname")String videoname,
                               @RequestParam(value = "uid")Integer uid,
                               @RequestParam(value = "sort")Integer sort,
//                               @RequestParam(value = "description",required = false)String description,
                               @RequestParam(value = "videosrc") String vidoesrc,
                               @RequestParam(value = "imagesrc") String imagesrc){
        Video video=new Video();
        video.setSortid(sort);
        video.setUid(uid);
        video.setVideoname(videoname);
        video.setVideosrc(vidoesrc);
        video.setImagesrc(imagesrc);
        JsonResult js=null;
        try{
            videoService.addVideo(video);
            js=new JsonResult(200,"上传成功！");

        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //下架视频
    @RequestMapping(value = "/api/video/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult deleteVideo(@RequestParam(value = "vid") Integer vid){
        JsonResult js=null;
        try{
            videoService.deleteVideo(vid);
            js=new JsonResult(200,"操作成功");

        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //收藏视频
    @RequestMapping(value = "/api/collection/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult collection(@RequestParam(value = "uid") Integer uid,
                                 @RequestParam(value = "vid") Integer vid){
        JsonResult js=null;
        try{
            videoService.collection(uid,vid);
            js=new JsonResult(200,"收藏成功！");
        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //查询收藏
    @RequestMapping(value = "/api/collection",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectVideo(Integer uid){
        JsonResult js=null;
        List<Video> list=null;
        try{
            list=videoService.selectCollection(uid);
            if(list.size()>0){
                js=new JsonResult(200,"查询成功",list);
            }else{
                js=new JsonResult(404,"查询失败");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //取消收藏
    @RequestMapping(value = "/api/collection/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult deleteCollection(@RequestParam(value = "uid") Integer uid,
                                       @RequestParam(value = "vid") Integer vid){
        JsonResult js=null;
        try{
            videoService.remove(uid,vid);
            js=new JsonResult(200,"操作成功");
        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
}
