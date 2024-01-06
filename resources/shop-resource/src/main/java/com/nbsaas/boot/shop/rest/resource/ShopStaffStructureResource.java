package com.nbsaas.boot.shop.rest.resource;

import com.nbsaas.boot.shop.api.apis.ShopStaffStructureApi;
import com.nbsaas.boot.shop.data.entity.ShopStaffStructure;
import com.nbsaas.boot.shop.api.domain.request.ShopStaffStructureRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffStructureResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopStaffStructureSimple;
import com.nbsaas.boot.shop.rest.convert.ShopStaffStructureSimpleConvert;
import com.nbsaas.boot.shop.rest.convert.ShopStaffStructureEntityConvert;
import com.nbsaas.boot.shop.rest.convert.ShopStaffStructureResponseConvert;
import com.nbsaas.boot.shop.data.repository.ShopStaffStructureRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.function.Function;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.shop.api.domain.request.ShopStaffStructureSearch;
/**
*   业务接口实现
*/
@Transactional
@Service
public class ShopStaffStructureResource extends BaseResource<ShopStaffStructure,ShopStaffStructureResponse, ShopStaffStructureSimple, ShopStaffStructureRequest>  implements ShopStaffStructureApi {

    @Resource
    private ShopStaffStructureRepository shopStaffStructureRepository;

    @Override
    public JpaRepositoryImplementation<ShopStaffStructure, Serializable> getJpaRepository() {
        return shopStaffStructureRepository;
    }

    @Override
    public Function<ShopStaffStructure, ShopStaffStructureSimple> getConvertSimple() {
        return new ShopStaffStructureSimpleConvert();
    }

    @Override
    public Function<ShopStaffStructureRequest, ShopStaffStructure> getConvertForm() {
        return new ShopStaffStructureEntityConvert();
    }

    @Override
    public Function<ShopStaffStructure, ShopStaffStructureResponse> getConvertResponse() {
        return new ShopStaffStructureResponseConvert();
    }



    @Override
    public ListResponse<ShopStaffStructureSimple> list(PageRequest request) {
        ShopStaffStructureSimpleConvert convert=new ShopStaffStructureSimpleConvert();
        if (request instanceof ShopStaffStructureSearch){
             ShopStaffStructureSearch searchRequest=(ShopStaffStructureSearch)request;
             convert.setFetch(searchRequest.getFetch());
        }
        return listSimple(request,convert);
    }

}


