package com.mosaiker.manage_hean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class ManageHeanApplication {

    public static void main(String[] args) {

        SpringApplication.run(ManageHeanApplication.class, args);
    }
    @Bean
    @Autowired
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}