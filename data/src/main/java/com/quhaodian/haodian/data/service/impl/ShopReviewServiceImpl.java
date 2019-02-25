package com.quhaodian.haodian.data.service.impl;

import java.util.Date;

import com.quhaodian.haodian.data.dao.ShopDao;
import com.quhaodian.haodian.data.dao.ShopReviewDao;
import com.quhaodian.haodian.data.entity.Shop;
import com.quhaodian.haodian.data.entity.ShopCategory;
import com.quhaodian.haodian.data.entity.ShopReview;
import com.quhaodian.haodian.data.dao.ShopCategoryDao;
import com.quhaodian.haodian.data.service.UserService;
import com.quhaodian.haodian.data.dao.FeedDao;
import com.quhaodian.haodian.data.service.ShopReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.area.data.dao.AreaDao;
import com.haoxuer.discover.area.data.entity.Area;
import com.haoxuer.discover.data.core.Finder;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.user.data.entity.UserInfo;

@Service
@Transactional
public class ShopReviewServiceImpl implements ShopReviewService {
    @Transactional(readOnly = true)
    public Pagination getPage(int pageNo, int pageSize) {
        Pagination page = dao.getPage(pageNo, pageSize);
        return page;
    }

    @Transactional(readOnly = true)
    public ShopReview findById(Long id) {
        ShopReview entity = dao.findById(id);
        return entity;
    }

    @Autowired
    ShopDao shopDao;

    @Autowired
    UserService userService;

    @Autowired
    FeedDao feedDao;

    @Transactional
    public ShopReview save(ShopReview bean) {
        if (bean.getShop() == null || bean.getUser() == null|| bean.getServicescore() == null) {

        } else {
            dao.save(bean);
            feedDao.addFeed(bean);
            updatecomments(bean);


        }
        return bean;
    }

    private void updatecomments(ShopReview bean) {
        Shop shop = shopDao.findById(bean.getShop().getId());
        Finder finder = Finder
                .create("from ShopReview s where s.shop.id =:shopid");
        finder.setParam("shopid", shop.getId());
        int comments = dao.countQueryResult(finder);
        shop.setComment_num(comments);

        UserInfo user = userService.findById(bean.getUser().getId());
        Finder finderuser = Finder
                .create("from ShopReview s where s.user.id =:userid");
        finderuser.setParam("userid", user.getId());
        int usercomment = dao.countQueryResult(finderuser);
        //user.setComments(usercomment);
        // userService

        bean.setAddDate(new Date());
        bean.setLastDate(new Date());

        Finder findersum = Finder
                .create("select sum(s.servicescore) from ShopReview s where s.shop.id =" + shop.getId());
        Long sumscore = dao.<Long>hql(findersum);
        try {
        	if (comments==0) {
				return;
			}
            float score= (float) (sumscore/(comments*1.0));
            shop.setService_rating(score);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

    @Transactional
    public ShopReview update(ShopReview bean) {
        Updater<ShopReview> updater = new Updater<ShopReview>(bean);
        bean = dao.updateByUpdater(updater);
        return bean;
    }

    @Transactional
    public ShopReview deleteById(Long id) {

        ShopReview bean = dao.findById(id);
        bean = dao.deleteById(id);
        updatecomments(bean);
        return bean;
    }

    @Transactional
    public ShopReview[] deleteByIds(Long[] ids) {
        ShopReview[] beans = new ShopReview[ids.length];
        for (int i = 0, len = ids.length; i < len; i++) {
            beans[i] = deleteById(ids[i]);
        }
        return beans;
    }

    private ShopReviewDao dao;

    @Autowired
    public void setDao(ShopReviewDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    @Override
    public Pagination pageByShop(Long id, int pageNo, int pageSize) {
        Finder finder = Finder.create();
        finder.append("from ShopReview s where s.shop.id=:shopid order by id desc ");
        finder.setParam("shopid", id);
        return dao.find(finder, pageNo, pageSize);
    }

    @Transactional(readOnly = true)
    @Override
    public Pagination pageByUser(Long uid, int pageNo, int pageSize) {
        Finder finder = Finder.create();
        finder.append("from ShopReview s where s.user.id=:userid ");
        finder.setParam("userid", uid);
        finder.append(" order by s.id desc");
        return dao.find(finder, pageNo, pageSize);
    }

    @Autowired
    ShopCategoryDao categoryDao;

    @Autowired
    AreaDao areaDao;

    @Transactional(readOnly = true)
    @Override
    public Pagination page(int areaid, int catalog, int pageNo, int pageSize) {
        ShopCategory category = categoryDao.findById(catalog);

        Area area = areaDao.findById(areaid);

        if (category != null && area != null) {
            Finder finder = Finder.create();
            finder.append("select distinct  s from ShopReview s ");

            finder.append(" join s.shop.categorys  as c  where c.lft >=:lft and c.rgt <=:rgt");
            finder.setParam("lft", category.getLft());
            finder.setParam("rgt", category.getRgt());
            finder.append(" and s.shop.area.lft   >=:arealft");
            finder.append(" and s.shop.area.rgt   <=:areargt");
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

    @Transactional(readOnly = true)
    @Override
    public Pagination page(int pageNo, int pageSize) {
        Finder finder = Finder.create();
        finder.append("from  ShopReview s order by s.id desc ");
        return dao.find(finder, pageNo, pageSize);
    }
}