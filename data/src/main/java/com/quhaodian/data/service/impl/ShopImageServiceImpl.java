package com.quhaodian.data.service.impl;

import java.util.List;

import com.quhaodian.data.dao.ShopCategoryDao;
import com.quhaodian.data.dao.ShopDao;
import com.quhaodian.data.entity.ShopImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.area.data.dao.AreaDao;
import com.ada.area.data.entity.Area;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.quhaodian.data.dao.FeedDao;
import com.quhaodian.data.dao.ShopImageDao;
import com.quhaodian.data.entity.Shop;
import com.quhaodian.data.entity.ShopCategory;
import com.quhaodian.data.service.ShopImageService;

@Service
@Transactional
public class ShopImageServiceImpl implements ShopImageService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopImage findById(Long id) {
		ShopImage entity = dao.findById(id);
		return entity;
	}

	@Autowired
    ShopDao shopDao;

	@Autowired
	FeedDao feedDao;
	
	@CacheEvict(value="shop_cache",allEntries=true)
	@Transactional
	public ShopImage save(ShopImage bean) {

		Shop shop = shopDao.findById(bean.getShop().getId());
		Finder finder = Finder.create();
		finder.append("from ShopImage s where s.shop.id =:shopid");
		finder.setParam("shopid", bean.getShop().getId());
		int ps = dao.countQueryResult(finder);
		if(shop.getImage()==null||shop.getImage().length()<10){
			shop.setImage(bean.getUrl());
		}
		shop.setPhotos(ps);
		bean.setNum(ps);
		dao.save(bean);
		feedDao.addFeed(bean);

		return bean;
	}

	@Transactional
	public ShopImage update(ShopImage bean) {
		Updater<ShopImage> updater = new Updater<ShopImage>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public ShopImage deleteById(Long id) {
		ShopImage bean = dao.deleteById(id);
		Shop shop = shopDao.findById(bean.getShop().getId());
		Finder finder = Finder.create();
		finder.append("from ShopImage s where s.shop.id =:shopid");
		finder.setParam("shopid", bean.getShop().getId());
		int ps = dao.countQueryResult(finder);
		shop.setPhotos(ps);
		return bean;
	}

	@Transactional
	public ShopImage[] deleteByIds(Long[] ids) {
		ShopImage[] beans = new ShopImage[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopImageDao dao;

	@Autowired
	public void setDao(ShopImageDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByShop(Long id, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from ShopImage s where s.shop.id =:shopid ");
		finder.setParam("shopid", id);
		finder.append(" order by s.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public ShopImage findById(Long id, int num) {
		Finder finder = Finder.create();
		finder.append("from ShopImage s where s.shop.id =:shopid ");
		finder.setParam("shopid", id);
		finder.append(" and s.num >= :num ");
		finder.setParam("num", num);
		finder.append(" order by s.num asc ");
		List<ShopImage> ss = dao.find(finder);
		if(ss!=null&&ss.size()>0){
			return ss.get(0);
		}
		return null;
	}
	
	
	@Autowired
    ShopCategoryDao categoryDao;

	@Autowired
	AreaDao areaDao;
	
	
	
	@Transactional(readOnly = true)
	@Override
	public Pagination page(int areaid, int catalog, int pageNo, int pageSize) {
		ShopCategory category = categoryDao.findById(catalog);

		Area area = areaDao.findById(areaid);

		if (category != null && area != null) {
			Finder finder = Finder.create();
			finder.append("select distinct  s from ShopImage s ");

			finder.append(" join s.shop.categorys  as c  where c.lft >=:lft and c.rgt <=:rgt");
			finder.setParam("lft", category.getLft());
			finder.setParam("rgt", category.getRgt());
			finder.append(" and s.shop.area.lft   >=:arealft");
			finder.append(" and s.shop.area.rgt   <=:areargt");
			finder.setParam("arealft", area.getLft());
			finder.setParam("areargt", area.getRgt());
			finder.append(" order by s.id desc");
			Pagination p = null;
			try {
				p = dao.find(finder, pageNo, pageSize);
				// System.out.println(dao.transHqlToSql(finder.getOrigHql()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return p;
		} else {
			return null;
		}
	}
}