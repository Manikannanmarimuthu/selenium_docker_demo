package com.mvi.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static int getCurrentYear() {
		return LocalDate.now().getYear();
	}

	public static String getCurrentLocalDateTimeStamp(String datePattern) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(datePattern));
	}

	public static String addOrMinusDays(String dateFormart, int noOfDays) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormart);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, noOfDays); // Adding no of Days
		return sdf.format(c.getTime());
	}
	

}
