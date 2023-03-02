
import ir.pakcharkh.bdood.core.exception.NotFoundException;
import ir.pakcharkh.bdood.core.exception.ServerExceptionMultiLanguageHelper;
import ir.pakcharkh.bdood.core.model.Customer;
import ir.pakcharkh.bdood.core.model.CustomerV2;
import ir.pakcharkh.bdood.core.model.FavouriteLocation;
import ir.pakcharkh.bdood.core.model.enums.ExceptionType;
import ir.pakcharkh.bdood.core.repository.FavouriteLocationRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FavouriteLocationServiceImpl implements FavouriteLocationService  {

    private final FavouriteLocationRepository favouriteLocationRepository;

    @Autowired
    public FavouriteLocationServiceImpl(final FavouriteLocationRepository favouriteLocationRepository){
        this.favouriteLocationRepository = favouriteLocationRepository;
    }

    @Override
    public List<FavouriteLocation> getAll(String acceptLanguage/*, String customerUuid*/) {
        return favouriteLocationRepository.findAllByIsDeletedIsFalseAndCustomer_Uuid(this.findLoggedInCustomer().getUuid());
    }

    @Override
    public FavouriteLocation findOne(String language, String uuid){
        return favouriteLocationRepository.findAllByIsDeletedIsFalseAndUuid(UUID.fromString(uuid))
                .orElseThrow(() -> ServerExceptionMultiLanguageHelper.getMessage(ExceptionType.NotFoundException,language));
    }

    @Override
    public void save(String acceptLanguage, FavouriteLocation location) {
        CustomerV2 customer = this.findLoggedInCustomer();
        List<FavouriteLocation> locations = favouriteLocationRepository.findAllByIsDeletedIsFalseAndCustomer_Uuid(customer.getUuid());
        if(locations.size() == 3)
            throw ServerExceptionMultiLanguageHelper.getMessage(ExceptionType.reachedLimitOfFavouriteLocations, acceptLanguage);
        location.setCustomer(customer);
        favouriteLocationRepository.save(location);
    }

    @Override
    public void update(String acceptLanguage, String uuid, FavouriteLocation location){
        FavouriteLocation fetchedLocation = this.findOne(acceptLanguage,uuid);
        favouriteLocationRepository.save(this.map(fetchedLocation,location));
    }

    @Override
    public void remove(String acceptLanguage, String uuid) {
        FavouriteLocation fetchedLocation = this.findOne(acceptLanguage,uuid);
        fetchedLocation.setIsDeleted(true);
        favouriteLocationRepository.save(fetchedLocation);
    }

    private FavouriteLocation map(FavouriteLocation fetched, FavouriteLocation received){
        fetched.setTitle(received.getTitle());
        fetched.setPoint(received.getPoint());
        return fetched;
    }
    private CustomerV2 findLoggedInCustomer(){
        return (CustomerV2) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
