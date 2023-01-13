package com.statistics.domain;

import com.statistics.domain.usercase.dtos.StatisticDTO;
import com.statistics.domain.util.AmoutUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Statistic {
    private Map<String, BigDecimal> sum;
    private Map<String, BigDecimal> avg;
    private Map<String, BigDecimal> max;
    private Map<String, BigDecimal> min;
    private Map<String, Long> count;

    public Statistic() {
        this.sum = new HashMap<>();
        this.avg = new HashMap<>();
        this.max = new HashMap<>();
        this.min = new HashMap<>();
        this.count = new HashMap<>();
    }

    public void addStatistic(String dateTime, BigDecimal amount) {
        if (verifyNonExistsStatistic(dateTime))
            newStatistics(dateTime, amount);
        else
            updateStatistics(dateTime, amount);
    }

    public StatisticDTO findStatistic(String dateTime) {
        if(!verifyNonExistsStatistic(dateTime))
            return new StatisticDTO(
                    AmoutUtil.setScaleAndHalfUpBigDecimal(sum.get(dateTime)),
                    AmoutUtil.setScaleAndHalfUpBigDecimal(avg.get(dateTime)),
                    AmoutUtil.setScaleAndHalfUpBigDecimal(max.get(dateTime)),
                    AmoutUtil.setScaleAndHalfUpBigDecimal(min.get(dateTime)),
                    count.get(dateTime)
            );
        return null;
    }

    private void newStatistics(String dateTime, BigDecimal amount) {
        sum.put(dateTime, amount);
        avg.put(dateTime, amount);
        max.put(dateTime, amount);
        min.put(dateTime, amount);
        count.put(dateTime, 1L);
    }

    private void updateStatistics(String dateTime, BigDecimal amount) {
        calculateSum(dateTime, amount);
        verifyMax(dateTime, amount);
        verifyMim(dateTime, amount);
        countValue(dateTime);
        calculateAvg(dateTime);
    }

    private void calculateSum(String dateTime, BigDecimal amount) {
        sum.put(dateTime,
                sum.getOrDefault(dateTime, BigDecimal.ZERO).add(amount));
    }

    private void calculateAvg(String dateTime) {
        avg.put(dateTime,
                sum.get(dateTime)
                        .divide(
                                new BigDecimal(count.get(dateTime))
                        )
        );
    }

    private void verifyMax(String dateTime, BigDecimal amount) {
        if (max.get(dateTime).compareTo(amount) < 0)
            max.put(dateTime, amount);
    }

    private void verifyMim(String dateTime, BigDecimal amount) {
        if (min.get(dateTime).compareTo(amount) > 0)
            min.put(dateTime, amount);
    }

    private void countValue(String dateTime) {
        count.put(dateTime, count.getOrDefault(dateTime, 0L) + 1);
    }

    private Boolean verifyNonExistsStatistic(String dateTime) {
        return sum.get(dateTime) == null;
    }


    public Map<String, BigDecimal> getSum() {
        return sum;
    }

    public void setSum(Map<String, BigDecimal> sum) {
        this.sum = sum;
    }

    public Map<String, BigDecimal> getAvg() {
        return avg;
    }

    public void setAvg(Map<String, BigDecimal> avg) {
        this.avg = avg;
    }

    public Map<String, BigDecimal> getMax() {
        return max;
    }

    public void setMax(Map<String, BigDecimal> max) {
        this.max = max;
    }

    public Map<String, BigDecimal> getMin() {
        return min;
    }

    public void setMin(Map<String, BigDecimal> min) {
        this.min = min;
    }

    public Map<String, Long> getCount() {
        return count;
    }

    public void setCount(Map<String, Long> count) {
        this.count = count;
    }
}
