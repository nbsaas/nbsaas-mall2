package com.nbsaas.life.user.api.domain.response;

import com.nbsaas.life.user.api.domain.enums.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
/**
* 响应对象
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserAccountResponse implements Serializable {
        /**
         * 序列化参数
         */
        private static final long serialVersionUID = 1L;

        private Integer loginSize;

        private Long id;

        private Long user;

        private String username;

        private AccountType accountType;


}