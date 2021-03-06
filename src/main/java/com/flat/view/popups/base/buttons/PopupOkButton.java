package com.flat.view.popups.base.buttons;

import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PopupOkButton extends Button {

    public PopupOkButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setText("Ok");
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            ((Stage) super.getScene().getWindow()).close();
        });
    }

}