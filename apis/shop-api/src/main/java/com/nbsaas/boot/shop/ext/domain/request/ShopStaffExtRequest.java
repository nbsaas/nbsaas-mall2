package com.nbsaas.boot.shop.ext.domain.request;

import com.nbsaas.boot.shop.api.domain.request.ShopStaffRequest;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ShopStaffExtRequest extends ShopStaffRequest {


    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

    @NotEmpty(message = "密码不能为空")
    private String phone;


    private Long shopRole;

}
