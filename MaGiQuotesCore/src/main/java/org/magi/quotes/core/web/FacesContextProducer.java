package org.magi.quotes.core.web;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class FacesContextProducer
{
    @Produces @RequestScoped @Context
    public FacesContext getFacesContext()
    {
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (ctx == null) throw new ContextNotActiveException("Context is not active");
        
        return ctx;
    }
}
