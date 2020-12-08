package com.laozhou.service;

import com.laozhou.pojo.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerService {
    int addAnswer(Answer answer);

    int delAnswerById(Integer answer_id);
    int delAnswerByProblemId(Integer problem_id);
    int updateAnswer(Answer answer);

    List<Answer> getAllAnswerByProblemId(Integer problem_id);

    int getAnswerNums();

    List<Answer> getAllAnswerByUserId(Integer answer_user_id);

    String getCurAnswerUser(Integer answer_id);

    List<Answer> getAnswerByProblemIdAndUserId(Integer problem_id, Integer answer_user_id);

    int getLikeByAnswerID(Integer answer_id);

    int likesAdd(Integer answer_id,Integer answer_likes);

}
