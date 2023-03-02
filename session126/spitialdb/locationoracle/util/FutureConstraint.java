
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TimeValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FutureConstraint {
    String message() default "The input time must be the future!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
