package com.kurdestanbootcamp.postgis;


import javax.persistence.*;
import java.io.Serializable;

import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

@Entity
@Table(name = "advertise")
@Data
public class Advertise implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;



    private Integer inStock;



    @Column(name = "adv_location")
    private Point<G2D> location;



    @Override
    public String toString() {
        return "Advertise{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", inStock=" + inStock +
                ", location=" + location.getPosition().getLat()+"-"+location.getPosition().getLon()+
                '}';
    }
}
