package com.laozhou.dao;

import com.laozhou.pojo.Rank;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankMapper {
    List<Rank> getRankByProblemId(@Param("problem_id")Integer problem_id);
}
