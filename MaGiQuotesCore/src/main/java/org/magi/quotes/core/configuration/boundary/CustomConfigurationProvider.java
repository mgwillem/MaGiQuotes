package org.magi.quotes.core.configuration.boundary;

import java.util.Map;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public interface CustomConfigurationProvider {

    public Map<ConfigurationItemType, String> getConfiguration();

}
