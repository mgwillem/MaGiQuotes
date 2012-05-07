package org.magi.quotes.core.configuration.boundary;

import java.util.Comparator;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class ConfigurationItemComparator implements Comparator<ConfigurationItem> 
{
    @Override
    public int compare(ConfigurationItem o1, ConfigurationItem o2) 
    {
        return o1.getConfigurationItemType().getName().compareToIgnoreCase(o2.getConfigurationItemType().getName());
    }
}
