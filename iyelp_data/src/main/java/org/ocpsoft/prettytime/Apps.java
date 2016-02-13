package org.ocpsoft.prettytime;

import java.util.Date;

public class Apps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrettyTime p = new PrettyTime();
		System.out.println(p.format(new Date()));
		long t = 1000 * 60 * 60 *60* 10l;

		String timestamp = p.format(new Date(System.currentTimeMillis()- t));

		System.out.println(timestamp);

		System.out.println(t);
		
		int tx = 1000 * 60 * 60*60 * 10;
		System.out.println(tx);
	}

}
