package com.nbsaas.life.system.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: sys_application  实体类
 */
@Data
@Entity
@Table(name = "sys_app")
public class Application extends AbstractEntity {


    /**
     * name 应用名称
     */
    @Comment("应用名称")
    private String name;

    /**
     * app_key 应用key
     */
    @Comment("应用key")
    private String appKey;

    /**
     * note 应用介绍
     */
    @Comment("应用介绍")
    private String note;

}