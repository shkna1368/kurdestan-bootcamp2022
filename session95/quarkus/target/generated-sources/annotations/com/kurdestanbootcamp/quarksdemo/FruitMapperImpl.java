package com.kurdestanbootcamp.quarksdemo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T01:37:11+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class FruitMapperImpl implements FruitMapper {

    @Override
    public Fruit toEntity(FruitDTO fruitDTO) {
        if ( fruitDTO == null ) {
            return null;
        }

        Fruit fruit = new Fruit();

        fruit.setId( fruitDTO.getId() );
        fruit.setName( fruitDTO.getName() );
        fruit.setColor( fruitDTO.getColor() );

        return fruit;
    }

    @Override
    public FruitDTO toDTO(Fruit fruit) {
        if ( fruit == null ) {
            return null;
        }

        FruitDTO fruitDTO = new FruitDTO();

        fruitDTO.setId( fruit.getId() );
        fruitDTO.setName( fruit.getName() );
        fruitDTO.setColor( fruit.getColor() );

        return fruitDTO;
    }

    @Override
    public List<FruitDTO> toDTOs(Iterable<Fruit> fruits) {
        if ( fruits == null ) {
            return null;
        }

        List<FruitDTO> list = new ArrayList<FruitDTO>();
        for ( Fruit fruit : fruits ) {
            list.add( toDTO( fruit ) );
        }

        return list;
    }
}
