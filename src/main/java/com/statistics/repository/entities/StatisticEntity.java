package com.statistics.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticEntity {
    private Map<String, BigDecimal> sum;
    private Map<String, BigDecimal> avg;
    private Map<String, BigDecimal> max;
    private Map<String, BigDecimal> min;
    private Map<String, Long> count;
}
