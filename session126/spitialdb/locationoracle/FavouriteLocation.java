

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;


@Entity
@Table(name = "FAVOURITE_LOCATIONS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "uuid", column = @Column(name = "UUID"))
})

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteLocation extends BaseEntity {

    @Column(name = "TITLE", unique = true)
    private String title;

    @Column(name = "POINT")
    private Point<G2D> point;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "customer_id")
    private CustomerV2 customer;

}
