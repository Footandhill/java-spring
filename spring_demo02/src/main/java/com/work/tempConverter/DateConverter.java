package com.work.tempConverter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

}
