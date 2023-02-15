package com.kurdestanbootcamp.graphql.qraphql;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class RatingController {

    private final RatingRepository ratingRepository;



    @MutationMapping
    public Rating create(@Argument String rate, @Argument String star) {
        Rating rating1=new Rating();
        rating1.setRate(rate);
        rating1.setStar(star);

        return ratingRepository.save(rating1);
    }


}
