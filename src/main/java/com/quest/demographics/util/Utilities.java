package com.quest.demographics.util;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * Utilities - Common Functions
 * 
 * @Author - Alan Kavanagh
 */
public class Utilities {
	/**
	 * Returns the current date/time
	 * 
	 * @return: String - yyyy/MM/dd HH:mm:ss
	 */
	public static String getTimestamp() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}