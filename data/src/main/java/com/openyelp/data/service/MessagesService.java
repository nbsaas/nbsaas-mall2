package com.openyelp.data.service;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.Messages;



public interface MessagesService {
	public Pagination getPage(int pageNo, int pageSize);

	public Messages findById(Long id);

	public Messages save(Messages bean);
	public Messages send(Messages bean);

	public Messages update(Messages bean);

	public Messages deleteById(Long id);
	public Messages removeByFrom(Long id);
	public Messages removeByFrom(Long[] ids);
	public Messages removeByTo(Long id);
	public Messages removeByTo(Long[] id);

	public Messages[] deleteByIds(Long[] ids);
	
	
	public Pagination pageByReceive(long userid,int pageNo, int pageSize);
	public Pagination pageBySend(long userid,int pageNo, int pageSize);

}