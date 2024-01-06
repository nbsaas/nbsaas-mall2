package com.nbsaas.boot.shop.ext.domain.config;

import lombok.Data;

@Data
public class WeChatPay {

    /**
     * 微信支付商户号
     */
    private String appSecret;

    /**
     * 微信支付商户号
     */
    private String appId;

    //商户id
    private String mchId;

    //商户密钥
    private String mchKey;

    //通知地址
    private String notifyUrl;

    //证书路径
    private String keyPath;

    //支付模式 1：直连模式 2：服务商模式
    private Integer payType;

    //服务商户号
    private String serviceMchId;

    //备注
    private String remark;
}
