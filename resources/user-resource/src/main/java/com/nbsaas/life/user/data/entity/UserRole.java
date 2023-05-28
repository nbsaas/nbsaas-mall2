package com.nbsaas.life.user.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@org.hibernate.annotations.Table(appliesTo = "user_role", comment = "用户角色表")
@Data
@Entity
@Table(name = "user_role")
public class UserRole extends AbstractEntity {

    @Comment("用户id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;

    @Comment("角色id")
    private Long roleId;
}
