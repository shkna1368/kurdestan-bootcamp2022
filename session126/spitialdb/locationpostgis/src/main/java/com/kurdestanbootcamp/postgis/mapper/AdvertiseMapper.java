package com.kurdestanbootcamp.postgis.mapper;



import com.kurdestanbootcamp.postgis.Advertise;
import com.kurdestanbootcamp.postgis.dto.AdvertiseDTO;
import com.kurdestanbootcamp.postgis.dto.LocationDTO;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdvertiseMapper {



    @Mappings({
            @Mapping(source = "locationDTO", target = "location", qualifiedByName = "locationDtoToDomainLocation")})
    Advertise toAddvertise(AdvertiseDTO advertiseDTO);

    @Mappings({
            @Mapping(source = "location", target = "locationDTO", qualifiedByName = "domainLocationToDtoLocatiom")})
    AdvertiseDTO toAdvertiseDTO(Advertise advertise);

    List<AdvertiseDTO> toAdvertiseDTOs(List<Advertise> advertises);

    List<Advertise> toAdvertise(List<AdvertiseDTO> advertiseDTOS);






    @Named("locationDtoToDomainLocation")
    default  Point<G2D> convertLocationDtoToDomainLocation(LocationDTO locationDTO) {

        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()), CoordinateReferenceSystems.WGS84);

return  candidPoint;



    }

 @Named("domainLocationToDtoLocatiom")
    default  LocationDTO  convertDomainLocationToDtoLocatiom(Point<G2D> point) {
  G2D g2D=   point.getPosition();
    LocationDTO locationDTO=new LocationDTO();
    locationDTO.setLat(g2D.getLat());
    locationDTO.setLng(g2D.getLon());

return  locationDTO;
    }



}
