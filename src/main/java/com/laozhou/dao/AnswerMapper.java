package com.laozhou.dao;

import com.laozhou.pojo.Answer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerMapper {
    int addAnswer(Answer answer);

    int delAnswerById(@Param("answer_id") Integer answer_id);

    int updateAnswer(Answer answer);

    List<Answer> getAllAnswerByProblemId(@Param("problem_id") Integer problem_id);

    int getAnswerNums();

    List<Answer> getAllAnswerByUserId(@Param("answer_user_id") Integer answer_user_id);
}
