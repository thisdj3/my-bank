package com.abc;

import java.util.Calendar;
import java.util.Date;

public class DateProvider {
	private static DateProvider instance = null;

	public static DateProvider getInstance() {
		if (instance == null)
			instance = new DateProvider();
		return instance;
	}

	public static int moveDateForward = 0;

	public Date now() {

		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, moveDateForward);
		dt = c.getTime();
		return dt;
	}
}
