package com.nbsaas.life.ad.api.domain.request;

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
public class AdPositionSearchRequest   extends PageRequest implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


                //
               @Search(name = "height",operator = Operator.eq)
                private Integer height;
                //
               @Search(name = "width",operator = Operator.eq)
                private Integer width;
                //
               @Search(name = "sortNum",operator = Operator.eq)
                private Integer sortNum;
                //
               @Search(name = "id",operator = Operator.eq)
                private Long id;
                //
               @Search(name = "key",operator = Operator.like)
                private String key;
                //
               @Search(name = "note",operator = Operator.like)
                private String note;
                //
               @Search(name = "name",operator = Operator.like)
                private String name;
                //
               @Search(name = "template",operator = Operator.like)
                private String template;


}