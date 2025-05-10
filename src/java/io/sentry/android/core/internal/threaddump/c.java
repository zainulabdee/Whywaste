package io.sentry.android.core.internal.threaddump;

import java.util.List;
import java.util.Collections;
import io.sentry.protocol.u;
import io.sentry.l4;
import java.util.ArrayList;
import io.sentry.protocol.v;
import java.util.regex.Matcher;
import java.util.Map;
import java.util.HashMap;
import io.sentry.m4;
import io.sentry.protocol.w;
import io.sentry.s4;
import io.sentry.q4;
import java.util.regex.Pattern;

public class c
{
    private static final Pattern d;
    private static final Pattern e;
    private static final Pattern f;
    private static final Pattern g;
    private static final Pattern h;
    private static final Pattern i;
    private static final Pattern j;
    private static final Pattern k;
    private static final Pattern l;
    private static final Pattern m;
    private static final Pattern n;
    private static final Pattern o;
    private final q4 a;
    private final boolean b;
    private final s4 c;
    
    static {
        d = Pattern.compile("\"(.*)\" (.*) ?prio=(\\d+)\\s+tid=(\\d+)\\s*(.*)");
        e = Pattern.compile("  (?:native: )?#\\d+ \\S+ [0-9a-fA-F]+\\s+(.*?)\\s+\\((.*)\\+(\\d+)\\)(?: \\(.*\\))?");
        f = Pattern.compile("  (?:native: )?#\\d+ \\S+ [0-9a-fA-F]+\\s+(.*)\\s*\\(?(.*)\\)?(?: \\(.*\\))?");
        g = Pattern.compile("  at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\((.*):([\\d-]+)\\)");
        h = Pattern.compile("  at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\(Native method\\)");
        i = Pattern.compile("  - locked \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
        j = Pattern.compile("  - sleeping on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
        k = Pattern.compile("  - waiting on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
        l = Pattern.compile("  - waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
        m = Pattern.compile("  - waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)(?: held by thread (\\d+))");
        n = Pattern.compile("  - waiting to lock an unknown object");
        o = Pattern.compile("\\s+");
    }
    
    public c(final q4 a, final boolean b) {
        this.a = a;
        this.b = b;
        this.c = new s4(a);
    }
    
    private void a(final w w, final m4 m4) {
        Object k;
        if ((k = w.k()) == null) {
            k = new HashMap();
        }
        final m4 m5 = (m4)((Map)k).get((Object)m4.f());
        if (m5 != null) {
            m5.l(Math.max(m5.g(), m4.g()));
        }
        else {
            ((Map)k).put((Object)m4.f(), (Object)new m4(m4));
        }
        w.t((Map)k);
    }
    
    private Integer b(final Matcher matcher, final int n, final Integer n2) {
        final String group = matcher.group(n);
        if (group != null && group.length() != 0) {
            return Integer.parseInt(group);
        }
        return n2;
    }
    
    private Long c(final Matcher matcher, final int n, final Long n2) {
        final String group = matcher.group(n);
        if (group != null && group.length() != 0) {
            return Long.parseLong(group);
        }
        return n2;
    }
    
    private Integer d(final Matcher matcher, final int n, final Integer n2) {
        final String group = matcher.group(n);
        Integer n3 = n2;
        if (group != null) {
            if (group.length() == 0) {
                n3 = n2;
            }
            else {
                final Integer value = Integer.parseInt(group);
                n3 = n2;
                if (value >= 0) {
                    n3 = value;
                }
            }
        }
        return n3;
    }
    
    private boolean e(final Matcher matcher, final String s) {
        matcher.reset((CharSequence)s);
        return matcher.matches();
    }
    
    private v g(final b b, final w w) {
        final ArrayList list = new ArrayList();
        final Matcher matcher = io.sentry.android.core.internal.threaddump.c.e.matcher((CharSequence)"");
        final Matcher matcher2 = io.sentry.android.core.internal.threaddump.c.f.matcher((CharSequence)"");
        final Matcher matcher3 = io.sentry.android.core.internal.threaddump.c.g.matcher((CharSequence)"");
        final Matcher matcher4 = io.sentry.android.core.internal.threaddump.c.h.matcher((CharSequence)"");
        final Matcher matcher5 = io.sentry.android.core.internal.threaddump.c.i.matcher((CharSequence)"");
        final Matcher matcher6 = io.sentry.android.core.internal.threaddump.c.k.matcher((CharSequence)"");
        final Matcher matcher7 = io.sentry.android.core.internal.threaddump.c.j.matcher((CharSequence)"");
        final Matcher matcher8 = io.sentry.android.core.internal.threaddump.c.m.matcher((CharSequence)"");
        final Matcher matcher9 = io.sentry.android.core.internal.threaddump.c.l.matcher((CharSequence)"");
        final Matcher matcher10 = io.sentry.android.core.internal.threaddump.c.n.matcher((CharSequence)"");
        final Matcher matcher11 = io.sentry.android.core.internal.threaddump.c.o.matcher((CharSequence)"");
        u u = null;
        while (b.a()) {
            final a b2 = b.b();
            if (b2 == null) {
                this.a.getLogger().a(l4.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                break;
            }
            final String b3 = b2.b;
            u u3 = null;
            Label_0962: {
                if (this.e(matcher, b3)) {
                    final u u2 = new u();
                    u2.y(matcher.group(1));
                    u2.s(matcher.group(2));
                    u2.u(this.b(matcher, 3, null));
                    ((List)list).add((Object)u2);
                }
                else {
                    if (!this.e(matcher2, b3)) {
                        Label_0392: {
                            if (this.e(matcher3, b3)) {
                                u3 = new u();
                                final String format = String.format("%s.%s", new Object[] { matcher3.group(1), matcher3.group(2) });
                                u3.w(format);
                                u3.s(matcher3.group(3));
                                u3.r(matcher3.group(4));
                                u3.u(this.d(matcher3, 5, null));
                                u3.t(this.c.b(format));
                                ((List)list).add((Object)u3);
                            }
                            else if (this.e(matcher4, b3)) {
                                u3 = new u();
                                final String format2 = String.format("%s.%s", new Object[] { matcher4.group(1), matcher4.group(2) });
                                u3.w(format2);
                                u3.s(matcher4.group(3));
                                u3.t(this.c.b(format2));
                                ((List)list).add((Object)u3);
                            }
                            else if (this.e(matcher5, b3)) {
                                if ((u3 = u) != null) {
                                    final m4 m4 = new m4();
                                    m4.l(1);
                                    m4.h(matcher5.group(1));
                                    m4.j(matcher5.group(2));
                                    m4.i(matcher5.group(3));
                                    u.v(m4);
                                    this.a(w, m4);
                                    u3 = u;
                                }
                            }
                            else if (this.e(matcher6, b3)) {
                                if ((u3 = u) != null) {
                                    final m4 m5 = new m4();
                                    m5.l(2);
                                    m5.h(matcher6.group(1));
                                    m5.j(matcher6.group(2));
                                    m5.i(matcher6.group(3));
                                    u.v(m5);
                                    this.a(w, m5);
                                    u3 = u;
                                }
                            }
                            else if (this.e(matcher7, b3)) {
                                if ((u3 = u) != null) {
                                    final m4 m6 = new m4();
                                    m6.l(4);
                                    m6.h(matcher7.group(1));
                                    m6.j(matcher7.group(2));
                                    m6.i(matcher7.group(3));
                                    u.v(m6);
                                    this.a(w, m6);
                                    u3 = u;
                                }
                            }
                            else {
                                if (this.e(matcher8, b3)) {
                                    if ((u3 = u) == null) {
                                        break Label_0392;
                                    }
                                    final m4 m7 = new m4();
                                    m7.l(8);
                                    m7.h(matcher8.group(1));
                                    m7.j(matcher8.group(2));
                                    m7.i(matcher8.group(3));
                                    m7.k(this.c(matcher8, 4, null));
                                    u.v(m7);
                                    this.a(w, m7);
                                }
                                else if (this.e(matcher9, b3)) {
                                    if (u != null) {
                                        final m4 m8 = new m4();
                                        m8.l(8);
                                        m8.h(matcher9.group(1));
                                        m8.j(matcher9.group(2));
                                        m8.i(matcher9.group(3));
                                        u.v(m8);
                                        this.a(w, m8);
                                    }
                                }
                                else if (this.e(matcher10, b3)) {
                                    if (u != null) {
                                        final m4 m9 = new m4();
                                        m9.l(8);
                                        u.v(m9);
                                        this.a(w, m9);
                                    }
                                }
                                else {
                                    if (b3.length() == 0) {
                                        break;
                                    }
                                    u3 = u;
                                    if (this.e(matcher11, b3)) {
                                        break;
                                    }
                                    break Label_0962;
                                }
                                u3 = u;
                            }
                        }
                        break Label_0962;
                    }
                    final u u4 = new u();
                    u4.y(matcher2.group(1));
                    u4.s(matcher2.group(2));
                    ((List)list).add((Object)u4);
                }
                u3 = null;
            }
            u = u3;
        }
        Collections.reverse((List)list);
        final v v = new v((List)list);
        v.e(Boolean.TRUE);
        return v;
    }
    
    private w h(final b b) {
        final w w = new w();
        final Matcher matcher = io.sentry.android.core.internal.threaddump.c.d.matcher((CharSequence)"");
        if (!b.a()) {
            return null;
        }
        final a b2 = b.b();
        final boolean b3 = false;
        if (b2 == null) {
            this.a.getLogger().a(l4.WARNING, "Internal error while parsing thread dump.", new Object[0]);
            return null;
        }
        if (this.e(matcher, b2.b)) {
            final Long c = this.c(matcher, 4, null);
            if (c == null) {
                this.a.getLogger().a(l4.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                return null;
            }
            w.u(c);
            w.w(matcher.group(1));
            final String group = matcher.group(5);
            if (group != null) {
                if (group.contains((CharSequence)" ")) {
                    w.z(group.substring(0, group.indexOf(32)));
                }
                else {
                    w.z(group);
                }
            }
            final String m = w.m();
            if (m != null) {
                final boolean equals = m.equals((Object)"main");
                w.v(Boolean.valueOf(equals));
                w.q(Boolean.valueOf(equals));
                boolean b4 = b3;
                if (equals) {
                    b4 = b3;
                    if (!this.b) {
                        b4 = true;
                    }
                }
                w.r(Boolean.valueOf(b4));
            }
        }
        w.y(this.g(b, w));
        return w;
    }
    
    public List<w> f(final b b) {
        final ArrayList list = new ArrayList();
        final Matcher matcher = io.sentry.android.core.internal.threaddump.c.d.matcher((CharSequence)"");
        while (b.a()) {
            final a b2 = b.b();
            if (b2 == null) {
                this.a.getLogger().a(l4.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                return (List<w>)list;
            }
            if (!this.e(matcher, b2.b)) {
                continue;
            }
            b.d();
            final w h = this.h(b);
            if (h == null) {
                continue;
            }
            ((List)list).add((Object)h);
        }
        return (List<w>)list;
    }
}
