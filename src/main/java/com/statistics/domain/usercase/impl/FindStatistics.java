package com.statistics.domain.usercase.impl;

import com.statistics.domain.usercase.IFindStatistics;
import com.statistics.domain.usercase.dtos.StatisticDTO;
import com.statistics.domain.usercase.util.DateTimeUtil;
import com.statistics.mappers.StatisticMapper;
import com.statistics.repository.IStatisticRepository;

import java.time.LocalDateTime;

public class FindStatistics implements IFindStatistics {

    private IStatisticRepository statisticRepository;
    private StatisticMapper mapper;

    public FindStatistics(IStatisticRepository statisticRepository,
                          StatisticMapper mapper){
        this.statisticRepository = statisticRepository;
        this.mapper = mapper;
    }

    @Override
    public StatisticDTO findLastMinutStatistics() {
        var statisticDomain = mapper.convertTo(statisticRepository.findStatistic());
        return statisticDomain.findStatistic(DateTimeUtil.stringfyDateTime(LocalDateTime.now()));
    }
}
