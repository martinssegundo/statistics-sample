package com.statistics.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private DateTimeUtil(){}

    public static String stringfyDateTime(LocalDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public static LocalDateTime convertTo(){
        
    }
}
