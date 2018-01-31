package com.quhaodian.haodian.data.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.quhaodian.haodian.data.dao.ContentDao;
import com.quhaodian.haodian.data.dao.ContentTagDao;
import com.quhaodian.haodian.data.entity.ContentTag;
import com.quhaodian.haodian.data.service.ContentService;
import com.quhaodian.haodian.data.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;

@Service
@Transactional
public class ContentServiceImpl implements ContentService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Content findById(Integer id) {
		Content entity = dao.findById(id);
		return entity;
	}

	@Autowired
	private ContentTagDao contentTagDao;

	@Transactional
	public Content save(Content bean) {
		Set<ContentTag> tagss =new HashSet<ContentTag>();
		Set<ContentTag> tags = bean.getTags();
		if (tags != null) {
			for (ContentTag contentTag : tags) {
				if (contentTag.getId() == null) {
					List<ContentTag> ts = contentTagDao.findByProperty("name",
							contentTag.getName());
					if (ts != null && ts.size() > 0) {
						contentTag = ts.get(0);
					} else {
						contentTagDao.save(contentTag);
					}
				}
				if(contentTag.getName()!=null){
					tagss.add(contentTag);
				}
			}
		}
		bean.setTags(tagss);
		dao.save(bean);
		return bean;
	}

	@Transactional
	public Content update(Content bean) {
		Updater<Content> updater = new Updater<Content>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public Content deleteById(Integer id) {
		Content bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public Content[] deleteByIds(Integer[] ids) {
		Content[] beans = new Content[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ContentDao dao;

	@Autowired
	public void setDao(ContentDao dao) {
		this.dao = dao;
	}
}