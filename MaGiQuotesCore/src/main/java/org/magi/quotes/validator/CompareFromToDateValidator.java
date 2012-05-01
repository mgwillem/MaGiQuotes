package org.magi.quotes.validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

/**
 * @author MGW
 */
public class CompareFromToDateValidator implements ConstraintValidator<CompareFromToDate, Object>
{
    private String[] propertyNames;
    private boolean allowNull;

    @Override
    public void initialize(CompareFromToDate constraintAnnotation)
    {
        this.propertyNames = constraintAnnotation.propertyNames();
        this.allowNull = constraintAnnotation.allowNull();
    }

    @Override
    public boolean isValid(Object target, ConstraintValidatorContext context)
    {
        List<Date> propertyValues = new ArrayList<Date> (propertyNames.length);
        if (!retrieveProperties(propertyValues, target))
        {
            createErrorMessage(propertyNames[0] + " or " + propertyNames[1] + " cannot be null", context);
            return false;
        }

        if (!validate(propertyValues))
        {
            createErrorMessage("error.date_from.date_to.invalid", context);
            return false;
        }

        return true;
    }

    private void createErrorMessage(String errorMessage, ConstraintValidatorContext context)
    {
        boolean isDefaultMessage = "".equals(context.getDefaultConstraintMessageTemplate());
        /* if custom message was provided, don't touch it, otherwise build the default message */
        if (isDefaultMessage)
        {
            context.disableDefaultConstraintViolation();

            ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(errorMessage);
            violationBuilder.addConstraintViolation();
        }
    }

    private boolean retrieveProperties(List<Date> propertyValues, Object target)
    {
        for (int i=0; i < propertyNames.length; i++)
        {
            Date propertyValue = ConstraintValidatorHelper.getPropertyValue(Date.class, propertyNames[i], target);

            if (propertyValue == null)
            {
                if (!allowNull)
                {
                    return false;
                }
            }
            else
            {
                propertyValues.add(propertyValue);
            }
        }

        return true;
    }

    private boolean validate(List<Date> propertyValues)
    {
        Date from = null;
        Date to = null;

        if (propertyValues.size() > 0) from = propertyValues.get(0);
        if (propertyValues.size() > 1) to = propertyValues.get(1);

        if (from == null) return true;
        if (to == null) return true;

        if (to.before(from)) return false;

        return true;
    }
}
