package org.magi.quotes.core.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author MGW
 */
public final class EjbUtil 
{
    private static final String EJB_CONTEXT;
    
    static 
    {
        try
        {
            // Thanks to Java EE 6, it is possible to obtain the application name from JNDI.
            EJB_CONTEXT = "java:global/" + new InitialContext().lookup("java:app/AppName") + "/";
        }
        catch (NamingException e)
        {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    private EjbUtil() 
    {
        // utility class, nothing to do
    }
    
    public static <T> T lookup(Class<T> ejbClass)
    {
        String jndiName = EJB_CONTEXT + ejbClass.getSimpleName();

        try
        {
            return (T)new InitialContext().lookup(jndiName);
        }
        catch (NamingException e)
        {
            throw new IllegalArgumentException(String.format("Cannot find EJB class %s in JNDI %S", ejbClass, jndiName));
        }
    }
}

