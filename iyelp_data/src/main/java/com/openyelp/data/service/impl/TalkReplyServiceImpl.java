package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.TalkDao;
import com.openyelp.data.dao.TalkReplyDao;
import com.openyelp.data.entity.Talk;
import com.openyelp.data.entity.TalkReply;
import com.openyelp.data.service.TalkReplyService;

@Service
@Transactional
public class TalkReplyServiceImpl implements TalkReplyService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public TalkReply findById(Integer id) {
		TalkReply entity = dao.findById(id);
		return entity;
	}

	@Autowired
	TalkDao talkDao;

	@Transactional
	public TalkReply save(TalkReply bean) {
		dao.save(bean);
		Talk talk = talkDao.findById(bean.getTalk().getId());
		Integer replies = talk.getReplies();
		if(replies==null){
			replies=0;
		}
		replies++;
		talk.setReplies(replies);
		talk.setLastmessage(bean.getMessage());
		return bean;
	}

	@Transactional
	public TalkReply update(TalkReply bean) {
		Updater<TalkReply> updater = new Updater<TalkReply>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public TalkReply deleteById(Integer id) {
		TalkReply bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public TalkReply[] deleteByIds(Integer[] ids) {
		TalkReply[] beans = new TalkReply[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private TalkReplyDao dao;

	@Autowired
	public void setDao(TalkReplyDao dao) {
		this.dao = dao;
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByTalk(Long talkid, int pageNo, int pageSize) {
		Finder finder =Finder.create();
		finder.append("from TalkReply t where  t.talk.id=:talkid");
		finder.setParam("talkid", talkid);
		finder.append(" order by t.id desc");
		return dao.find(finder , pageNo, pageSize);
	}
}