package com.laozhou.service;

import com.laozhou.pojo.Answer;

import java.util.List;

public interface AnswerService {
    int addAnswer(Answer answer);

    int delAnswerById(Integer answer_id);

    int updateAnswer(Answer answer);

    List<Answer> getAllAnswerByProblemId(Integer problem_id);

    int getAnswerNums();

    List<Answer> getAllAnswerByUserId(Integer answer_user_id);

}
