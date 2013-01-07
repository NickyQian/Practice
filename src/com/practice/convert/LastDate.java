package com.practice.convert;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LastDate {
	public static String getLastPeriodDate(int daycount){
		TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar cal = Calendar.getInstance(tz,Locale.US);
		int s = cal.get(daycount);
		System.out.println(s);
		long oneDay = (long) 1000.0 * 60 * 60 *24;
		Date d = new Date(System.currentTimeMillis()-oneDay*s);
		SimpleDateFormat ft = new SimpleDateFormat("MMdd",Locale.US);
		ft.setTimeZone(tz);
		return ft.format(d);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get last Saturday
		System.out.println(getLastPeriodDate(Calendar.DAY_OF_WEEK));
		//get the last day in last month
		System.out.println(getLastPeriodDate(Calendar.DAY_OF_MONTH));
		
		// get host name, IP
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress().toString();//获得本机IP
			String address = addr.getHostName().toString();//获得本机名称
			System.out.println(ip);
			System.out.println(address);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
