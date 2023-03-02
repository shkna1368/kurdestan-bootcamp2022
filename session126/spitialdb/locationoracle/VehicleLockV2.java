

import lombok.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "B_LOCK_V2")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
        @AttributeOverride(name = "uuid", column = @Column(name = "uuid"))})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleLockV2 extends BaseEntity  {

    @Column(name = "lock_serial", unique = true)
    private String lockSerial;

    @Column(name = "longtiude")
    private Double longitude;

    @Column(name = "last_trip")
    private TripV2 lastTrip;

    @Column(name = "occur_time")
    private Long occurTime;

    @Column(name = "hardware_version")
    private String hardwareVersion;

    @Column(name = "config_version")
    private String configVersion;

    @Column(name = "change_status_time")
    private Long changeStatusTime;

    @Column(name = "lock_status")
    private Boolean lockStatus;

    @Column(name = "battery_power")
    private Integer batteryPower;

    @Column(name = "mac", unique = true)
    private String macAddress;

    @Column(name = "last_location")
    private Point<G2D> lastLocation;

    @Column(name = "software_version")
    private String softwareVersion;

    @Column(name = "last_Customer")
    private CustomerV2 lastCustomer;

    @Column(name = "service_caller")
    private Boolean serviceCaller;

    @Column(name = "gsm_signal")
    private Integer gsmSignal;

    @Column(name = "sys_time")
    private Long sysTime;

    @Column(name = "ble_version")
    private String bleVersion;

    @Column(name = "latitude")
    private Double latitude;

    private VehicleV2 vehicle;

}
