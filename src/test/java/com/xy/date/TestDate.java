package com.xy.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TestDate {

	@Test
	public void test01(){
		Calendar calendar = new GregorianCalendar();  
//		当前月的第一天  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
	}
}
