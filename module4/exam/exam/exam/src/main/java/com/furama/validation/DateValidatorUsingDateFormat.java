package com.furama.validation;

import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
@Configurable
public class DateValidatorUsingDateFormat implements  ConstraintValidator<DateValidator,String> {
    private String dateFormat;

    public DateValidatorUsingDateFormat(String dateFormat) {
        this.dateFormat = "DD/MM/YYYY";
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        DateFormat sdf=new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }
}
