package com.nbsaas.life.system.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@org.hibernate.annotations.Table(appliesTo = "sys_role_menu", comment = "角色功能表")
@Data
@Entity
@Table(name = "sys_role_menu")
public class RoleMenu extends AbstractEntity {


    @FieldConvert
    @Comment("角色id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;


    @FieldConvert
    @Comment("菜单id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;


}