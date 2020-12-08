package com.laozhou.controller;

import com.alibaba.fastjson.JSON;
import com.laozhou.pojo.User;
import com.laozhou.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/user/getAnswerTotal")
    @ResponseBody
    public String getAnswerTotal() {
        return JSON.toJSONString(userService.getUserTotal());
    }
    @RequestMapping("/getUserNums")
    @ResponseBody
    public String getUserTotal(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("userNums",Integer.toString(userService.getUserTotal()));
        return JSON.toJSONString(map);
    }
    @PostMapping("/registerUser")
    @ResponseBody
    public String registerUser(@RequestParam("username")String username,
                               @RequestParam("password")String password,
                               @RequestParam("email")String email){
        HashMap<Object, Object> map = new HashMap<>();
        if(username!=null&&password!=null&&email!=null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setStatus("1");
            user.setRole(0);
            userService.addUser(user);
            map.put("code","1");
            map.put("msg","注册成功!");
            return JSON.toJSONString(map);
        }
        map.put("code","0");
        map.put("msg","注册失败!");
        return JSON.toJSONString(map);
    }
    @RequestMapping("/getID")
    @ResponseBody
    public String getID(@RequestParam("username")String username){
        int id = userService.getIDByUsername(username);
        return String.valueOf(id);

    }

}
