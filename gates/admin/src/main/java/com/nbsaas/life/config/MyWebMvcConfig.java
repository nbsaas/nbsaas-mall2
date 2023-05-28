package com.nbsaas.life.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("*");
    }

    @Bean
    @Autowired
    public ConversionService getConversionService(GlobalFormDateConvert globalDateConvert){

        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();

        Set<Converter> converters = new HashSet<>();

        converters.add(globalDateConvert);

        factoryBean.setConverters(converters);

        return factoryBean.getObject();

    }
}