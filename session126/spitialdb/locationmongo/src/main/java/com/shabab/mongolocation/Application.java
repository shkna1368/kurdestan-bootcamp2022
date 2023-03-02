package com.shabab.mongolocation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.geo.*;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private AdvertiseRepository advertiseRepository;

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        advertiseRepository.deleteAll();
        if (advertiseRepository.count() == 0) {
            Advertise advertise = new Advertise();
            advertise.setId(sequenceGeneratorService.generateSequence(Advertise.SEQUENCE_NAME));

            advertise.setInStock(50);
            advertise.setTitle("Azadi tower");

            advertise.setLocation(new Double[]{35.70006, 51.33827});
            Advertise saved = advertiseRepository.save(advertise);
            System.out.println("saved" + saved.toString());

        }

        System.out.println("----------------------------");
        System.out.println("all" + advertiseRepository.findAll());


        System.out.println("------find nearest-----");
        Point candidPoint = new Point(35.700201, 51.342043);
        System.out.println("nearest" + advertiseRepository.findByLocationNear(candidPoint, new Distance(1, Metrics.KILOMETERS)));


        System.out.println("---------find in circle--------");
        //  Point centerOfCirclePoint=       new Point( 51.342043,35.700201);
        Circle circle = new Circle(candidPoint, new Distance(30, Metrics.KILOMETERS));
        System.out.println("in circle:" + advertiseRepository.findByLocationWithin(circle));


        System.out.println("-----------in polygon-----------------");
        Polygon polygon = new Polygon(new Point(35.702920, 51.342901), new Point(35.705254, 51.337322), new Point(35.699679, 51.331657), new Point(35.695566, 51.339747));
        System.out.println("in polygon:" + advertiseRepository.findByLocationWithin(polygon));


    }


}
