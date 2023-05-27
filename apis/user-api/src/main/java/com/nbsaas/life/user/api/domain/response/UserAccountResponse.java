package com.nbsaas.life.user.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.life.user.api.domain.enums.AccountType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class UserAccountResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

        private String username;

        private AccountType accountType;

        private Long user;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private Long id;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

        private Integer loginSize;


}