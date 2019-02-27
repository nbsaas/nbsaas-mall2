package com.haoxuer.haodian.domain.response;

import com.haoxuer.discover.rest.base.ResponseObject;

public class PoiResponse extends ResponseObject {
  
  private String address;
  
  private String city;
  
  private String province;
  
  private String county;
  
  private Integer cityId;
  
  private Integer provinceId;
  
  private Integer countyId;
  
  private Float lng;
  private Float lat;
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getCity() {
    return city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getProvince() {
    return province;
  }
  
  public void setProvince(String province) {
    this.province = province;
  }
  
  public String getCounty() {
    return county;
  }
  
  public void setCounty(String county) {
    this.county = county;
  }
  
  public Integer getCityId() {
    return cityId;
  }
  
  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }
  
  public Integer getProvinceId() {
    return provinceId;
  }
  
  public void setProvinceId(Integer provinceId) {
    this.provinceId = provinceId;
  }
  
  public Integer getCountyId() {
    return countyId;
  }
  
  public void setCountyId(Integer countyId) {
    this.countyId = countyId;
  }
  
  public Float getLng() {
    return lng;
  }
  
  public void setLng(Float lng) {
    this.lng = lng;
  }
  
  public Float getLat() {
    return lat;
  }
  
  public void setLat(Float lat) {
    this.lat = lat;
  }
}
