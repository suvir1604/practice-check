package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static Date converttoDate(String date) throws ParseException {
		Date d = sdf.parse(date);
		return d;
	}

	public static String Converttostring(Date date) {
		return sdf.format(date);

	}
}
