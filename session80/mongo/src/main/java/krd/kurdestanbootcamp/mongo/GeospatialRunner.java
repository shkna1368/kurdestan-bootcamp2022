package krd.kurdestanbootcamp.mongo;

import krd.kurdestanbootcamp.mongo.repo.LocationRepository;
import krd.kurdestanbootcamp.mongo.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class GeospatialRunner implements CommandLineRunner {

    @Autowired
    private LocationRepository repository;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("# Geospatial");
if (repository.count()==0) {
    repository.saveAll(Arrays.asList(
            new Location(null, "Dragonstone", new GeoJsonPoint(-6.815096, 55.167801)),
            new Location(null, "King's Landing", new GeoJsonPoint(18.110189, 42.639752)),
            new Location(null, "The Red Keep", new GeoJsonPoint(14.446442, 35.896447)),
            new Location(null, "Yunkai", new GeoJsonPoint(-7.129532, 31.046642)),
            new Location(null, "Astapor", new GeoJsonPoint(-9.774249, 31.50974)),
            new Location(null, "Winterfell", new GeoJsonPoint(-5.581312, 54.368321)),
            new Location(null, "Vaes Dothrak", new GeoJsonPoint(-6.096125, 54.16776)),
            new Location(null, "Beyond the wall", new GeoJsonPoint(-21.094093, 64.265473))));
}

        System.out.println("## Find the first 5 locations near 'Winterfell'");
        repository.findByLocationNear(
                new Point(-5.581312, 54.368321),
                new Distance(5, Metrics.KILOMETERS));
        System.out.println("nj");

     //   List<Location> first6 = repository.findAllByLocationNear(new Point(-5.581312, 54.368321));

       Page<Location> first5 = repository.findByLocationNear(new Point(-5.581312, 54.368321),new Distance(200, Metrics.KILOMETERS) ,PageRequest.of(0, 5));
        first5.forEach(System.out::println);




        System.out.println("## Find the next 5 locations near 'Winterfell' (only 3 locations left)");
       // Page<Location> next5 = repository.findAllByLocationNear(new GeoJsonPoint(-5.581312, 54.368321), PageRequest.of(1, 5));
     //   next5.forEach(System.out::println);
        System.out.println("## Find all locations within 50 kilometers of 'Winterfell'");
        /*GeoResults<Location> findWithing50kilometers = repository
                .findByLocationWithin(new Point(-5.581312, 54.368321), new Distance(50, Metrics.KILOMETERS));
        findWithing50kilometers.forEach(System.out::println);*/

  /*      System.out.println("## Find all locations which are 40 to 50 kilometers away from 'Winterfell'");
        List<Location> findByLocationWithin = repository.findByLocationWithin(new Point(-5.581312, 54.368321),
                Range.of(Range.Bound.inclusive(40000.), Range.Bound.exclusive(50000.)));
        findByLocationWithin.forEach(System.out::println);




        System.out.println("## Find all locations within a given polygon");
        List<Location> withinPolygon = repository.findByLocationWithin(
                new Polygon(Arrays.asList(new Point(-25, 40), new Point(-25, 70), new Point(25, 70), new Point(-25, 40))));
        withinPolygon.forEach(System.out::println);
    */
    }
}