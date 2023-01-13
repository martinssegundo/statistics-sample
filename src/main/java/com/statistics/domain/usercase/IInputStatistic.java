package com.statistics.domain.usercase;

import com.statistics.exceptions.FutureTimeException;
import com.statistics.exceptions.NumberException;
import com.statistics.exceptions.PastTimeException;

import java.time.LocalDateTime;

public interface IInputStatistic {
    void inputStatistic(String dateTime, String amout) throws FutureTimeException,
            PastTimeException, NumberException;
}
