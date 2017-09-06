package com.fwh.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 日期工具类
 * @author dieeman
 *
 */
public class DateUtil {
	/**
	 * 获得当前日期
	 * @return
	 */
	public static String getCurrentDate(){
		Date dt=new Date();
		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = matter1.format(dt);
		return currentDate;
	}
	/**
	 * 获得n天后的日期
	 * @param date
	 * @param days
	 * @return
	 * @throws ParseException
	 */
	public static String dateAdding(String date,int days) throws ParseException{  
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
		Date dt = df.parse(date);//将string转成date
		Calendar dd = Calendar.getInstance();
        dd.setTime(dt);
        dd.add(Calendar.DAY_OF_YEAR,days);//日期加days天
        Date newdate = dd.getTime();
        String newdateString = df.format(newdate);
		return newdateString;
	}
	/**
	 * 求两个日期相差几个月
	 * @param date1
	 * @param date2
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static int countMonths(String date1,String date2) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));
		int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
		int a;
		//开始日期若小月结束日期
		if(year<0){
			year=-year;		
			a= year*12+c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH);
		}else{
			System.out.println(c2.get(Calendar.DATE));			
			a = year*12+c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);
			if(c2.get(Calendar.DATE)>c1.get(Calendar.DATE)){
				a=a+1;
			}
		}
		return a;
		}
	
	public static void main(String args[]) throws ParseException{
		
		System.out.println(DateUtil.getCurrentDate()); 
	}
}
