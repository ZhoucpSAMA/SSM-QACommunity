package com.laozhou.dao;

import com.laozhou.pojo.Problem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemMapper {
    List<Problem> getAllTitle();

    List<Problem> getAllProblems();

    int addProblem(Problem problem);

    int delProblemById(@Param("problem_id") Integer problem_id);

    int updateProblem(Problem problem);

    int getProblemNums();

    Problem getProblemById(@Param("problem_id")Integer problem_id);

    String getCurProblemUser(@Param("problem_id")Integer problem_id);

}
