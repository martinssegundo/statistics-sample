package com.statistics.domain.usercase.impl;

import com.statistics.domain.usercase.IInputStatistic;
import com.statistics.domain.util.AmoutUtil;
import com.statistics.domain.util.DateTimeUtil;
import com.statistics.exceptions.FutureTimeException;
import com.statistics.exceptions.PastTimeException;
import com.statistics.mappers.StatisticMapper;
import com.statistics.repository.IStatisticRepository;

public class InputStatistic implements IInputStatistic {

    private IStatisticRepository statisticRepository;
    private StatisticMapper mapper;

    public InputStatistic(IStatisticRepository statisticRepository,
                          StatisticMapper mapper){
        this.statisticRepository = statisticRepository;
        this.mapper = mapper;
    }

    @Override
    public void inputStatistic(String dateTime, String amout) {
        var statisticDomain = mapper.convertTo(statisticRepository.findStatistic());
        statisticDomain.addStatistic(
                DateTimeUtil.stringfyDateTime(dateTime),
                AmoutUtil.convertToBigDecimal(amout)
        );
        statisticRepository.updataStatistic(mapper.convertTo(statisticDomain));
    }

    private void isLocalDateInPast(String dateTime) throws FutureTimeException{
        var dateTimeFuture = dateTime.plusMinutes(-1);
        if(dateTime.compareTo(dateTimeFuture) < 0)
            throw new PastTimeException("Date time in past");
    }

    private void isLocalDateInFuture(String dateTime) throws FutureTimeException{
        var dateTimeFuture = dateTime.plusMinutes(1);
        if(dateTime.compareTo(dateTimeFuture) > 0)
            throw new FutureTimeException("Date time in future");
    }

    private boolean isNumber(String number){
        return number.matches("^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$");
    }
}
