package krd.kurdestanbootcamp.mongo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Person")
@Data
public class Person {
    @Id
    private String id;
    private String name;
    private Integer age;



}
