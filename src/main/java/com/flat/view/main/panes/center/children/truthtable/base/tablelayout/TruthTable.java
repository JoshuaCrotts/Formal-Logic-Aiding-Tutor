package com.flat.view.main.panes.center.children.truthtable.base.tablelayout;

import com.flat.models.treenode.WffTree;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTable {
    private ArrayList <TableHeader> headers = new ArrayList();

    public TruthTable (WffTree _wffTree) {
        this.addHeaders(_wffTree, 0, 0);
    }

    private void addHeaders (WffTree _wffTree, int _leftMod, int _rightMod) {
        switch (_wffTree.getChildrenSize()) {
            case 1:
                this.headers.add(new TableHeader(this.headers.size(), _wffTree.getSymbol(), _wffTree));
                this.addHeaders(_wffTree.getChildren().get(0), 0, 2);
                break;
            case 2:
                this.addHeaders(_wffTree.getChildren().get(0), _leftMod + 1, 0);
                this.headers.add(new TableHeader(this.headers.size(), _wffTree.getSymbol(), _wffTree));
                this.addHeaders(_wffTree.getChildren().get(1), 0, _rightMod + 1);
                break;
            default:
                this.addParentheticalHeaders(_leftMod, "(");
                this.headers.add(new TableHeader(this.headers.size(), /*_leftMod +*/ _wffTree.getSymbol() /*+ _rightMod*/, _wffTree));
                this.addParentheticalHeaders(_rightMod, ")");
                break;
        }
    }

    private void addParentheticalHeaders (int _qty, String _text) {
        while (_qty-- > 0)
            this.headers.add(new TableHeader(this.headers.size(), _text));
    }

    // Getters for object's attributes.
    public ArrayList<TableHeader> getHeaders() {
        return headers;
    }

    // Setters for object's attributes.
    public void setHeaders(ArrayList<TableHeader> headers) {
        this.headers = headers;
    }

}