package com.quhaodian.haodian.data.service.impl;

import java.util.Date;

import com.quhaodian.haodian.data.dao.MessagesDao;
import com.quhaodian.haodian.data.service.MessageReplyService;
import com.quhaodian.haodian.data.dao.MessageReplyDao;
import com.quhaodian.haodian.data.entity.MessageReply;
import com.quhaodian.haodian.data.entity.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;

@Service
public class MessageReplyServiceImpl implements MessageReplyService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public MessageReply findById(Long id) {
		MessageReply entity = dao.findById(id);
		return entity;
	}
	
	@Autowired
    MessagesDao messagesDao;

    @Transactional
	public MessageReply save(MessageReply bean) {
    	bean.setAddDate(new Date());
		dao.save(bean);
		if(bean.getMessage()!=null){
			Messages msg=	messagesDao.findById(bean.getMessage().getId());
			msg.setTohide(0);
			msg.setFromhide(0);
			msg.setContents(bean.getMessages());
		}
		
		return bean;
	}

    @Transactional
	public MessageReply update(MessageReply bean) {
		Updater<MessageReply> updater = new Updater<MessageReply>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public MessageReply deleteById(Long id) {
		MessageReply bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public MessageReply[] deleteByIds(Long[] ids) {
		MessageReply[] beans = new MessageReply[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private MessageReplyDao dao;

	@Autowired
	public void setDao(MessageReplyDao dao) {
		this.dao = dao;
	}

	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByMessage(long id, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from MessageReply m where m.message.id  = :messageid ");
		finder.setParam("messageid", id);
		finder.append("  order by m.id desc  ");
		
		return dao.find(finder, pageNo, pageSize);
	}
}