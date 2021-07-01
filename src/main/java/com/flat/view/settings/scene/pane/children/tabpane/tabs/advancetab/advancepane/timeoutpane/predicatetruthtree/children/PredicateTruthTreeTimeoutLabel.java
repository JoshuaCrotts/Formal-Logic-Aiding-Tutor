package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree.children;

import com.flat.view.viewdata.SettingsData;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PredicateTruthTreeTimeoutLabel extends Label {

    public PredicateTruthTreeTimeoutLabel () {
        super.textProperty().bind(SettingsData.getPredicateTruthTree().textProperty());
    }

}