package com.nbsaas.life.system.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.system.api.apis.DictApi;
import com.nbsaas.life.system.api.domain.field.DictField;
import com.nbsaas.life.system.api.domain.request.DictDataRequest;
import com.nbsaas.life.system.api.domain.response.DictResponse;
import com.nbsaas.life.system.ext.apis.DictExtApi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class DictExtResource implements DictExtApi {

    @Resource
    private DictApi dictApi;

    @Transactional
    @Override
    public ResponseObject<DictResponse> create(DictDataRequest request) {
        ResponseObject<DictResponse> result = new ResponseObject<>();
        Long num = dictApi.countData(Filter.eq(DictField.dictKey, request.getDictKey()));
        if (num == null) {
            num = 0L;
        }
        if (num > 0) {
            result.setCode(501);
            result.setMsg("该字段key已经使用过了");
            return result;
        }
        return dictApi.create(request);
    }
}
