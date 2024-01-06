package com.nbsaas.boot.shop.ext.resource;

import com.nbsaas.boot.app.api.apis.AppUserRoleApi;
import com.nbsaas.boot.app.api.domain.request.AppUserRoleRequest;
import com.nbsaas.boot.app.data.entity.AppUserRole;
import com.nbsaas.boot.app.ext.apis.AppUserRoleExtApi;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.shop.api.apis.ShopStaffApi;
import com.nbsaas.boot.shop.api.apis.ShopStaffRoleApi;
import com.nbsaas.boot.shop.api.domain.field.ShopStaffField;
import com.nbsaas.boot.shop.api.domain.request.ShopStaffRoleRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopStaffSimple;
import com.nbsaas.boot.shop.ext.apis.ShopStaffExtApi;
import com.nbsaas.boot.shop.ext.domain.request.ShopStaffExtRequest;
import com.nbsaas.boot.user.api.domain.enums.AccountType;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.user.ext.apis.UserExtApi;
import com.nbsaas.boot.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.boot.user.ext.domain.request.UserResetPasswordRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopStaffExtResource implements ShopStaffExtApi {

    @Resource
    private ShopStaffApi shopStaffApi;

    @Resource
    private AppUserRoleExtApi appUserRoleExtApi;

    @Resource
    private AppUserRoleApi appUserRoleApi;

    @Resource
    private UserExtApi userExtApi;

    @Transactional(readOnly = true)
    @Override
    public ResponseObject<ShopStaffResponse> findByUserId(Long userId) {
        ResponseObject<ShopStaffResponse> result = new ResponseObject<>();

        List<ShopStaffSimple> staffs = shopStaffApi.listData(Filter.eq("staff.id", userId));
        if (staffs == null || staffs.isEmpty()) {
            result.setCode(501);
            result.setMsg("你还没店铺");
            return result;
        }
        ShopStaffResponse response=new ShopStaffResponse();
        BeanUtils.copyProperties(staffs.get(0),response);
        result.setData(response);
        return result;
    }

    @Transactional
    @Override
    public ResponseObject<?> create(ShopStaffExtRequest request) {
        ResponseObject<?> result = new ResponseObject<>();

        UserRegisterRequest req = new UserRegisterRequest();
        req.setPassword(request.getPassword());
        req.setUsername(request.getPhone());
        req.setAccountType(AccountType.phone);
        ResponseObject<UserInfoResponse> res = userExtApi.register(req);
        if (res.getCode() != 200) {
            return res;
        }
        request.setStaff(res.getData().getId());
        ResponseObject<ShopStaffResponse> staff = shopStaffApi.create(request);

        if (request.getShopRole() != null) {
            AppUserRoleRequest staffRole = new AppUserRoleRequest();
            staffRole.setUser(staff.getData().getStaff());
            staffRole.setRole(request.getShopRole());
            appUserRoleExtApi.create(staffRole);
        }

        return staff;
    }

    @Transactional
    @Override
    public ResponseObject<?> update(ShopStaffExtRequest request) {
        ResponseObject<?> result = new ResponseObject<>();
        ResponseObject<ShopStaffResponse> res = shopStaffApi.update(request);
        if (res.getCode() != 200) {
            return res;
        }
        if (request.getShopRole() != null) {
            appUserRoleApi.deleteByFilter(Filter.eq("user.id", request.getId()));
            AppUserRoleRequest staffRole = new AppUserRoleRequest();
            staffRole.setUser(request.getId());
            staffRole.setRole(request.getShopRole());
            appUserRoleExtApi.create(staffRole);
        }
        return result;
    }

    @Transactional
    @Override
    public ResponseObject<?> restPassword(ShopStaffExtRequest request) {
        ResponseObject<?> result = new ResponseObject<>();
        ShopStaffResponse res = shopStaffApi.oneData(Filter.eq("id", request.getId()));
        if (res == null) {
            result.setCode(501);
            result.setMsg("无效员工id");
            return result;
        }
        UserResetPasswordRequest req=new UserResetPasswordRequest();
        req.setId(res.getStaff());
        req.setPassword(request.getPassword());

        return  userExtApi.resetPassword(req);
    }
}
