package com.flat.models.data.logicsymbols.propositional.biconditional.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.biconditional.BiconditionalSymbol;

/**
 *
 * @author christopherbrantley
 */
public class BiconditionalSymbols extends Symbols {

    public BiconditionalSymbols () {
        super(
                new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.GENERAL, "↔"),
                new KeyedTextArrayList(
                        BiconditionalSymbol.class,
                        LogicSymbol.Keys.ALTERNATE,
                        new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "⇔"),
                        new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.ALTERNATE_2, "≡"),
                        new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.ALTERNATE_3, "<->"),
                        new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.ALTERNATE_4, "↔")
                )
        );
    }

    public BiconditionalSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}