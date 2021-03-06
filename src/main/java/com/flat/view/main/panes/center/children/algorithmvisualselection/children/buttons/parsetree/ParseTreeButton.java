package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.parsetree;

import com.flat.controller.Controller;
import com.flat.models.data.miscellaneous.ButtonsLabels;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.parsetree.events.ParseTreeButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreeButton extends Button {

    public ParseTreeButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setThisOnAction();
    }

    private void setThisFx () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.PARSE_TREE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.PARSE_TREE).fontProperty());
        super.setDisable(true);
        super.setMinWidth(110);
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new ParseTreeButtonPressed());
        });
    }

}