package com.flat.tools.translation.base;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.translation.FLATTranslate;
import com.google.cloud.translate.Translation;

import java.util.List;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class Translatable implements TranslateProperty {

    @Override
    public void translate(JsonLanguage _language) {
        FLATTranslate.translate(this, _language);
    }

    @Override
    public void applyTranslation(List <Translation> _translations) {
        List <JsonString> jsonStrings = this.toTranslate();
        for (int i = 0; i < _translations.size(); i++) {
            jsonStrings.get(i).setString(_translations.get(i).getTranslatedText());
        }
    }

}