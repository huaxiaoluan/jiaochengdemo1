package cn.yykjc.jiaochengdemo.user.controller;

import cn.yykjc.jiaochengdemo.user.entity.UserEntity;
import cn.yykjc.jiaochengdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/*
*ResController=@ResponsrBody+@Controller
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping("/getAll")
    public List<UserEntity> getAll(Map map){
      return userService.getAll(map);

    }
    @RequestMapping("/delById")
    public String delById(Integer id){
        userService.delById(id);
        return "redirect:/index.html";/*跳回本页面*/
    }
    //保存用户
    //实体类和数据相互转换
    @RequestMapping("/save")
    @ResponseBody//通常用于返回json数据或者xml
    public String save(@RequestBody UserEntity userEntity){

        userService.save(userEntity);
        return  "success";//@RequestBody会默认返回一个页面
    }

}
