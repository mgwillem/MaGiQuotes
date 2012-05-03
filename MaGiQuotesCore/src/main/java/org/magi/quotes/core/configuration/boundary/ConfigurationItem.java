package org.magi.quotes.core.configuration.boundary;

import java.io.Serializable;

/**
 * @author MGW
 */
public class ConfigurationItem implements Serializable
{
    private final ConfigurationItemType configurationItemType;
    private final String defaultValue;
    private String overridedValue;
    private final Class typeClazz;

    public ConfigurationItem(ConfigurationItemType configurationItemType, String defaultValue)
    {
        this(configurationItemType, defaultValue, Long.class);
    }
    
    public ConfigurationItem(ConfigurationItemType configurationItemType, String defaultValue, Class typeClazz)
    {
        this.configurationItemType = configurationItemType;
        this.defaultValue = defaultValue;
        this.typeClazz = typeClazz;
    }

    public void setOverridedValue(String overridedValue) {
        this.overridedValue = overridedValue;
    }
    
    public String getOverridedValue() {
        return overridedValue;
    }
    
    public String getDefaultValue() {
        return defaultValue;
    }

    public String getUsedValue() {
        if (overridedValue != null) return overridedValue;
        
        return defaultValue;
    }
    
    public Class getTypeClazz() {
        return typeClazz;
    }
    
    public boolean isLong()
    {
        return typeClazz == Long.class;
    }

    public boolean isString()
    {
        return typeClazz == String.class;
    }
    
    public ConfigurationItemType getConfigurationItemType() {
        return configurationItemType;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConfigurationItem other = (ConfigurationItem) obj;

        return (this.configurationItemType == other.configurationItemType);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.configurationItemType != null ? this.configurationItemType.hashCode() : 0);
        return hash;
    }
}
