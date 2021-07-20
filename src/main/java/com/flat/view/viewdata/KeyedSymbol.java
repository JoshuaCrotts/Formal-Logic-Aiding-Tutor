package com.flat.view.viewdata;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.Symbols;
import java.util.HashMap;

/**
 *
 * @author christopherbrantley
 */
public class KeyedSymbol {
    private HashMap <Class<?>, Symbols> symbols = new HashMap();

    public KeyedSymbol () {
    }

    public Symbols getAxioms (Class<?> _key) {
        return this.symbols.get(_key);
    }

    public void putValue (Class <?> _key, Symbols _value) {
        this.symbols.put(_key, _value);
    }

}