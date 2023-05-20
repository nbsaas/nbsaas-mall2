package com.nbsaas.life;

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
public class FrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class, args);
    }

}
