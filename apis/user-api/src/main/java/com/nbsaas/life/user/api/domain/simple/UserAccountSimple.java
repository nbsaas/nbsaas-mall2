package com.nbsaas.life.user.api.domain.simple;

import com.nbsaas.life.user.api.domain.enums.AccountType;
import lombok.Data;

import java.io.Serializable;

/**
* 列表对象
 */
@Data
public class UserAccountSimple implements Serializable {

        /**
         * 序列化参数
         */
        private static final long serialVersionUID = 1L;


        /**
         * 登陆次数
         **/
        private Integer loginSize;

        /**
         * 主键id
         **/
        private Long id;

        /**
         * 用户id
         **/
        private Long user;

        /**
         * 用户名
         **/
        private String username;

        /**
         *
         **/
        private AccountType accountType;


}