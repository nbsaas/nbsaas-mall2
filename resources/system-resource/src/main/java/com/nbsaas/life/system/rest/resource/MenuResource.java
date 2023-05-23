package com.nbsaas.life.system.rest.resource;

import com.nbsaas.life.system.api.apis.MenuApi;
import com.nbsaas.life.system.data.entity.Menu;
import com.nbsaas.life.system.api.domain.request.MenuDataRequest;
import com.nbsaas.life.system.api.domain.response.MenuResponse;
import com.nbsaas.life.system.api.domain.simple.MenuSimple;
import com.nbsaas.life.system.rest.convert.MenuSimpleConvert;
import com.nbsaas.life.system.rest.convert.MenuEntityConvert;
import com.nbsaas.life.system.rest.convert.MenuResponseConvert;
import com.nbsaas.life.system.data.repository.MenuRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class MenuResource extends BaseResource<Menu,MenuResponse, MenuSimple, MenuDataRequest>  implements MenuApi {

    @Resource
    private MenuRepository menuRepository;

    @Override
    public JpaRepositoryImplementation<Menu, Serializable> getJpaRepository() {
        return menuRepository;
    }

    @Override
    public Function<Menu, MenuSimple> getConvertSimple() {
        return new MenuSimpleConvert();
    }

    @Override
    public Function<MenuDataRequest, Menu> getConvertForm() {
        return new MenuEntityConvert();
    }

    @Override
    public Function<Menu, MenuResponse> getConvertResponse() {
        return new MenuResponseConvert();
    }

}


