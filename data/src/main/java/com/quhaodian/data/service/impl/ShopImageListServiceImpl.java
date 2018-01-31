package com.quhaodian.data.service.impl;

import java.util.Set;

import com.quhaodian.data.dao.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.dao.FeedDao;
import com.quhaodian.data.dao.ShopImageDao;
import com.quhaodian.data.dao.ShopImageListDao;
import com.quhaodian.data.entity.Shop;
import com.quhaodian.data.entity.ShopImage;
import com.quhaodian.data.entity.ShopImageList;
import com.quhaodian.data.service.ShopImageListService;

@Service
@Transactional
public class ShopImageListServiceImpl implements ShopImageListService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopImageList findById(Long id) {
		ShopImageList entity = dao.findById(id);
		return entity;
	}
	
	@Autowired
	FeedDao feedDao;
	
	@Autowired
    ShopDao shopDao;
	
	
	@Autowired
	ShopImageDao shopImageDao;

    @Transactional
	public ShopImageList save(ShopImageList bean) {
		Set<ShopImage> images=	bean.getImages();
		if(images!=null&&images.size()>0){
			ShopImage image = null;
			for (ShopImage shopImage : images) {
				shopImageDao.save(shopImage);
				image=shopImage;
			}
			Shop shop = shopDao.findById(image.getShop().getId());
			Finder finder = Finder.create();
			finder.append("from ShopImage s where s.shop.id =:shopid");
			finder.setParam("shopid", image.getShop().getId());
			int ps = dao.countQueryResult(finder);
			if(shop.getImage()==null||shop.getImage().length()<10){
				shop.setImage(image.getUrl());
			}
			shop.setPhotos(ps);
			bean.setNum(images.size());
		}
		dao.save(bean);
		feedDao.addFeed(bean);
		return bean;
	}

    @Transactional
	public ShopImageList update(ShopImageList bean) {
		Updater<ShopImageList> updater = new Updater<ShopImageList>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ShopImageList deleteById(Long id) {
		ShopImageList bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ShopImageList[] deleteByIds(Long[] ids) {
		ShopImageList[] beans = new ShopImageList[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopImageListDao dao;

	@Autowired
	public void setDao(ShopImageListDao dao) {
		this.dao = dao;
	}
}