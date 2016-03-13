package com.openyelp.data.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.admin.entity.Menu;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.openyelp.annotation.NoGson;
import com.openyelp.data.dao.ShopCategoryDao;
import com.openyelp.data.dao.ShopDao;
import com.openyelp.data.entity.Shop;
import com.openyelp.data.entity.ShopCategory;
import com.openyelp.data.entity.TalkCategory;
import com.openyelp.data.service.ShopCategoryService;
import com.openyelp.data.shop.vo.ShopCatalog;

@Service
@Transactional
public class ShopCategoryServiceImpl implements ShopCategoryService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	
    @Cacheable(value="shop_catalog_cache")
	@Transactional(readOnly = true)
	public ShopCategory findById(Integer id) {
		ShopCategory entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public ShopCategory save(ShopCategory bean) {
		dao.save(bean);
		if (bean.getParentId() != null) {
			ShopCategory parent = dao.findById(bean.getParentId());
			if (parent != null) {
				if (parent.getLevelinfo() != null) {
					bean.setLevelinfo(parent.getLevelinfo() + 1);
				} else {
					bean.setLevelinfo(2);
				}
				if (parent.getIds() != null) {
					bean.setIds(parent.getIds() + "," + bean.getId());

				} else {
					bean.setIds(parent.getId() + "," + bean.getId());
				}
			} else {
				bean.setLevelinfo(1);
				bean.setIds("" + bean.getId());
			}
		} else {
			bean.setLevelinfo(1);
			bean.setIds("" + bean.getId());
		}
		return bean;
	}

	@Transactional
	public ShopCategory update(ShopCategory bean) {
		Updater<ShopCategory> updater = new Updater<ShopCategory>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public ShopCategory deleteById(Integer id) {
		ShopCategory bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public ShopCategory[] deleteByIds(Integer[] ids) {
		ShopCategory[] beans = new ShopCategory[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopCategoryDao dao;

	@Autowired
	public void setDao(ShopCategoryDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public List<ShopCategory> findByPid(int id) {
		Finder finder = Finder.create();
		finder.append("from ShopCategory s where s.parent.id=:pid");
		finder.setParam("pid", id);
		return dao.find(finder);
	}

	@Transactional
	@Override
	public ShopCategory findByName(String name) {
		ShopCategory result = null;

		Finder finder = Finder.create();
		finder.append("from ShopCategory s where s.name=:name");
		finder.setParam("name", name);
		List<ShopCategory> cs = dao.find(finder);
		if (cs != null && cs.size() > 0) {
			result = cs.get(0);
		} else {
			if (name != null) {
				result = new ShopCategory();
				ShopCategory parent = new ShopCategory();
				parent.setId(1);
				result.setParent(parent);
				result.setName(name);
				result = dao.save(result);
			}
		}
		return result;
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public String findByPidForJson(int id) {
		Finder finder = Finder.create();
		finder.append("from ShopCategory s where s.parent.id=:pid");
		finder.setParam("pid", id);
		List<ShopCategory> cs = dao.find(finder);

		Gson gson = new GsonBuilder().setExclusionStrategies(
				new ExclusionStrategy() {

					@Override
					public boolean shouldSkipField(FieldAttributes f) {
						NoGson noGson = f.getAnnotation(NoGson.class);
						if (noGson != null) {
							return true;
						}
						return false;
					}

					@Override
					public boolean shouldSkipClass(Class<?> clazz) {
						// TODO Auto-generated method stub
						return false;
					}
				}) // <---
				.create();
		return gson.toJson(cs);
	}

	@Autowired
	ShopDao shopDao;
	
	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByNear(Long shopid, int pageNo, int pageSize) {
		Shop shop = shopDao.findById(shopid);
		Finder finder = Finder.create();
		if (shop != null) {
			Set<ShopCategory> ss = shop.getCategorys();
			if(ss.size()>0){
				finder.append("from ShopCategory s where s.id > :cid");
				finder.setParam("cid", ss.iterator().next().getIcon());
			}else{
				finder.append("from ShopCategory s ");

			}
			
		} else {
			finder.append("from ShopCategory s ");

		}

		finder.append(" order by s.id desc");
		return dao.find(finder, pageNo, pageSize);
	}
	@Transactional(readOnly = true)
	@Override
	public List<ShopCategory> findByTops(int id) {
		LinkedList<ShopCategory> areas = new LinkedList<ShopCategory>();
		ShopCategory area = dao.findById(id);
		while (area.getParent()!=null&&area.getId() > 1) {
			areas.addFirst(area);
			area=dao.findById(area.getParentId());
		}

		return areas;
	}

	@Transactional(readOnly = true)
	@Override
	public List<ShopCatalog> findByPidl2(int id) {
		List<ShopCatalog> result=new ArrayList<ShopCatalog>();
		Finder finder = Finder.create();
		finder.append("from ShopCategory s where s.parent.id=:pid");
		finder.setParam("pid", id);
		List<ShopCategory>  cs=dao.find(finder);
		if(cs!=null){
			for (ShopCategory shopCategory : cs) {
				ShopCatalog item=new ShopCatalog();
				item.setId(shopCategory.getId());
				item.setName(shopCategory.getCname());
				item.setClilds(conver(shopCategory.getChildrens()));
				result.add(item);
			}
		}
		return result;
	} 
	public List<ShopCatalog> conver(List<ShopCategory>  cs){
		List<ShopCatalog> result=new ArrayList<ShopCatalog>();
		if (cs!=null) {
			for (ShopCategory shopCategory : cs) {
				ShopCatalog item=new ShopCatalog();
				item.setId(shopCategory.getId());
				item.setName(shopCategory.getCname());
				result.add(item);
			}
		}
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public List<ShopCatalog> findByPidl1(int id) {
		List<ShopCatalog> result=new ArrayList<ShopCatalog>();
		Finder finder = Finder.create();
		finder.append("from ShopCategory s where s.parent.id=:pid");
		finder.setParam("pid", id);
		List<ShopCategory>  cs=dao.find(finder);
		if(cs!=null){
			for (ShopCategory shopCategory : cs) {
				ShopCatalog item=new ShopCatalog();
				item.setId(shopCategory.getId());
				item.setName(shopCategory.getCname());
				result.add(item);
			}
		}
		return result;
	}

	@Transactional
	@Override
	public Integer updateNumsAndTime(Integer id) {
		// TODO Auto-generated method stub
		return dao.updateNums(id);
	}

	@Transactional
	@Override
	public Page<ShopCategory> findPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findPage(pageable);
	}

	@Transactional
	@Override
	public List<ShopCategory> findTop(int id) {
		LinkedList<ShopCategory> menus = new LinkedList<ShopCategory>();
		ShopCategory menu = dao.findById(id);
		while (menu.getParent() != null && menu.getId() > 0) {
			menus.addFirst(menu);
			menu = dao.findById(menu.getParentId());
		}

		if (menu != null && menu.getId() != null) {
			menus.addFirst(menu);
		}
		return menus;
	}

}