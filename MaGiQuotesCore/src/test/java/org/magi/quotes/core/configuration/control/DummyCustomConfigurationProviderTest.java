package org.magi.quotes.core.configuration.control;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
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
