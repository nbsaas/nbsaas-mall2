package com.quhaodian.haodian.api;

import com.quhaodian.haodian.domain.list.CategoryList;
import com.quhaodian.haodian.domain.request.CategoryFindByPidRequest;
import com.quhaodian.jsonrpc.annotation.RestFul;

/**
 * 分类接口
 */
@RestFul(value = "categoryApi", api = CategoryApi.class)
public interface CategoryApi {
  
  /**
   * 根据分类父id查找下一层分类
   *
   * @param request
   * @return
   */
  CategoryList findByPid(CategoryFindByPidRequest request);
}
