package com.openyelp.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.MenuDao;
import com.openyelp.data.entity.Menu;
import com.openyelp.data.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Menu findById(Integer id) {
		Menu entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public Menu save(Menu bean) {
		dao.save(bean);
		if (bean.getParent() != null) {
			Menu parent = dao.findById(bean.getParentId());

			String ids = "";
			if (parent.getIds() != null) {
				ids = parent.getIds() + ",";
			}
			ids = ids + bean.getId();
			bean.setIds(ids);
			Integer parentlevel = parent.getLevelinfo();
			int level=1;
			if(parentlevel!=null){
				level=parentlevel+1;
			}
			bean.setLevelinfo(level);
		}else{
			bean.setIds(""+bean.getId());
			bean.setLevelinfo(1);
		}
		return bean;
	}

	@Transactional
	public Menu update(Menu bean) {
		Updater<Menu> updater = new Updater<Menu>(bean);
		if (bean.getParent() != null) {
			Menu p = dao.findById(bean.getParentId());

			String ids = "";
			if (p.getIds() != null) {
				ids = p.getIds() + ",";
			}
			ids = ids + bean.getId();
			bean.setIds(ids);
			Integer l = bean.getLevelinfo();
			int level=1;
			if(l!=null){
				level=l+1;
			}
			bean.setLevelinfo(level);
		}
		bean = dao.updateByUpdater(updater);

		return bean;
	}

	@Transactional
	public Menu deleteById(Integer id) {
		Menu bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public Menu[] deleteByIds(Integer[] ids) {
		Menu[] beans = new Menu[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private MenuDao dao;

	@Autowired
	public void setDao(MenuDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Menu> findChild(int id) {
		Finder finder = Finder.create("from Menu t where t.parent.id=" + id);
		finder.append(" order by t.sortnum asc");
		finder.setCacheable(true);
		return dao.find(finder);
	}
}