package com.flat.view.main.panes.right.children.top.practicetoggle.pane;

import com.flat.controller.Controller;
import com.flat.models.data.miscellaneous.ButtonsLabels;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.children.PracticeModeToggleSwitch;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.children.ToggleText;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.events.PracticeModeToggle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.geometry.VPos;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeModeTogglePane extends Pane {
    // Attributes.
    private SimpleBooleanProperty toggle = new SimpleBooleanProperty(false);
    private ToggleText toggleText = new ToggleText();
    // Children.
    private PracticeModeToggleSwitch toggleSwitch = new PracticeModeToggleSwitch();

    public PracticeModeTogglePane () {
        this.initializeFx();
        Controller.DATA_BUS.throwUpdate(new PracticeModeToggle(this.toggle.getValue()));
    }

    private void initializeFx () {
        this.setThisFx();
        this.setToggleTextFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.toggleText, this.toggleSwitch);
        super.setWidth(140);
        super.setMaxWidth(140);
        super.setMinHeight(20);
        super.setHeight(20);
        super.setMaxHeight(20);
        super.setLayoutX(0);
        super.getStyleClass().setAll("practiceModeTogglePane");
        this.onToggleSetCss();
        this.onToggleSetToggleText();
        this.setToggleUpdate();
    }

    private void setToggleTextFx () {
        this.toggleText.setTextAlignment(TextAlignment.CENTER);
        this.toggleText.setTextOrigin(VPos.CENTER);
        this.setToggleText();
    }

    private void onToggleSetCss () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            super.pseudoClassStateChanged(PseudoClass.getPseudoClass("on"), this.toggle.get());
        });
    }

    private void onToggleSetToggleText () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            this.setToggleText();
        });
    }

    private void setToggleText () {
            if (this.toggle.getValue()) {
                this.toggleText.textProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.PRACTICE_MODE_ON).textProperty());
                this.toggleText.setLayoutX(10);
            }
            else {
                this.toggleText.textProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.PRACTICE_MODE_OFF).textProperty());
                this.toggleText.setLayoutX(super.getWidth() - this.toggleText.getLayoutBounds().getWidth() - 10);
            }
            this.toggleText.setLayoutY((super.getHeight()) / 2);
    }

    public void setToggleUpdate () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            Controller.DATA_BUS.throwUpdate(new PracticeModeToggle(this.toggle.getValue()));
        });
    }

    public void toggle () {
        this.setToggle(!this.toggle.getValue());
    }

    // Getters for object's attributes.
    public SimpleBooleanProperty getToggle() {
        return toggle;
    }

    // Setters for object's attributes.
    public void setToggle(boolean _boolean) {
        this.toggle.set(_boolean);
    }

}