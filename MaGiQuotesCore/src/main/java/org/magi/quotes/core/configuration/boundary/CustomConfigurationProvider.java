package org.magi.quotes.core.configuration.boundary;

import java.util.Map;

/**
 * @author MGW
 */
public interface CustomConfigurationProvider {

    public Map<ConfigurationItemType, String> getConfiguration();

}
