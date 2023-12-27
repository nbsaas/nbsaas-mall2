package com.nbsaas.boot.controller.system;

import com.nbsaas.boot.config.SiteConfig;
import com.nbsaas.boot.config.ext.apis.ConfigExtApi;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/config")
public class ConfigController {


    @Resource
    private ConfigExtApi configExtApi;

    @RequestMapping("/info")
    public ResponseObject<SiteConfig> info() {
        return configExtApi.info(SiteConfig.class);
    }


    @RequestMapping("/configData")
    public ResponseObject<SiteConfig> config(SiteConfig config) {
        return configExtApi.configData(config);
    }

}