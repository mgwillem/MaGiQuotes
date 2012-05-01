package org.magi.quotes.core.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

/**
 * @author MGW
 */
public class StringUtilTest {

    private StringUtil stringUtil;

    @Before
    public void setUp() throws Exception {
        stringUtil = new StringUtil();
    }

    @Test
    public void testToSqlLike() throws Exception {
        Assert.assertEquals("%TEST%", stringUtil.toSqlLike("test"));
    }

    @Test
    public void testDecodeUrl() throws Exception {
        Assert.assertEquals("/ab cd", stringUtil.decodeUrl(new URL("file:///ab%20cd")));
    }

    @Test
    public void testNumberOfDigit() throws Exception {
        Assert.assertEquals(6, stringUtil.numberOfDigit("abc123efg456hij"));
        Assert.assertEquals(3, stringUtil.numberOfDigit("a1b2c3"));
        Assert.assertEquals(3, stringUtil.numberOfDigit("123"));
        Assert.assertEquals(0, stringUtil.numberOfDigit("abc"));
    }

    @Test
    public void testRemoveUselessSpace() throws Exception {
        Assert.assertEquals("a b c", stringUtil.removeUselessSpace("a b c"));
        Assert.assertEquals("a b c", stringUtil.removeUselessSpace("a b c "));
        Assert.assertEquals("a b c", stringUtil.removeUselessSpace("a   b   c"));
    }
}
