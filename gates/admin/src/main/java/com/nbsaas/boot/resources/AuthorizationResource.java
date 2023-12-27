package com.nbsaas.boot.resources;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.security.api.AuthorizationApi;
import com.nbsaas.boot.system.api.apis.RoleApi;
import com.nbsaas.boot.system.api.domain.response.RoleResponse;
import com.nbsaas.boot.system.ext.apis.MenuExtApi;
import com.nbsaas.boot.user.api.apis.UserRoleApi;
import com.nbsaas.boot.user.api.domain.simple.UserRoleSimple;
import com.nbsaas.boot.utils.UserUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationResource implements AuthorizationApi {

    @Resource
    private UserRoleApi userRoleApi;

    @Resource
    private MenuExtApi menuExtApi;

    @Resource
    private RoleApi roleApi;

    @Override
    public List<String> loadRoles() {
        List<String> result = new ArrayList<>();


        List<UserRoleSimple> us = userRoleApi.listData(Filter.eq("userInfo.id", UserUtils.user().getId()));
        if (us != null) {
            for (UserRoleSimple u : us) {
                RoleResponse role = roleApi.oneData(Filter.eq("id", u.getRoleId()));
                if (role != null) {
                    result.add(role.getName());
                }
            }
        }

        return result;
    }

    @Override
    public List<String> loadPermissions() {
        List<String> result = new ArrayList<>();

        List<UserRoleSimple> us = userRoleApi.listData(Filter.eq("userInfo.id", UserUtils.user().getId()));
        if (us != null) {
            for (UserRoleSimple u : us) {
                List<String> permissions = menuExtApi.permissions(u.getRoleId());
                if (permissions != null) {
                    result.addAll(permissions);
                }
            }
        }

        return result;
    }
}
