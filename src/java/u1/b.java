package u1;

import android.content.res.Configuration;
import java.util.Iterator;
import android.os.LocaleList;
import java.util.Collection;
import java.util.Locale$LanguageRange;
import androidx.core.os.e;
import java.util.ArrayList;
import android.os.Build$VERSION;
import java.util.List;
import java.util.Locale;
import android.content.Context;
import s1.f;

public class b
{
    private final f a;
    private final Context b;
    final f.b c;
    
    public b(final Context b, final f a) {
        final b$a c = new b$a(this);
        this.c = (f.b)c;
        this.b = b;
        (this.a = a).c((f.b)c);
    }
    
    public static Locale b(String s) {
        final String[] split = s.replace('_', '-').split("-", -1);
        final String s2 = split[0];
        final int length = split.length;
        final String s3 = "";
        int n = 1;
        if (length > 1 && split[1].length() == 4) {
            s = split[1];
            n = 2;
        }
        else {
            s = "";
        }
        String s4 = s3;
        if (split.length > n) {
            s4 = s3;
            if (split[n].length() >= 2) {
                s4 = s3;
                if (split[n].length() <= 3) {
                    s4 = split[n];
                }
            }
        }
        return new Locale(s2, s4, s);
    }
    
    public Locale c(final List<Locale> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 26) {
            final ArrayList list2 = new ArrayList();
            final LocaleList a = e.a(this.b.getResources().getConfiguration());
            for (int size = a.size(), i = 0; i < size; ++i) {
                final Locale value = a.get(i);
                String s2;
                final String s = s2 = value.getLanguage();
                if (!value.getScript().isEmpty()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(s);
                    sb.append("-");
                    sb.append(value.getScript());
                    s2 = sb.toString();
                }
                String string = s2;
                if (!value.getCountry().isEmpty()) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(s2);
                    sb2.append("-");
                    sb2.append(value.getCountry());
                    string = sb2.toString();
                }
                ((List)list2).add((Object)new Locale$LanguageRange(string));
                ((List)list2).add((Object)new Locale$LanguageRange(value.getLanguage()));
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(value.getLanguage());
                sb3.append("-*");
                ((List)list2).add((Object)new Locale$LanguageRange(sb3.toString()));
            }
            final Locale a2 = u1.a.a((List)list2, (Collection)list);
            if (a2 != null) {
                return a2;
            }
            return (Locale)list.get(0);
        }
        else {
            if (sdk_INT >= 24) {
                final LocaleList a3 = e.a(this.b.getResources().getConfiguration());
                for (int j = 0; j < a3.size(); ++j) {
                    final Locale value2 = a3.get(j);
                    for (final Locale locale : list) {
                        if (value2.equals((Object)locale)) {
                            return locale;
                        }
                    }
                    for (final Locale locale2 : list) {
                        if (value2.getLanguage().equals((Object)locale2.toLanguageTag())) {
                            return locale2;
                        }
                    }
                    for (final Locale locale3 : list) {
                        if (value2.getLanguage().equals((Object)locale3.getLanguage())) {
                            return locale3;
                        }
                    }
                }
                return (Locale)list.get(0);
            }
            final Locale locale4 = this.b.getResources().getConfiguration().locale;
            if (locale4 != null) {
                for (final Locale locale5 : list) {
                    if (locale4.equals((Object)locale5)) {
                        return locale5;
                    }
                }
                for (final Locale locale6 : list) {
                    if (locale4.getLanguage().equals((Object)locale6.toString())) {
                        return locale6;
                    }
                }
            }
            return (Locale)list.get(0);
        }
    }
    
    public void d(final Configuration configuration) {
        final ArrayList list = new ArrayList();
        if (Build$VERSION.SDK_INT >= 24) {
            final LocaleList a = e.a(configuration);
            for (int size = a.size(), i = 0; i < size; ++i) {
                ((List)list).add((Object)a.get(i));
            }
        }
        else {
            ((List)list).add((Object)configuration.locale);
        }
        this.a.b((List<Locale>)list);
    }
}
