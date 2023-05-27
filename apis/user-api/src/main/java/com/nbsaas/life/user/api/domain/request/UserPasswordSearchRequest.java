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
public class UserPasswordSearchRequest   extends PageRequest implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


                //
               @Search(name = "password",operator = Operator.like)
                private String password;
                //
               @Search(name = "salt",operator = Operator.like)
                private String salt;
                //
               @Search(name = "id",operator = Operator.eq)
                private Long id;
                //
               @Search(name = "checkSize",operator = Operator.eq)
                private Integer checkSize;


}