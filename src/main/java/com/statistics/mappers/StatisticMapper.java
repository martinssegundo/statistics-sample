package com.statistics.mappers;

import com.statistics.api.dto.FindedStatisticsResponse;
import com.statistics.domain.Statistic;
import com.statistics.domain.usercase.dtos.StatisticDTO;
import com.statistics.repository.entities.StatisticEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface StatisticMapper {

    Statistic convertTo(StatisticEntity entity);
    StatisticEntity convertTo(Statistic domain);

    FindedStatisticsResponse convertToResponse(StatisticDTO domainDTO);
}
