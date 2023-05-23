package com.nbsaas.life.system.api.domain.request;

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
public class ErrorLogSearchRequest   extends PageRequest implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


                //
               @Search(name = "serverName",operator = Operator.like)
                private String serverName;
                //
               @Search(name = "param",operator = Operator.like)
                private String param;
                //
               @Search(name = "url",operator = Operator.like)
                private String url;
                //
               @Search(name = "app",operator = Operator.like)
                private String app;
                //
               @Search(name = "id",operator = Operator.eq)
                private Long id;
                //
               @Search(name = "note",operator = Operator.like)
                private String note;
                //
               @Search(name = "name",operator = Operator.like)
                private String name;


}