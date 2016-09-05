package beanvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by yhw on 08/26/2016.
 */
public class StatusValidator implements ConstraintValidator<Status, String> {
    private final String[] ALL_STATUS = {"created", "paid", "shipped", "closed"};

    public void initialize(Status status) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(Arrays.asList(ALL_STATUS).contains(value))
            return true;
        return false;
    }
}