package com.haoxuer.haodian.actions.rest;

import com.haoxuer.haodian.api.LbsApi;
import com.haoxuer.haodian.domain.request.PoiSearchRequest;
import com.haoxuer.haodian.domain.response.PoiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class LbsRestController {
  
  @RequestMapping("/lbs/search")
  public PoiResponse search(PoiSearchRequest request) {
    return api.search(request);
  }
  
  @Autowired
  private LbsApi api;
}
