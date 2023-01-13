package com.statistics.repository.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Builder
@Data
public class StatisticEntity {
    private Map<String, BigDecimal> sum;
    private Map<String, BigDecimal> avg;
    private Map<String, BigDecimal> max;
    private Map<String, BigDecimal> min;
    private Map<String, Long> count;
}
