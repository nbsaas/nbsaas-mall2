package com.nbsaas.boot.shop.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
    import java.util.List;

/**
* 列表对象
*/
@Data
public class ShopStaffStructureSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

    private String value;
    private String label;
    private List<ShopStaffStructureSimple> children;



            /**
            * 商家部门父id
            **/
                private Long parent;

            /**
            * 商家id
            **/
                private Long shop;

            /**
            * 编码
            **/
                private String code;

            /**
            * 商家id
            **/
                private String shopName;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 商家部门父id
            **/
                private String parentName;

            /**
            * 深度
            **/
                private Integer depth;

            /**
            * 名称
            **/
                private String name;

            /**
            * ids
            **/
                private String ids;

            /**
            * 排序号
            **/
                private Integer sortNum;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 左节点
            **/
                private Integer lft;

            /**
            * 右节点
            **/
                private Integer rgt;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}