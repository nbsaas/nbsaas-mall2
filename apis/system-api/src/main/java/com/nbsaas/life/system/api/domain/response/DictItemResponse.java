package com.nbsaas.life.system.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class DictItemResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String dictTitle;

        /**
        * 键值
        **/
            private String dataValue;

        /**
        * 
        **/
            private Long dict;

        /**
        * 排序字段
        **/
            private Integer sortNum;

        /**
        * 
        **/
            //枚举
            private StoreState storeState;

            private String storeStateName;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 编码
        **/
            private String dataCode;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}