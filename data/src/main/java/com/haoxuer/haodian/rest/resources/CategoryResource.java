package com.haoxuer.haodian.rest.resources;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.haodian.data.dao.ShopCategoryDao;
import com.haoxuer.haodian.data.entity.ShopCategory;
import com.haoxuer.haodian.api.CategoryApi;
import com.haoxuer.haodian.domain.list.CategoryList;
import com.haoxuer.haodian.domain.request.CategoryFindByPidRequest;
import com.haoxuer.haodian.domain.simple.CategorySimple;
import com.haoxuer.haodian.rest.conver.ShopCategorySimpleConver;
import com.haoxuer.discover.user.utils.ConverResourceUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class CategoryResource implements CategoryApi {
  
  @Autowired
  private ShopCategoryDao categoryDao;
  
  @Override
  public CategoryList findByPid(CategoryFindByPidRequest request) {
    CategoryList result = new CategoryList();
    List<Filter> filters = new ArrayList<Filter>();
    filters.add(Filter.eq("parent.id", request.getId()));
    
    List<Order> orders = new ArrayList<Order>();
    orders.add(Order.desc("id"));
    List<ShopCategory> categories = categoryDao.findList(0, 200, filters, orders);
    List<CategorySimple> simples = ConverResourceUtils.coverCollect(categories, new ShopCategorySimpleConver());
    result.setList(simples);
    return result;
  }
}
