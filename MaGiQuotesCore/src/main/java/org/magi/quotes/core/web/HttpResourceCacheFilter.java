package org.magi.quotes.core.web;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@WebFilter(filterName="httpResourceCacheFilter", urlPatterns="/*")
public class HttpResourceCacheFilter implements Filter
{
    @Inject
    private ResourceCache resourceCache;
    
    private long maxAge;
    private long expireTime;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest hRequest = (HttpServletRequest) request;
        HttpServletResponse hResponse = (HttpServletResponse) response;

        String uri = hRequest.getRequestURI();
        if (resourceCache.isCached(uri))
        {
            hResponse.setHeader("Cache-Control", "max-age=" + maxAge);
            hResponse.setDateHeader("Expires", expireTime);
            // ?should pragma be defined too?
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException 
    {
        int numberOfDay = 1;
        
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.DAY_OF_YEAR, numberOfDay);
        expireTime = gc.getTime().getTime();
        
        maxAge = (60 * 60 * 24) * numberOfDay;
    }

    @Override
    public void destroy() 
    {
    }
}
