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
public class Problem {
    private Integer problem_id;
    private String problem_title;
    private String problem_content;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date problem_date;
    private Integer problem_user_id;
}
