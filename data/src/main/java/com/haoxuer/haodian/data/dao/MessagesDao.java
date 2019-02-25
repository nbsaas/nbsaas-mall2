package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.Messages;

public interface MessagesDao extends BaseDao<Messages, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Messages findById(Long id);

	public Messages save(Messages bean);

	public Messages updateByUpdater(Updater<Messages> updater);

	public Messages deleteById(Long id);
}