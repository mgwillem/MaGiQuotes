package org.magi.quotes.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class CompareFromToDateValidatorTest {

    private Validator validator;

    @Before
    public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testValidFromToDate() {
        Set<ConstraintViolation<ValidFromToDate>> validFromToDateConstraintViolation = validator.validate(new ValidFromToDate());
        Assert.assertTrue(validFromToDateConstraintViolation.isEmpty());
    }

    @Test
    public void testInvalidFromToDate() {
        Set<ConstraintViolation<InvalidFromToDate>> validFromToDateConstraintViolation = validator.validate(new InvalidFromToDate());
        Assert.assertFalse(validFromToDateConstraintViolation.isEmpty());
    }

    @CompareFromToDate(propertyNames = {"dateFrom", "dateTo"})
    class ValidFromToDate {
        Date dateFrom = new GregorianCalendar(2015,10,10).getTime();
        Date dateTo = new GregorianCalendar(2020,10,10).getTime();

        public Date getDateFrom() {
            return dateFrom;
        }

        public void setDateFrom(Date dateFrom) {
            this.dateFrom = dateFrom;
        }

        public Date getDateTo() {
            return dateTo;
        }

        public void setDateTo(Date dateTo) {
            this.dateTo = dateTo;
        }
    }

    @CompareFromToDate(propertyNames = {"dateFrom", "dateTo"})
    class InvalidFromToDate {
        Date dateFrom = new GregorianCalendar(2025,10,10).getTime();
        Date dateTo = new GregorianCalendar(2020,10,10).getTime();

        public Date getDateFrom() {
            return dateFrom;
        }

        public void setDateFrom(Date dateFrom) {
            this.dateFrom = dateFrom;
        }

        public Date getDateTo() {
            return dateTo;
        }

        public void setDateTo(Date dateTo) {
            this.dateTo = dateTo;
        }
    }
}
