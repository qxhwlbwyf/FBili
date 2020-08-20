package com.taru.Bili.controller;

import com.taru.Bili.common.JsonResult;
import com.taru.Bili.entity.Token;
import com.taru.Bili.entity.User;
import com.taru.Bili.entity.UserToken;
import com.taru.Bili.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 相当于登录Api
 */
@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    //登录
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(@RequestBody User user){

        User user1=userService.land(user);
        Integer id=user1.getId();
        userService.land1(id);
        User user2=userService.land2(id);
        JsonResult js=null;
        Token token=new Token("lanqiao123456");
        UserToken ut=new UserToken(token,user2);
        try{
            //判断用户名或密码是否正确
            if(user2==null){
                //返回消息“登陆失败用户名或密码错误” code：404
                js=new JsonResult(404,"用户名或密码错误");
            }else{

                //返回消息”登陆成功“
                js=new JsonResult(200,"登陆成功",ut);
            }
        }catch (Exception e){
            /*System.out.println("请求失败");
            e.printStackTrace();*/
            //返回错误消息
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }

    //退出
    @RequestMapping(value = "/api/logout",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult logout(@RequestBody User user){
        JsonResult js=null;
        try{
            userService.logout(user);
            js=new JsonResult(200,"退出成功");
        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }



}
