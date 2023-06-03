package com.nbsaas.life.system.data.entity;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;

@org.hibernate.annotations.Table(appliesTo = "sys_dict", comment = "字典表")
@Data
@Entity
@Table(name = "sys_dict")
public class Dict extends AbstractEntity {


    @Comment("字典名称")
    private String title;

    @Comment("字典key")
    private String dictKey;

}
