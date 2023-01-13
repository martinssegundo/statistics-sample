package com.statistics.domain.usercase.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmoutUtil {

    private AmoutUtil(){}

    public static BigDecimal convertToBigDecimal(String amout){
        return new BigDecimal(amout).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal setScaleAndHalfUpBigDecimal(BigDecimal amout){
        return amout.setScale(2, RoundingMode.HALF_UP);
    }
}
