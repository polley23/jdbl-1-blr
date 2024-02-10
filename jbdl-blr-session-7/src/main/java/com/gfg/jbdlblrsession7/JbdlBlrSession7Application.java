package com.gfg.jbdlblrsession7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class JbdlBlrSession7Application {

	public static void main(String[] args) {
		WebApplicationContext ioc = (WebApplicationContext) SpringApplication.run(JbdlBlrSession7Application.class, args);
		Man man = ioc.getBean("b2", Man.class);
		man.drive();

	}

}
