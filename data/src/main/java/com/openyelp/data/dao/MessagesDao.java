package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.Messages;

public interface MessagesDao extends BaseDao<Messages, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Messages findById(Long id);

	public Messages save(Messages bean);

	public Messages updateByUpdater(Updater<Messages> updater);

	public Messages deleteById(Long id);
}