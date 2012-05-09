package org.magi.quotes.core.web;

import org.primefaces.component.calendar.Calendar;

import javax.faces.component.UIInput;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class PostValidationListener implements SystemEventListener
{
    @Override
    public boolean isListenerForSource(Object source)
    {
        return true;
    }

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException
    {
        UIInput source = (UIInput) event.getSource();
        if (!source.isValid())
        {
            if (source instanceof Calendar) ((Calendar)source).setStyleClass("ui-input-invalid");
            else source.getAttributes().put("styleClass", "ui-input-invalid");
        }
        else
        {
            if (source instanceof Calendar) ((Calendar)source).setStyleClass("ui-input-valid");
            else source.getAttributes().put("styleClass", "ui-input-valid");
        }
    }
}
