package com.kurdestanbootcamp.quarksdemo;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface FruitMapper {

   Fruit toEntity(FruitDTO fruitDTO) ;
   FruitDTO toDTO(Fruit fruit) ;
   List<FruitDTO> toDTOs(Iterable<Fruit> fruits) ;

}
