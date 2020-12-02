package com.laozhou.controller;

import com.alibaba.fastjson.JSON;
import com.laozhou.pojo.LoginInfo;
import com.laozhou.pojo.User;
import com.laozhou.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    LoginInfo info;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        User user = userService.getUserByName(username);
        if (user == null) {
            info.setCode("0");
            info.setMsg("账号不存在");
            return JSON.toJSONString(info);
        }
        if (username != null && password != null && username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            if ("0".equals(user.getStatus())) {
                info.setCode("0");
                info.setMsg("该用户被封禁");
                return JSON.toJSONString(info);
            }
            session.setAttribute("userSession", user);
            info.setCode("1");
            info.setMsg("登陆成功");
            info.setRole(user.getRole());
            info.setUsername(user.getUsername());
            info.setToken(session.getId());
            return JSON.toJSONString(info);
        } else {
            info.setCode("0");
            info.setMsg("账号或密码错误");
        }
        return JSON.toJSONString(info);
    }
    @RequestMapping("/user/loginInfo")
    @ResponseBody
    public String getLoginInfo(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("userSession")!=null){
            HashMap<Object, Object> map = new HashMap<>();
            map.put("username",info.getUsername());
            map.put("role",info.getRole());
            map.put("id",userService.getIDByUsername(info.getUsername()));
            return JSON.toJSONString(map);
        }
        return null;
    }

    @RequestMapping("/user/logout")
    @ResponseBody
    public String logout(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("userSession")!=null) {
            session.removeAttribute("userSession");
            return "1";
        }
        return "0";
    }

}
