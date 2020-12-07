package com.laozhou.service;

import com.laozhou.dao.AnswerMapper;
import com.laozhou.pojo.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public int addAnswer(Answer answer) {
        return answerMapper.addAnswer(answer);
    }

    @Override
    public int delAnswerById(Integer answer_id) {
        return answerMapper.delAnswerById(answer_id);
    }

    @Override
    public int delAnswerByProblemId(Integer problem_id) {
        return answerMapper.delAnswerByProblemId(problem_id);
    }

    @Override
    public int updateAnswer(Answer answer) {
        return answerMapper.updateAnswer(answer);
    }

    @Override
    public List<Answer> getAllAnswerByProblemId(Integer problem_id) {
        return answerMapper.getAllAnswerByProblemId(problem_id);
    }

    @Override
    public int getAnswerNums() {
        return answerMapper.getAnswerNums();
    }

    @Override
    public List<Answer> getAllAnswerByUserId(Integer answer_user_id) {
        return answerMapper.getAllAnswerByUserId(answer_user_id);
    }

    @Override
    public String getCurAnswerUser(Integer answer_id) {
        return answerMapper.getCurAnswerUser(answer_id);
    }


}
