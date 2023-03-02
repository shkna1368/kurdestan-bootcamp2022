
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TimeValidator implements ConstraintValidator<FutureConstraint, Long> {

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        if(System.currentTimeMillis() < aLong)
            return true;
        else
            return false;
    }

    @Override
    public void initialize(FutureConstraint constraintAnnotation) {

    }
}

