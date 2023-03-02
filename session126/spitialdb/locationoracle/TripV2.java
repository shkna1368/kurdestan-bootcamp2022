

import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "b_tripV2")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
        @AttributeOverride(name = "uuid", column = @Column(name = "uuid"))})
@Data
public class TripV2 extends BaseEntity {

    @Column(name = "duration")
    private Long duration;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    @JoinColumn(name = "customer_vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    @JoinColumn(name = "customer_trip_id", nullable = false)
    private CustomerV2 customer;

    @Column(name = "invoice_time")
    private Long invoiceTime;

    @Column(name = "distance")
    private Long distance;

    @Column(name = "rent_amount")
    private Long rentAmount;

    @Column(name = "revision_total_amount")
    private Long revisionTotalAmount;

    @Column(name = "end_location")
    private Point<G2D> endLocation;

    @Column(name = "score")
    private Long score;

    @Column(name = "end_address")
    private String endAddress;

    @Column(name = "tax_percent")
    private Integer taxPercent;

    @Column(name = "lock")
    private VehicleLock lock;

    @Column(name = "discount_value")
    private BigDecimal discountValue;

    @Column(name = "status", columnDefinition = "smallint")
    @Enumerated
    private StatusVehicleEnum statusEnum;

    @Column(name = "start_address")
    private String startAddress;

    @Column(name = "payment_time")
    private Long paymentTime;

    @Column(name = "calorie")
    private Long calorie;

    @Column(name = "revision_invoice_no")
    private Long revisionInvoiceNo;

    @Column(name = "end_time")
    private Long endTime;

    @Column(name = "start_location")
    private Point<G2D> startLocation;

    @Column(name = "start_time")
    private Long statTime;

    @Column(name = "payable_amount")
    private BigDecimal payableAmount;

    @Column(name = "carbon")
    private Long carbon;

    @Column(name = "changeStatusTime")
    private Long changeStatusTime;

    @Column(name = "invoice_no")
    private Long invoiceNo;

    @Column(name = "revision_sys_time")
    private Long revisionSysTime;

    @OneToMany( mappedBy = "trip")
    private List<TripPicture> tripPictures;

    @OneToMany(mappedBy = "trip")
    private List<TripStatusLog> tripStatusLogs;


    @OneToOne(mappedBy = "trip")
    private ReserveVehicle reserveVehicle;


    @Column(name = "pause_time")
    private Long pauseTime;

    @Column(name = "duration_pause")
    private Long durationPause;

    @Column(name = "stop_location")
    private Point<G2D> stopLocation;

}
