



import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.QueryHint;
import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleLockRepository extends PagingAndSortingRepository<VehicleLock, UUID>, QuerydslPredicateExecutor<VehicleLock> {


    @Query("SELECT vl, distance(vl.lastLocation, ?1) as distance from VehicleLock vl order by distance")
    List<Tuple> findAllWithDistance(Point<G2D> refPnt);


    @Query("SELECT vl from VehicleLock vl where  distance(vl.lastLocation, ?1) < ?2")
    List<VehicleLock> findAllWithDistance3(Point<G2D> refPnt, double dist);


    @Query(" SELECT evt  ,distance(evt.lastLocation, ?1) as distance from VehicleLock evt where distance<200")
    List<VehicleLock> findAllWithDistance4(Point<G2D> refPnt);

 //@Query("SELECT TOP 1 *  from VehicleLock evt where  distance(evt.lastLocation, ?1)" )
 //@Query("SELECT evt, distance(evt.lastLocation, ?1) as distance from VehicleLock evt where evt.vehicle.inService=false order by distance" )
 //@Query("SELECT vl, distance(vl.lastLocation, ?1) as distance from VehicleLock vl where vl.vehicle.inService=true order by distance" )
 @Query("SELECT vl, distance(vl.lastLocation, ?1) as distance from VehicleLock vl where vl.vehicle.inService=true  order by distance" )
 List<Tuple> findNearest(Point<G2D> refPnt, Pageable page);



    ////////


    Optional<VehicleLock> findByUuidAndIsDeletedIsFalse(UUID uuid);

    Optional<VehicleLock> findByLockSerialAndIsDeletedIsFalse(String uuid);
    List<VehicleLock> findAllByLockSerialAndIsDeletedIsFalse(String uuid);
    List<VehicleLock> findAllByLastLocationIsNullAndIsDeletedIsFalse();

    Optional<VehicleLock> findByMacAddressAndIsDeletedIsFalse(String uuid);

    List<VehicleLock> findAllByIsDeletedIsFalse();

    List<VehicleLock> findByLockSerial(String lockSerial);


}
