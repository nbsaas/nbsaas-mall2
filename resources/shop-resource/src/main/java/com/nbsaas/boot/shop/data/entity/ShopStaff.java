package com.nbsaas.boot.shop.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.jpa.data.entity.User;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;



@BeanExt(
        items = {
                @FormExtField(fieldName = "avatar", parentField = "avatar", parent = "user", fieldClass = String.class),
                @FormExtField(fieldName = "name", parentField = "name", parent = "user", fieldClass = String.class),
                @FormExtField(fieldName = "phone", parentField = "phone", parent = "user", fieldClass = String.class)

        }
)
@SearchBean(items = {
        @SearchItem(label = "名称", name = "name", key = "user.name"),
        @SearchItem(label = "手机号", name = "phone", key = "user.phone"),
})
@Data
@FormAnnotation(title = "管理员")
@Entity
@Table(name = "bs_shop_staff")
public class ShopStaff extends LongEntity {

    @JoinColumn(name = "user_id")
    @Comment("用户账号id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @FormField(title = "商家名称", grid = true, col = 22, width = "260", ignore = true)
    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @Comment("用户登录次数")
    private Integer loginSize = 0;


    @FormField(title = "添加时间", grid = true, width = "11111", ignore = true)
    @Comment("添加时间")
    private Date addDate;

    @Comment("最新修改时间")
    private Date lastDate;
}
