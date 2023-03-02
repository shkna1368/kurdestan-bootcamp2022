package com.kurdestanbootcamp;


import com.kurdestanbootcamp.postgis.Advertise;
import com.kurdestanbootcamp.postgis.AdvertiseRepository;
import com.kurdestanbootcamp.postgis.dto.LocationDTO;
import org.geolatte.geom.*;
import org.geolatte.geom.codec.db.sqlserver.CountingPositionSequenceBuilder;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.List;


@SpringBootApplication

public class Application implements CommandLineRunner {
@Autowired
    AdvertiseRepository advertiseRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


        System.out.println("-------------save in DB");
        if(advertiseRepository.count()==0) {
            Advertise advertise = new Advertise();
            Point<G2D> point = Geometries.mkPoint(new G2D(35.70006, 51.33827), CoordinateReferenceSystems.WGS84);
            advertise.setInStock(25);
            advertise.setTitle("Title 1");
            advertise.setLocation(point);
            Advertise saved = advertiseRepository.save(advertise);
            System.out.println("saved" + saved);
        }
        System.out.println("----------fetch all From db----------");

        System.out.println(advertiseRepository.findAll());

        System.out.println("All Data");



        System.out.println("----------fetch From db----------");

        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(35.700201, 51.342043), CoordinateReferenceSystems.WGS84);
        // List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance(point);
        //  List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance2(point);
        List<Advertise> tuples = advertiseRepository.findAllWithDistance3(candidPoint, 200);

        System.out.println(tuples);






        PositionSequenceBuilder<G2D> positionSequenceBuilder = new CountingPositionSequenceBuilder<>(CoordinateReferenceSystems.WGS84);

            positionSequenceBuilder.add(35.702920, 51.342901);
            positionSequenceBuilder.add(35.705254, 51.337322);
            positionSequenceBuilder.add(35.699679, 51.331657);
            positionSequenceBuilder.add(35.695566, 51.339747);
            positionSequenceBuilder.add(35.702920, 51.342901);

         Polygon<G2D> g2DPolygon  = new Polygon<>(positionSequenceBuilder.toPositionSequence(), CoordinateReferenceSystems.WGS84);

        List<Advertise> pointsInPolygon = advertiseRepository.findWithin(g2DPolygon);

        System.out.println("in polygons+"+pointsInPolygon.toString());


//////////////custom convert to dto-------
        int positionsLength = g2DPolygon.getNumPositions();
        List<LocationDTO> locationDTOS = new ArrayList<>(positionsLength);


        for(int i=0;i<positionsLength;i++){
            LocationDTO locationDTO=new LocationDTO();

            G2D point = g2DPolygon.getPositionN(i);

            locationDTO.setLat(point.getLat());
            locationDTO.setLng(point.getLon());

            locationDTOS.add(i, locationDTO);


        }






        System.out.println("dto="+locationDTOS.toString());

    }


}
