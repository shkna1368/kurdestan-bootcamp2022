
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FavouriteLocationRepository extends PagingAndSortingRepository<FavouriteLocation, UUID>,
        QuerydslPredicateExecutor<FavouriteLocation> {

    Optional<FavouriteLocation> findAllByIsDeletedIsFalseAndUuid(UUID uuid);
    List<FavouriteLocation> findAllByIsDeletedIsFalseAndCustomer_Uuid(UUID customerUuid);
}
