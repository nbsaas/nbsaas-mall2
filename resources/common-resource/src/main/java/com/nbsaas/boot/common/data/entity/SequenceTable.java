package com.nbsaas.boot.common.data.entity;

import com.nbsaas.boot.code.annotation.ComposeView;
import com.nbsaas.boot.code.annotation.CreateByUser;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.UUIDEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@org.hibernate.annotations.Table(appliesTo = "common_sequence_table", comment = "客户表")
@CreateByUser
@ComposeView
@Data
@FormAnnotation(title = "客户", model = "客户", menu = "1,60,61", searchWidth = "100", viewWidth = "120")
@Entity
@Table(name = "common_sequence_table")
public class SequenceTable extends UUIDEntity {

    private String name;

    private Integer step;

    private Long value;
}
