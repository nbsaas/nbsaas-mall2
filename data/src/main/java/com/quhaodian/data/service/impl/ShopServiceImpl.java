package com.quhaodian.data.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.quhaodian.data.dao.FeedDao;
import com.quhaodian.data.dao.ShopAttrDao;
import com.quhaodian.data.dao.ShopCategoryDao;
import com.quhaodian.data.dao.ShopDao;
import com.quhaodian.data.entity.Shop;
import com.quhaodian.data.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.area.data.dao.AreaDao;
import com.ada.area.data.entity.Area;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.quhaodian.data.dao.ShopTagDao;
import com.quhaodian.data.entity.ShopCategory;
import com.quhaodian.data.entity.ShopTag;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Shop findById(Long id) {
		Shop entity = dao.findById(id);
		return entity;
	}

	@Autowired
    FeedDao feedDao;

	@Autowired
    ShopCategoryDao shopCategoryDao;

	@CacheEvict(value = "shop_cache", allEntries = true)
	@Transactional
	public Shop save(Shop bean) {

		Finder finder = Finder.create();
		finder.append("from Shop s where s.name=:name");
		finder.setParam("name", bean.getName());
		finder.append(" and s.gps =:gps");
		finder.setParam("gps", bean.getGps());
		List<Shop> shops = dao.find(finder);
		if (shops != null && shops.size() > 0) {
			Shop shop = shops.get(0);
			bean.setAddDate(shop.getAddDate());
			bean.setLastDate(new Date());
			bean.setId(shop.getId());
			dao.update(bean);
		} else {
			bean.setAddDate(new Date());
			bean.setLastDate(new Date());
			dao.save(bean);
			feedDao.addFeed(bean);
		}

		Set<ShopCategory> cs = bean.getCategorys();
		if (cs != null) {
			for (ShopCategory shopCategory : cs) {
				shopCategoryDao.updateNums(shopCategory.getId());
			}
		}
		return bean;
	}

	@CacheEvict(value = "shop_cache", allEntries = true)
	@Transactional
	public Shop update(Shop bean) {
		Updater<Shop> updater = new Updater<Shop>(bean);
		bean = dao.updateByUpdater(updater);
		
		Set<ShopCategory> cs = bean.getCategorys();
		if (cs != null) {
			for (ShopCategory shopCategory : cs) {
				shopCategoryDao.updateNums(shopCategory.getId());
			}
		}
		
		return bean;
	}

	@CacheEvict(value = "shop_cache", allEntries = true)
	@Transactional
	public Shop deleteById(Long id) {
		Shop bean = dao.deleteById(id);
		
		Set<ShopCategory> cs = bean.getCategorys();
		if (cs != null) {
			for (ShopCategory shopCategory : cs) {
				shopCategoryDao.updateNums(shopCategory.getId());
			}
		}
		return bean;
	}

	@CacheEvict(value = "shop_cache", allEntries = true)
	@Transactional
	public Shop[] deleteByIds(Long[] ids) {
		Shop[] beans = new Shop[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopDao dao;

	@Autowired
	private ShopAttrDao shopAttrDao;

	@Autowired
	private ShopTagDao shopTagDao;

	@Autowired
	public void setDao(ShopDao dao) {
		this.dao = dao;
	}

	@CacheEvict(value = "shop_cache", allEntries = true)
	@Override
	public Shop addTag(Shop bean, String tag) {

		if (bean.getId() == null || tag == null) {
			Shop shop = new Shop();
			shop.setId(-1l);
			return shop;
		}
		bean = dao.findById(bean.getId());
		if (bean != null) {
			List<ShopTag> tags = shopTagDao.findByProperty("name", tag);
			if (tags != null && tags.size() > 0) {
				ShopTag tagx = tags.get(0);

				boolean isadd = bean.getTags().add(tagx);
				if (isadd) {
					Integer size = tagx.getSize();
					if (size == null) {
						size = 0;
					}
					size++;
					tagx.setSize(size);
				}
			} else {
				ShopTag tagx = new ShopTag();
				tagx.setAddDate(new Date());
				tagx.setSize(1);
				tagx.setName(tag);
				shopTagDao.save(tagx);
				bean.getTags().add(tagx);
			}

		}
		return bean;
	}

	@CacheEvict(value = "shop_cache", allEntries = true)
	@Override
	public Shop deleteTag(Shop bean, String tag) {
		if (bean.getId() == null || tag == null) {
			Shop shop = new Shop();
			shop.setId(-1l);
			return shop;
		}
		bean = dao.findById(bean.getId());
		if (bean != null) {
			List<ShopTag> tags = shopTagDao.findByProperty("name", tag);
			if (tags != null && tags.size() > 0) {
				ShopTag tagx = tags.get(0);
				boolean isdelete = bean.getTags().remove(tagx);
				if (isdelete) {
					Integer size = tagx.getSize();
					if (size == null) {
						size = 1;
					}
					size--;
					if (size < 0) {
						size = 0;
					}
					tagx.setSize(size);
				}
			}

		}
		return bean;
	}

	@Cacheable(value = "shop_cache")
	@Transactional(readOnly = true)
	@Override
	public Pagination search(String loc, String find_desc, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from Shop s where s.area.name=:name");
		finder.setParam("name", loc);
		if (find_desc != null && find_desc.length() > 1) {
			finder.append(" and s.name  like  :shopname");
			finder.setParam("shopname", "%" + find_desc + "%");
		}
		finder.append(" order by s.id desc");
		// TODO Auto-generated method stub
		return dao.find(finder, pageNo, pageSize);
	}

	@CacheEvict(value = "shop_cache", allEntries = true)
	@Transactional
	@Override
	public Shop addCategory(Shop bean, ShopCategory category) {
		Shop restult = dao.findById(bean.getId());
		restult.getCategorys().add(category);
		return restult;
	}

	@CacheEvict(value = "shop_cache", allEntries = true)
	@Transactional
	@Override
	public Shop addCategory(Shop bean, Integer category) {
		Shop restult = dao.findById(bean.getId());
		ShopCategory shopcatagory = new ShopCategory();
		shopcatagory.setId(category);
		restult.getCategorys().add(shopcatagory);
		return restult;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination page(int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from Shop s ");
		finder.append(" order by s.id desc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByNew(int areaid, int pageNo, int pageSize) {
		Pagination result = new Pagination<Shop>();
		Area area = areaDao.findById(areaid);

		if (area != null) {
			Finder finder = Finder.create();
			finder.append("from Shop s ");
			finder.append(" where s.area.lft   >=:arealft");
			finder.append(" and s.area.rgt   <=:areargt");
			finder.setParam("arealft", area.getLft());
			finder.setParam("areargt", area.getRgt());
			finder.append(" order by s.id desc");
			// TODO Auto-generated method stub
			return dao.find(finder, pageNo, pageSize);
		}
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByNear(int shopid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from Shop s where s.id > :shopid");
		finder.setParam("shopid", shopid);
		finder.append(" order by s.id desc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByGood(int shopid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from Shop s where s.id < :shopid");
		finder.setParam("shopid", shopid);
		finder.append(" order by s.id desc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Autowired
	ShopCategoryDao categoryDao;

	@Autowired
	AreaDao areaDao;

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByType(int areaid, int typeid, int pageNo, int pageSize) {
		ShopCategory category = categoryDao.findById(typeid);

		Area area = areaDao.findById(areaid);

		if (category != null && area != null) {
			Finder finder = Finder.create();
			finder.append("select distinct  s from Shop s ");

			finder.append(" join s.categorys  as c  where c.lft >=:lft and c.rgt <=:rgt");
			finder.setParam("lft", category.getLft());
			finder.setParam("rgt", category.getRgt());
			finder.append(" and s.area.lft   >=:arealft");
			finder.append(" and s.area.rgt   <=:areargt");
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

	@Override
	public List search(String hql) {
		// TODO Auto-generated method stub
		return dao.find(hql, null);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination search(String loc, String find_desc, int catalog, int pageNo, int pageSize) {
		ShopCategory category = categoryDao.findById(catalog);

		Area area = areaDao.findByName(loc);

		if (category != null && area != null) {
			Finder finder = Finder.create();
			finder.append("select distinct  s from Shop s ");

			finder.append(" join s.categorys  as c  where c.lft >=:lft and c.rgt <=:rgt");
			finder.setParam("lft", category.getLft());
			finder.setParam("rgt", category.getRgt());
			finder.append(" and s.area.lft   >=:arealft");
			finder.append(" and s.area.rgt   <=:areargt");
			finder.append("  and s.name like :find_desc ");
			finder.setParam("find_desc", "%" + find_desc + "%");
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
			return new Pagination();
		}
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination search(String key, int areaid, int catalog, int pageNo, int pageSize) {
		ShopCategory category = categoryDao.findById(catalog);

		Area area = areaDao.findById(areaid);

		if (category != null && area != null) {
			Finder finder = Finder.create();
			finder.append("select distinct  s from Shop s ");

			finder.append(" join s.categorys  as c  where c.lft >=:lft and c.rgt <=:rgt");
			finder.setParam("lft", category.getLft());
			finder.setParam("rgt", category.getRgt());
			finder.append(" and s.area.lft   >=:arealft");
			finder.append(" and s.area.rgt   <=:areargt");
			finder.setParam("arealft", area.getLft());
			finder.setParam("areargt", area.getRgt());
			finder.append(" and s.name   like :name ");
			finder.setParam("name", "%" + key + "%");
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

	@Transactional(readOnly = true)
	@Override
	public Shop findByRand(int areaid) {
		Area area = areaDao.findById(areaid);
		if (area==null){
			return null;
		}

		Finder finder = Finder.create();
		finder.append("select max(s.id) from Shop s ");
		finder.append(" where s.area.lft   >=:arealft");
		finder.append(" and s.area.rgt   <=:areargt");
		finder.setParam("arealft", area.getLft());
		finder.setParam("areargt", area.getRgt());
		Long maxid = dao.<Long> hql(finder);
		if (maxid != null && maxid > 0) {
			Random random = new Random();
			Long id = (long) (Math.random() * maxid);
			Finder finder2 = Finder.create();

			finder2.append("select distinct  s from Shop s ");
			finder2.append(" where s.id >=:maxid");
			finder2.setParam("maxid", id);
			finder2.append(" and s.area.lft   >=:arealft");
			finder2.append(" and s.area.rgt   <=:areargt");
			finder2.setParam("arealft", area.getLft());
			finder2.setParam("areargt", area.getRgt());
			finder2.append("  order by s.id asc");
			finder2.setMaxResults(3);
			List<Shop> shops = dao.find(finder2);
			if (shops != null && shops.size() > 0) {
				return shops.get(0);
			}
		}

		return null;
	}

}