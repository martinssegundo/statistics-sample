package com.statistics.mappers;

import com.statistics.api.dto.FindedStatisticsResponse;
import com.statistics.domain.Statistic;
import com.statistics.domain.usercase.dtos.StatisticDTO;
import com.statistics.repository.entities.StatisticEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface StatisticMapper {

//    @Mappings({
//            @Mapping(target = "sum", source = "sum"),
//            @Mapping(target = "avg", source = "avg"),
//            @Mapping(target = "max", source = "max"),
//            @Mapping(target = "min", source = "min"),
//            @Mapping(target = "count", source = "count")
//    })
    Statistic convertTo(StatisticEntity entity);
//    @Mappings({
//            @Mapping(target = "sum", source = "sum"),
//            @Mapping(target = "avg", source = "avg"),
//            @Mapping(target = "max", source = "max"),
//            @Mapping(target = "min", source = "min"),
//            @Mapping(target = "count", source = "count")
//    })
    StatisticEntity convertTo(Statistic domain);

    FindedStatisticsResponse convertToResponse(StatisticDTO domainDTO);
}
