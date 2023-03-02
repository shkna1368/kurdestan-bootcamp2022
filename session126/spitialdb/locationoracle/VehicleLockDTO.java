

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;


@Data
public class VehicleLockDTO {

    @ApiModelProperty(required = false, hidden = true)
    private UUID vehicleLockId;

    @ApiModelProperty(required = true)
    private String lockSerial;
    //    private Double longitude;
    //    private Date occurTime;

    @ApiModelProperty(required = true)
    private String hardwareVersion;

    @ApiModelProperty(required = true)
    private String configVersion;
    //    private Date changeStatusTime;
    //    private Boolean lockStatus;

    @ApiModelProperty(required = true)
    private Integer batteryPower;

    @ApiModelProperty(required = true)
    private String macAddress;
    //    private Point<G2D> lastLocation;
    //    private String softwareVersion;

    @ApiModelProperty(required = true)
    private Boolean serviceCaller;


    @ApiModelProperty(required = true)
    private Integer gsmSignal;
    //    private Date sysTime;

    @ApiModelProperty(required = true)
    private String bleVersion;
    //    private Double latitude;
    //    private Vehicle vehicle;

    @Override
    public String toString() {
        return super.toString();
    }

}
