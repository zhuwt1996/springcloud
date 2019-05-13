package com.pagoda.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by zhuwutao on 2019/5/13
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartSpringCloudApp.class,args);
    }
}
