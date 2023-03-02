
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public interface PolygonModelRepository extends PagingAndSortingRepository<PolygonModel, UUID>, QuerydslPredicateExecutor<PolygonModel> {


    Optional<PolygonModel> findByUuidAndIsDeletedIsFalse(UUID polygonId);


    Optional<PolygonModel> findByTitleAndIsDeletedIsFalse(String polygonTitle);


    List<PolygonModel> findAllByIsDeletedIsFalse();


    List<PolygonModel> findAllByCityAndIsDeletedIsFalse(City city);


    List<PolygonModel> findAllByAreaAndIsDeletedIsFalse(Area area);


    List<PolygonModel> findAllByUuidAndIsDeletedIsFalse(UUID uuid);


}
