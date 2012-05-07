package org.magi.quotes.core.util;

import javax.enterprise.context.ApplicationScoped;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@ApplicationScoped
public class StringUtil
{
    public String toSqlLike(String value)
    {
        StringBuilder sb = new StringBuilder();

        sb.append('%');
        sb.append(value.toUpperCase());
        sb.append('%');

        return sb.toString();
    }

    public String decodeUrl(URL url)
    {
        try
        {
            return URLDecoder.decode(url.getFile(), "UTF-8");
        }
        catch (UnsupportedEncodingException ex)
        {
            return url.getFile();
        }
    }

    public int numberOfDigit(String text)
    {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(text);

        StringBuilder sb = new StringBuilder();

        while (matcher.find())
            sb.append(text.substring(matcher.start(), matcher.end()));

        return sb.length();
    }

    public String removeUselessSpace(String string)
    {
        return string.replaceAll("\\s+", " ").trim();
    }
}
