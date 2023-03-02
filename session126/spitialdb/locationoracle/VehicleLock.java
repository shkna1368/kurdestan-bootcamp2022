

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "B_LOCK")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "lock_id")),
        @AttributeOverride(name = "uuid", column = @Column(name = "lock_uuid"))})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleLock extends BaseEntity {

    @Column(name = "lock_serial", unique = true)
    private String lockSerial;

    @Column(name = "longtiude")
    private Double longitude;

    @Column(name = "occur_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date occurTime;

    @Column(name = "hardware_version")
    private String hardwareVersion;

    @Column(name = "config_version")
    private String configVersion;

    @Column(name = "change_status_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeStatusTime;

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

    @Column(name = "service_caller")
    private Boolean serviceCaller;

    @Column(name = "gsm_signal")
    private Integer gsmSignal;

    @Column(name = "sys_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sysTime;

    @Column(name = "ble_version")
    private String bleVersion;

    @Column(name = "latitude")
    private Double latitude;

    @OneToOne(mappedBy = "vehicleLock")
    private Vehicle vehicle;


    @Transient
    private UUID vehicleLockId;

    @Override
    public String toString() {
        return super.toString();
    }
}
