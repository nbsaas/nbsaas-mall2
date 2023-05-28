package com.nbsaas.life.system.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;

@org.hibernate.annotations.Table(appliesTo = "sys_role", comment = "角色表 ")
@Data
@Entity
@Table(name = "sys_role")
public class Role extends AbstractEntity {


    /**
     * name 角色名称
     */
    @Comment("角色名称")
    private String name;


    /**
     * description 角色描述
     */
    @Comment("角色描述")
    private String remark;


}