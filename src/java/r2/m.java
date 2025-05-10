package r2;

import o2.d;
import java.util.Iterator;
import o2.c;
import d2.z;
import java.util.Collection;
import kotlin.jvm.internal.i;

class m extends l
{
    public static final boolean h(final String s, final String s2, final boolean b) {
        kotlin.jvm.internal.i.e((Object)s, "<this>");
        kotlin.jvm.internal.i.e((Object)s2, "suffix");
        if (!b) {
            return s.endsWith(s2);
        }
        return k(s, s.length() - s2.length(), s2, 0, s2.length(), true);
    }
    
    public static boolean j(final CharSequence charSequence) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        final int length = charSequence.length();
        boolean b = false;
        if (length != 0) {
            final c t = n.t(charSequence);
            boolean b2 = false;
            Label_0085: {
                if (!(t instanceof Collection) || !((Collection)t).isEmpty()) {
                    final Iterator iterator = ((Iterable)t).iterator();
                    while (iterator.hasNext()) {
                        if (!a.c(charSequence.charAt(((z)iterator).nextInt()))) {
                            b2 = false;
                            break Label_0085;
                        }
                    }
                }
                b2 = true;
            }
            if (!b2) {
                return b;
            }
        }
        b = true;
        return b;
    }
    
    public static final boolean k(final String s, final int n, final String s2, final int n2, final int n3, final boolean b) {
        kotlin.jvm.internal.i.e((Object)s, "<this>");
        kotlin.jvm.internal.i.e((Object)s2, "other");
        boolean b2;
        if (!b) {
            b2 = s.regionMatches(n, s2, n2, n3);
        }
        else {
            b2 = s.regionMatches(b, n, s2, n2, n3);
        }
        return b2;
    }
    
    public static final String l(String string, final String s, final String s2, final boolean b) {
        kotlin.jvm.internal.i.e((Object)string, "<this>");
        kotlin.jvm.internal.i.e((Object)s, "oldValue");
        kotlin.jvm.internal.i.e((Object)s2, "newValue");
        int n = 0;
        int w = r2.n.w((CharSequence)string, s, 0, b);
        if (w < 0) {
            return string;
        }
        final int length = s.length();
        final int a = d.a(length, 1);
        final int n2 = string.length() - length + s2.length();
        if (n2 >= 0) {
            final StringBuilder sb = new StringBuilder(n2);
            int w2;
            int n3;
            do {
                sb.append((CharSequence)string, n, w);
                sb.append(s2);
                n3 = w + length;
                if (w >= string.length()) {
                    break;
                }
                w2 = r2.n.w((CharSequence)string, s, w + a, b);
                n = n3;
            } while ((w = w2) > 0);
            sb.append((CharSequence)string, n3, string.length());
            string = sb.toString();
            kotlin.jvm.internal.i.d((Object)string, "stringBuilder.append(this, i, length).toString()");
            return string;
        }
        throw new OutOfMemoryError();
    }
    
    public static final boolean n(final String s, final String s2, final boolean b) {
        kotlin.jvm.internal.i.e((Object)s, "<this>");
        kotlin.jvm.internal.i.e((Object)s2, "prefix");
        if (!b) {
            return s.startsWith(s2);
        }
        return k(s, 0, s2, 0, s2.length(), b);
    }
}
