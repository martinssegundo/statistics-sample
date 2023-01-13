package com.statistics.domain;

import com.statistics.domain.util.AmoutUtil;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class StatisticTest {
    Statistic statistic;

    @BeforeEach
    void setUp() {
        statistic = new Statistic();
    }

    @Test
    void testAddNewStatistic() {
        var dateTime = buildFormatedDateTimeStringfied();
        statistic.addStatistic(dateTime, BigDecimal.TEN);
        var statisticDT0 = statistic.findStatistic(dateTime);
        assertNotNull(statisticDT0);
        assertEquals(statisticDT0.getSum(), AmoutUtil.setScaleAndHalfUpBigDecimal(BigDecimal.TEN));
        assertEquals(statisticDT0.getAvg(), AmoutUtil.setScaleAndHalfUpBigDecimal(BigDecimal.TEN));
        assertEquals(statisticDT0.getMax(), AmoutUtil.setScaleAndHalfUpBigDecimal(BigDecimal.TEN));
        assertEquals(statisticDT0.getMin(), AmoutUtil.setScaleAndHalfUpBigDecimal(BigDecimal.TEN));
        assertEquals(statisticDT0.getCount(), 1L);
    }

    @Test
    void testAddUpdateStatistic() {
        var dateTime = buildFormatedDateTimeStringfied();
        statistic.addStatistic(dateTime, BigDecimal.TEN);
        statistic.addStatistic(dateTime, new BigDecimal(100));
        var statisticDT0 = statistic.findStatistic(dateTime);
        assertNotNull(statisticDT0);
        assertEquals(statisticDT0.getSum(), AmoutUtil.setScaleAndHalfUpBigDecimal(new BigDecimal(110)));
        assertEquals(statisticDT0.getAvg(), AmoutUtil.setScaleAndHalfUpBigDecimal(new BigDecimal(55)));
        assertEquals(statisticDT0.getMax(), AmoutUtil.setScaleAndHalfUpBigDecimal(new BigDecimal(100)));
        assertEquals(statisticDT0.getMin(), AmoutUtil.setScaleAndHalfUpBigDecimal(BigDecimal.TEN));
        assertEquals(statisticDT0.getCount(), 2L);
    }


    private String buildFormatedDateTimeStringfied(){
       return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}

