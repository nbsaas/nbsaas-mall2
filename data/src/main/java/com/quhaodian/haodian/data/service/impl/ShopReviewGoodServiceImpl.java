package com.quhaodian.haodian.data.service.impl;

import com.quhaodian.haodian.data.dao.ShopReviewGoodDao;
import com.quhaodian.haodian.data.entity.ShopReviewGood;
import com.quhaodian.haodian.data.service.ShopReviewGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.area.data.service.AreaService;
import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;

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