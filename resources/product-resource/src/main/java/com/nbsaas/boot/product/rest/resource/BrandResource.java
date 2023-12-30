package com.nbsaas.boot.product.rest.resource;

import com.nbsaas.boot.product.api.apis.BrandApi;
import com.nbsaas.boot.product.data.entity.Brand;
import com.nbsaas.boot.product.api.domain.request.BrandRequest;
import com.nbsaas.boot.product.api.domain.response.BrandResponse;
import com.nbsaas.boot.product.api.domain.simple.BrandSimple;
import com.nbsaas.boot.product.rest.convert.BrandSimpleConvert;
import com.nbsaas.boot.product.rest.convert.BrandEntityConvert;
import com.nbsaas.boot.product.rest.convert.BrandResponseConvert;
import com.nbsaas.boot.product.data.repository.BrandRepository;

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
public class BrandResource extends BaseResource<Brand,BrandResponse, BrandSimple, BrandRequest>  implements BrandApi {

    @Resource
    private BrandRepository brandRepository;

    @Override
    public JpaRepositoryImplementation<Brand, Serializable> getJpaRepository() {
        return brandRepository;
    }

    @Override
    public Function<Brand, BrandSimple> getConvertSimple() {
        return new BrandSimpleConvert();
    }

    @Override
    public Function<BrandRequest, Brand> getConvertForm() {
        return new BrandEntityConvert();
    }

    @Override
    public Function<Brand, BrandResponse> getConvertResponse() {
        return new BrandResponseConvert();
    }




    @Override
    public ResponseObject<BrandResponse> create(BrandRequest request) {
        request.setStoreState(StoreState.normal);
        return super.create(request);
   }

    @Override
    public ResponseObject<?> delete(RequestId request) {

        ResponseObject<?> result = new ResponseObject<>();
        Optional<Brand> optional = getJpaRepository().findById(request.getId());
        if (!optional.isPresent()) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Brand bean = optional.get();
        bean.setStoreState(StoreState.draft);
        return result;

    }
}


