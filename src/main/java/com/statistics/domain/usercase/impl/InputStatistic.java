package com.statistics.domain.usercase.impl;

import com.statistics.domain.usercase.IInputStatistic;
import com.statistics.domain.usercase.util.AmoutUtil;
import com.statistics.domain.usercase.util.DateTimeUtil;
import com.statistics.mappers.StatisticMapper;
import com.statistics.repository.IStatisticRepository;
import com.statistics.repository.impl.StatisticRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputStatistic implements IInputStatistic {

    private IStatisticRepository statisticRepository;
    private StatisticMapper mapper;

    public InputStatistic(IStatisticRepository statisticRepository,
                          StatisticMapper mapper){
        this.statisticRepository = statisticRepository;
        this.mapper = mapper;
    }

    @Override
    public void inputStatistic(LocalDateTime dateTime, String amout) {
        var statisticDomain = mapper.convertTo(statisticRepository.findStatistic());
        statisticDomain.addStatistic(
                DateTimeUtil.stringfyDateTime(dateTime),
                AmoutUtil.convertToBigDecimal(amout)
        );
        statisticRepository.updataStatistic(mapper.convertTo(statisticDomain));
    }

    private void verifyLocalDate(){

    }


}
