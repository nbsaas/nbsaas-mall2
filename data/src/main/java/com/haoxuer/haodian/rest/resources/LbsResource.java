package com.haoxuer.haodian.rest.resources;

import com.haoxuer.discover.area.data.dao.AreaDao;
import com.haoxuer.discover.area.data.entity.Area;
import com.haoxuer.haodian.api.LbsApi;
import com.haoxuer.haodian.domain.request.PoiSearchRequest;
import com.haoxuer.haodian.domain.response.PoiResponse;
import com.haoxuer.lbs.qq.v1.builder.ServicesBuilder;
import com.haoxuer.lbs.qq.v1.domain.response.Geo;
import com.haoxuer.lbs.qq.v1.service.GeoCoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class LbsResource implements LbsApi {
  
  @Autowired
  private AreaDao areaDao;
  
  @Override
  public PoiResponse search(PoiSearchRequest request) {
    PoiResponse result = new PoiResponse();
    GeoCoderService service = ServicesBuilder.newBuilder().key("H4DBZ-WLVCU-YLEVF-4MIDF-MGB5H-TOFDR").build().geoGeoCoderService();
   
    Geo geo = service.address(request.getAddress());
    if (geo != null && geo.getLocation() != null) {
      result.setLat(geo.getLocation().getLat());
      result.setLng(geo.getLocation().getLng());
    }
    if (geo != null) {
      result.setAddress(geo.getTitle());
      result.setProvince(geo.getProvince());
      result.setCity(geo.getCity());
      result.setCounty(geo.getDistrict());
    }
    if (StringUtils.hasText(result.getProvince())) {
      Area area = areaDao.name(result.getProvince());
      if (area != null) {
        result.setProvinceId(area.getId());
      }
    }
    if (StringUtils.hasText(result.getCity())) {
      Area area = areaDao.name(result.getCity());
      if (area != null) {
        result.setCityId(area.getId());
      }
    }
    if (StringUtils.hasText(result.getCounty())) {
      Area area = areaDao.name(result.getCounty(),result.getCity());
      if (area != null) {
        result.setCountyId(area.getId());
      }
    }
    return result;
  }
}
