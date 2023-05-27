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
public class UserLoginLogSearchRequest   extends PageRequest implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;

            //用户
            @Search(name = "user.id",operator = Operator.eq)
            private Long userId;

            //用户姓名
            @Search(name = "user.name",operator = Operator.like)
            private String userName;


                //
               @Search(name = "password",operator = Operator.like)
                private String password;
                //
               @Search(name = "ip",operator = Operator.like)
                private String ip;
                //
               @Search(name = "id",operator = Operator.eq)
                private Long id;
                //
               @Search(name = "client",operator = Operator.like)
                private String client;
                //
               @Search(name = "note",operator = Operator.like)
                private String note;
                //
               @Search(name = "account",operator = Operator.like)
                private String account;


}