

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
public class PolygonModelDTO {


    @ApiModelProperty(required = false, hidden = true)
    private UUID polygonId;

    @ApiModelProperty(required = true)
    private String title;

    @ApiModelProperty(required = true)
    private UUID cityId;

    @ApiModelProperty(required = true)
    private UUID areaId;

    @ApiModelProperty(required = true)
    private List<TranslateDTO> translates;


    @ApiModelProperty(required = true)
    private List<LocationDTO> locationList;


    @ApiModelProperty(required = true)
    private Integer polygonType;


}
