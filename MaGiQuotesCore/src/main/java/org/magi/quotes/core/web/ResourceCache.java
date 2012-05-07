package org.magi.quotes.core.web;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@ApplicationScoped
public class ResourceCache implements Serializable
{
    private List<String> resourcesCached;

    @PostConstruct
    protected void init()
    {
        resourcesCached = Collections.synchronizedList(new ArrayList<String>() {{
            add("theme.css");
            add("primefaces.css");
            add("layout.css");

            add("jquery.js");
            add("primefaces.js");
            add("layout.js");
            add("jsf.js");

            add(".gif");
            add(".png");
            add(".jpg");
        }});        
    }
    
    public boolean isCached(String resourceUri)
    {
        for (String resourceCached : resourcesCached.toArray(new String[resourcesCached.size()]))
        {
            if (resourceUri.endsWith(resourceCached)) return true;
        }

        return false;
    }
}
