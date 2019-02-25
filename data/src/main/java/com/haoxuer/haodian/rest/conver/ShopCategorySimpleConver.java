package com.haoxuer.haodian.rest.conver;

import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.haodian.data.entity.ShopCategory;
import com.haoxuer.haodian.domain.simple.CategorySimple;

public class ShopCategorySimpleConver implements Conver<CategorySimple, ShopCategory> {
  @Override
  public CategorySimple conver(ShopCategory source) {
    CategorySimple result = new CategorySimple();
    result.setId(source.getId());
    result.setName(source.getName());
    return result;
  }
}
