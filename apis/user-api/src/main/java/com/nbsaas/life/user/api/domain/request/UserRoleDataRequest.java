package com.nbsaas.life.user.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
* 请求对象
 */
@Data
public class UserRoleDataRequest implements Serializable, RequestId {

        /**
         * 序列化参数
         */
        private static final long serialVersionUID = 1L;


        /**
         * 最新修改时间
         **/
        private Date lastDate;

        /**
         * 角色id
         **/
        private Long roleId;

        /**
         * 主键id
         **/
        private Long id;

        /**
         * 添加时间
         **/
        private Date addDate;
}