
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IranianNationalCodeValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IranianNationalCode {

    String message() default "Invalid National code!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
