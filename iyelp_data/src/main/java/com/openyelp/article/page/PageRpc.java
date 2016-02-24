package com.openyelp.article.page;

import java.io.Serializable;
import java.util.List;

import com.openyelp.data.core.Pagination;

public class PageRpc<T> implements Serializable {

	private List<T> list;
	private int pageNo;
	private int pageSize;
	private int pageTotal;
	private Pagination pagination;

	private int total;

	//public PageRpc(){}
	public PageRpc(Pagination page){
		
		pageNo=page.getPageNo();
		pageTotal=page.getTotalPage();
		pageSize=page.getPageSize();
		total=page.getTotalCount();
		list=(List<T>) page.getList();
		pagination=page;
	}
	public List<T> getList() {
		return list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}
	public Pagination getPagination() {
		return pagination;
	}

	public int getTotal() {
		return total;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageRpc [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", pageTotal=" + pageTotal + ", total=" + total + ", list="
				+ list + "]";
	}
	
}
