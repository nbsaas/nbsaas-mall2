package com.nbsaas.life.user.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserInfoSearchRequest   extends PageRequest implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


                //
               @Search(name = "avatar",operator = Operator.like)
                private String avatar;
                //
               @Search(name = "phone",operator = Operator.like)
                private String phone;
                //
               @Search(name = "catalog",operator = Operator.eq)
                private Integer catalog;
                //
               @Search(name = "id",operator = Operator.eq)
                private Long id;
                //
               @Search(name = "loginSize",operator = Operator.eq)
                private Integer loginSize;
                //
               @Search(name = "name",operator = Operator.like)
                private String name;


}