package org.magi.quotes.core.util;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@RequestScoped
public class DateUtil implements Serializable
{
    private SimpleDateFormat dateTimeFormat;

    @PostConstruct
    protected void init() {
        dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
    }

    public String formatDateTime(Date value)
    {
        if (value == null) return null;
        return dateTimeFormat.format(value);
    }
}
