package com.openyelp.data.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.ShopReviewVoteDao;
import com.openyelp.data.entity.ShopReview;
import com.openyelp.data.entity.ShopReviewVote;
import com.openyelp.data.service.ShopReviewService;
import com.openyelp.data.service.ShopReviewVoteService;

@Service
@Transactional
public class ShopReviewVoteServiceImpl implements ShopReviewVoteService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopReviewVote findById(Long id) {
		ShopReviewVote entity = dao.findById(id);
		return entity;
	}

	@Autowired
	ShopReviewService reviewService;

	@Transactional
	public ShopReviewVote save(ShopReviewVote bean) {

		Finder finder2 = Finder.create();
		finder2.append("from ShopReviewVote v where v.user.id=:userid");
		finder2.setParam("userid", bean.getUser().getId());
		finder2.append(" and v.catalog=:catalog");
		finder2.setParam("catalog", bean.getCatalog());
		int num = dao.countQueryResult(finder2);
		if (num == 0) {
			bean.setAddDate(new Date());
			bean.setLastDate(new Date());
			dao.save(bean);
			if (bean.getReview() != null) {
				ShopReview review = reviewService.findById(bean.getReview()
						.getId());

				Finder finder = Finder.create();
				finder.append("from ShopReviewVote v where v.review.id=:reviewid");
				finder.setParam("reviewid", bean.getReview().getId());
				finder.append(" and v.catalog=:catalog");
				finder.setParam("catalog", bean.getCatalog());
				int rs = dao.countQueryResult(finder);
				if (bean.getCatalog() == 1) {
					review.setVote1(rs);
				}
				if (bean.getCatalog() == 2) {
					review.setVote2(rs);
				}
				if (bean.getCatalog() == 3) {
					review.setVote3(rs);
				}
			}
		} else {
			bean.setId(-1l);
		}

		return bean;
	}

	@Transactional
	public ShopReviewVote update(ShopReviewVote bean) {
		Updater<ShopReviewVote> updater = new Updater<ShopReviewVote>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public ShopReviewVote deleteById(Long id) {
		ShopReviewVote bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public ShopReviewVote[] deleteByIds(Long[] ids) {
		ShopReviewVote[] beans = new ShopReviewVote[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopReviewVoteDao dao;

	@Autowired
	public void setDao(ShopReviewVoteDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public int vote(ShopReviewVote bean) {
		int result = -1;
		Finder finder2 = Finder.create();
		finder2.append("from ShopReviewVote v where v.user.id=:userid");
		finder2.setParam("userid", bean.getUser().getId());
		finder2.append(" and v.catalog=:catalog");
		finder2.setParam("catalog", bean.getCatalog());
		finder2.append(" and v.review.id=:reviewid");
		finder2.setParam("reviewid", bean.getReview().getId());
		int num = dao.countQueryResult(finder2);
		if (num == 0) {
			bean.setAddDate(new Date());
			bean.setLastDate(new Date());
			dao.save(bean);
		} else {
			List<ShopReviewVote> vs = dao.find(finder2);
			if(vs!=null&&vs.size()>0){
				for (ShopReviewVote shopReviewVote : vs) {
					dao.delete(shopReviewVote);
				}
			}
			result = -1;
		}
		if (bean.getReview() != null) {
			ShopReview review = reviewService.findById(bean.getReview()
					.getId());

			Finder finder = Finder.create();
			finder.append("from ShopReviewVote v where v.review.id=:reviewid");
			finder.setParam("reviewid", bean.getReview().getId());
			finder.append(" and v.catalog=:catalog");
			finder.setParam("catalog", bean.getCatalog());
			result = dao.countQueryResult(finder);
			if (bean.getCatalog() == 1) {
				review.setVote1(result);
			}
			if (bean.getCatalog() == 2) {
				review.setVote2(result);
			}
			if (bean.getCatalog() == 3) {
				review.setVote3(result);
			}
		}
		return result;

	}

	@Override
	public ShopReviewVote findByUser(Long uid, Long shopreviewid, int catalog) {
		Finder finder2 = Finder.create();
		finder2.append("from ShopReviewVote v where v.user.id=:userid");
		finder2.setParam("userid", uid);
		finder2.append(" and v.catalog=:catalog");
		finder2.setParam("catalog", catalog);
		finder2.append(" and v.review.id=:reviewid");
		finder2.setParam("reviewid", shopreviewid);
		List<ShopReviewVote> vs = dao.find(finder2);
		if (vs != null && vs.size() > 0) {
			return vs.get(0);
		}
		return null;
	}
}