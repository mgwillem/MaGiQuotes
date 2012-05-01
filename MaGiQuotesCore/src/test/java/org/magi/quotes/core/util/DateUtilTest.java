package org.magi.quotes.core.util;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @author MGW
 */
public class DateUtilTest 
{
    private DateUtil dateUtil;

    @Before
    public void setUp() {
        dateUtil = new DateUtil();
        dateUtil.init();
    }

    @Test
    public void testDateTime() 
    {
        String formattedDate = dateUtil.formatDateTime(new Date());
        
        Assert.assertNotNull(formattedDate);
        Assert.assertTrue("Unexpected date/time value length", formattedDate.length() == 19);
    }
}
