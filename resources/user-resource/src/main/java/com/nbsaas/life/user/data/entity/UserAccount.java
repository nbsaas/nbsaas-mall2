package com.nbsaas.life.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.life.user.api.domain.enums.AccountType;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

/**
 * 用户账号
 * <p>
 * Created by ada on 2016/12/20.
 */

@Data
@Entity
@Table(name = "user_account", uniqueConstraints=
@UniqueConstraint(name = "accountType_username",columnNames={"accountType", "username"}))
@org.hibernate.annotations.Table(appliesTo = "user_account", comment = "用户账号表")
public class UserAccount extends LongEntity {

    /**
     * 用户名
     */
    @Comment("用户名")
    @Column(length = 50)
    private String username;
    /**
     * 账号类型
     */
    @Comment("账号类型")
    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;

    /**
     * 登陆次数
     */
    @Comment("登陆次数")
    private Integer loginSize;


    /**
     * 用户信息
     */
    @Comment("用户id")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;


}
