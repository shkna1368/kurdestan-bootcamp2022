


import org.geolatte.geom.G2D;
import org.geolatte.geom.Polygon;
import org.geolatte.geom.PositionSequenceBuilder;
import org.geolatte.geom.codec.db.sqlserver.CountingPositionSequenceBuilder;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring", uses = {TranslateMapper.class})
public interface PolygonModelMapper {


    @Mappings({
            @Mapping(source = "uuid", target = "polygonId"),
            @Mapping(source = "city.uuid", target = "cityId"),
            @Mapping(source = "area.uuid", target = "areaId"),
            @Mapping(source = "polygonEnum.id", target = "polygonType"),
            @Mapping(source = "polygon", target = "locationList", qualifiedByName = "ploygonToLocation")
    })
    PolygonModelDTO toPolygonDTO(PolygonModel polygonModel);


    @Mapping(source = "locationList", target = "polygon", ignore = false, qualifiedByName = "locationsToPolygon")
    @Mapping(source = "polygonType", target = "polygonEnum", qualifiedByName = "polygonTypeConvert")
    @Mapping(source = "cityId", target = "cityId")
    @Mapping(source = "areaId", target = "areaId")
    PolygonModel toPolygonModel(PolygonModelDTO polygonModelDTO);


    List<PolygonModelDTO> toPolygonDTOs(List<PolygonModel> polygonModels);


    @Named("locationsToPolygon")
    @InheritInverseConfiguration
    default Polygon<G2D> toPolygon(List<LocationDTO> locationDTOS) {
        PositionSequenceBuilder<G2D> positionSequenceBuilder = new CountingPositionSequenceBuilder<>(CoordinateReferenceSystems.WGS84);
        locationDTOS.forEach(locationDTO -> {
            positionSequenceBuilder.add(locationDTO.getLng(), locationDTO.getLat());
        });
        Polygon<G2D> g2DPolygon = null;
        try {
            g2DPolygon = new Polygon<>(positionSequenceBuilder.toPositionSequence(), CoordinateReferenceSystems.WGS84);
        } catch (Exception e) {
            throw new IllegalArgumentException(StringResource.how_to_add_polygon);
        }
        return g2DPolygon;
    }


    @Named("ploygonToLocation")
    @InheritInverseConfiguration
    default List<LocationDTO> toLocation(Polygon<G2D> polygon) {
        int positionsLength = polygon.getNumPositions();
        List<LocationDTO> locationDTOS = new ArrayList<>(positionsLength);

        for (int i = 0; i < positionsLength; i++) {
            LocationDTO locationDTO = new LocationDTO();
            G2D point = polygon.getPositionN(i);
            locationDTO.setLat(point.getLat());
            locationDTO.setLng(point.getLon());
            locationDTOS.add(i, locationDTO);
        }
        return locationDTOS;
    }


    @Named("polygonTypeConvert")
    default PolygonEnum convertToPolygonType(Integer id) {
        return PolygonEnum.getValue(id);
    }


}

