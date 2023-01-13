package com.statistics.producers;

import com.statistics.domain.usercase.IDeleteAllStatistics;
import com.statistics.domain.usercase.IFindStatistics;
import com.statistics.domain.usercase.IInputStatistic;
import com.statistics.domain.usercase.impl.DeleteAllStatistics;
import com.statistics.domain.usercase.impl.FindStatistics;
import com.statistics.domain.usercase.impl.InputStatistic;
import com.statistics.mappers.StatisticMapper;
import com.statistics.repository.IStatisticRepository;
import com.statistics.repository.impl.StatisticRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Produces;

@ApplicationScoped
public class StatisticsProducers {

    private StatisticMapper mapper;
    private IStatisticRepository statisticRepository;

    @Inject
    public StatisticsProducers(StatisticMapper mapper,
                               StatisticRepository statisticRepository){
        this.mapper = mapper;
        this.statisticRepository = statisticRepository;
    }

    @Produces
    @Named("inputStatistic")
    public IInputStatistic buildInputStatistic(){
        return new InputStatistic(statisticRepository,mapper);
    }

    @Produces
    @Named("findStatistics")
    public IFindStatistics buildFindStatistics(){
        return new FindStatistics(statisticRepository,mapper);
    }

    @Produces
    @Named("deleteAllStatistics")
    public IDeleteAllStatistics buildDeleteAllStatistics(){
        return new DeleteAllStatistics(statisticRepository);
    }
}
