package com.flat.models.json.logicsymbols.logictype.predicate.symbols.universal.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.axioms.keyed.KeyedAxioms;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.universal.UniversalSymbol;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UniversalAxioms extends KeyedAxioms {

    public UniversalAxioms () {
        super(
                UniversalSymbol.class,
                "(∀x)Px or (x)Px means the predicate P holds true for all inputs x from some domain D.",
                new ArrayList <String> () {{
                    add("1. (∀x)Px");
                    add("2. (y)(Py & Qay)");
                }}
        );
    }

}