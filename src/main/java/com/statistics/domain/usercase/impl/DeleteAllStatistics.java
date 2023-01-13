package com.statistics.domain.usercase.impl;

import com.statistics.domain.usercase.IDeleteAllStatistics;
import com.statistics.repository.IStatisticRepository;

public class DeleteAllStatistics implements IDeleteAllStatistics {
    private IStatisticRepository statisticRepository;

    public DeleteAllStatistics(IStatisticRepository statisticRepository){
        this.statisticRepository = statisticRepository;
    }

    @Override
    public void deleteAll() {
        statisticRepository.deleteAll();
    }
}
