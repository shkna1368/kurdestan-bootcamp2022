package com.shabab.mongolocation;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdvertiseRepository extends MongoRepository<Advertise, Long>{
List<Advertise> findByLocationNear(Point location, Distance distance);
List<Advertise> findByLocationWithin(Circle circle);
List<Advertise> findByLocationWithin(Polygon polygon);



}
