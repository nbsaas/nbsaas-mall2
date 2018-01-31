package com.quhaodian.haodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Messages;

public interface MessagesDao extends BaseDao<Messages, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Messages findById(Long id);

	public Messages save(Messages bean);

	public Messages updateByUpdater(Updater<Messages> updater);

	public Messages deleteById(Long id);
}