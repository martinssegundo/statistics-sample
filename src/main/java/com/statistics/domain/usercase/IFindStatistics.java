package com.statistics.domain.usercase;

import com.statistics.domain.usercase.dtos.StatisticDTO;

public interface IFindStatistics {

    StatisticDTO findLastMinutStatistics();
}
