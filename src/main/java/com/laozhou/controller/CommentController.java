package com.laozhou.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.laozhou.pojo.Comment;
import com.laozhou.service.CommentServiceImpl;
import com.laozhou.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

@Controller
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/comment/add")
    @ResponseBody
    public String addComment(@RequestParam("comment_user_id") String comment_user_id,
                             @RequestParam("comment_content") String comment_content,
                             @RequestParam("answer_id") String answer_id){
        int role = 0;
        if (comment_user_id != null) {
            role = userService.getRoleById(comment_user_id);
        }
        HashMap<Object, Object> map = new HashMap<>();
        if (comment_content != null && answer_id != null && role != 0) {
            Comment comment = new Comment();
            comment.setComment_content(comment_content);
            comment.setComment_date(new Date());
            comment.setAnswer_id(Integer.parseInt(answer_id));
            comment.setComment_user_id(Integer.parseInt(comment_user_id));
            commentService.addComment(comment);
            map.put("code", "1");
            map.put("msg", "发布成功!");
            return JSON.toJSONString(map);
        }
        map.put("code", "0");
        map.put("msg", "用户无权限!");
        return JSON.toJSONString(map);
    }
        @RequestMapping("/comment/getCommentByAnswerID")
    @ResponseBody
    public String getProblemById(@RequestParam("answer_id") String answer_id) {

        if(answer_id!=null){
            return JSON.toJSONString(commentService.getCommentByAnswerID(Integer.parseInt(answer_id)));
        }
        return null;
    }

}
