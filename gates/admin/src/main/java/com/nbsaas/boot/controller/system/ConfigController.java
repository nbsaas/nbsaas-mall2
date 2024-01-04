package com.nbsaas.boot.controller.system;

import com.nbsaas.boot.common.ext.domain.config.*;
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

    @RequestMapping("/viewSms")
    public ResponseObject<SmsConfig> smsConfig() {
        return configExtApi.info(SmsConfig.class);
    }
    @RequestMapping("/configSms")
    public ResponseObject<SmsConfig> smsConfig(SmsConfig smsConfig) {
        return configExtApi.configData(smsConfig);
    }

    @RequestMapping("/viewWeChat")
    public ResponseObject<WeChatConfig> viewWeChat() {
        return configExtApi.info(WeChatConfig.class);
    }

    @RequestMapping("/configWeChat")
    public ResponseObject<WeChatConfig> weChatConfig(WeChatConfig smsConfig) {
        return configExtApi.configData(smsConfig);
    }


    @RequestMapping("/viewAliOss")
    public ResponseObject<AliOssConfig> viewAliOss() {
        return configExtApi.info(AliOssConfig.class);
    }

    @RequestMapping("/configAliOss")
    public ResponseObject<AliOssConfig> configAliOss(AliOssConfig smsConfig) {
        return configExtApi.configData(smsConfig);
    }

    @RequestMapping("/viewAMapConfig")
    public ResponseObject<AMapConfig> viewAMapConfig() {
        return configExtApi.info(AMapConfig.class);
    }

    @RequestMapping("/configAMapConfig")
    public ResponseObject<AMapConfig> configAMapConfig(AMapConfig smsConfig) {
        return configExtApi.configData(smsConfig);
    }


    @RequestMapping("/viewAliOcrConfig")
    public ResponseObject<AliOcrConfig> viewAliOcrConfig() {
        return configExtApi.info(AliOcrConfig.class);
    }

    @RequestMapping("/configAliOcrConfig")
    public ResponseObject<AliOcrConfig> configAliOcrConfig(AliOcrConfig smsConfig) {
        return configExtApi.configData(smsConfig);
    }
}