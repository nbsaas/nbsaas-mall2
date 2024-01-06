package com.nbsaas.boot.shop.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.shop.api.apis.ShopSearchWordApi;
import com.nbsaas.boot.shop.api.domain.field.ShopSearchWordField;
import com.nbsaas.boot.shop.api.domain.request.ShopSearchWordRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopSearchWordResponse;
import com.nbsaas.boot.shop.ext.apis.ShopSearchWordExtApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class ShopSearchWordExtResource implements ShopSearchWordExtApi {

    @Resource
    private ShopSearchWordApi shopSearchWordApi;


    @Override
    public ResponseObject<ShopSearchWordResponse> create(ShopSearchWordRequest request) {

        if (request.getSearchType() == null) {
            request.setSearchType(1);
        }
        ShopSearchWordResponse search = shopSearchWordApi.oneData(
                Filter.eq(ShopSearchWordField.word, request.getWord()),
                Filter.eq(ShopSearchWordField.searchType, request.getSearchType())
        );
        if (search == null) {
            return shopSearchWordApi.create(request);
        }
        request.setId(search.getId());
        request.setLastDate(new Date());

        return shopSearchWordApi.update(request);
    }
}
