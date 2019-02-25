package com.haoxuer.haodian.data.service.impl;

import java.util.Date;

import com.haoxuer.haodian.data.dao.PhotoDao;
import com.haoxuer.haodian.data.entity.Photo;
import com.haoxuer.haodian.data.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Finder;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Photo findById(Long id) {
		Photo entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Photo save(Photo bean) {
    	bean.setAddDate(new Date());
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Photo update(Photo bean) {
		Updater<Photo> updater = new Updater<Photo>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Photo deleteById(Long id) {
		Photo bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Photo[] deleteByIds(Long[] ids) {
		Photo[] beans = new Photo[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private PhotoDao dao;

	@Autowired
	public void setDao(PhotoDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(Long id, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from Photo p where p.userInfo.id =:userid");
		finder.setParam("userid", id);
		finder.append("  order by p.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}
}