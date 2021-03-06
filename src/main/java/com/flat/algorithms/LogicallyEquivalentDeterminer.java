package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.models.treenode.BicondNode;
import com.flat.models.treenode.NegNode;
import com.flat.models.treenode.NodeFlag;
import com.flat.models.treenode.WffTree;

/**
 *
 */
public final class LogicallyEquivalentDeterminer {

    /**
     * TruthTree that is constructed from the generator.
     */
    private final TruthTree truthTree;

    /**
     * Combined WffTree is the negated biconditional.
     */
    private final WffTree combinedTree;

    public LogicallyEquivalentDeterminer(WffTree _wffTreeOne, WffTree _wffTreeTwo) {
        BicondNode bicond = new BicondNode(_wffTreeOne.getChild(0), _wffTreeTwo.getChild(0));
        this.combinedTree = new WffTree();
        this.combinedTree.setFlags(_wffTreeOne.isPropositionalWff() ? NodeFlag.PROPOSITIONAL : NodeFlag.PREDICATE);
        this.combinedTree.addChild(new NegNode(bicond));

        BaseTruthTreeGenerator treeGenerator;
        if (this.combinedTree.isPropositionalWff()) {
            treeGenerator = new PropositionalTruthTreeGenerator(this.combinedTree);
        } else {
            treeGenerator = new PredicateTruthTreeGenerator(this.combinedTree);
        }

        this.truthTree = treeGenerator.getTruthTree();
    }

    /**
     * Two formulas are logically equivalent if they are the same in every model. When running a truth
     * tree, we check the negated version of the wff and determine if it is closed.
     *
     * @return true if the wffs are logically equivalent, false otherwise.
     */
    public boolean isEquivalent() {
        return new ClosedTreeDeterminer(this.truthTree).hasAllClosed();
    }

    public WffTree getCombinedTree() {
        return this.combinedTree;
    }

    public TruthTree getTruthTree() {
        return this.truthTree;
    }
}
