package com.nbsaas.life.area.api.domain.request;

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
public class AreaSearchRequest   extends PageRequest implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


                //
               @Search(name = "rgt",operator = Operator.eq)
                private Integer rgt;
                //
               @Search(name = "ids",operator = Operator.like)
                private String ids;
                //
               @Search(name = "sortNum",operator = Operator.eq)
                private Integer sortNum;
                //
               @Search(name = "id",operator = Operator.eq)
                private Long id;
                //
               @Search(name = "lft",operator = Operator.eq)
                private Integer lft;
                //
               @Search(name = "name",operator = Operator.like)
                private String name;
                //
               @Search(name = "depth",operator = Operator.eq)
                private Integer depth;
                //
               @Search(name = "code",operator = Operator.like)
                private String code;


}