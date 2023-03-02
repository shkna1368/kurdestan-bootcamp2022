


import ir.pakcharkh.bdood.core.dto.VehicleLockDTO;
import ir.pakcharkh.bdood.core.model.VehicleLock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface VehicleLockMapper {


    @Mapping(source = "uuid", target = "vehicleLockId")
    VehicleLockDTO toVehicleLockDTO(VehicleLock vehicleLock);

    VehicleLock toVehicleLock(VehicleLockDTO vehicleLockDTO);


    List<VehicleLockDTO> toVehicleLockDTOs(List<VehicleLock> vehicleLocks);


}
