package org.magi.quotes.core.web;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class NavigationHistoryUtil 
{
    private static final String facesPrefix = "/faces";
    private static final String facesSuffix = ".xhtml";
    
    public static String extractViewId(String uri)
    {
        if (uri == null) return null;
        
        if (uri.contains(facesPrefix))
        {
            uri = uri.substring(uri.indexOf(facesPrefix) + facesPrefix.length());
        }
        
        if (uri.contains(facesSuffix))
        {
            uri = uri.substring(0, uri.indexOf(facesSuffix));
        }
        
        return uri;
    }
}
