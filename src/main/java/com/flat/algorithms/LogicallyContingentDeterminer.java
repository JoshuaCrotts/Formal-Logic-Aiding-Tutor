package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.models.treenode.NegNode;
import com.flat.models.treenode.NodeFlag;
import com.flat.models.treenode.WffTree;

public final class LogicallyContingentDeterminer {

    /**
     * TruthTree that is constructed from the generator.
     */
    private final WffTree wffTree;

    /**
     * Negated truth tree created from generator.
     */
    private final WffTree negatedTree;

    public LogicallyContingentDeterminer(WffTree _wffTree) {
        this.wffTree = _wffTree.copy();
        this.wffTree.setFlags(_wffTree.getFlags());

        // Create the negated expression.
        this.negatedTree = new WffTree();
        this.negatedTree.addChild(new NegNode());
        this.negatedTree.setFlags(_wffTree.isPropositionalWff() ? NodeFlag.PROPOSITIONAL : NodeFlag.PREDICATE);
        this.negatedTree.getChild(0).addChild(this.wffTree.getChild(0).copy());
    }

    /**
     * A wff is contingent if it and its negation have at least one open branch.
     *
     * @return true if the formula is contingent, false otherwise.
     */
    public boolean isContingent() {
        BaseTruthTreeGenerator treeGenerator;
        BaseTruthTreeGenerator negatedTreeGenerator;
        if (this.wffTree.isPropositionalWff() && this.negatedTree.isPropositionalWff()) {
            treeGenerator = new PropositionalTruthTreeGenerator(this.wffTree);
            negatedTreeGenerator = new PropositionalTruthTreeGenerator(this.negatedTree);
        } else {
            treeGenerator = new PredicateTruthTreeGenerator(this.wffTree);
            negatedTreeGenerator = new PredicateTruthTreeGenerator(this.negatedTree);
        }

        TruthTree truthTree = treeGenerator.getTruthTree();
        TruthTree negatedTruthTree = negatedTreeGenerator.getTruthTree();

        // Both truth trees must have at least one open branch.
        return (new OpenTreeDeterminer(truthTree).hasSomeOpen())
                && (new OpenTreeDeterminer(negatedTruthTree).hasSomeOpen());
    }

    public WffTree getWffTree() {
        return this.wffTree;
    }

    public WffTree getNegatedTree() {
        return this.negatedTree;
    }
}
