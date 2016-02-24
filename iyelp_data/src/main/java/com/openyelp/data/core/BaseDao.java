package com.openyelp.data.core;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

public interface BaseDao<T, ID extends Serializable> {

	public abstract T add(T t);
	String transHqlToSql(String hql);

	public abstract T delete(T t);

	public abstract T update(T t);
	
	public abstract T merge(T t);

	
	public Pagination find(Finder finder, int pageNo, int pageSize);
	public Pagination findnsql(Finder finder, int pageNo, int pageSize,Class<?> otoclass);

	public List find(Finder finder);
	public Pagination findByCriteria(Criteria crit, int pageNo, int pageSize);
	public List find(String hql, Object... values) ;
	public List<T> findByProperty(String property, Object value) ;
	
	public int countQueryResult(Finder finder);
	public int countQuerySqlResult(Finder finder);
	
	public  <X> X hql(Finder finder);

}