package com.Xr.Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.Xr.Management.controller.PingController;


//@SpringBootApplication
@Import({ PingController.class })
@SpringBootApplication(scanBasePackages = "com.Xr.Management")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}