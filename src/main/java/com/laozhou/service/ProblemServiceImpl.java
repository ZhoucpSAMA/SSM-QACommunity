package com.laozhou.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laozhou.dao.ProblemMapper;
import com.laozhou.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public List<Problem> getAllTitle() {
        return problemMapper.getAllTitle();
    }

    @Override
    public List<Problem> getAllProblems() {
        return problemMapper.getAllProblems();
    }

    @Override
    public int addProblem(Problem problem) {
        return problemMapper.addProblem(problem);
    }

    @Override
    public int delProblemById(Integer problem_id) {
        return problemMapper.delProblemById(problem_id);
    }

    @Override
    public int updateProblem(Problem problem) {
        return problemMapper.updateProblem(problem);
    }

    @Override
    public int getProblemNums() {
        return problemMapper.getProblemNums();
    }

    @Override
    public Problem getProblemById(Integer problem_id) {
        return problemMapper.getProblemById(problem_id);
    }

    @Override
    public String getCurProblemUser(Integer problem_id) {
        return problemMapper.getCurProblemUser(problem_id);
    }

    @Override
    public PageInfo<Problem> getAllProblemsByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Problem> list = problemMapper.getAllProblems();
        return new PageInfo<>(list);
    }
}
