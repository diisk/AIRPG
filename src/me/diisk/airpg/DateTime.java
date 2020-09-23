package me.diisk.airpg;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTime {

	private int year=1,
			month=1,
			day=1,
			hour=0,
			minute=0,
			second=0;
	
	public DateTime(long milliseconds) {
		if(milliseconds!=-1) {
			LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.systemDefault());
			year = localDateTime.getYear();
			month = localDateTime.getMonthValue();
			day = localDateTime.getDayOfMonth();
			hour = localDateTime.getHour();
			minute = localDateTime.getMinute();
			second = localDateTime.getSecond();
			fix();
		}
	}
	
	public DateTime(int day, int month, int year, int hour, int minute, int second){
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public DateTime() {}
	
	public DateTime copy() {
		DateTime r = new DateTime();
		r.second = second;
		r.minute = minute;
		r.hour = hour;
		r.day = day;
		r.month = month;
		r.year = year;
		return r;
	}
	
	public void copy(DateTime dateTime) {
		second = dateTime.second;
		minute = dateTime.minute;
		hour = dateTime.hour;
		day = dateTime.day;
		month = dateTime.month;
		year = dateTime.year;
	}
	
	public DateTime differenceBetween(DateTime dateTime) {
		if(isValid() && dateTime.isValid()) {
			DateTime dt;
			if(dateTime.isRecentlyThen(this, false)) {
				dt = dateTime.copy();
				dt.removeSeconds(second);
				dt.removeMinutes(minute);
				dt.removeHours(hour);
				dt.removeDays(day);
				dt.removeMonths(month);
				dt.year-=year;
			}else if(dateTime.isOlderThen(this, false)) {
				dt = copy();
				dt.removeSeconds(dateTime.second);
				dt.removeMinutes(dateTime.minute);
				dt.removeHours(dateTime.hour);
				dt.removeDays(dateTime.day);
				dt.removeMonths(dateTime.month);
				dt.year-=dateTime.year;
			}else {
				dt = new DateTime();
				dt.year=0;
				dt.month=0;
				dt.day=0;
			}
			return dt;
		}
		return null;
	}
	
	private void removeMonths(int months) {
		month-=months;
		while(month<0) {
			month+=12;
			year--;
		}
	}
	
	private void removeDays(int days) {
		day-=days;
		while(day<0) {
			removeMonths(1);
			day+=getDaysOfMonth(month, year);
		}
	}
	
	private void removeHours(int hours) {
		hour-=hours;
		while(hour<0) {
			hour+=24;
			removeDays(1);
		}
	}
	
	private void removeMinutes(int minutes) {
		minute-=minutes;
		while(minute<0) {
			minute+=60;
			removeHours(1);
		}
	}
	
	private void removeSeconds(int seconds) {
		second-=seconds;
		while(second<0) {
			second+=60;
			removeMinutes(1);
		}
	}
	
	public DateTime subtract(DateTime dateTime) {
		DateTime r = new DateTime();
		r.setDateTime(day-dateTime.day, month-dateTime.month, year-dateTime.year, hour-dateTime.hour, minute-dateTime.minute, second-dateTime.second);
		r.fix();
		return r;
	}
	
	public DateTime add(DateTime dateTime) {
		DateTime r = new DateTime();
		r.setDateTime(day+dateTime.day, month+dateTime.month, year+dateTime.year, hour+dateTime.hour, minute+dateTime.minute, second+dateTime.second);
		r.fix();
		return r;
	}
	
	public static DateTime valueOf(String dateTime) {
		int days = 0;
		int months = 0;
		int years = 0;
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		String[] args = dateTime.split(" ");
		String date = null;
		String time = null;
		if(args.length >=2){
			date = args[0];
			time = args[1];
		}else{
			date = dateTime;
		}
		if(date != null){
			args = date.split("/");
			if(args.length >= 3){
				if(args[0].matches("\\d{1,2}") && args[1].matches("\\d{1,2}") && args[2].matches("\\d{4,4}")){
					days = Integer.parseInt(args[0]);
					months = Integer.parseInt(args[1]);
					years = Integer.parseInt(args[2]);
				}
			}
		}
		if(time != null){
			args = time.split(":");
			if(args.length >= 3){
				if(args[0].matches("\\d{1,2}") && args[1].matches("\\d{1,2}") && args[2].matches("\\d{1,2}")){
					hours = Integer.parseInt(args[0]);
					minutes = Integer.parseInt(args[1]);
					seconds = Integer.parseInt(args[2]);
				}
			}
		}
		DateTime dt = new DateTime(days,months,years,hours,minutes,seconds);
		return dt;
	}
	
	public void setDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		fix();
	}
	
	public void setDay(int day) {
		setDate(day, month, year);
	}
	
	public void setMonth(int month) {
		setDate(day, month, year);
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		fix();
	}
	
	public void setHour(int hour) {
		setTime(hour, minute, second);
	}
	
	public void setMinute(int minute) {
		setTime(hour, minute, second);
	}
	
	public void setSecond(int second) {
		setTime(hour, minute, second);
	}
	
	public void setDateTime(int day, int month, int year, int hour, int minute, int second) {
		setDate(day, month, year);
		setTime(hour, minute, second);
	}
	
	public String getTime(){
		String r = ((hour+"").length()>1?hour:"0"+hour)+":";
		r+=((minute+"").length()>1?minute:"0"+minute)+":";
		r+=((second+"").length()>1?second:"0"+second);
		return r;
	}
	
	public String getDate(){
		String r = ((day+"").length()>1?day:"0"+day)+"/";
		r+=((month+"").length()>1?month:"0"+month)+"/";
		r+=year;
		return r;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getSecond() {
		return second;
	}
	
	public int getYear() {
		return year;
	}
	
	private void fix() {
		while(!isValid()) {
			while(second>=60) {
				second-=60;
				minute+=1;
			}
			while(second<0) {
				second+=60;
				minute-=1;
			}
			while(minute>=60) {
				minute-=60;
				hour+=1;
			}
			while(minute<0) {
				minute+=60;
				hour-=1;
			}
			while(hour>=24) {
				hour-=24;
				day+=1;
			}
			while(hour<0) {
				hour+=24;
				day-=1;
			}
			while(day>getDaysOfMonth(month, year)) {
				day-=getDaysOfMonth(month, year);
				month+=1;
			}
			while(day<1) {
				month-=1;
				day+=getDaysOfMonth(month, year);
			}
			while(month>12) {
				month-=12;
				year+=1;
			}
			while(month<1) {
				month+=12;
				year-=1;
			}
			if(year < 1) {
				year=1;
			}
		}
	}
	
	private boolean isValid() {
		if(second >= 0 && second < 60) {
			if(minute >=0 && minute < 60) {
				if(hour >= 0 && hour < 24) {
					if(day >= 1 && day <= getDaysOfMonth(month, year)) {
						if(month >= 1 && month <= 12) {
							if(year >= 1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private static int getDaysOfMonth(int month, int year) {
		int r = 31;
		switch(month) {
		case 2: return year%4==0?29:28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		}
		return r;
	}
	
	public boolean isBetweenDates(DateTime dtmin, DateTime dtmax){
		if(day >= dtmin.getDay() && day <= dtmax.getDay()){
			if(month >= dtmin.getMonth() && month <= dtmax.getMonth()){
				if(year >= dtmin.getYear() && year <= dtmax.getYear()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isOlderThen(DateTime dateTime, boolean ignoreTime) {
		return compare(dateTime, ignoreTime)<0;
	}
	
	public boolean isRecentlyThen(DateTime dateTime, boolean ignoreTime) {
		return compare(dateTime, ignoreTime)>0;
	}
	
	/**
	 * return == 0 - if is equals
	 * return > 0 if is recently then
	 * return < 0 if is older then
	 */
	public int compare(DateTime dateTime, boolean ignoreTime){
		int r = year-dateTime.year;
		if(r == 0){
			r = month-dateTime.month;
			if(r == 0){
				r = day-dateTime.day;
				if(r == 0){
					if(!ignoreTime) {
						r = hour-dateTime.hour;
						if(r == 0){
							r = minute-dateTime.minute;
							if(r == 0){
								r = second-dateTime.second;
							}
						}
					}
				}
			}
		}
		return r;
	}
	
	@Override
	public String toString() {
		return getDate()+" "+getTime();
	}
	
	public static DateTime now(){
		return new DateTime(System.currentTimeMillis());
	}
	
	public long toMilliSeconds() {
		if(isValid()) {
			return LocalDateTime.of(year, month, day, hour, minute, second).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		}
		return -1;
	}
	
}
