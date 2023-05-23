package com.nbsaas.life.system.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApplicationMenuSearchRequest   extends PageRequest implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;

            //应用
            @Search(name = "app.id",operator = Operator.eq)
            private Long app;


                //
               @Search(name = "router",operator = Operator.like)
                private String router;
                //
               @Search(name = "rgt",operator = Operator.eq)
                private Integer rgt;
                //
               @Search(name = "sortNum",operator = Operator.eq)
                private Integer sortNum;
                //
               @Search(name = "creator",operator = Operator.eq)
                private Long creator;
                //
               @Search(name = "id",operator = Operator.eq)
                private Long id;
                //
               @Search(name = "depth",operator = Operator.eq)
                private Integer depth;
                //
               @Search(name = "code",operator = Operator.like)
                private String code;
                //
               @Search(name = "menuType",operator = Operator.eq)
                private Integer menuType;
                //
               @Search(name = "ids",operator = Operator.like)
                private String ids;
                //
               @Search(name = "path",operator = Operator.like)
                private String path;
                //
               @Search(name = "permission",operator = Operator.like)
                private String permission;
                //
               @Search(name = "catalog",operator = Operator.eq)
                private Integer catalog;
                //
               @Search(name = "icon",operator = Operator.like)
                private String icon;
                //
               @Search(name = "num",operator = Operator.eq)
                private Long num;
                //
               @Search(name = "lft",operator = Operator.eq)
                private Integer lft;
                //
               @Search(name = "name",operator = Operator.like)
                private String name;

        private int fetch;

        @Search(name = "levelInfo",operator = Operator.eq)
        private Integer level;

}