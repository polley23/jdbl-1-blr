package com.gfg.jbdl1session8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
@Slf4j
public class Jbdl1Session8Application {
	@Bean
	Car car(){
		return new Car();
	}


	public static void main(String[] args) {
		WebApplicationContext ioc = (WebApplicationContext) SpringApplication.run(Jbdl1Session8Application.class, args);
//		Car car = ioc.getBean(Car.class);
//		Method[] methods = car.getClass().getMethods();
//
//		for (int i=0; i<2; i++) {
//
//			try {
//				Deprecated d = methods[i].getAnnotation(Deprecated.class);
//				CustomLog c = methods[i].getAnnotation(CustomLog.class);
//				if (d != null){
//					continue;
//				}
//				if (c != null){
//					log.info("Hello world");
//				}
//				methods[i].invoke(car);
//				if (c != null){
//					log.info("Good bye world");
//				}
//
//			} catch (IllegalAccessException e) {
//				throw new RuntimeException(e);
//			} catch (InvocationTargetException e) {
//				throw new RuntimeException(e);
//			}
//
//		}
		JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
		Book book = new Book("The outsider", "Camus", jdbcTemplate);
		book.persist();
		book.GetAuthor("The outsider");

	}

}

/*
create table books(
  id bigint auto_increment,
  bname varchar(255),
  author varchar(255),
  PRIMARY KEY (id)
 );


 create table authors(
  aname varchar(255),
  hometown varchar(255),
  PRIMARY KEY (aname)
 );

 insert into books ('bname', 'author') values ('abcd','abcd');
  insert into authors ('aname', 'hometown') values ('abcd','bangalore');

 */
