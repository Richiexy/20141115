package com.xy.test02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate1 {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = df.parse("2014-06-29");
		Date d2 = new Date();
		System.out.println(d1);
		System.out.println(df.format(new Date()));
		System.out.println(d1.after(d2));
	}

}
