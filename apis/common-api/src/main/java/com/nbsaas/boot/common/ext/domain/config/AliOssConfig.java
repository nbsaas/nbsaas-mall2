package com.nbsaas.boot.common.ext.domain.config;

import lombok.Data;

@Data
public class AliOssConfig {

    /**
     * 阿里云oss的endpoint
     */
    private  String endpoint ;

    /**
     * 阿里云oss的accessKeyId
     */
    private  String accessKeyId ;

    /**
     * 阿里云oss的accessKeySecret
     */
    private  String accessKeySecret ;

    /**
     * 储存桶名称
     */
    private  String bucketName;
}
