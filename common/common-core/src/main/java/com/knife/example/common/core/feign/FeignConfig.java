package com.knife.example.common.core.feign;

import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;

@Configuration
public class FeignConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;
 
    @Bean
    public Encoder feignEncoder() {
        return new SpringEncoder(messageConverters);
    }

    @Bean
    public Decoder feignDecoder() {
        return new ResponseEntityDecoder(new FeignResultDecoder(messageConverters));
    }
 
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Feign.Builder feignBuilder(Decoder decoder) throws Exception {
        Feign.Builder builder = Feign.builder().decoder(decoder);

        // 默认为false。此时如果@FeignClient里的方法返回值是void，就执行不到自定义Decoder
        Field forceDecoding = builder.getClass().getDeclaredField("forceDecoding");
        forceDecoding.setAccessible(true);
        forceDecoding.set(builder, true);
        forceDecoding.setAccessible(false);
        return builder;
    }
}