package com.shabab;


import com.shabab.elasiclocation.ElasticAdvertise;
import com.shabab.elasiclocation.ElasticClientService;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import org.springframework.data.elasticsearch.core.query.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2

public class Application implements CommandLineRunner {


    @Autowired
    ElasticsearchOperations elasticsearchOperations;


    @Autowired
    ElasticClientService client;
public void method(){


    /*
    Point<G2D> point = Geometries.mkPoint(new G2D(lon, lat), CoordinateReferenceSystems.WGS84);
    // List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance(point);
    //  List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance2(point);
    List<Advertise> tuples = vehicleLockRepository.findAllWithDistance3(point, 200);


    Point<G2D> point = Geometries.mkPoint(new G2D(lan, lat), CoordinateReferenceSystems.WGS84);
    // List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance(point);
    //  List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance2(point);
    List<Tuple> tp = vehicleLockRepository.findNearest(point, PageRequest.of(0, 1));
    VehicleLock vehicleLock = (VehicleLock) tp.get(0).get(0);
    */


}


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {




        System.out.println("-----------elastic------------------- ");


        final TermQueryBuilder qb = QueryBuilders.termQuery("id", 1);
     //   final SearchHit<ElasticAdvertise> hit = elasticsearchRestTemplate.searchOne(new NativeSearchQuery(qb), Link.class);


        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
               // .withQuery(matchPhraseQuery("id", "1").slop(1))
                .build();
    // long count=    elasticsearchOperations.count(searchQuery,ElasticAdvertise.class);
      //  System.out.println("elastic count="+count);
    //   if(count==0) {
             ElasticAdvertise elasticAdvertise = new ElasticAdvertise();
             elasticAdvertise.setId(2l);
             elasticAdvertise.setInStock(51);
             elasticAdvertise.setTitle("tit2");
           GeoPoint geoPoint1=new GeoPoint(35.70006, 51.33827);
           elasticAdvertise.setLocation(geoPoint1);

             ElasticAdvertise elasticAdvertise2 = new ElasticAdvertise();
             elasticAdvertise2.setId(3l);
             elasticAdvertise2.setInStock(51);
             elasticAdvertise2.setTitle("tit2");
           GeoPoint geoPoint2=new GeoPoint(35.70006, 51.33827);

           elasticAdvertise2.setLocation(geoPoint2);





             ElasticAdvertise saved = elasticsearchOperations.save(elasticAdvertise);
             ElasticAdvertise saved2 = elasticsearchOperations.save(elasticAdvertise2);
             System.out.println("saved=" + saved.toString());
             System.out.println("saved2=" + saved2.toString());
         //}

        ElasticAdvertise get = elasticsearchOperations.get(String.valueOf(2), ElasticAdvertise.class);

        System.out.println("get "+get);



        Criteria criteria = new Criteria("title").is("tit2")
                .and("inStock").is(51);

        Query query = new CriteriaQuery(criteria);



        SearchHits<ElasticAdvertise> hitsData=  elasticsearchOperations.search(query, ElasticAdvertise.class);
        SearchPage<ElasticAdvertise> page = SearchHitSupport.searchPageFor(hitsData, query.getPageable());
        System.out.println("size of search="+page.getTotalElements());
        System.out.println("search data"+page.getContent().toString());





        CriteriaQuery geoLocationCriteriaQuery = new CriteriaQuery(
                new Criteria("location").within(new GeoPoint(35.70005, 51.33826), "20km"));

        GeoDistanceQueryBuilder geoDistanceQueryBuilder = QueryBuilders
                .geoDistanceQuery("location")
                .point(35.70004, 51.33825)
                .distance(10, DistanceUnit.KILOMETERS);

        Query queryLocation = new CriteriaQuery(geoLocationCriteriaQuery.getCriteria());

        SearchHits<ElasticAdvertise> hitsDataLocation=  elasticsearchOperations.search(queryLocation, ElasticAdvertise.class);
        SearchPage<ElasticAdvertise> pageLocation = SearchHitSupport.searchPageFor(hitsDataLocation, queryLocation.getPageable());
        System.out.println("size of location search="+pageLocation.getTotalElements());
        System.out.println("search location data"+pageLocation.getContent().toString());


    }












}
