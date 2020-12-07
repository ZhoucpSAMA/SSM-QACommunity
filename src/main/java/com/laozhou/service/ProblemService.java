package com.laozhou.service;

import com.github.pagehelper.PageInfo;
import com.laozhou.pojo.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemService {
    List<Problem> getAllTitle();

    List<Problem> getAllProblems();

    int addProblem(Problem problem);

    int delProblemById(Integer problem_id);

    int updateProblem(Problem problem);

    int getProblemNums();

    Problem getProblemById(Integer problem_id);

    String getCurProblemUser(Integer problem_id);

    PageInfo<Problem> getAllProblemsByPage(Integer pageNum, Integer pageSize);
}
