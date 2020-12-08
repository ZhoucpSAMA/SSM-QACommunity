package com.laozhou.controller;

import com.alibaba.fastjson.JSON;
import com.laozhou.service.RankService;
import com.laozhou.service.RankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController {
    @Autowired
    private RankServiceImpl rankService;
    @RequestMapping("/getRankByProblemID")
    public String getRankByProblemID(@RequestParam("id")String problem_id){
        if(problem_id!=null){
            return JSON.toJSONString(rankService.getRankByProblemId(Integer.parseInt(problem_id)));
        }
        return null;
    }

}
