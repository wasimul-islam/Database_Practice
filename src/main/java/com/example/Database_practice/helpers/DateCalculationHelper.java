package com.example.Database_practice.helpers;

import java.util.Calendar;
import java.util.Date;

public class DateCalculationHelper {
	
	
	public static Date incrementDay(Date date, int increment) {
		Calendar calendar =  Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, increment);
		return calendar.getTime();
	}

}
