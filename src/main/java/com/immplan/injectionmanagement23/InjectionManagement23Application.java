package com.immplan.injectionmanagement23;

import com.immplan.injectionmanagement23.controller.MainPageController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


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
