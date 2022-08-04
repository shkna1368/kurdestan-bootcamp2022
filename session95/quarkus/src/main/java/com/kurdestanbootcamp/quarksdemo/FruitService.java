package com.kurdestanbootcamp.quarksdemo;

import com.kurdestanbootcamp.quarksdemo.exception.CustomException;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class FruitService {


    @ConfigProperty(name = "custom.error.msg.usernotfound")
    String notFoundException;



    @ConfigProperty(name = "custom.error.msg.duplicate")
    String duplicateException;


    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }


    public Iterable<Fruit> findAll() {
        return fruitRepository.findAll();
    }



    public void delete( long id) {
        fruitRepository.deleteById(id);
    }

    public Fruit create( Fruit fruit) {


        return fruitRepository.save(fruit);
    }

    public Fruit changeColor( Long id, String color) {
        Optional<Fruit> optional = fruitRepository.findById(id);
        if (optional.isPresent()) {
            Fruit fruit = optional.get();
            fruit.setColor(color);
            return fruitRepository.save(fruit);
        }

        throw new CustomException(notFoundException);
    }

    public List<Fruit> findByColor( String color) {
        return fruitRepository.findByColor(color);
    }
}
