package com.laozhou.service;

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
}
