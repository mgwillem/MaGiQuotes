package org.magi.quotes.presentation;

import org.magi.quotes.Query;
import org.magi.quotes.QueryModel;
import org.magi.quotes.QueryModelType;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@Named
@SessionScoped
public class QueryWizardBean implements Serializable {
    
    @Inject @QueryModelType 
    private QueryModel queryModel;

    private transient HtmlPanelGrid wizard;

    public HtmlPanelGrid getWizard() {
        loadWizard();
        return wizard;
    }

    public void setWizard(HtmlPanelGrid wizard) {
        this.wizard = wizard;
        loadWizard();
    }

    private void loadWizard() {
        if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE && wizard != null) {

            wizard.getChildren().clear();
            wizard.setColumns(1);

            for (Query query : queryModel.getModel()) {

                HtmlOutputText label = new HtmlOutputText();
                label.setValue(query.getProduct().getDescription());
                label.setTransient(true);
                label.setId("lbl-cat-" + query.getId());
                wizard.getChildren().add(label);

                HtmlPanelGrid grid = new HtmlPanelGrid();
                grid.setColumns(2);
                grid.setStyle("margin-left:20px");
                grid.setId("grid-" + query.getId());
                wizard.getChildren().add(grid);

                for (Query queryItem : query.getQueries()) {
                    HtmlOutputText labelItem = new HtmlOutputText();
                    labelItem.setValue(queryItem.getProduct().getDescription());
                    labelItem.setTransient(true);
                    labelItem.setId("lbl-item-" + queryItem.getId());

                    HtmlInputText inputItem = new HtmlInputText();
                    ((HtmlInputText)inputItem).setSize(10);
                    inputItem.setTransient(true);
                    inputItem.setId("inp-" + queryItem.getId());

                    grid.getChildren().add(labelItem);
                    grid.getChildren().add(inputItem);
                }
            }
        }
    }
}
