package com.openyelp.data.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.AreaDao;
import com.openyelp.data.entity.Area;
import com.openyelp.data.entity.Menu;

@Repository
public class AreaDaoImpl extends BaseDaoImpl<Area, Integer> implements AreaDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Area findById(Integer id) {
		Area entity = get(id);
		return entity;
	}

	public Area save(Area bean) {
		
		if (bean.getParent() != null) {
			Area parent = findById(bean.getParentId());

			String ids = "";
			if (parent.getIds() != null&&parent.getIds().length()>0) {
				ids = parent.getIds() + ",";
			}
			ids = ids + parent.getId();
			bean.setIds(ids);
			Integer parentlevel = parent.getLevelinfo();
			int level=1;
			if(parentlevel!=null){
				level=parentlevel+1;
			}
			bean.setLevelinfo(level);
		}else{
			bean.setIds("");
			bean.setLevelinfo(1);
		}
		getSession().save(bean);
		
		
		
		
		
		return bean;
	}

	public Area deleteById(Integer id) {
		Area entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Area> getEntityClass() {
		return Area.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public Area findByName(String name) {
		Area  resultone=null;

		List<Area>  result=null;
		Finder finder=Finder.create();
		finder.append(" from Area a  where a.name=:name");
		finder.setParam("name", name);
		result=find(finder);
		if(result!=null&&result.size()>0){
			resultone=result.get(0);
		}	
		return resultone;
	}
}