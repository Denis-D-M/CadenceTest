package com.test;

import com.test.configuration.WorkerRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = WorkerRegister.class)
public class Application {

  @Autowired
  private static ApplicationContext context;

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
    System.out.println(context.getBean(WorkerRegister.class));
  }

}
