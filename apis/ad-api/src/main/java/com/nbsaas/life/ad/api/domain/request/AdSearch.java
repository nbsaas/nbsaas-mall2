package com.nbsaas.life.ad.api.domain.request;

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
public class AdSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "title",operator = Operator.like)
    private String title;


            /**
            * 内容
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 分类
            **/
            @Search(name = "catalog",operator = Operator.eq)
            private Integer catalog;

            /**
            * 链接地址
            **/
            @Search(name = "url",operator = Operator.like)
            private String url;

            /**
            * 业务id
            **/
            @Search(name = "bussId",operator = Operator.eq)
            private Long bussId;

            /**
            * 广告图片
            **/
            @Search(name = "path",operator = Operator.like)
            private String path;

            /**
            * 排序号
            **/
            @Search(name = "sortNum",operator = Operator.eq)
            private Integer sortNum;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}