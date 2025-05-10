package io.sentry;

import java.util.Set;
import io.sentry.protocol.w;
import io.sentry.exception.a;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Deque;
import io.sentry.protocol.v;
import io.sentry.protocol.p;
import io.sentry.protocol.u;
import java.util.List;
import io.sentry.protocol.i;
import io.sentry.util.n;

public final class f4
{
    private final s4 a;
    
    public f4(final s4 s4) {
        this.a = n.c(s4, "The SentryStackTraceFactory is required.");
    }
    
    private p b(final Throwable t, final i i, final Long n, final List<u> list, final boolean b) {
        final Package package1 = t.getClass().getPackage();
        final String name = t.getClass().getName();
        final p p5 = new p();
        final String message = t.getMessage();
        String replace = name;
        if (package1 != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(package1.getName());
            sb.append(".");
            replace = name.replace((CharSequence)sb.toString(), (CharSequence)"");
        }
        String name2;
        if (package1 != null) {
            name2 = package1.getName();
        }
        else {
            name2 = null;
        }
        if (list != null && !list.isEmpty()) {
            final v v = new v((List)list);
            if (b) {
                v.e(Boolean.TRUE);
            }
            p5.k(v);
        }
        p5.l(n);
        p5.m(replace);
        p5.i(i);
        p5.j(name2);
        p5.o(message);
        return p5;
    }
    
    private List<p> d(final Deque<p> deque) {
        return (List<p>)new ArrayList((Collection)deque);
    }
    
    Deque<p> a(Throwable cause) {
        final ArrayDeque arrayDeque = new ArrayDeque();
        Throwable c;
        for (HashSet set = new HashSet(); cause != null && ((Set)set).add((Object)cause); cause = c.getCause()) {
            i a2;
            Thread b;
            boolean d;
            if (cause instanceof a) {
                final a a = (a)cause;
                a2 = a.a();
                c = a.c();
                b = a.b();
                d = a.d();
            }
            else {
                final Thread currentThread = Thread.currentThread();
                a2 = null;
                d = false;
                c = cause;
                b = currentThread;
            }
            ((Deque)arrayDeque).addFirst((Object)this.b(c, a2, b.getId(), this.a.a(c.getStackTrace()), d));
        }
        return (Deque<p>)arrayDeque;
    }
    
    public List<p> c(final Throwable t) {
        return this.d(this.a(t));
    }
    
    public List<p> e(final w w, final i i, final Throwable t) {
        final v n = w.n();
        if (n == null) {
            return (List<p>)new ArrayList(0);
        }
        final ArrayList list = new ArrayList(1);
        ((List)list).add((Object)this.b(t, i, w.l(), (List<u>)n.d(), true));
        return (List<p>)list;
    }
}
