package com.shabab.elasiclocation;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import javax.persistence.Id;
import java.io.Serializable;

@Document(indexName = "adv")
public class ElasticAdvertise implements Serializable {


    @Id
    private Long id;

    private String title;


    private Integer inStock;


    @GeoPointField
    private GeoPoint location;


    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Advertise{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", inStock=" + inStock +
                ", location=" + location.getLat() + "," + location.getLon() +
                '}';
    }
}
