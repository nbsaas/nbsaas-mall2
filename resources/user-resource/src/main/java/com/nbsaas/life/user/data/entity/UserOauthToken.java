package com.nbsaas.life.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户oauth登陆信息
 *
 * @author 73552
 */

@Data
@Entity
@Table(name = "user_oauth_token")
public class UserOauthToken extends AbstractEntity {

    /**
     * 访问token
     */
    @Comment("访问token")
    private String access_token;
    /**
     * 刷新token
     */
    @Comment("刷新token")
    private String refresh_token;

    /**
     * token类型
     */
    @Comment("token类型")
    private String tokenType;

    /**
     * 用户id
     */
    @Comment("用户openId")
    private String openId;


    /**
     * 过期时间
     */
    @Comment("过期时间")
    private Long expiresTime;

    /**
     * 和用户绑定
     */
    @Comment("用户id")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;


    @Comment("登录次数")
    private Integer loginSize;


}
