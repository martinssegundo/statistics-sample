package com.statistics.api.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FindedStatisticsResponse {
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private Long count;
}
