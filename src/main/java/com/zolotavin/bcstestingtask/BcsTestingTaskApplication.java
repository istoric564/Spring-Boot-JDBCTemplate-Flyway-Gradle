package com.zolotavin.bcstestingtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class BcsTestingTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcsTestingTaskApplication.class, args);
    }

}
