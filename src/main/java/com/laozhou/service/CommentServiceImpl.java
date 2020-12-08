package com.laozhou.service;

import com.laozhou.dao.CommentMapper;
import com.laozhou.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public Comment getCommentByAnswerID(Integer answer_id) {
        return commentMapper.getCommentByAnswerID(answer_id);
    }
}
