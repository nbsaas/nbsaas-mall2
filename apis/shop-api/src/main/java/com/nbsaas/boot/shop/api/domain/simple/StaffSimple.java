package com.nbsaas.boot.shop.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class StaffSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;




            /**
            * 内容
            **/
                private String note;

            /**
            * 联系电话
            **/
                private String phone;

            /**
            * 客户名称
            **/
                private String name;

            /**
            * 头像
            **/
                private String avatar;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}