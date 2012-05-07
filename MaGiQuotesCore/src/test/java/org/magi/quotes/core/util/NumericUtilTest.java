package org.magi.quotes.core.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class NumericUtilTest {

    private NumericUtil numericUtil;

    @Before
    public void setUp() throws Exception {
        numericUtil = new NumericUtil();
        numericUtil.init();
    }

    @Test
    public void testFormatAmount() throws Exception {
        Assert.assertEquals("0.00", numericUtil.formatAmount(BigDecimal.ZERO));
    }
}
