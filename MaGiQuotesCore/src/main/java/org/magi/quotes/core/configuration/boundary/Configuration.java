package org.magi.quotes.core.configuration.boundary;

import org.magi.quotes.core.configuration.control.DummyCustomConfigurationProvider;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.*;

import static org.magi.quotes.core.configuration.boundary.ConfigurationItemType.*;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * @author MGW
 */
@Startup
@Singleton
@Path("configuration")
@javax.ws.rs.Produces(TEXT_PLAIN)
public class Configuration 
{
    @Inject
    private CustomConfigurationProvider customConfigurationProvider;

    @Inject
    private ConfigurationUtil configurationUtil;

    @Inject
    private Logger logger;
            
    private Map<ConfigurationItemType, ConfigurationItem> configuration;
    private Set<String> unconfiguredFields;
    private Long startupTime;

    @PostConstruct
    public void fetchConfiguration()
    {
        unconfiguredFields = new HashSet<String>();
        
        // default values
        configuration = new HashMap<ConfigurationItemType, ConfigurationItem>() {{
            addConfiguration(this, new ConfigurationItem(MONITORING_JMX_ACTIVATED, "true"));
            addConfiguration(this, new ConfigurationItem(MONITORING_CONSOLE_ACTIVATED, "true"));
        }};
        
        // merge with custom configuration
        mergeWithCustomConfigurationProvider();

        startupTime = System.currentTimeMillis();
    }

    private void addConfiguration(Map<ConfigurationItemType, ConfigurationItem> configuration, ConfigurationItem item)
    {
        configuration.put(item.getConfigurationItemType(), item);
    }

    public Map<ConfigurationItemType, ConfigurationItem> getConfigurationMap()
    {
        return Collections.unmodifiableMap(configuration);
    }
    
    private void mergeWithCustomConfigurationProvider()
    {
        Map<ConfigurationItemType, String> customConfiguration = customConfigurationProvider.getConfiguration();

        for (ConfigurationItemType key : customConfiguration.keySet())
        {
            ConfigurationItem item = this.configuration.get(key);
            item.setOverridedValue(customConfiguration.get(key));
        }
    }
    
    private String retrieveValue(InjectionPoint point)
    {
        String fieldName = point.getMember().getName();
        return retrieveValue(ConfigurationItemType.get(fieldName));
    }

    private String retrieveValue(ConfigurationItemType key)
    {
        ConfigurationItem valueForKey = configuration.get(key);
        if (valueForKey == null) 
        {
            unconfiguredFields.add(key.getName());
            return null;
        }
        
        return valueForKey.getUsedValue();
    }

    public String getString(ConfigurationItemType key)
    {
        return retrieveValue(key);
    }

    @Produces
    public String getString(InjectionPoint point)
    {
        return retrieveValue(point);
    }

    public Integer getInteger(ConfigurationItemType key)
    {
        return Integer.parseInt(retrieveValue(key));
    }

    @Produces
    public Integer getInteger(InjectionPoint point)
    {
        return Integer.parseInt(retrieveValue(point));
    }
    
    @GET
    @Path("view")
    public String getConfiguration()
    {
        return configurationUtil.dump(configuration);
    }

    @GET
    @Path("reload")
    public String getConfigurationReload()
    {
        fetchConfiguration();
        return getConfiguration();
    }

    @Schedule(hour="*", minute="*", second="0,30")
    protected void displayUptimeInfo()
    {
        logger.info("Uptime: " + getUptimeInfo());
    }

    public String getUptimeInfo() {
        long uptime = (System.currentTimeMillis() - startupTime) / 1000;
        long hours = uptime / (60 * 60);
        long minutes = (uptime / 60) % 60;
        long seconds = (uptime % 60) % 60;

        StringBuilder sb = new StringBuilder();
        sb.append(hours).append(" h ");
        sb.append(minutes).append(" min ");
        sb.append(seconds).append(" sec");

        return sb.toString();
    }
}
