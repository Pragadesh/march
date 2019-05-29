package org.pg.march.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

public class DateUtil {

	@Test
	public void testTimeZone() {
		long time = System.currentTimeMillis();
		System.out.println("MST - Local: " + (time - convertTimeToMST(time)));
	}
	
	
    public static long convertTimeToMST(long time) {
    	
    	try {
//    		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		SimpleDateFormat sdf1 = new SimpleDateFormat();
    		String locatDate = sdf1.format(new Date(time));
    		System.out.println(new Date(time));
    		System.out.println(locatDate);
//    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		sdf1.setTimeZone(TimeZone.getTimeZone("MST"));
    		long mstTime = sdf1.parse(locatDate).getTime();
    		System.out.println(new Date(mstTime));
    		return mstTime;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return time;
    }
}
