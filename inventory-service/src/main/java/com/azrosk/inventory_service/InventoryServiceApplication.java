package com.azrosk.inventory_service;

import com.azrosk.inventory_service.model.Inventory;
import com.azrosk.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = Inventory.builder()
                    .skuCode("Iphone_13")
                    .quantity(100)
                    .build();

            Inventory inventory2 = Inventory.builder()
                    .skuCode("Iphone_14")
                    .quantity(50)
                    .build();

            inventoryRepository.save(inventory2);
            inventoryRepository.save(inventory);
        };
    }

}
