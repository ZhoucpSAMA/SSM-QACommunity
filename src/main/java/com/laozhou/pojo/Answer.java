package com.laozhou.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Answer {
    private Integer answer_id;
    private Integer problem_id;
    private Integer answer_user_id;
    private String problem_answer;
    private Integer answer_score;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date answer_date;
    private String answer_likes;
}
