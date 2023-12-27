package com.nbsaas.boot;
/*
 * 版权声明和许可协议
 *
 * 版权所有 (c) 2023 纽百特®
 * 版权所有，保留所有权利
 *
 * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *
 *   https://opensource.org/licenses/MIT
 *
 * 更多信息，请访问我们的网站：
 *
 *   http://www.nbsaas.com
 *
 * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 排除jpa注解，使用原生hibernate
 * (exclude= HibernateJpaAutoConfiguration.class)
 */
@EnableTransactionManagement
@EnableCaching
@CrossOrigin
@SpringBootApplication
@EnableDiscoveryClient
public class ShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}
