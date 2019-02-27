package com.haoxuer.haodian.api;


import com.haoxuer.haodian.domain.request.PoiSearchRequest;
import com.haoxuer.haodian.domain.response.PoiResponse;

public interface LbsApi {
  
  PoiResponse search(PoiSearchRequest request);
  
}
