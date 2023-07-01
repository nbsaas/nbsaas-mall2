package com.nbsaas.boot.ad.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class GroupMemberSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 
            **/
                private Long groupRoom;

            /**
            * 
            **/
                private String groupRoomName;

            /**
            * 
            **/
                private Long member;

            /**
            * 
            **/
                private String memberName;

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