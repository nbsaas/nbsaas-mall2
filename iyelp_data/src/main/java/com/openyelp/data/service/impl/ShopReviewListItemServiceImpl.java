package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.openyelp.data.dao.ShopReviewListItemDao;
import com.openyelp.data.entity.ShopReviewListItem;
import com.openyelp.data.service.ShopReviewListItemService;

@Service
@Transactional
public class ShopReviewListItemServiceImpl implements ShopReviewListItemService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopReviewListItem findById(Long id) {
		ShopReviewListItem entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ShopReviewListItem save(ShopReviewListItem bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ShopReviewListItem update(ShopReviewListItem bean) {
		Updater<ShopReviewListItem> updater = new Updater<ShopReviewListItem>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ShopReviewListItem deleteById(Long id) {
		ShopReviewListItem bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ShopReviewListItem[] deleteByIds(Long[] ids) {
		ShopReviewListItem[] beans = new ShopReviewListItem[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopReviewListItemDao dao;

	@Autowired
	public void setDao(ShopReviewListItemDao dao) {
		this.dao = dao;
	}

	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByList(Long listid, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from  ShopReviewListItem s where s.list.id =:listid ");
		finder.setParam("listid", listid);
		finder.append("order by s.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}
}