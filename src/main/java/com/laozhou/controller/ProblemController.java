package com.laozhou.controller;

import com.alibaba.fastjson.JSON;
import com.laozhou.Utils.DateUtil;
import com.laozhou.pojo.Problem;
import com.laozhou.service.ProblemServiceImpl;
import com.laozhou.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProblemController {
    @Autowired
    private ProblemServiceImpl problemService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getProblemNums")
    @ResponseBody
    public String getProblemTotal() {
        HashMap<Object, String> map = new HashMap<>();
        map.put("problemNums", Integer.toString(problemService.getProblemNums()));
        return JSON.toJSONString(map);
    }

    @GetMapping("/getAllProblem")
    @ResponseBody
    public String getAllProblem() {
        List<Problem> problems = problemService.getAllProblems();
        return JSON.toJSONString(problems);
    }

    @RequestMapping("/getProblemById")
    @ResponseBody
    public String getProblemById(@RequestParam("id") String problem_id) {
        Integer problemId = Integer.parseInt(problem_id);
        return JSON.toJSONString(problemService.getProblemById(problemId));
    }

    @RequestMapping("/getCurProblemUser")
    @ResponseBody
    public String getCurProblemUser(@RequestParam("id") String problem_id) {
        Integer id = Integer.parseInt(problem_id);
        return problemService.getCurProblemUser(id);

    }

    @RequestMapping("/problem/add")
    @ResponseBody
    public String addProblem(
            @RequestParam("user_id") String user_id,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {

        int role = 0;
        if (user_id != null) {
            role = userService.getRoleById(user_id);
        }
        HashMap<Object, Object> map = new HashMap<>();
        if (title != null && content != null && role != 0) {
            Problem problem = new Problem();
            problem.setProblem_content(content);
            problem.setProblem_title(title);
            problem.setProblem_user_id(Integer.parseInt(user_id));
            problem.setProblem_date(new Date());
            problemService.addProblem(problem);
            map.put("code", "1");
            map.put("msg", "发布成功!");
            return JSON.toJSONString(map);
        }

        map.put("code", "0");
        map.put("msg", "用户无权限!");
        return JSON.toJSONString(map);
    }
}
