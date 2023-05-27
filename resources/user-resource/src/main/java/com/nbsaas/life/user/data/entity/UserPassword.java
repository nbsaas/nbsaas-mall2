package com.nbsaas.life.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.life.user.api.domain.enums.SecurityType;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

/**
 * 用户密码集合
 */


@Data
@Entity
@Table(name = "user_password")
public class UserPassword extends AbstractEntity {

    @Comment("用户id")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    /**
     * 校验次数
     */
    @Comment("校验次数")
    private Integer checkSize;

    /**
     * 密码
     */
    @Comment("密码")
    @Column(length = 50)
    private String password;

    /**
     * 盐
     */
    @Comment("加密盐")
    @Column(length = 50)
    private String salt;

    @Comment("密码类型")
    private SecurityType securityType;

}
