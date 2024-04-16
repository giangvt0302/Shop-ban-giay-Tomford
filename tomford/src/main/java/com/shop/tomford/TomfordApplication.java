package com.shop.tomford;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.shop")
@EnableScheduling
public class TomfordApplication {

  public static void main(String[] args) {
    SpringApplication.run(TomfordApplication.class, args);

      System.out.println("Hello World!");
  }

}
