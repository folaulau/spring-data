package com.kaveinga.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {

	// Millisecond Based
	public static final long MILLISECOND = 1000L;
	public static final long SECOND = MILLISECOND;
	public static final long MINUTE = SECOND * 60;
	public static final long HOUR = MINUTE * 60;
	public static final long DAY = HOUR * 24;
	public static final long WEEK = DAY * 7;

	/**
	 * Based on Milliseconds
	 * 
	 * @param hr
	 * @return hours in milliseconds
	 */
	public static long getHoursInMilliseconds(long hr) {
		return HOUR * hr;
	}

	public static String getTimeStamp() {
		DateFormat formmatter = new SimpleDateFormat("M-dd-yyyy h:mm:ss a");
		return formmatter.format(new Date());
	}

	public static String getFormattedDate(Date date) {
		DateFormat formmatter = new SimpleDateFormat("M-dd-yyyy h:mm:ss a");
		return formmatter.format(date);
	}

	public static SimpleDateFormat getFormat(String format) {
		return new SimpleDateFormat(format);
	}

	public static int getDiffMonths(Date start, Date end) {
		LocalDate startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		Period period = Period.between(startDate,endDate);
		
		int numOfYears = period.getYears();
		
		int numOfMonths = period.getMonths();
		
		if(numOfYears>=1) {
			numOfMonths += (numOfYears*12);
		}
		return numOfMonths;
	}

	public static int getDiffHours(Date start, Date end) {
		long different = end.getTime() - start.getTime();
		return (int) (different/HOUR);
	}

	public static int getDiffDays(Date start, Date end) {
		long different = end.getTime() - start.getTime();
		return (int) (different/DAY);
	}

	public static String getUTCFormattedDate(Date date) {
		DateFormat formmatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		return formmatter.format(date);
	}

	public static String getDOBAsText(Date dob) {
		DateFormat formmatter = new SimpleDateFormat("yyyy-MM-dd");
		return formmatter.format(dob);
	}

	public static Date getLastSecondOfDayDateTime(Date date) {
		Calendar startDateCalendar = Calendar.getInstance();
		startDateCalendar.setTime(date);

		startDateCalendar.set(Calendar.HOUR_OF_DAY, startDateCalendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		startDateCalendar.set(Calendar.MINUTE, startDateCalendar.getActualMaximum(Calendar.MINUTE));
		startDateCalendar.set(Calendar.SECOND, startDateCalendar.getActualMaximum(Calendar.SECOND));
		startDateCalendar.set(Calendar.MILLISECOND, startDateCalendar.getActualMaximum(Calendar.MILLISECOND));

		return startDateCalendar.getTime();
	}

	public static Date getFirstSecondOfDayDateTime(Date date) {
		Calendar startDateCalendar = Calendar.getInstance();
		startDateCalendar.setTime(date);

		startDateCalendar.set(Calendar.HOUR_OF_DAY, startDateCalendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		startDateCalendar.set(Calendar.MINUTE, startDateCalendar.getActualMinimum(Calendar.MINUTE));
		startDateCalendar.set(Calendar.SECOND, startDateCalendar.getActualMinimum(Calendar.SECOND));
		startDateCalendar.set(Calendar.MILLISECOND, startDateCalendar.getActualMinimum(Calendar.MILLISECOND));

		return startDateCalendar.getTime();
	}
}
