

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "INF_CITY")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "uuid", column = @Column(name = "UUID"))
})


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@Data
public class City extends BaseEntity {


    @NotNull
    @NotBlank
    @NotEmpty(message = "defaultTitle is required")
    @Column(name = "DEFAULT_TITLE", unique = true)
    private String defaultTitle;


    @Column(name = "CENTER_LOCATION")
    private Point<G2D> centerLocation;


    //////////////////////


    @ManyToOne
    @JoinColumn
    private Province province;


    ////////////////////////


//    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<CityTranslate> translates;



    @JsonIgnore
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CompanyLocation> companyLocations;


    @JsonIgnore
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PayPriceDefinition> payPriceDefinitions;


    @JsonIgnore
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CompanyAssets> companyAssets;


    @JsonIgnore
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Area> areas;


    @JsonIgnore
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PolygonModel> polygonModels;

    ////////////////////////


    @Transient
    private Location cityCenterLocation;

    @Transient
    private UUID provinceId;


    @Transient
    private List<Translate> translates;

    @Override
    public String toString() {
        return super.toString();
    }

}
