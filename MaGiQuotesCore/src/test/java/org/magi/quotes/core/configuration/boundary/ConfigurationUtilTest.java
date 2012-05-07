package org.magi.quotes.core.configuration.boundary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Map;

import static org.magi.quotes.core.configuration.boundary.ConfigurationItemType.MONITORING_CONSOLE_ACTIVATED;
import static org.magi.quotes.core.configuration.boundary.ConfigurationItemType.MONITORING_JMX_ACTIVATED;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ConfigurationUtilTest {

    @Mock
    private Map<ConfigurationItemType, ConfigurationItem> configurationMap;
    
    private ConfigurationUtil configurationUtil;

    @Before
    public void setUp() throws Exception {
        configurationUtil = new ConfigurationUtil();
    }

    @Test
    public void testDump() {
        stub(configurationMap.values()).toReturn(new ArrayList<ConfigurationItem>() {{
            add(new ConfigurationItem(MONITORING_JMX_ACTIVATED, "true"));
            add(new ConfigurationItem(MONITORING_CONSOLE_ACTIVATED, "false"));
        }});
        
        String dump = configurationUtil.dump(configurationMap);

        Assert.assertNotNull(dump);
        Assert.assertTrue(dump.length() > 0);

        verify(configurationMap, times(1)).values();
    }
}
