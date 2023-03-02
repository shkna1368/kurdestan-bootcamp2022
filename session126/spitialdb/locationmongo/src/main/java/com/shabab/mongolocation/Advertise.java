package com.shabab.mongolocation;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "advertise")

public class Advertise {
    @Transient
    public static final String SEQUENCE_NAME = "advertise_sequence";

    @Id
    private Long id;

    @Indexed(unique = true)
    private String title;

    private Integer inStock;

    @GeoSpatialIndexed(name = "Location")
    Double[] location;

    public static String getSequenceName() {
        return SEQUENCE_NAME;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public Double[] getLocation() {
        return location;
    }

    public void setLocation(Double[] location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Advertise{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", inStock=" + inStock +
                ", location=" + Arrays.toString(location) +
                '}';
    }
}
