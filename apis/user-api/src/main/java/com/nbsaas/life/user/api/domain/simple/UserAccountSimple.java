package com.nbsaas.life.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.life.user.api.domain.enums.AccountType;

/**
* 列表对象
*/
@Data
public class UserAccountSimple implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


            private String username;
            private AccountType accountType;
            private Long user;
            private Long id;
            private Integer loginSize;


}