package com.nbsaas.life.system.ext.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UpdateRoleMenuRequest {

    @NotNull(message = "角色id不能为空")
    private Long roleId;


    private List<Long> menus;
}
