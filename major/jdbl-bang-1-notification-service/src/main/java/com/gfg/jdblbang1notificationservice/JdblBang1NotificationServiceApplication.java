package com.gfg.jdblbang1notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JdblBang1NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdblBang1NotificationServiceApplication.class, args);
	}

}
