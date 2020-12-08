package com.laozhou.service;

import com.laozhou.pojo.Comment;

public interface CommentService {
    int addComment(Comment comment);
    Comment getCommentByAnswerID(Integer answer_id);
}
