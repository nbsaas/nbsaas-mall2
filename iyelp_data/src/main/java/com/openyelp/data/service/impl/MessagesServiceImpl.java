package com.openyelp.data.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.MessageReplyDao;
import com.openyelp.data.dao.MessagesDao;
import com.openyelp.data.entity.MessageReply;
import com.openyelp.data.entity.Messages;
import com.openyelp.data.service.MessagesService;

@Service
@Transactional
public class MessagesServiceImpl implements MessagesService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Messages findById(Long id) {
		Messages entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Messages save(Messages bean) {
    	bean.setFromhide(0);
    	bean.setTohide(0);
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Messages update(Messages bean) {
		Updater<Messages> updater = new Updater<Messages>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Messages deleteById(Long id) {
		Messages bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Messages[] deleteByIds(Long[] ids) {
		Messages[] beans = new Messages[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private MessagesDao dao;

	@Autowired
	private MessageReplyDao messageReplyDao;
	
	@Autowired
	public void setDao(MessagesDao dao) {
		this.dao = dao;
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByReceive(long userid, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from Messages m where m.to.id=:toid ");
		finder.setParam("toid", userid);
		//finder.append("  and m.typeinfo=1");
		finder.append("  and m.tohide=0");
		finder.append("  order by m.id desc   ");
		return dao.find(finder, pageNo, pageSize);
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination pageBySend(long userid, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from Messages m where m.from.id=:fromid ");
		finder.setParam("fromid", userid);
		//finder.append("  and m.typeinfo=2");
		finder.append("  and m.tohide=0");

		finder.append("  order by m.id desc   ");
		return dao.find(finder, pageNo, pageSize);
	}
	@Transactional
	@Override
	public Messages send(Messages bean) {
		bean.setAddDate(new Date());
		dao.save(bean);
		
		MessageReply reply=new MessageReply();
		reply.setAddDate(new Date());
		reply.setMessage(bean);
		reply.setMessages(bean.getContents());
		reply.setUser(bean.getFrom());
		messageReplyDao.save(reply);

		
		return bean;
	}
	
	@Transactional
	@Override
	public Messages removeByFrom(Long id) {
		Messages message=new Messages();
		message.setId(id);
		message.setFromhide(1);
		message=dao.update(message);
		return message;
	}
	@Transactional
	@Override
	public Messages removeByTo(Long id) {
		Messages message=new Messages();
		message.setId(id);
		message.setTohide(1);
		message=dao.update(message);
		return message;
	}
	@Transactional
	@Override
	public Messages removeByFrom(Long[] ids) {
		for (Long id : ids) {
			Messages message=dao.findById(id);
			message.setId(id);
			message.setTohide(1);
			message=dao.update(message);
		}
		return null;
	}
	@Transactional
	@Override
	public Messages removeByTo(Long[] ids) {
		for (Long id : ids) {
			Messages message=dao.findById(id);
			message.setId(id);
			message.setTohide(1);
			message=dao.update(message);
			return message;
		}
		return null;
	}
}