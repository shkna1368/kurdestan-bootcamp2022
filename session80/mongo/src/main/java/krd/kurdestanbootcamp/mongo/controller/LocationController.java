package krd.kurdestanbootcamp.mongo.controller;

import krd.kurdestanbootcamp.mongo.repo.LocationRepository;
import krd.kurdestanbootcamp.mongo.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationRepository repository;

    @GetMapping("/findNearest/{distance}")
    public List<Location> read(@PathVariable Integer distance ) {
        return  repository.findByLocationNear(
                new Point(-5.581312, 54.368321),
                new Distance(distance, Metrics.KILOMETERS));
    }







}
