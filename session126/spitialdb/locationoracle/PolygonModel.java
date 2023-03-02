

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ir.pakcharkh.bdood.core.model.enums.PolygonEnum;
import ir.pakcharkh.bdood.core.util.PolygonSerializer;
import lombok.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Polygon;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "INF_POLYGON_MODEL")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "uuid", column = @Column(name = "UUID"))
})

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data

public class PolygonModel extends BaseEntity {


    @NotNull
    @NotBlank
    @Column(name = "TITLE", unique = true)
    @NotEmpty(message = "title is required")
    private String title;


    @JsonSerialize(using = PolygonSerializer.class)
    @Column(name = "POLYGON")
    private Polygon<G2D> polygon;


    @ManyToOne
    @JoinColumn
    private Area area;


    @ManyToOne
    @JoinColumn
    private City city;


    @Column(name = "polygonType", columnDefinition = "smallint")
    @Enumerated
    private PolygonEnum polygonEnum;


    @Transient
    private List<Translate> translates;

    @Transient
    private UUID cityId;

    @Transient
    private UUID areaId;

    @Transient
    private UUID polygonId;

    @Override
    public String toString() {
        return super.toString();
    }

}
