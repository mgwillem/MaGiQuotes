package org.magi.quotes.core.audit.boundary;

import org.magi.quotes.core.configuration.boundary.Configuration;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.lang.management.ManagementFactory;

/**
 * @author MGW
 */
@Singleton
@Startup
public class MonitoringApplication implements MonitoringApplicationMXBean
{
    @Inject
    private Configuration configuration;

    @PostConstruct
    protected void register()
    {
        try
        {
            ObjectName objectName = new ObjectName(createObjectName());
            MBeanServer platformBeanServer = ManagementFactory.getPlatformMBeanServer();

            if (platformBeanServer.isRegistered(objectName)) platformBeanServer.unregisterMBean(objectName);

            platformBeanServer.registerMBean(this, objectName);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Unexpected error during registration to JMX", e);
        }
    }
    
    private String createObjectName() throws NamingException
    {
        StringBuilder sb = new StringBuilder();
        sb.append(new InitialContext().lookup("java:app/AppName"));
        sb.append("Monitoring:type=");
        sb.append(this.getClass().getName());
        
        System.out.println(":::" + sb.toString());
        return sb.toString();
    }

    @Override
    public String getUptimeInfo() {
        return configuration.getUptimeInfo();
    }
}
