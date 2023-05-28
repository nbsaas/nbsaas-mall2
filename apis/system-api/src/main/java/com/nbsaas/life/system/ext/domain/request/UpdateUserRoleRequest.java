package com.nbsaas.life.system.ext.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UpdateUserRoleRequest {

    @NotNull(message = "用户id不能为空")
    private Long userId;


    private List<Long> roles;
}
