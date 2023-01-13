package com.statistics.repository.impl;

import com.statistics.repository.IStatisticRepository;
import com.statistics.repository.entities.StatisticEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;

@ApplicationScoped
public class StatisticRepository implements IStatisticRepository {

    private StatisticEntity statisticEntity;

    public StatisticRepository(){
        this.statisticEntity = new StatisticEntity();
    }

    @Override
    public StatisticEntity findStatistic() {
        return statisticEntity;
    }

    @Override
    public void updataStatistic(StatisticEntity statisticEntity) {
        this.statisticEntity.setAvg(statisticEntity.getAvg());
        this.statisticEntity.setMax(statisticEntity.getMax());
        this.statisticEntity.setCount(statisticEntity.getCount());
        this.statisticEntity.setMin(statisticEntity.getMin());
        this.statisticEntity.setSum(statisticEntity.getSum());
    }

    @Override
    public void deleteAll() {
        this.statisticEntity = new StatisticEntity();
    }


}
