package com.quhaodian.data.service.impl;

import com.quhaodian.data.entity.Channel;
import com.quhaodian.data.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.quhaodian.data.dao.ChannelDao;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Channel findById(Integer id) {
		Channel entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public Channel save(Channel bean) {
		dao.save(bean);
		int level = 0;

		if (bean.getParent() != null) {
			Channel p = dao.findById(bean.getParentId());
			if (p != null) {
				if (p.getLevelinfo() != null) {
					level=p.getLevelinfo();
					level++;
				}
			}
		}
		bean.setLevelinfo(level);

		return bean;
	}

	@Transactional
	public Channel update(Channel bean) {
		Updater<Channel> updater = new Updater<Channel>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public Channel deleteById(Integer id) {
		Channel bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public Channel[] deleteByIds(Integer[] ids) {
		Channel[] beans = new Channel[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ChannelDao dao;

	@Autowired
	public void setDao(ChannelDao dao) {
		this.dao = dao;
	}
}