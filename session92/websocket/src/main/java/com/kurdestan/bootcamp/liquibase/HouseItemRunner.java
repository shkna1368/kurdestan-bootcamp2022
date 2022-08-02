package com.kurdestan.bootcamp.liquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HouseItemRunner implements CommandLineRunner {

    @Autowired
    HouseRepository houseRepository;


    @Autowired
    ItemRepository itemRepository;


    @Override
    public void run(String... args) throws Exception {

        if(houseRepository.count()==0){
            House house=new House();
            house.setFullyPaid(true);
            house.setOwner("Zhina");
          var savedHouse=  houseRepository.save(house);

            Item item=new Item();
            item.setHouse(savedHouse);
            item.setName("TV");
            itemRepository.save(item);
        }





    }
}
