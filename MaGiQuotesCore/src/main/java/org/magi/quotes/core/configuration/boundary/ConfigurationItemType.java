package org.magi.quotes.core.configuration.boundary;

import java.io.Serializable;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public enum ConfigurationItemType implements Serializable
{
    MONITORING_JMX_ACTIVATED("jmxMonitoringActivated", "Monitoring feature - activate or desactivate the JMX monitoring"),
    MONITORING_CONSOLE_ACTIVATED("consoleMonitoringActivated", "Monitoring feature - activate or desactivate the console monitoring");

    private final String name;
    private final String description;
    
    private ConfigurationItemType(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public static ConfigurationItemType get(String name)
    {
        for (ConfigurationItemType type : values())
        {
            if (type.getName().equalsIgnoreCase(name)) return type;
        }
        
        return null;
    }
}
