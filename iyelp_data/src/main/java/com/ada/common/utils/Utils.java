package com.ada.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {

	public static String getpassword(int pwd_len) {
		StringBuffer buffer = new StringBuffer();

		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				buffer.append(str[i]);
				count++;
			}

		}
		return buffer.toString();
	}
	public static String getnumpassword(int pwd_len) {
		StringBuffer buffer = new StringBuffer();

		final int maxNum = 10;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
			if(count==0){
				if(i==0){
					continue;
				}
			}

			if (i >= 0 && i < str.length) {
				buffer.append(str[i]);
				count++;
			}

		}
		return buffer.toString();
	}
	public static void main(String[] args) {
		System.out.println(getmenpai(9,"x"));
	}
	public static String getCard(int length,String last){
		StringBuffer buffer = new StringBuffer();
		
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy");
		int l=length-5;
		l=l-last.length()-1;
		buffer.append(format.format(date));
		buffer.append(getnumpassword(l));
		buffer.append(last);
		return buffer.toString();

		
	}
	public static String getmenpai(int length,String last){
		StringBuffer buffer = new StringBuffer();
		
		int l=length-last.length();
		buffer.append(last);
		buffer.append(getnumpassword(l));
		return buffer.toString();

		
	}
}
