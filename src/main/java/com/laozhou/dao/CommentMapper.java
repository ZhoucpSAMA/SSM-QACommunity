package com.laozhou.dao;

import com.laozhou.pojo.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface CommentMapper {
    int addComment(Comment comment);
    Comment getCommentByAnswerID(@RequestParam("answer_id")Integer answer_id);
}
