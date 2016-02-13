package com.openyelp.actions.shop;

public class TimeUtils {
	public static String showtime(int index) {
		String result = "";
		if (index < 48) {
			int hour = index / 2;
			int minute = index % 2;
			StringBuffer buffer = show(index,hour, minute);
			if(index==0){
				buffer.append("(午夜)");
			}
			else if(index==24){
				buffer.append("(正午)");
			}
			result = buffer.toString();
		} else {
			int hour = (index % 48) / 2;
			int minute = index % 2;
			StringBuffer buffer = show(index,hour, minute);
			if (index==48) {
				buffer.append("(下一日的午夜)");
			}else{
				buffer.append("(下一日)");
			}
			result = buffer.toString();
		}
		return result;
	}
	public static String showtime1(int index) {
		String result = "";
		if (index < 48) {
			int hour = index / 2;
			int minute = index % 2;
			StringBuffer buffer = show(index,hour, minute);
			result = buffer.toString();
		} else {
			int hour = (index % 48) / 2;
			int minute = index % 2;
			StringBuffer buffer = show(index,hour, minute);
			result = buffer.toString();
		}
		return result;
	}
	private static StringBuffer show(int index,int hour, int minute) {
		StringBuffer buffer = new StringBuffer();
		if (hour < 10) {
			buffer.append("0");
		}
		buffer.append(hour);
		buffer.append(":");
		if (minute < 1) {
			buffer.append("00");
		} else {
			buffer.append(minute * 30);
		}
		return buffer;
	}

}
