package org.magi.quotes.core.audit.control;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class LoggerFactory implements Serializable
{
    @Produces @Slf4j
    protected Logger createLogger(InjectionPoint injectionPoint)
    {
        String name = injectionPoint.getMember().getDeclaringClass().getName();
        return org.slf4j.LoggerFactory.getLogger(name);
    }
}
