package org.magi.quotes.presentation;

import org.magi.quotes.Query;
import org.primefaces.component.watermark.Watermark;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import java.io.Serializable;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class QueryWizardComponentFactory implements Serializable {

    public HtmlOutputText createHtmlOutputText(Query query, String idPrefix) {
        HtmlOutputText label = new HtmlOutputText();
        label.setValue(query.getProduct().getDescription());
        label.setTransient(true);
        label.setId(idPrefix + query.getId());

        return label;
    }

    public HtmlPanelGrid createHtmlPanelGrid(Query query, String idPrefix, int columns, String cssStyle) {
        HtmlPanelGrid grid = new HtmlPanelGrid();
        grid.setColumns(columns);
        grid.setStyle(cssStyle);
        grid.setTransient(true);
        grid.setId(idPrefix + query.getId());

        return grid;
    }

    public HtmlInputText createHtmlInputText(Query query, String idPrefix, int size) {
        HtmlInputText inputItem = new HtmlInputText();
        inputItem.setSize(size);
        inputItem.setTransient(true);
        inputItem.setId(idPrefix + query.getId());
        inputItem.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void processValueChange(ValueChangeEvent valueChangeEvent) throws AbortProcessingException {
                System.out.println(":::processValueChange:::" + ((HtmlInputText) valueChangeEvent.getSource()).getId() + " " + valueChangeEvent.getNewValue() + " " + valueChangeEvent.getOldValue());
            }
        });

        return inputItem;
    }

    public Watermark createWatermark(Query query, String idPrefix, String forIdPrefix) {
        Watermark watermark = new Watermark();
        watermark.setId(idPrefix + query.getId());
        watermark.setFor(forIdPrefix + query.getId());
        watermark.setTransient(true);
        watermark.setValue(query.getProduct().getPriceType().getDescription());

        return watermark;
    }

    public HtmlCommandButton createHtmlCommandButton(Query query, String idPrefix, String value) {
        HtmlCommandButton button = new HtmlCommandButton();
        button.setValue(value);
        button.setTransient(true);
        button.setId(idPrefix + query.getId());

        return button;
    }

}
