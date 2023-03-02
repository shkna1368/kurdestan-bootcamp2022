
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteLocationDTO {

    @NotBlank
    @ApiModelProperty(required = true)
    private String title;

    @NotBlank
    @ApiModelProperty(required = true)
    private PointDTO pointDTO;
}
