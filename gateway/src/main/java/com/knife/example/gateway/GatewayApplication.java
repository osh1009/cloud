package com.knife.example.gateway;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootappplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
