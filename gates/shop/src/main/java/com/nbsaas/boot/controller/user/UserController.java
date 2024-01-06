package com.nbsaas.boot.controller.user;

import com.nbsaas.boot.rest.response.ResponseObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequiresUser
    @RequestMapping("/logout")
    public ResponseObject<?> logout() {
        SecurityUtils.getSubject().logout();
        return ResponseObject.success();
    }
}
