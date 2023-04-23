package com.springbootapp.inventoryservice;

import com.springbootapp.inventoryservice.model.Inventory;
import com.springbootapp.inventoryservice.repository.InventoryRepository;
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
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory iPhone13 = Inventory.builder()
					.skuCode("IPhone-13")
					.quantity(100)
					.build();
			Inventory iPhone13Red = Inventory.builder()
					.skuCode("IPhone-13-Red")
					.quantity(0)
					.build();
			inventoryRepository.save(iPhone13);
			inventoryRepository.save(iPhone13Red);
		};
	}

}
