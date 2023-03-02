

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileConstraintValidator implements ConstraintValidator<Mobile, String> {

    @Override
    public boolean isValid(String mobileNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(mobileNumber.trim().length()> 20 || mobileNumber.trim().length()< 11)
            throw ServerExceptionMultiLanguageHelper.getMessage(ExceptionType.numberFormatException, "English");
        return true;
    }
}
