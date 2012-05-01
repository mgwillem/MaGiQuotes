package org.magi.quotes.core.configuration.boundary;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author MGW
 */
@ApplicationScoped
public class ConfigurationUtil 
{
    public String dump(Map<ConfigurationItemType, ConfigurationItem> configurationMap)
    {
        List<String> configurationList = new ArrayList<String>();
        
        for (ConfigurationItem value : configurationMap.values())
        {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getConfigurationItemType().getName());
            sb.append('=');
            sb.append(value.getUsedValue());
            
            configurationList.add(sb.toString());
        }
        
        Collections.sort(configurationList);
        
        StringBuilder sb = new StringBuilder();
        for (String item : configurationList)
        {
            sb.append(item);
            sb.append('\n');
        }
        
        return sb.toString();
    }
}
