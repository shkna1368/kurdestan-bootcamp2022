package krd.kurdestanbootcamp.mongo.repo;

import krd.kurdestanbootcamp.mongo.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    List<Location> findByLocationNear( Point p, Distance d);
    Page<Location> findByLocationNear( Point p, Distance d,Pageable pageable);




    List<Location> findByLocationWithin(Point location, Distance distance);
    List<Location> findByLocationWithin(Point location, Range<Double> distanceRange);


    List<Location> findByLocationWithin(Polygon polygon);
}

