package com.flat.view.main;

import com.flat.view.action.ResizePane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainBottom {
    private Pane parentPane = new Pane();
    private ResizePane resizePane;

    public MainBottom () {
        this.parentPane.setStyle("-fx-background-color: brown");
        this.resizePane = new ResizePane(this.parentPane, ResizePane.Orientation.VERTICAL, ResizePane.Side.TOP);
        this.parentPane.getChildren().add(this.resizePane.getParentPane());
        this.initializeFx();
    }

    // Calls all FX property setters.
    public void initializeFx () {
        this.setResizePaneFx();
    }

    // Setters for initial FX properties
    public void setResizePaneFx () {
        this.parentPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.resizePane.getParentPane().setMinWidth(newVal.doubleValue());
            this.resizePane.getParentPane().setMaxWidth(newVal.doubleValue());
        });
        this.resizePane.getParentPane().setLayoutY(0);
    }

    // Getters for object's attributes.
    public Pane getParentPane () {
        return this.parentPane;
    }

    // Setters for object's attributes.
    public void setParentPane (Pane parentPane) {
        this.parentPane = parentPane;
    }

}