package com.nbsaas.boot.shop.data.entity;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Embeddable
public class ShopTime implements Serializable {

    private Integer week = 0;
    private Integer minHour = 0;
    private Integer maxHour = 47;


    public boolean getWork() {
        boolean result = false;
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int curweek = calendar.get(Calendar.DAY_OF_WEEK);
        int curmite = calendar.get(Calendar.MINUTE);
        int twekk=week;
        twekk=twekk+2;
        twekk=twekk%7;
        if (twekk == 0) {
            twekk = 7;
        }
        if (twekk == curweek) {
            int hh = (hour * 60 + curmite) / 30;
            if (hh > minHour) {
                if (hh < maxHour) {
                    result = true;
                }
            }
        }

        return result;

    }
    public static void main(String[] args) {
        int week=4;
        week=week+2;
        week=week%7;
        if (week == 0) {
            week = 1;
        }
        System.out.println(week);
    }
    public boolean getDay() {
        boolean result = false;
        Calendar calendar = Calendar.getInstance();
        int curweek = calendar.get(Calendar.DAY_OF_WEEK);

        return result;
    }



    static Map<Integer, String> weeks = new HashMap<Integer, String>();

    static {
        //1周天
        //2 周一
        //7 周六
        weeks.put(0, "周一");
        weeks.put(1, "周二");
        weeks.put(2, "周三");
        weeks.put(3, "周四");
        weeks.put(4, "周五");
        weeks.put(5, "周六");
        weeks.put(6, "周日");
    }

    public String getWeekDay() {
        return weeks.get(week);
    }
}
