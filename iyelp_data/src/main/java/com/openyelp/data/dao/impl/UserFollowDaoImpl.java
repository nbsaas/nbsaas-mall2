package com.openyelp.data.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.UserFollowDao;
import com.openyelp.data.entity.UserFollow;

@Repository
public class UserFollowDaoImpl extends BaseDaoImpl<UserFollow, Long> implements
		UserFollowDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserFollow findById(Long id) {
		UserFollow entity = get(id);
		return entity;
	}

	public UserFollow save(UserFollow bean) {
		getSession().save(bean);
		return bean;
	}

	public UserFollow deleteById(Long id) {
		UserFollow entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<UserFollow> getEntityClass() {
		return UserFollow.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public UserFollow findById(Long id, Long friendid) {
		Finder finder = Finder.create();
		finder.append("from UserFollow u where u.user.id =:uid");
		finder.setParam("uid", id);
		finder.append("  and u.friend.id =:fid");
		finder.setParam("fid", friendid);
		List<UserFollow> fs = find(finder);
		if(fs!=null&&fs.size()>0){
			return fs.get(0);
		}
		return null;
	}
}