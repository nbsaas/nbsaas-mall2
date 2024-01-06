package com.nbsaas.boot.store.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.shop.data.entity.Staff;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@org.hibernate.annotations.Table(appliesTo = "bs_store_staff", comment = "商家员工")
@Data
@FormAnnotation(title = "商家员工")
@Entity
@Table(name = "bs_store_staff")
public class StoreStaff extends AbstractEntity {

    @Comment("商家id")
    @JoinColumn()
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @Comment("员工id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Staff staff;

}
