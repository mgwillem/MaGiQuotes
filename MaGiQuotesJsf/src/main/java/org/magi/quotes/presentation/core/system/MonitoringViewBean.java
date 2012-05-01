package org.magi.quotes.presentation.core.system;

import org.magi.quotes.core.configuration.boundary.Configuration;
import org.magi.quotes.core.configuration.boundary.ConfigurationItem;
import org.magi.quotes.core.configuration.boundary.ConfigurationItemComparator;
import org.magi.quotes.core.configuration.boundary.ConfigurationItemType;
import org.ocpsoft.pretty.time.PrettyTime;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

/**
 * @author MGW
 */
@Named(value="monitoringViewBean")
@RequestScoped
public class MonitoringViewBean implements Serializable
{
    private @Inject Configuration configuration;

    public String getUptimeInfo() {
//        PrettyTime p = new PrettyTime();
//        return p.format(new Date(configuration.getUptimeInfo()));

        return configuration.getUptimeInfo();
    }
}
