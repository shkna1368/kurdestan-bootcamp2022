

import com.querydsl.core.BooleanBuilder;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehickeLockServiceImpl implements VehicleLockService {

    private VehicleLockRepository vehicleLockRepository;

    @Autowired
    public VehickeLockServiceImpl(VehicleLockRepository vehicleLockRepository) {
        this.vehicleLockRepository = vehicleLockRepository;
    }

    @Override
    public VehicleLock addVehicleLock(String acceptLanguage, VehicleLock vehicleLock) {

        String lockSerial = vehicleLock.getLockSerial();

        Optional<VehicleLock> optionalLockSerial = vehicleLockRepository.findByLockSerialAndIsDeletedIsFalse(lockSerial);
        if (optionalLockSerial.isPresent()) {
            throw new ConflictException(StringResource.conflict_error);
        }

        String macAddress = vehicleLock.getMacAddress();

        Optional<VehicleLock> optionalMacAddress = vehicleLockRepository.findByMacAddressAndIsDeletedIsFalse(macAddress);
        if (optionalMacAddress.isPresent()) {
            throw new ConflictException(StringResource.conflict_error);
        }

        try {
            return vehicleLockRepository.save(vehicleLock);
        } catch (Exception e) {
            throw new SqlException(StringResource.adding_error);
        }

    }


    @Override
    public void deleteVehicleLock(String acceptLanguage, List<String> ids) {

        ids.forEach(id -> {
            UUID uuid = Utils.strToUuid(id);
            Optional<VehicleLock> optionalVehicleLock = vehicleLockRepository.findByUuidAndIsDeletedIsFalse(uuid);
            if (!optionalVehicleLock.isPresent()) {
                throw new ConflictException(StringResource.not_found_error_FA);
            }
            VehicleLock vehicleLock = optionalVehicleLock.get();
            vehicleLock.setIsDeleted(true);
            try {
                vehicleLockRepository.save(vehicleLock);
            } catch (Exception e) {
                throw new SqlException(StringResource.geting_data_error);
            }
        });

    }


    @Override
    public VehicleLock updateVehicle(String acceptLanguage, String vehicleLockId, VehicleLock vehicleLock) {
        UUID uuid = Utils.strToUuid(vehicleLockId);
        Optional<VehicleLock> optionalVehicleLock = vehicleLockRepository.findByUuidAndIsDeletedIsFalse(uuid);
        if (!optionalVehicleLock.isPresent()) {
            throw new NotFoundException(StringResource.not_found_error_FA);
        }

        VehicleLock temp = optionalVehicleLock.get();
        temp.setLockSerial(vehicleLock.getLockSerial());
        temp.setHardwareVersion(vehicleLock.getHardwareVersion());
        temp.setConfigVersion(vehicleLock.getConfigVersion());
        temp.setBatteryPower(vehicleLock.getBatteryPower());
        temp.setMacAddress(vehicleLock.getMacAddress());
        temp.setServiceCaller(vehicleLock.getServiceCaller());
        temp.setGsmSignal(vehicleLock.getGsmSignal());
        temp.setBleVersion(vehicleLock.getBleVersion());

        try {
            return vehicleLockRepository.save(temp);
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException(StringResource.conflict_error);
        } catch (Exception e) {
            throw new SqlException(StringResource.error_while_updating_FA);
        }

    }

    @Override
    public VehicleLock getVehiclelockById(String acceptLanguage, String vehicleLockId) {

        UUID uuid = Utils.strToUuid(vehicleLockId);
        Optional<VehicleLock> optionalVehicleLock = vehicleLockRepository.findByUuidAndIsDeletedIsFalse(uuid);

        if (!optionalVehicleLock.isPresent()) {
            throw new NotFoundException("قفل یافت نشد");
        }

        try {
            return optionalVehicleLock.get();
        } catch (Exception e) {
            throw new SqlException(StringResource.geting_data_error);
        }

    }

    @Override
    public VehicleLock getVehiclelockByMacAddress(String acceptLanguage, String macAddress) {


        Optional<VehicleLock> optionalVehicleLock = vehicleLockRepository.findByMacAddressAndIsDeletedIsFalse(macAddress);

        if (!optionalVehicleLock.isPresent()) {
            throw new NotFoundException("not exist");
        }

        try {
            return optionalVehicleLock.get();
        } catch (Exception e) {
            throw new SqlException(StringResource.geting_data_error);
        }


    }

    @Override
    public VehicleLock getVehiclelockByLockSerail(String acceptLanguage, String lockSerial) {

        Optional<VehicleLock> optionalVehicleLock = vehicleLockRepository.findByLockSerialAndIsDeletedIsFalse(lockSerial);

        if (!optionalVehicleLock.isPresent()) {
            throw new NotFoundException("not exist");
        }

        try {
            return optionalVehicleLock.get();
        } catch (Exception e) {
            throw new SqlException(StringResource.geting_data_error);
        }

    }

    @Override
    public List<VehicleLock> findAllWithDistance(String acceptLanguage, double lat, double lon, int distance) {

        Point<G2D> point = Geometries.mkPoint(new G2D(lon, lat), CoordinateReferenceSystems.WGS84);
        // List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance(point);
        //  List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance2(point);
        List<VehicleLock> tuples = vehicleLockRepository.findAllWithDistance3(point, distance);

        return tuples;
    }

    @Override
    public List<VehicleLock> searchVehicleLock(String acceptLanguage, VehicleLockSearchDTO vehicleLockSearchDTO, Boolean isDeleted) {
        QVehicleLock qVehicleLock = QVehicleLock.vehicleLock;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (isDeleted == false) {
            booleanBuilder.and(qVehicleLock.isDeleted.eq(false));
        }

        if (vehicleLockSearchDTO.getLockSerial() != null && !vehicleLockSearchDTO.getLockSerial().isEmpty()) {
            booleanBuilder.and(qVehicleLock.lockSerial.eq(vehicleLockSearchDTO.getLockSerial()));
        }

        if (vehicleLockSearchDTO.getMacAddress() != null && !vehicleLockSearchDTO.getMacAddress().isEmpty()) {
            booleanBuilder.and(qVehicleLock.macAddress.eq(vehicleLockSearchDTO.getMacAddress()));
        }

        Pageable pageable = PageRequest.of(
                vehicleLockSearchDTO.getPageNumber(),
                vehicleLockSearchDTO.getPageSize(),
                vehicleLockSearchDTO.getSortedBy(),
                vehicleLockSearchDTO.getOrderedBy());

        return vehicleLockRepository.findAll(booleanBuilder.getValue(), pageable).getContent();


    }

    @Override
    public List<VehicleLock> getAllVehicleLocks(String acceptLanguage) {
        return vehicleLockRepository.findAllByIsDeletedIsFalse();

    }

    @Override
    public VehicleLock findNearest(String acceptLanguage, double lat, double lan) {
        Point<G2D> point = Geometries.mkPoint(new G2D(lan, lat), CoordinateReferenceSystems.WGS84);
        // List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance(point);
        //  List<Tuple>  tuples=   vehicleLockRepository.findAllWithDistance2(point);
        List<Tuple> tp = vehicleLockRepository.findNearest(point, PageRequest.of(0, 1));
        VehicleLock vehicleLock = (VehicleLock) tp.get(0).get(0);
        return vehicleLock;
    }

    @Override
    public List<VehicleLock> findAll(String acceptLanguage) {
        return (List<VehicleLock>) vehicleLockRepository.findAll();
    }
}
