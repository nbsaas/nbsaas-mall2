package com.nbsaas.boot.common.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.common.api.domain.enums.CycleType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class TaskFolderItemResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private Integer limitNum;

        /**
        * 
        **/
            private CycleType cycleType;

        /**
        * 
        **/
            private Integer score;

        /**
        * 
        **/
            private String note;

        /**
        * 
        **/
            private String name;

        /**
        * 
        **/
            private Long taskFolder;

        /**
        * 
        **/
            private Integer sortNum;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private String key;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}