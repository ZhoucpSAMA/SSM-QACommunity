package com.laozhou.service;

import com.laozhou.pojo.Rank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RankService {
    List<Rank> getRankByProblemId(Integer problem_id);
}
