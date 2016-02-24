package com.openyelp.actions.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.openyelp.data.entity.EventInfoCategory;

public class EventCategory implements Serializable {

	private Integer id;
	private String name;
	private String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	private boolean show;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getShowSelect() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	
	public static List<EventCategory> show(List<EventInfoCategory> es,List<Integer> ids){
		List<EventCategory> result=new ArrayList<EventCategory>();
		if (es!=null&&es.size()>0) {
			for (EventInfoCategory eventCategory : es) {
				EventCategory item=new EventCategory();
				if(ids.contains(eventCategory.getId())){
					item.setShow(true);
				}else{
					item.setShow(false);
				}
				item.setId(eventCategory.getId());
				item.setName(eventCategory.getName());
				item.setUrl(makeUrl(ids,item.getId()));
				
				result.add(item);
			}
		}
		return result;
	}
	public static String makeUrl(List<Integer> ids,Integer id){
		StringBuffer result=new StringBuffer();
		if(ids!=null){
			List<Integer> idss=new ArrayList<Integer>(); 
			idss.addAll(ids);
			idss.remove(id);
			for (Integer integer : idss) {
				result.append("&");
				result.append("c=");
				result.append(integer);
			}
		}
		return result.toString();
		
	}
	
	
	
}
