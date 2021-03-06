package com.flat.models.treenode;

import com.flat.algorithms.TexPrinter;

/**
 *
 */
public class FalseNode extends WffTree {

    /**
     *
     */
    private static final String DEFAULT_SYMBOL = "⊥";

    /**
     *
     */
    private static final String DEFAULT_TEX_SYMBOL = "\\perp";

    public FalseNode() {
        super(DEFAULT_SYMBOL, NodeType.FALSE);
    }

    @Override
    public WffTree copy() {
        FalseNode falseNode = new FalseNode();
        falseNode.setFlags(this.getFlags());
        return falseNode;
    }

    @Override
    public String getStringRep() {
        return this.getSymbol();
    }

    @Override
    public String getTexCommand() {
        return TexPrinter.removeMathMode(FalseNode.DEFAULT_TEX_SYMBOL);
    }

    @Override
    public String getTexParseCommand() {
        return this.getTexCommand();
    }

    @Override
    public String toString() {
        return super.toString() + ": " + super.getSymbol();
    }
}
