package com.nbsaas.life.product.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.nbsaas.boot.rest.enums.StoreState;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BrandSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "storeState",operator = Operator.eq)
    private StoreState storeState;


            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}