package com.nbsaas.boot.shop.ext.domain.config;

import lombok.Data;

@Data
public class WeChatOauth {

    /**
     * 密码
     */
    private String appSecret;

    /**
     * 程序key
     */
    private String appKey;

}
