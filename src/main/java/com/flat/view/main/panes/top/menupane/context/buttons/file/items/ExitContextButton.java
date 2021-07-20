package com.flat.view.main.panes.top.menupane.context.buttons.file.items;

import com.flat.controller.Controller;
import com.flat.models.json.menubar.items.file.JsonExitMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExitContextButton extends ContextButton {

    public ExitContextButton () {
        super(Controller.getKEYED_TEXT().getValue(JsonExitMenuItem.class, JsonExitMenuItem.Keys.EXIT).textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            System.exit(0);
        });
    }

}