package com.laozhou.service;

import com.laozhou.dao.RankMapper;
import com.laozhou.pojo.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper rankMapper;
    @Override
    public List<Rank> getRankByProblemId(Integer problem_id) {
        return rankMapper.getRankByProblemId(problem_id);
    }
}
