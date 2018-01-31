package com.quhaodian.haodian.actions.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TimeVo implements Serializable {

	private int index;
	private String name;

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "TimeVo{" +
				"index=" + index +
				", name='" + name + '\'' +
				'}';
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   //62
	public static  List<TimeVo> times(int min,int max) {
		List<TimeVo> result = new ArrayList<TimeVo>();
		for (int i = min; i < max; i++) {
			String name=TimeUtils.showtime(i);
			TimeVo vo=new TimeVo();
			vo.name=name;
			vo.index=i;
			result.add(vo);
		}
		return result;
	}
	public static void main(String[] args) {
		List<TimeVo> vos=	TimeVo.times(1, 48);
		for (TimeVo vo:vos){
			System.out.println(vo);
		}
	}
}
