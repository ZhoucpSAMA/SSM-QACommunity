package com.laozhou.controller;

import com.alibaba.fastjson.JSON;
import com.laozhou.pojo.Answer;
import com.laozhou.service.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class AnswerController {
    @Autowired
    private AnswerServiceImpl answerService;
    @RequestMapping("/getAnswerNums")
    @ResponseBody
    public String getAnswerNums(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("answerNums",Integer.toString(answerService.getAnswerNums()));
        return JSON.toJSONString(map);
    }
    @RequestMapping("/getAnswerByProblemId")
    @ResponseBody
    public String getAnswerByProblemId(@RequestParam("id")String id){
        if(id!=null){
            List<Answer> list = answerService.getAllAnswerByProblemId(Integer.parseInt(id));
            return JSON.toJSONString(list);
        }
        return null;
    }
}
