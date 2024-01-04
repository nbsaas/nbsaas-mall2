package com.nbsaas.boot.common.ext.domain.config;

import lombok.Data;

/**
 * 公众号配置
 */
@Data
public class WeChatConfig {

    /**
     * 密码
     */
    private String appSecret;

    /**
     * 程序key
     */
    private String appKey;

}
