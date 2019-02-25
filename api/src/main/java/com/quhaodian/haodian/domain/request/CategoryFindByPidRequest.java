package com.quhaodian.haodian.domain.request;

import com.haoxuer.discover.rest.base.RequestUserTokenObject;

public class CategoryFindByPidRequest extends RequestUserTokenObject {
  
  private Integer id;
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
}
