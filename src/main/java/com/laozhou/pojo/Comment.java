package com.laozhou.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer comment_id;
    private String comment_content;
    private Integer comment_user_id;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date comment_date;
    private Integer answer_id;
}
