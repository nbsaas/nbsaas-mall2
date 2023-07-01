package com.nbsaas.boot.common.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.common.api.domain.enums.CycleType;
/**
* 请求对象
*/
@Data
public class TaskFolderItemDataRequest implements Serializable,RequestId {

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