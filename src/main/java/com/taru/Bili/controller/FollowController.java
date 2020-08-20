package com.taru.Bili.controller;

import com.taru.Bili.common.JsonResult;
import com.taru.Bili.entity.News;
import com.taru.Bili.entity.Vo.UserVo;
import com.taru.Bili.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FollowController {
    @Autowired
    IUserService iUserService;
    //查询关注
    @RequestMapping(value = "/api/follow",method = RequestMethod.GET )
    @ResponseBody
    public JsonResult selectFollow(@RequestParam(value = "id",required = true) Integer uid){
        JsonResult js=null;
        UserVo list=null;
        try{
            list=iUserService.selectFollow(uid);
            js=new JsonResult(200,"查询成功",list);
        }catch (Exception e){
            js=new JsonResult(500,"查询失败",e.getMessage());
        }
        return js;
    }
    //添加关注
    @RequestMapping(value = "/api/follow/add",method = RequestMethod.POST )
    @ResponseBody
    public JsonResult addFollow(Integer uid,Integer followerid){
        JsonResult js=null;
        try{
            iUserService.addFollow(uid,followerid);
            js=new JsonResult(200,"关注成功！");
        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //取消关注
    @RequestMapping(value = "/api/follow/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult deleteCollection(@RequestParam(value = "uid") Integer uid,
                                       @RequestParam(value = "followerid") Integer followerid){
        JsonResult js=null;
        try{
            iUserService.deleteFollow(uid,followerid);
            js=new JsonResult(200,"操作成功");
        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //查看动态
    @RequestMapping(value = "/api/news",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectVideo(Integer uid){
        JsonResult js=null;
        List<News> list=null;
        try{
            list=iUserService.selectNews(uid);
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


}
