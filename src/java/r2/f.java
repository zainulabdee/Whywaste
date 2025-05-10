package r2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import d2.k;
import java.util.ArrayList;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import l2.l;

class f extends e
{
    private static final l<String, String> b(final String s) {
        j e;
        if (((CharSequence)s).length() == 0) {
            e = f$a.e;
        }
        else {
            e = new l<String, String>(s) {
                final String e;
                
                public final String a(final String s) {
                    i.e((Object)s, "line");
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this.e);
                    sb.append(s);
                    return sb.toString();
                }
            };
        }
        return (l<String, String>)e;
    }
    
    private static final int c(final String s) {
        while (true) {
            for (int length = ((CharSequence)s).length(), i = 0; i < length; ++i) {
                if (a.c(((CharSequence)s).charAt(i)) ^ true) {
                    int length2 = i;
                    if (i == -1) {
                        length2 = s.length();
                    }
                    return length2;
                }
            }
            int i = -1;
            continue;
        }
    }
    
    public static final String d(String string, String s) {
        i.e((Object)string, "<this>");
        i.e((Object)s, "newIndent");
        final List<String> i = n.I((CharSequence)string);
        final ArrayList list = new ArrayList();
        for (final Object next : i) {
            if (d.j((CharSequence)next) ^ true) {
                ((Collection)list).add(next);
            }
        }
        final ArrayList list2 = new ArrayList(k.g((Iterable)list, 10));
        final Iterator iterator2 = ((Iterable)list).iterator();
        while (iterator2.hasNext()) {
            ((Collection)list2).add((Object)c((String)iterator2.next()));
        }
        final Integer n = (Integer)k.o((Iterable)list2);
        int n2 = 0;
        int intValue;
        if (n != null) {
            intValue = n;
        }
        else {
            intValue = 0;
        }
        final int length = string.length();
        final int length2 = s.length();
        final int size = i.size();
        final l<String, String> b = b(s);
        final int c = k.c((List)i);
        final ArrayList list3 = new ArrayList();
        for (final Object next2 : i) {
            if (n2 < 0) {
                k.f();
            }
            s = (String)next2;
            if ((n2 == 0 || n2 == c) && d.j((CharSequence)s)) {
                string = null;
            }
            else {
                final String b2 = p.b0(s, intValue);
                string = s;
                if (b2 != null) {
                    string = (String)b.invoke((Object)b2);
                    if (string == null) {
                        string = s;
                    }
                }
            }
            if (string != null) {
                ((Collection)list3).add((Object)string);
            }
            ++n2;
        }
        string = ((StringBuilder)k.l((Iterable)list3, (Appendable)new StringBuilder(length + length2 * size), (CharSequence)"\n", null, null, 0, null, null, 124, null)).toString();
        kotlin.jvm.internal.i.d((Object)string, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return string;
    }
    
    public static String e(final String s) {
        i.e((Object)s, "<this>");
        return d(s, "");
    }
}
