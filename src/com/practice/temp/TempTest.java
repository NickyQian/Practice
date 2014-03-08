package com.practice.temp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TempTest {

    public static String getThreeMonthDayBefore() throws ParseException {  
        Calendar c = Calendar.getInstance();  
        Date date = new Date();
        c.setTime(date);  
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 91);
  
        String dayBefore = new SimpleDateFormat("yyyyMMdd").format(c  
                .getTime());  
        return dayBefore;
    }
    
    public static boolean judge(String lastUpdate, String lastUpdate2) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyyMMdd").parse(lastUpdate);
        Date date2 = new SimpleDateFormat("yyyyMMdd").parse(lastUpdate2);
        long datetime1 = date1.getTime();
        long datetime2 = date2.getTime();
        long s = 90*24*60*60*1000L;
        System.out.println(datetime1-datetime2 >= 90*24*60*60*1000L);
        System.out.println(datetime2);
        System.out.println(datetime2);
        System.out.println(s);
        System.out.println(datetime1 - datetime2);
        return true;
    }
    /**
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub
        String s = getThreeMonthDayBefore();
        System.out.println(s);
        judge("201308091212","201305101212");
        
    }

}
