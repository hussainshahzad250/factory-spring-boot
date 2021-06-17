package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author shahzad.hussain
 *
 */
public class DateUtil {

	public static final String DD_MM_YYYY = "dd-MM-yyyy";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm:ss";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static Date parseDate(String date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setLenient(false);
			return sdf.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static LocalDate getLocalDateFromDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDate parseLocalDate(String date, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return LocalDate.parse(date, formatter);

	}

	public static String format(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String formatLocalDate(LocalDate date, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return formatter.format(date);
	}

	public static Date getDateBeforeXDays(Date date, int getDateBeforeXDays) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -getDateBeforeXDays);
		return c.getTime();
	}

	public static Date getDateAfterXDays(Date date, int getDateBeforeXDays) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, getDateBeforeXDays);
		return c.getTime();
	}

	public static String getLocalDateToString(LocalDate localDate, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return localDate.format(formatter);
	}

	public static String getLocalDateTimeToString(LocalDateTime localDate, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return localDate.format(formatter);
	}

	public static String getDateToString(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static String getLocalTimeToString(LocalTime time, String formatter) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formatter);
		return time.format(format);
	}

}
