package com.nbsaas.life.user.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.life.user.api.domain.enums.LoginState;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

/**
 * 用户登录记录
 *
 * @author ada
 */

@FormAnnotation(title = "登录日志管理", model = "登录日志", menu = "1,20,23")
@SearchBean(items = {
        @SearchItem(label = "用户姓名", name = "userName", key = "user.name")
})
@Data
@Entity
@Table(name = "user_login_log")
public class UserLoginLog extends AbstractEntity {


    @Comment("用户id")
    @FormField(title = "用户姓名", sortNum = "1", grid = true)
    @SearchItem(label = "用户", name = "userId", key = "user.id", operator = Operator.eq, classType = Long.class, show = false)
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY )
    private UserInfo user;

    private StoreState storeState;

    /**
     * 登陆账号
     */
    @Comment("登陆账号")
    @FormField(title = "登陆账号", sortNum = "1", grid = true)
    private String account;

    @Comment("登录IP")
    @FormField(title = "登录IP", sortNum = "1", grid = true)
    @Column(length = 30)
    private String ip;

    /**
     * 登陆客户端
     */
    @Comment("客户端")
    @FormField(title = "客户端", sortNum = "1", grid = true)
    private String client;

    /**
     * 登录状态，0为失败1为成功
     */
    @Comment("登录状态，0为失败1为成功")
    @FormField(title = "状态", sortNum = "1", grid = true)
    private LoginState state;

    @Comment("登录密码")
    @Column(length = 30)
    private String password;

    @Comment("备注")
    private String note;

}
