package org.magi.quotes.core.audit.control;

import java.net.URL;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@Singleton
@Startup
public class Log4jConfigurator 
{
    private static final String LOG4J_XML = "log4j.xml";

    @PostConstruct
    protected void startup()
    { 
        try
        {
            URL url = this.getClass().getResource(LOG4J_XML);
            if (url == null || url.getFile().length() == 0) 
            {
                throw new RuntimeException("Log4j config file "+ LOG4J_XML +" not found");
            }
            
            DOMConfigurator.configure(url);

            Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
            logger.info("logger initialized with " + LOG4J_XML + "...");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            throw new RuntimeException("Log4j configurator cannot be started", e);
        }
    }
}
