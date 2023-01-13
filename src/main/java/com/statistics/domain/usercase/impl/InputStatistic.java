package com.statistics.domain.usercase.impl;

import com.statistics.domain.usercase.IInputStatistic;
import com.statistics.domain.util.AmoutUtil;
import com.statistics.domain.util.DateTimeUtil;
import com.statistics.exceptions.FutureTimeException;
import com.statistics.exceptions.NumberException;
import com.statistics.exceptions.PastTimeException;
import com.statistics.mappers.StatisticMapper;
import com.statistics.repository.IStatisticRepository;

import java.time.LocalDateTime;

public class InputStatistic implements IInputStatistic {

    private IStatisticRepository statisticRepository;
    private StatisticMapper mapper;

    public InputStatistic(IStatisticRepository statisticRepository,
                          StatisticMapper mapper) {
        this.statisticRepository = statisticRepository;
        this.mapper = mapper;
    }

    @Override
    public void inputStatistic(String dateTimeAsString, String amout) throws FutureTimeException,
            PastTimeException, NumberException{
        var dateTime = DateTimeUtil.convertTo(dateTimeAsString);
        verifyLocalDateInFuture(dateTime);
        verifyLocalDateInPast(dateTime);
        verifyNumber(amout);
        var statisticDomain = mapper.convertTo(statisticRepository.findStatistic());
        statisticDomain.addStatistic(
                DateTimeUtil.stringfyDateTime(dateTime),
                AmoutUtil.convertToBigDecimal(amout)
        );
        statisticRepository.updataStatistic(mapper.convertTo(statisticDomain));

    }

    private void verifyLocalDateInPast(LocalDateTime dateTime) throws PastTimeException {
        var dateTimeFuture = dateTime.plusMinutes(-1);
        if (dateTime.compareTo(dateTimeFuture) < 0)
            throw new PastTimeException("Date time in past");
    }

    private void verifyLocalDateInFuture(LocalDateTime dateTime) throws FutureTimeException {
        var dateTimeFuture = dateTime.plusMinutes(1);
        if (dateTime.compareTo(dateTimeFuture) > 0)
            throw new FutureTimeException("Date time in future");
    }

    private void verifyNumber(String number) throws NumberException{
        if(!number.matches("^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"))
            throw new NumberException("Erro parse number");
    }
}
