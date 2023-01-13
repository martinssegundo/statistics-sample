package com.statistics.repository;

import com.statistics.repository.entities.StatisticEntity;

public interface IStatisticRepository {

    StatisticEntity findStatistic();

    void updataStatistic(StatisticEntity statisticEntity);

    void deleteAll();
}
