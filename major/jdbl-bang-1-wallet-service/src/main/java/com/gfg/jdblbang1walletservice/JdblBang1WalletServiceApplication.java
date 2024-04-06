package com.gfg.jdblbang1walletservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JdblBang1WalletServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(JdblBang1WalletServiceApplication.class, args);
	}

}
