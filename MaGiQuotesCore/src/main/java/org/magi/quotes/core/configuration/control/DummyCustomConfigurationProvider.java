package org.magi.quotes.core.configuration.control;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.magi.quotes.core.configuration.boundary.ConfigurationItemType;
import org.magi.quotes.core.configuration.boundary.CustomConfigurationProvider;

/**
 * @author MGW
 */
public class DummyCustomConfigurationProvider implements CustomConfigurationProvider {

    public Map<ConfigurationItemType, String> getConfiguration() {
        return Collections.unmodifiableMap(new HashMap<ConfigurationItemType, String>());
    }

}
