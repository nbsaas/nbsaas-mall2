package com.nbsaas.boot.product.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
    import java.util.List;

/**
* 列表对象
*/
@Data
public class ProductCatalogSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

    private String value;
    private String label;
    private List<ProductCatalogSimple> children;



            /**
            * 
            **/
                private Long parent;

            /**
            * 
            **/
                private String parentName;

            /**
            * 编码
            **/
                private String code;

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
            * 添加时间
            **/
                private Date addDate;

            /**
            * 右节点
            **/
                private Integer rgt;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}