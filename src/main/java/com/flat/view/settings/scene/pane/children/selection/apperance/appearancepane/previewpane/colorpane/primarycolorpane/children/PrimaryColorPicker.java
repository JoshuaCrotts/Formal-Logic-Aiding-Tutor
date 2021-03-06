package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.primarycolorpane.children;

import com.flat.view.data.fx.settings.appearance.AppearancePreviewData;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PrimaryColorPicker extends ColorPicker {

    public PrimaryColorPicker() {
        super.setValue(AppearancePreviewData.getPrimaryColor().getColor());
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction((event) -> {
            AppearancePreviewData.getPrimaryColor().setColor(new Color(super.getValue().getRed(), super.getValue().getGreen(), super.getValue().getBlue(), super.getOpacity()));
        });
    }

}