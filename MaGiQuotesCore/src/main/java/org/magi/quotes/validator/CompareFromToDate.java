package org.magi.quotes.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy=CompareFromToDateValidator.class)
@Documented
public @interface CompareFromToDate
{
    String[] propertyNames();
    boolean allowNull() default true;
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
