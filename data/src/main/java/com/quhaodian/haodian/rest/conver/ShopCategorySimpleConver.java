package com.quhaodian.haodian.rest.conver;

import com.quhaodian.data.rest.core.Conver;
import com.quhaodian.haodian.data.entity.ShopCategory;
import com.quhaodian.haodian.domain.simple.CategorySimple;

public class ShopCategorySimpleConver implements Conver<CategorySimple,ShopCategory> {
  @Override
  public CategorySimple conver(ShopCategory source) {
    CategorySimple result = new CategorySimple();
    result.setId(source.getId());
    result.setName(source.getName());
    return result;
  }
}
