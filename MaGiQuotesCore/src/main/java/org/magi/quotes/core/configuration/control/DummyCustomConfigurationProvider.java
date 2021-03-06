package org.magi.quotes.core.configuration.control;

import org.magi.quotes.core.configuration.boundary.ConfigurationItemType;
import org.magi.quotes.core.configuration.boundary.CustomConfigurationProvider;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class DummyCustomConfigurationProvider implements CustomConfigurationProvider {

    public Map<ConfigurationItemType, String> getConfiguration() {
        return Collections.unmodifiableMap(new HashMap<ConfigurationItemType, String>());
    }

}
