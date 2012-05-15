package org.magi.quotes.presentation;

import org.magi.quotes.Query;
import org.magi.quotes.QueryModel;
import org.magi.quotes.QueryModelType;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
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

    @Inject
    private QueryWizardComponentFactory queryWizardComponentFactory;

    private transient HtmlPanelGrid wizard;
    private int wizardIndex;

    @PostConstruct
    protected void init() {
        wizardIndex = 0;
    }

    public HtmlPanelGrid getWizard() {
        if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE && wizard != null) {
            loadWizard();
        }
        return wizard;
    }

    public void setWizard(HtmlPanelGrid wizard) {
        this.wizard = wizard;
        if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE && wizard != null) {
            loadWizard();
        }
    }

    private void loadWizard() {
        System.out.println(":::loadWizard:::");

        wizard.getChildren().clear();
        wizard.setColumns(1);

        wizard.getChildren().add(queryWizardComponentFactory.createHtmlOutputText(queryModel.getModel().get(wizardIndex), "lbl-cat-"));
        wizard.getChildren().add(createOneQuestionGrid(queryModel.getModel().get(wizardIndex)));
    }

    private HtmlPanelGrid createOneQuestionGrid(Query query) {
        HtmlPanelGrid grid = queryWizardComponentFactory.createHtmlPanelGrid(query, "grid-", 4, "margin-left:20px");

        for (Query queryItem : query.getQueries()) {
            grid.getChildren().add(queryWizardComponentFactory.createHtmlOutputText(queryItem, "lbl-item"));
            grid.getChildren().add(queryWizardComponentFactory.createHtmlInputText(queryItem, "inp-", 10));
            grid.getChildren().add(queryWizardComponentFactory.createWatermark(queryItem, "wat-", "inp-"));

            HtmlCommandButton button = queryWizardComponentFactory.createHtmlCommandButton(queryItem, "cbutton-", "Add");
            grid.getChildren().add(button);

            button.setActionExpression(
                    FacesContext.getCurrentInstance().getApplication().getExpressionFactory().createMethodExpression(
                            FacesContext.getCurrentInstance().getELContext(), "#{queryWizardBean.next}", String.class, new Class[0]));
        }

        return grid;
    }

    public String next() {
        System.out.println(":::next:::");

        wizardIndex ++;
        if (wizardIndex < queryModel.getModel().size()) {
            loadWizard();
        }

        return null;
    }
}
