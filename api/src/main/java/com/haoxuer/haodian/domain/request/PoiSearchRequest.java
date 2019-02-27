package com.haoxuer.haodian.domain.request;

public class PoiSearchRequest extends AppRequest {
  
  
  private String address;
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
}
