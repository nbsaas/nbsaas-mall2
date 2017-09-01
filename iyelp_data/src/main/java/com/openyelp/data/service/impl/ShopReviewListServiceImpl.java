package com.openyelp.data.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.area.data.dao.AreaDao;
import com.ada.area.data.entity.Area;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.openyelp.data.dao.ShopReviewListDao;
import com.openyelp.data.entity.ShopReviewList;
import com.openyelp.data.service.ShopReviewListService;

@Service
@Transactional
public class ShopReviewListServiceImpl implements ShopReviewListService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopReviewList findById(Long id) {
		ShopReviewList entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public ShopReviewList save(ShopReviewList bean) {
		
		bean.setAddDate(new Date());
		bean.setLastDate(new Date());
		dao.save(bean);
		return bean;
	}

	@Transactional
	public ShopReviewList update(ShopReviewList bean) {
		
		bean.setLastDate(new Date());
		Updater<ShopReviewList> updater = new Updater<ShopReviewList>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public ShopReviewList deleteById(Long id) {
		ShopReviewList bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public ShopReviewList[] deleteByIds(Long[] ids) {
		ShopReviewList[] beans = new ShopReviewList[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopReviewListDao dao;

	@Autowired
	public void setDao(ShopReviewListDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(Long uid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  ShopReviewList s where s.user.id =:uid ");
		finder.setParam("uid", uid);
		finder.append("order by s.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByArea(int areaid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  ShopReviewList s where s.area.id =:areaid ");
		finder.setParam("areaid", areaid);
		finder.append("  order by s.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}

	@Autowired
	AreaDao areaDao;

	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByArea(String area, int pageNo, int pageSize) {
		Area areas = areaDao.findByName(area);
		if(areas!=null){
			Finder finder = Finder.create();
			finder.append("from  ShopReviewList s where s.area.id =:areaid ");
			finder.setParam("areaid", areas.getId());
			finder.append("  order by s.id desc ");
			return dao.find(finder, pageNo, pageSize);
		}else{
			Pagination page=new Pagination<ShopReviewList>();
			return page;

		}
		
	}

	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByArea(String key, String area, int pageNo,
			int pageSize) {
		Area areas = areaDao.findByName(area);
		if(areas!=null){
			Finder finder = Finder.create();
			finder.append("from  ShopReviewList s where s.area.id =:areaid ");
			finder.setParam("areaid", areas.getId());
			finder.append(" and s.title like :title");
			finder.setParam("title", "%"+key+"%");
			finder.append("  order by s.id desc ");
			return dao.find(finder, pageNo, pageSize);
		}else{
			Pagination page=new Pagination<ShopReviewList>();
			return page;

		}
	}
}