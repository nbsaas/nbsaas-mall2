package com.nbsaas.life.user.api.domain.simple;

import com.nbsaas.life.user.api.domain.enums.SecurityType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 列表对象
 */
@Data
public class UserPasswordSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private SecurityType securityType;

    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     * 加密盐
     **/
    private String salt;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 用户id
     **/
    private Long user;

    /**
     * 密码
     **/
    private String password;

    /**
     * 校验次数
     **/
    private Integer checkSize;

    /**
     * 添加时间
     **/
    private Date addDate;


}