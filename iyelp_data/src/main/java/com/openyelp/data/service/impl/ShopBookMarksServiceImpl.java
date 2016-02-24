package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.ShopBookMarksDao;
import com.openyelp.data.entity.ShopBookMarks;
import com.openyelp.data.service.ShopBookMarksService;

@Service
@Transactional
public class ShopBookMarksServiceImpl implements ShopBookMarksService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopBookMarks findById(Long id) {
		ShopBookMarks entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ShopBookMarks save(ShopBookMarks bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ShopBookMarks update(ShopBookMarks bean) {
		Updater<ShopBookMarks> updater = new Updater<ShopBookMarks>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ShopBookMarks deleteById(Long id) {
		ShopBookMarks bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ShopBookMarks[] deleteByIds(Long[] ids) {
		ShopBookMarks[] beans = new ShopBookMarks[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopBookMarksDao dao;

	@Autowired
	public void setDao(ShopBookMarksDao dao) {
		this.dao = dao;
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(long uerid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from ShopBookMarks s where s.user.id=:userid");
		finder.setParam("userid", uerid);
		return dao.find(finder, pageNo, pageSize);
	}
}