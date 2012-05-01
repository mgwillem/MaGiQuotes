package org.magi.quotes.core.configuration.control;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author MGW
 */
public class DummyCustomConfigurationProviderTest {

    @Test
    public void testGetConfiguration() throws Exception {
        Assert.assertTrue(new DummyCustomConfigurationProvider().getConfiguration().size() == 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetConfigurationReadonly() throws Exception {
        new DummyCustomConfigurationProvider().getConfiguration().clear();
    }
}
