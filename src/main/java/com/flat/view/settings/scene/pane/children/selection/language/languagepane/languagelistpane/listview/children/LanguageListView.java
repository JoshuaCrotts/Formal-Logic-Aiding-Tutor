package com.flat.view.settings.scene.pane.children.selection.language.languagepane.languagelistpane.listview.children;

import com.flat.controller.Controller;
import com.flat.models.json.language.JsonLanguage;
import javafx.scene.control.ListView;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageListView extends ListView {
    private static JsonLanguage selectedLanguage;

    public LanguageListView() {
        super.getItems().addAll(Controller.FX_DATA.getLanguages().getLanguages());
        super.setCellFactory(param -> new LanguageListCell());
        this.setOnMouseClicked();
    }

    // Getters for object's attributes.
    public static JsonLanguage getSelectedLanguage() {
        return selectedLanguage;
    }

    private void setOnMouseClicked() {
        super.setOnMouseClicked(event -> {
            LanguageListView.selectedLanguage = (JsonLanguage) super.getSelectionModel().getSelectedItem();
        });
    }

}