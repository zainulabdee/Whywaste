package io.flutter.plugin.editing;

import android.view.textservice.SuggestionsInfo;
import java.util.HashMap;
import java.util.ArrayList;
import android.view.textservice.SentenceSuggestionsInfo;
import java.util.Locale;
import android.view.textservice.TextInfo;
import android.os.Bundle;
import u1.b;
import t1.k;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.TextServicesManager;
import android.view.textservice.SpellCheckerSession$SpellCheckerSessionListener;
import s1.n;

public class f implements b, SpellCheckerSession$SpellCheckerSessionListener
{
    private final n a;
    private final TextServicesManager b;
    private SpellCheckerSession c;
    k.d d;
    
    public f(final TextServicesManager b, final n a) {
        this.b = b;
        (this.a = a).b((n.b)this);
    }
    
    @Override
    public void a(final String s, final String s2, final k.d d) {
        if (this.d != null) {
            d.b("error", "Previous spell check request still pending.", null);
            return;
        }
        this.d = d;
        this.c(s, s2);
    }
    
    public void b() {
        this.a.b(null);
        final SpellCheckerSession c = this.c;
        if (c != null) {
            c.close();
        }
    }
    
    public void c(final String s, final String s2) {
        final Locale b = u1.b.b(s);
        if (this.c == null) {
            this.c = this.b.newSpellCheckerSession((Bundle)null, b, (SpellCheckerSession$SpellCheckerSessionListener)this, true);
        }
        this.c.getSentenceSuggestions(new TextInfo[] { new TextInfo(s2) }, 5);
    }
    
    public void onGetSentenceSuggestions(final SentenceSuggestionsInfo[] array) {
        if (array.length == 0) {
            this.d.a(new ArrayList());
            this.d = null;
            return;
        }
        final ArrayList list = new ArrayList();
        final SentenceSuggestionsInfo sentenceSuggestionsInfo = array[0];
        for (int i = 0; i < sentenceSuggestionsInfo.getSuggestionsCount(); ++i) {
            final SuggestionsInfo suggestionsInfo = sentenceSuggestionsInfo.getSuggestionsInfoAt(i);
            final int suggestionsCount = suggestionsInfo.getSuggestionsCount();
            if (suggestionsCount > 0) {
                final HashMap hashMap = new HashMap();
                final int offset = sentenceSuggestionsInfo.getOffsetAt(i);
                final int length = sentenceSuggestionsInfo.getLengthAt(i);
                hashMap.put((Object)"startIndex", (Object)offset);
                hashMap.put((Object)"endIndex", (Object)(length + offset));
                final ArrayList list2 = new ArrayList();
                int j = 0;
                boolean b = false;
                while (j < suggestionsCount) {
                    final String suggestion = suggestionsInfo.getSuggestionAt(j);
                    if (!suggestion.equals((Object)"")) {
                        list2.add((Object)suggestion);
                        b = true;
                    }
                    ++j;
                }
                if (b) {
                    hashMap.put((Object)"suggestions", (Object)list2);
                    list.add((Object)hashMap);
                }
            }
        }
        this.d.a(list);
        this.d = null;
    }
    
    public void onGetSuggestions(final SuggestionsInfo[] array) {
    }
}
