package org.magi.quotes.presentation.core.system;

import org.magi.quotes.core.configuration.boundary.Configuration;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
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
