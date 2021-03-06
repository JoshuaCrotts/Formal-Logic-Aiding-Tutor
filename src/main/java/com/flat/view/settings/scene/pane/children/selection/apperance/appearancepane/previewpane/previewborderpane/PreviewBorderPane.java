package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.previewborderpane;

import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.previewborderpane.panes.PreviewBottomPane;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.previewborderpane.panes.PreviewCenterPane;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.previewborderpane.panes.PreviewLeftPane;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.previewborderpane.panes.PreviewRightPane;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.previewborderpane.panes.PreviewTopPane;
import javafx.scene.layout.BorderPane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PreviewBorderPane extends BorderPane {
    private final PreviewTopPane previewTopPane = new PreviewTopPane();
    private final PreviewRightPane previewRightPane = new PreviewRightPane();
    private final PreviewBottomPane previewBottomPane = new PreviewBottomPane();
    private final PreviewLeftPane previewLeftPane = new PreviewLeftPane();
    private final PreviewCenterPane previewCenterPane = new PreviewCenterPane();

    public PreviewBorderPane() {
        super.setMaxHeight(USE_PREF_SIZE);
        super.setId("previewBorderPane");
        super.setTop(this.previewTopPane);
        super.setRight(this.previewRightPane);
        super.setBottom(this.previewBottomPane);
        super.setLeft(this.previewLeftPane);
        super.setCenter(this.previewCenterPane);
    }

}