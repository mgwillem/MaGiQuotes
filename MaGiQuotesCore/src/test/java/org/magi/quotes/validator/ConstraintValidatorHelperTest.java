package org.magi.quotes.validator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author MGW
 */
public class ConstraintValidatorHelperTest {

    @Test
    public void testGetPropertyValue() throws Exception {
        Date value = ConstraintValidatorHelper.getPropertyValue(Date.class, "myDate", new FindProperty());
        Assert.assertNotNull(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPropertyValueInvalid() throws Exception {
        Date value = ConstraintValidatorHelper.getPropertyValue(Date.class, "xyzDate", new FindProperty());
        Assert.assertNotNull(value);
    }

    class FindProperty {
        Date myDate = new Date();

        public Date getMyDate() {
            return myDate;
        }

        public void setMyDate(Date myDate) {
            this.myDate = myDate;
        }
    }
}
