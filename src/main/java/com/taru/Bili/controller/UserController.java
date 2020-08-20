package com.taru.Bili.controller;

import com.taru.Bili.common.JsonResult;
import com.taru.Bili.entity.User;
import com.taru.Bili.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Resource(name="headimg")
    String headimgSRC;
    //注册
    @RequestMapping(value = "/api/user/register",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult register(@RequestParam(value = "username")String username,
                               @RequestParam(value = "password")String password,
                               @RequestParam(value = "headimg",required = false)MultipartFile headimg,
                               @RequestParam(value = "birth")String  birth,
                               @RequestParam(value = "autograph") String autograph,
                               @RequestParam(value = "sex") Integer sex){
        JsonResult js=null;
        //获取上传文件的名称
        String fileName = headimg.getOriginalFilename();
        //解决文件重名问题
        String videoName = UUID.randomUUID().toString().substring(0,5)+fileName.substring(fileName.lastIndexOf("."));
        //获取上传文件的路径
        File file=new File(headimgSRC);
        //测试此抽象路径名表示的文件或目录是否存在
        if(!file.exists()){
            /**
             *  mkdir() 如果你想在已经存在的文件夹(D盘下的yyy文件夹)下建立新的文件夹（2010-02-28文件夹），就可以用此方法。
             *  此方法不能在不存在的文件夹下建立新的文件夹。假如想建立名字是”2010-02-28”文件夹，那么它的父文件夹必须存在。
             *
             *  mkdirs() 如果你想根据File里的路径名建立文件夹（当你不知道此文件夹是否存在，也不知道父文件夹存在），就可用此方法，
             *  它建立文件夹的原则是：如果父文件夹不存在并且最后一级子文件夹不存在，它就自动新建所有路经里写的文件夹；如果父文件夹存在，它就直接在已经存在的父文件夹下新建子文件夹。
             */
            file.mkdirs();
        }
        if(headimg!=null||!headimg.isEmpty()){
            String path = file.getAbsolutePath()+File.separator+videoName;
            try {
                headimg.transferTo(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("video文件上传有错");
            }
        }else{
            System.out.println("文件上传为空！");
        }
        //存入数据库路径
        String pathh="/headimg/"+videoName;
        //判断用户名密码是否为空
        if(password.isEmpty()||username.isEmpty()){
            System.out.println("啊啊啊啊啊啊啊啊啊啊啊");
            js=new JsonResult(404,"注册失败！用户名或密码不能为空");
            return js;
        }
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setHeadimg(pathh);
        user.setBirth(birth);
        user.setAutograph(autograph);
        user.setSex(sex);
        try{
            userService.register(user);
            js=new JsonResult(200,"注册成功！");

        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //注销
    @RequestMapping(value = "/api/user/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult delete(@RequestBody User user){
        JsonResult js=null;
        try{
            userService.delete(user);
            js=new JsonResult(200,"注销成功");
        }catch (Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //通过ID查找用户
    @RequestMapping(value = "/api/user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectId(@PathVariable(value = "id",required = true) Integer id){
        JsonResult js=null;
        User user=null;
        try{
            user=userService.selectId(id);
            if(user!=null){
                js=new JsonResult(200,"查询成功",user);
            }else {
                js=new JsonResult(404,"用户ID错误");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }
    //名称查询
    @RequestMapping(value = "/api/user/select",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectUser(String username){
        JsonResult js=null;
        List<User> user=null;
        try{
            user=userService.selectUser(username);
            if(user!=null){
                js=new JsonResult(200,"查询成功",user);
            }else {
                js=new JsonResult(404,"用户名称错误");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            js=new JsonResult(500,"服务器内部错误");
        }
        return js;
    }


}
