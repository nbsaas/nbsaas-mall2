package com.nbsaas.life.area.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class AreaDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 
        **/
            private Long parent;

        /**
        * 编码
        **/
            private String code;

        /**
        * 经度
        **/
            private Double lng;

        /**
        * 地区全称
        **/
            private String fullName;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 国标编码
        **/
            private String govCode;

        /**
        * 深度
        **/
            private Integer depth;

        /**
        * 地区类型
        **/
            private String areaType;

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
        * 状态
        **/
            private Integer state;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 左节点
        **/
            private Integer lft;

        /**
        * 纬度
        **/
            private Double lat;

        /**
        * 右节点
        **/
            private Integer rgt;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}