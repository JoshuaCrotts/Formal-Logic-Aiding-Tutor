package com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.colorpane.bordercolorpane;

import com.flat.models.fx.FxPreviewData;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class BorderColorPicker extends ColorPicker {

    public BorderColorPicker() {
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction((event) -> {
            FxPreviewData.getBorderColor().setColor(new Color(super.getValue().getRed(), super.getValue().getGreen(), super.getValue().getBlue(), super.getValue().getOpacity()));
        });
    }

}