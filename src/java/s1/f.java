package s1;

import java.util.Iterator;
import java.util.ArrayList;
import f1.b;
import java.util.Locale;
import java.util.List;
import t1.l;
import t1.c;
import t1.g;
import g1.a;
import t1.k;

public class f
{
    public final k a;
    private b b;
    public final k.c c;
    
    public f(final a a) {
        final f$a c = new f$a(this);
        this.c = (k.c)c;
        (this.a = new k(a, "flutter/localization", (l)g.a)).e((k.c)c);
    }
    
    public void b(final List<Locale> list) {
        f1.b.f("LocalizationChannel", "Sending Locales to Flutter.");
        final ArrayList list2 = new ArrayList();
        for (final Locale locale : list) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Locale (Language: ");
            sb.append(locale.getLanguage());
            sb.append(", Country: ");
            sb.append(locale.getCountry());
            sb.append(", Variant: ");
            sb.append(locale.getVariant());
            sb.append(")");
            f1.b.f("LocalizationChannel", sb.toString());
            ((List)list2).add((Object)locale.getLanguage());
            ((List)list2).add((Object)locale.getCountry());
            ((List)list2).add((Object)locale.getScript());
            ((List)list2).add((Object)locale.getVariant());
        }
        this.a.c("setLocale", list2);
    }
    
    public void c(final b b) {
        this.b = b;
    }
    
    public interface b
    {
        String a(final String p0, final String p1);
    }
}
