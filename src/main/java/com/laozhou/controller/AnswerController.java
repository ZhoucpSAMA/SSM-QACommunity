package com.laozhou.controller;

import com.alibaba.fastjson.JSON;
import com.laozhou.pojo.Answer;
import com.laozhou.pojo.Problem;
import com.laozhou.service.AnswerServiceImpl;
import com.laozhou.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class AnswerController {
    @Autowired
    private AnswerServiceImpl answerService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getAnswerNums")
    @ResponseBody
    public String getAnswerNums() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("answerNums", Integer.toString(answerService.getAnswerNums()));
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getAnswerByProblemId")
    @ResponseBody
    public String getAnswerByProblemId(@RequestParam("id") String id) {
        if (id != null) {
            List<Answer> list = answerService.getAllAnswerByProblemId(Integer.parseInt(id));
            return JSON.toJSONString(list);
        }
        return null;
    }

    @RequestMapping("/getCurAnswerUser")
    @ResponseBody
    public String getCurAnswerUser(@RequestParam("id") String id) {
        return answerService.getCurAnswerUser(Integer.parseInt(id));
    }

    @RequestMapping("/answer/add")
    @ResponseBody
    public String addAnswer(
            @RequestParam("problem_id") String problem_id,
            @RequestParam("user_id") String user_id,
            @RequestParam("content") String content
    ) {

        int status = 0;
        if (user_id != null) {
            status = userService.getStatusById(user_id);
        }
        HashMap<Object, Object> map = new HashMap<>();
        if (user_id != null && problem_id != null && content != null && status != 0) {
            Answer answer = new Answer();
            answer.setAnswer_user_id(Integer.parseInt(user_id));
            answer.setAnswer_date(new Date());
            answer.setAnswer_likes(0);
            answer.setProblem_answer(content);
            answer.setProblem_id(Integer.parseInt(problem_id));
            answerService.addAnswer(answer);
            map.put("code", "1");
            map.put("msg", "发布成功!");
            return JSON.toJSONString(map);
        }
        map.put("code", "0");
        map.put("msg", "用户无权限!");
        return JSON.toJSONString(map);
    }

    @RequestMapping("/answer/del")
    @ResponseBody
    public String delAnswerByID(@RequestParam("answer_id") String answer_id) {
        if (answer_id != null) {
            return JSON.toJSONString(answerService.delAnswerById(Integer.parseInt(answer_id)));
        }
        return null;
    }
    @RequestMapping("/answer/likes")
    @ResponseBody
    public String likesAdd(@RequestParam("answer_id") String answer_id){
        if(answer_id!=null){
            int likes = answerService.getLikeByAnswerID(Integer.parseInt(answer_id));
            likes+=1;
            answerService.likesAdd(Integer.parseInt(answer_id), likes);
            return "1";
        }
        return "0";
    }


//    @RequestMapping("/isPost")
//    @ResponseBody
//    public String hasPost(@RequestParam("problem_id") String problem_id) {
//
//        List<Answer> list = answerService.getAllAnswerByProblemId(Integer.parseInt(problem_id));
//        if(list.size()==0){
//            return "0";
//        }
//        return "1";
//    }
}
