package com.nbsaas.boot.shop.rest.resource;

import com.nbsaas.boot.shop.api.apis.ShopApi;
import com.nbsaas.boot.shop.data.entity.Shop;
import com.nbsaas.boot.shop.api.domain.request.ShopRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopSimple;
import com.nbsaas.boot.shop.rest.convert.ShopSimpleConvert;
import com.nbsaas.boot.shop.rest.convert.ShopEntityConvert;
import com.nbsaas.boot.shop.rest.convert.ShopResponseConvert;
import com.nbsaas.boot.shop.data.repository.ShopRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.function.Function;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.request.RequestId;
import java.util.Optional;
import com.nbsaas.boot.rest.response.ResponseObject;
/**
*   业务接口实现
*/
@Transactional
@Service
public class ShopResource extends BaseResource<Shop,ShopResponse, ShopSimple, ShopRequest>  implements ShopApi {

    @Resource
    private ShopRepository shopRepository;

    @Override
    public JpaRepositoryImplementation<Shop, Serializable> getJpaRepository() {
        return shopRepository;
    }

    @Override
    public Function<Shop, ShopSimple> getConvertSimple() {
        return new ShopSimpleConvert();
    }

    @Override
    public Function<ShopRequest, Shop> getConvertForm() {
        return new ShopEntityConvert();
    }

    @Override
    public Function<Shop, ShopResponse> getConvertResponse() {
    return new ShopResponseConvert();
    }




    @Override
    public ResponseObject<ShopResponse> create(ShopRequest request) {
        request.setStoreState(StoreState.normal);
        return super.create(request);
   }

    @Override
    public ResponseObject<?> delete(RequestId request) {

        ResponseObject<?> result = new ResponseObject<>();
        Optional<Shop> optional = getJpaRepository().findById(request.getId());
        if (!optional.isPresent()) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Shop bean = optional.get();
        bean.setStoreState(StoreState.draft);
        return result;

    }
}


