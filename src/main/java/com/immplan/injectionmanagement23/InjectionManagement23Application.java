package com.immplan.injectionmanagement23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InjectionManagement23Application {

    public static void main(String[] args) {
        SpringApplication.run(InjectionManagement23Application.class, args);
        //SpringApplication.run(MainPageController.class, args);
    }


/*
    @Bean
    public CommandLineRunner run(EquipmentTypeRepository query) {
        return (args) -> {

            System.out.println("start");
            System.out.println(query.findById(4L));
            System.out.println("end");

        };
    }
*/
}
