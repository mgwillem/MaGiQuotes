package org.magi.quotes.presentation.core.system;

import org.magi.quotes.core.configuration.boundary.Configuration;
import org.magi.quotes.core.configuration.boundary.ConfigurationItem;
import org.magi.quotes.core.configuration.boundary.ConfigurationItemComparator;
import org.magi.quotes.core.configuration.boundary.ConfigurationItemType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@Named(value="configurationViewBean")
@RequestScoped
public class ConfigurationViewBean implements Serializable
{
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationViewBean.class);

    @Inject
    private Configuration configuration;

    private ListDataModel<ConfigurationItem> dataModel;

    @PostConstruct
    public void init()
    {
        logger.info("init called");

        dataModel = new ListDataModel<ConfigurationItem>();
        dataModel.setWrappedData(createWrappedData());
    }
    
    private List<ConfigurationItem> createWrappedData()
    {
        Map<ConfigurationItemType, ConfigurationItem> configurationMap = configuration.getConfigurationMap();

        List<ConfigurationItem> configurationList = new ArrayList<ConfigurationItem>(configurationMap.values());
        Collections.sort(configurationList, new ConfigurationItemComparator());
        
        return configurationList;
    }

    public ListDataModel<ConfigurationItem> getModel()
    {
        if (dataModel == null) init();
        return dataModel;
    }
}
