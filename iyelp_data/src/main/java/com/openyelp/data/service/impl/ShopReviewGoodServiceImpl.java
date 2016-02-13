package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.ShopReviewGoodDao;
import com.openyelp.data.entity.Area;
import com.openyelp.data.entity.ShopReviewGood;
import com.openyelp.data.service.AreaService;
import com.openyelp.data.service.ShopReviewGoodService;

@Service
@Transactional
public class ShopReviewGoodServiceImpl implements ShopReviewGoodService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopReviewGood findById(Long id) {
		ShopReviewGood entity = dao.findById(id);
		return entity;
	}

	
	
	@Transactional
	public ShopReviewGood save(ShopReviewGood bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public ShopReviewGood update(ShopReviewGood bean) {
		Updater<ShopReviewGood> updater = new Updater<ShopReviewGood>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public ShopReviewGood deleteById(Long id) {
		ShopReviewGood bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public ShopReviewGood[] deleteByIds(Long[] ids) {
		ShopReviewGood[] beans = new ShopReviewGood[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopReviewGoodDao dao;

	@Autowired
	public void setDao(ShopReviewGoodDao dao) {
		this.dao = dao;
	}

	@Autowired
	AreaService areaService;

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByArea(int areaid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		Area area = areaService.findById(areaid);
		if (area != null) {
			finder.append("from ShopReviewGood s where s.shopReview.shop.area.lft >= :lft");
			finder.setParam("lft", area.getLft());
			finder.append(" and s.shopReview.shop.area.rgt <= :rgt ");
			finder.setParam("rgt", area.getRgt());

			return dao.find(finder, pageNo, pageSize);
		} else {
			Pagination pagination = new Pagination<ShopReviewGood>();
			return pagination;
		}

	}
}