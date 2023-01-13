package com.statistics.domain.usercase.dtos;

import java.math.BigDecimal;

public class StatisticDTO {
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private Long count;

    public StatisticDTO(BigDecimal sum,
                        BigDecimal avg,
                        BigDecimal max,
                        BigDecimal min,
                        Long count) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public BigDecimal getMax() {
        return max;
    }

    public BigDecimal getMin() {
        return min;
    }

    public Long getCount() {
        return count;
    }
}
