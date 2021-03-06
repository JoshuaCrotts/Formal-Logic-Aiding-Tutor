package com.flat.view.main.panes.right.children.selection.children.selections.buttons.practice;

import com.flat.controller.Controller;
import com.flat.models.data.miscellaneous.ButtonsLabels;
import com.flat.view.main.panes.right.children.selection.children.selections.buttons.practice.events.PracticeSelectionButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeSelectionButton extends Button {

    public PracticeSelectionButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.PRACTICE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.PRACTICE).fontProperty());
        super.setMinWidth(80);
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new PracticeSelectionButtonPressed());
        });
    }

}