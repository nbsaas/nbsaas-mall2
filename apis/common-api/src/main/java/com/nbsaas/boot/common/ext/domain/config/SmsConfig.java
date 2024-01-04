package com.nbsaas.boot.common.ext.domain.config;


import lombok.Data;

@Data
public class SmsConfig {

    private String accessKeyId;

    private String accessKeySecret;

    private String loginTemplate;

    private String registerTemplate;

    private String forgetTemplate;


    private String signName;

}
