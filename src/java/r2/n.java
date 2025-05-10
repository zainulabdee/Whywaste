package r2;

import java.util.Iterator;
import d2.k;
import l2.l;
import java.util.Collection;
import c2.j;
import l2.p;
import java.util.List;
import d2.z;
import o2.c;
import o2.d;
import d2.e;
import kotlin.jvm.internal.i;

class n extends m
{
    public static final int B(final CharSequence charSequence, final char[] array, int i, final boolean b) {
        i.e((Object)charSequence, "<this>");
        i.e((Object)array, "chars");
        if (!b && array.length == 1 && charSequence instanceof String) {
            return ((String)charSequence).indexOf((int)e.i(array), i);
        }
        final z k = new c(d.a(i, 0), u(charSequence)).k();
    Label_0067:
        while (((Iterator)k).hasNext()) {
            final int nextInt = k.nextInt();
            final char char1 = charSequence.charAt(nextInt);
            final int length = array.length;
            i = 0;
            while (true) {
                while (i < length) {
                    if (b.d(array[i], char1, b)) {
                        i = 1;
                        if (i != 0) {
                            return nextInt;
                        }
                        continue Label_0067;
                    }
                    else {
                        ++i;
                    }
                }
                i = 0;
                continue;
            }
        }
        return -1;
    }
    
    public static final int C(final CharSequence charSequence, final char c, int n, final boolean b) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        if (!b && charSequence instanceof String) {
            n = ((String)charSequence).lastIndexOf((int)c, n);
        }
        else {
            n = G(charSequence, new char[] { c }, n, b);
        }
        return n;
    }
    
    public static final int D(final CharSequence charSequence, final String s, int n, final boolean b) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        kotlin.jvm.internal.i.e((Object)s, "string");
        if (!b && charSequence instanceof String) {
            n = ((String)charSequence).lastIndexOf(s, n);
        }
        else {
            n = x(charSequence, (CharSequence)s, n, 0, b, true);
        }
        return n;
    }
    
    public static /* synthetic */ int E(final CharSequence charSequence, final char c, int u, boolean b, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            u = u(charSequence);
        }
        if ((n & 0x4) != 0x0) {
            b = false;
        }
        return C(charSequence, c, u, b);
    }
    
    public static final int G(final CharSequence charSequence, final char[] array, int c, final boolean b) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        kotlin.jvm.internal.i.e((Object)array, "chars");
        if (!b && array.length == 1 && charSequence instanceof String) {
            return ((String)charSequence).lastIndexOf((int)e.i(array), c);
        }
        char char1;
        int length;
        int n;
        int n2;
        int n3;
        for (c = d.c(c, u(charSequence)); -1 < c; --c) {
            char1 = charSequence.charAt(c);
            length = array.length;
            n = 0;
            n2 = 0;
            while (true) {
                n3 = n;
                if (n2 >= length) {
                    break;
                }
                if (b.d(array[n2], char1, b)) {
                    n3 = 1;
                    break;
                }
                ++n2;
            }
            if (n3 != 0) {
                return c;
            }
        }
        return -1;
    }
    
    public static final q2.b<String> H(final CharSequence charSequence) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        return (q2.b<String>)O(charSequence, new String[] { "\r\n", "\n", "\r" }, false, 0, 6, null);
    }
    
    public static final List<String> I(final CharSequence charSequence) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        return (List<String>)q2.c.e((q2.b)H(charSequence));
    }
    
    private static final q2.b<c> J(final CharSequence charSequence, final String[] array, final int n, final boolean b, final int n2) {
        M(n2);
        return (q2.b<c>)new r2.c(charSequence, n, n2, (p<? super CharSequence, ? super Integer, c2.j<Integer, Integer>>)new p<CharSequence, Integer, c2.j<? extends Integer, ? extends Integer>>(e.b((Object[])array), b) {
            final List<String> e;
            final boolean f;
            
            public final c2.j<Integer, Integer> a(final CharSequence charSequence, final int n) {
                kotlin.jvm.internal.i.e((Object)charSequence, "$this$$receiver");
                final c2.j p2 = s(charSequence, (Collection<String>)this.e, n, this.f, false);
                c2.j a;
                if (p2 != null) {
                    a = n.a(p2.c(), (Object)((String)p2.d()).length());
                }
                else {
                    a = null;
                }
                return (c2.j<Integer, Integer>)a;
            }
        });
    }
    
    static /* synthetic */ q2.b K(final CharSequence charSequence, final String[] array, int n, boolean b, int n2, final int n3, final Object o) {
        if ((n3 & 0x2) != 0x0) {
            n = 0;
        }
        if ((n3 & 0x4) != 0x0) {
            b = false;
        }
        if ((n3 & 0x8) != 0x0) {
            n2 = 0;
        }
        return J(charSequence, array, n, b, n2);
    }
    
    public static final boolean L(final CharSequence charSequence, final int n, final CharSequence charSequence2, final int n2, final int n3, final boolean b) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        kotlin.jvm.internal.i.e((Object)charSequence2, "other");
        if (n2 >= 0 && n >= 0 && n <= charSequence.length() - n3 && n2 <= charSequence2.length() - n3) {
            for (int i = 0; i < n3; ++i) {
                if (!b.d(charSequence.charAt(n + i), charSequence2.charAt(n2 + i), b)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public static final void M(final int n) {
        if (n >= 0) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Limit must be non-negative, but was ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString().toString());
    }
    
    public static final q2.b<String> N(final CharSequence charSequence, final String[] array, final boolean b, final int n) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        kotlin.jvm.internal.i.e((Object)array, "delimiters");
        return (q2.b<String>)q2.c.c(K(charSequence, array, 0, b, n, 2, null), (l2.l)new l2.l<c, String>(charSequence) {
            final CharSequence e;
            
            public final String a(final c c) {
                kotlin.jvm.internal.i.e((Object)c, "it");
                return n.P(this.e, c);
            }
        });
    }
    
    public static /* synthetic */ q2.b O(final CharSequence charSequence, final String[] array, boolean b, int n, final int n2, final Object o) {
        if ((n2 & 0x2) != 0x0) {
            b = false;
        }
        if ((n2 & 0x4) != 0x0) {
            n = 0;
        }
        return N(charSequence, array, b, n);
    }
    
    public static final String P(final CharSequence charSequence, final c c) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        kotlin.jvm.internal.i.e((Object)c, "range");
        return charSequence.subSequence((int)c.o(), c.n() + 1).toString();
    }
    
    public static final String Q(final String s, final char c, String substring) {
        kotlin.jvm.internal.i.e((Object)s, "<this>");
        kotlin.jvm.internal.i.e((Object)substring, "missingDelimiterValue");
        final int z = r2.d.z((CharSequence)s, c, 0, false, 6, null);
        if (z != -1) {
            substring = s.substring(z + 1, s.length());
            kotlin.jvm.internal.i.d((Object)substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        return substring;
    }
    
    public static final String R(final String s, final String s2, String substring) {
        kotlin.jvm.internal.i.e((Object)s, "<this>");
        kotlin.jvm.internal.i.e((Object)s2, "delimiter");
        kotlin.jvm.internal.i.e((Object)substring, "missingDelimiterValue");
        final int a = r2.d.A((CharSequence)s, s2, 0, false, 6, null);
        if (a != -1) {
            substring = s.substring(a + s2.length(), s.length());
            kotlin.jvm.internal.i.d((Object)substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        return substring;
    }
    
    public static final String U(final String s, final char c, String substring) {
        kotlin.jvm.internal.i.e((Object)s, "<this>");
        kotlin.jvm.internal.i.e((Object)substring, "missingDelimiterValue");
        final int e = E((CharSequence)s, c, 0, false, 6, null);
        if (e != -1) {
            substring = s.substring(e + 1, s.length());
            kotlin.jvm.internal.i.d((Object)substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        return substring;
    }
    
    public static final String W(final String s, final char c, String substring) {
        kotlin.jvm.internal.i.e((Object)s, "<this>");
        kotlin.jvm.internal.i.e((Object)substring, "missingDelimiterValue");
        final int z = r2.d.z((CharSequence)s, c, 0, false, 6, null);
        if (z != -1) {
            substring = s.substring(0, z);
            kotlin.jvm.internal.i.d((Object)substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        return substring;
    }
    
    public static final String X(final String s, final String s2, String substring) {
        kotlin.jvm.internal.i.e((Object)s, "<this>");
        kotlin.jvm.internal.i.e((Object)s2, "delimiter");
        kotlin.jvm.internal.i.e((Object)substring, "missingDelimiterValue");
        final int a = r2.d.A((CharSequence)s, s2, 0, false, 6, null);
        if (a != -1) {
            substring = s.substring(0, a);
            kotlin.jvm.internal.i.d((Object)substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        return substring;
    }
    
    public static CharSequence a0(final CharSequence charSequence) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        int n = charSequence.length() - 1;
        int i = 0;
        int n2 = 0;
        while (i <= n) {
            int n3;
            if (n2 == 0) {
                n3 = i;
            }
            else {
                n3 = n;
            }
            final boolean c = a.c(charSequence.charAt(n3));
            if (n2 == 0) {
                if (!c) {
                    n2 = 1;
                }
                else {
                    ++i;
                }
            }
            else {
                if (!c) {
                    break;
                }
                --n;
            }
        }
        return charSequence.subSequence(i, n + 1);
    }
    
    public static final boolean q(final CharSequence charSequence, final CharSequence charSequence2, final boolean b) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        kotlin.jvm.internal.i.e((Object)charSequence2, "other");
        final boolean b2 = charSequence2 instanceof String;
        final boolean b3 = true;
        return (b2 ? (r2.d.A(charSequence, (String)charSequence2, 0, b, 2, null) >= 0) : (y(charSequence, charSequence2, 0, charSequence.length(), b, false, 16, null) >= 0)) && b3;
    }
    
    private static final c2.j<Integer, String> s(final CharSequence charSequence, final Collection<String> collection, int n, final boolean b, final boolean b2) {
        final c2.j<Integer, String> j = null;
        if (!b && collection.size() == 1) {
            final String s = (String)d2.k.p((Iterable)collection);
            if (!b2) {
                n = r2.d.A(charSequence, s, n, false, 4, null);
            }
            else {
                n = r2.d.F(charSequence, s, n, false, 4, null);
            }
            c2.j a;
            if (n < 0) {
                a = j;
            }
            else {
                a = n.a((Object)n, (Object)s);
            }
            return (c2.j<Integer, String>)a;
        }
        o2.a f;
        if (!b2) {
            f = new c(d.a(n, 0), charSequence.length());
        }
        else {
            f = d.f(d.c(n, u(charSequence)), 0);
        }
        Label_0414: {
            if (charSequence instanceof String) {
                final int h = f.h();
                final int i = f.i();
                final int k = f.j();
                if (k <= 0 || (n = h) > i) {
                    if (k >= 0 || i > h) {
                        return null;
                    }
                    n = h;
                }
            Label_0174:
                while (true) {
                    while (true) {
                        for (final Object next : collection) {
                            final String s2 = (String)next;
                            if (m.k(s2, 0, (String)charSequence, n, s2.length(), b)) {
                                final String s3 = (String)next;
                                if (s3 != null) {
                                    return (c2.j<Integer, String>)n.a((Object)n, (Object)s3);
                                }
                                if (n != i) {
                                    n += k;
                                    continue Label_0174;
                                }
                                break Label_0414;
                            }
                        }
                        Object next = null;
                        continue;
                    }
                }
            }
            else {
                final int h2 = f.h();
                final int l = f.i();
                final int m = f.j();
                if (m <= 0 || (n = h2) > l) {
                    if (m >= 0 || l > h2) {
                        return null;
                    }
                    n = h2;
                }
            Label_0321:
                while (true) {
                    while (true) {
                        for (final Object next2 : collection) {
                            final String s4 = (String)next2;
                            if (L((CharSequence)s4, 0, charSequence, n, s4.length(), b)) {
                                final String s5 = (String)next2;
                                if (s5 != null) {
                                    return (c2.j<Integer, String>)n.a((Object)n, (Object)s5);
                                }
                                if (n != l) {
                                    n += m;
                                    continue Label_0321;
                                }
                                break Label_0414;
                            }
                        }
                        Object next2 = null;
                        continue;
                    }
                }
            }
        }
        return null;
    }
    
    public static final c t(final CharSequence charSequence) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        return new c(0, charSequence.length() - 1);
    }
    
    public static final int u(final CharSequence charSequence) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        return charSequence.length() - 1;
    }
    
    public static final int v(final CharSequence charSequence, final char c, int n, final boolean b) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        if (!b && charSequence instanceof String) {
            n = ((String)charSequence).indexOf((int)c, n);
        }
        else {
            n = B(charSequence, new char[] { c }, n, b);
        }
        return n;
    }
    
    public static final int w(final CharSequence charSequence, final String s, int n, final boolean b) {
        kotlin.jvm.internal.i.e((Object)charSequence, "<this>");
        kotlin.jvm.internal.i.e((Object)s, "string");
        if (!b && charSequence instanceof String) {
            n = ((String)charSequence).indexOf(s, n);
        }
        else {
            n = y(charSequence, (CharSequence)s, n, charSequence.length(), b, false, 16, null);
        }
        return n;
    }
    
    private static final int x(final CharSequence charSequence, final CharSequence charSequence2, int n, int n2, final boolean b, final boolean b2) {
        o2.a f;
        if (!b2) {
            f = new c(d.a(n, 0), d.c(n2, charSequence.length()));
        }
        else {
            f = d.f(d.c(n, u(charSequence)), d.a(n2, 0));
        }
        if (charSequence instanceof String && charSequence2 instanceof String) {
            n2 = f.h();
            final int i = f.i();
            final int j = f.j();
            if (j <= 0 || (n = n2) > i) {
                if (j >= 0 || i > n2) {
                    return -1;
                }
                n = n2;
            }
            while (!m.k((String)charSequence2, 0, (String)charSequence, n, charSequence2.length(), b)) {
                if (n == i) {
                    return -1;
                }
                n += j;
            }
            return n;
        }
        n2 = f.h();
        final int k = f.i();
        final int l = f.j();
        if (l <= 0 || (n = n2) > k) {
            if (l >= 0 || k > n2) {
                return -1;
            }
            n = n2;
        }
        while (!L(charSequence2, 0, charSequence, n, charSequence2.length(), b)) {
            if (n == k) {
                return -1;
            }
            n += l;
        }
        return n;
    }
    
    static /* synthetic */ int y(final CharSequence charSequence, final CharSequence charSequence2, final int n, final int n2, final boolean b, boolean b2, final int n3, final Object o) {
        if ((n3 & 0x10) != 0x0) {
            b2 = false;
        }
        return x(charSequence, charSequence2, n, n2, b, b2);
    }
}
