package io.sentry;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import io.sentry.util.m;
import io.sentry.hints.h;
import java.util.Iterator;
import io.sentry.util.j$a;
import io.sentry.protocol.x;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import io.sentry.util.b;
import io.sentry.util.q;
import io.sentry.hints.i;
import io.sentry.hints.j;
import java.io.File;
import io.sentry.util.n;
import java.nio.charset.Charset;

public final class h2 extends o implements k0
{
    private static final Charset g;
    private final m0 c;
    private final j0 d;
    private final t0 e;
    private final n0 f;
    
    static {
        g = Charset.forName("UTF-8");
    }
    
    public h2(final m0 m0, final j0 j0, final t0 t0, final n0 n0, final long n2) {
        super(n0, n2);
        this.c = (m0)n.c((Object)m0, "Hub is required.");
        this.d = (j0)n.c((Object)j0, "Envelope reader is required.");
        this.e = (t0)n.c((Object)t0, "Serializer is required.");
        this.f = (n0)n.c((Object)n0, "Logger is required.");
    }
    
    private o5 i(m5 a) {
        if (a != null) {
            a = (m5)a.a();
            if (a != null) {
                try {
                    final Double value = Double.parseDouble((String)a);
                    if (q.e(value, false)) {
                        return new o5(Boolean.TRUE, value);
                    }
                    this.f.a(l4.ERROR, "Invalid sample rate parsed from TraceContext: %s", new Object[] { a });
                }
                catch (final Exception ex) {
                    this.f.a(l4.ERROR, "Unable to parse sample rate from TraceContext: %s", new Object[] { a });
                }
            }
        }
        return new o5(Boolean.TRUE);
    }
    
    private void l(final c4 c4, final int n) {
        this.f.a(l4.ERROR, "Item %d of type %s returned null by the parser.", new Object[] { n, c4.x().b() });
    }
    
    private void m(final int n) {
        this.f.a(l4.DEBUG, "Item %d is being captured.", new Object[] { n });
    }
    
    private void n(final io.sentry.protocol.q q) {
        this.f.a(l4.WARNING, "Timed out waiting for event id submission: %s", new Object[] { q });
    }
    
    private void o(final l3 l3, final io.sentry.protocol.q q, final int n) {
        this.f.a(l4.ERROR, "Item %d of has a different event id (%s) to the envelope header (%s)", new Object[] { n, l3.b().a(), q });
    }
    
    private void p(final l3 l3, final a0 a0) {
        this.f.a(l4.DEBUG, "Processing Envelope with %d item(s)", new Object[] { b.d(l3.c()) });
        final Iterator iterator = l3.c().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final c4 c4 = (c4)iterator.next();
            ++n;
            if (c4.x() == null) {
                this.f.a(l4.ERROR, "Item %d has no header", new Object[] { n });
            }
            else {
                Label_0756: {
                    if (k4.Event.equals(c4.x().b())) {
                        try {
                            final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new ByteArrayInputStream(c4.w()), h2.g));
                            try {
                                final e4 e4 = (e4)this.e.a((Reader)bufferedReader, (Class)e4.class);
                                if (e4 == null) {
                                    this.l(c4, n);
                                }
                                else {
                                    if (e4.L() != null) {
                                        io.sentry.util.j.q(a0, e4.L().f());
                                    }
                                    if (l3.b().a() != null && !l3.b().a().equals(e4.G())) {
                                        this.o(l3, e4.G(), n);
                                        ((Reader)bufferedReader).close();
                                        continue;
                                    }
                                    this.c.s(e4, a0);
                                    this.m(n);
                                    if (!this.q(a0)) {
                                        this.n(e4.G());
                                        ((Reader)bufferedReader).close();
                                        break;
                                    }
                                }
                                ((Reader)bufferedReader).close();
                            }
                            finally {
                                try {
                                    ((Reader)bufferedReader).close();
                                }
                                finally {
                                    final Throwable t;
                                    final Throwable t2;
                                    t.addSuppressed(t2);
                                }
                            }
                        }
                        finally {
                            final Throwable t3;
                            this.f.d(l4.ERROR, "Item failed to process.", t3);
                            break Label_0756;
                        }
                    }
                    if (k4.Transaction.equals(c4.x().b())) {
                        try {
                            final BufferedReader bufferedReader2 = new BufferedReader((Reader)new InputStreamReader((InputStream)new ByteArrayInputStream(c4.w()), h2.g));
                            try {
                                final x x = (x)this.e.a((Reader)bufferedReader2, (Class)x.class);
                                if (x == null) {
                                    this.l(c4, n);
                                }
                                else {
                                    if (l3.b().a() != null && !l3.b().a().equals(x.G())) {
                                        this.o(l3, x.G(), n);
                                        ((Reader)bufferedReader2).close();
                                        continue;
                                    }
                                    final m5 c5 = l3.b().c();
                                    if (x.C().e() != null) {
                                        x.C().e().l(this.i(c5));
                                    }
                                    this.c.j(x, c5, a0);
                                    this.m(n);
                                    if (!this.q(a0)) {
                                        this.n(x.G());
                                        ((Reader)bufferedReader2).close();
                                        break;
                                    }
                                }
                                ((Reader)bufferedReader2).close();
                            }
                            finally {
                                try {
                                    ((Reader)bufferedReader2).close();
                                }
                                finally {
                                    final Throwable t4;
                                    final Throwable t5;
                                    t4.addSuppressed(t5);
                                }
                            }
                        }
                        finally {
                            final Throwable t6;
                            this.f.d(l4.ERROR, "Item failed to process.", t6);
                            break Label_0756;
                        }
                    }
                    this.c.g(new l3(l3.b().a(), l3.b().b(), c4), a0);
                    this.f.a(l4.DEBUG, "%s item %d is being captured.", new Object[] { c4.x().b().getItemType(), n });
                    if (!this.q(a0)) {
                        this.f.a(l4.WARNING, "Timed out waiting for item type submission: %s", new Object[] { c4.x().b().getItemType() });
                        break;
                    }
                }
                final Object f = io.sentry.util.j.f(a0);
                if (f instanceof io.sentry.hints.o && !((io.sentry.hints.o)f).c()) {
                    this.f.a(l4.WARNING, "Envelope had a failed capture at item %d. No more items will be sent.", new Object[] { n });
                    break;
                }
                io.sentry.util.j.n(a0, (Class)i.class, (j$a)new g2());
            }
        }
    }
    
    private boolean q(final a0 a0) {
        final Object f = io.sentry.util.j.f(a0);
        if (f instanceof h) {
            return ((h)f).d();
        }
        m.a((Class)h.class, f, this.f);
        return true;
    }
    
    public void a(final String s, final a0 a0) {
        n.c((Object)s, "Path is required.");
        this.f(new File(s), a0);
    }
    
    protected boolean c(final String s) {
        return s != null && !s.startsWith("session") && !s.startsWith("previous_session") && !s.startsWith("startup_crash");
    }
    
    protected void f(File file, final a0 a0) {
        n.c((Object)file, "File is required.");
        if (!this.c(file.getName())) {
            this.f.a(l4.DEBUG, "File '%s' should be ignored.", new Object[] { file.getAbsolutePath() });
            return;
        }
        Label_0240: {
            f2 f3 = null;
            try {
                Object o = new BufferedInputStream((InputStream)new FileInputStream(file));
                try {
                    final l3 a2 = this.d.a((InputStream)o);
                    if (a2 == null) {
                        this.f.a(l4.ERROR, "Stream from path %s resulted in a null envelope.", new Object[] { file.getAbsolutePath() });
                    }
                    else {
                        this.p(a2, a0);
                        this.f.a(l4.DEBUG, "File '%s' is done.", new Object[] { file.getAbsolutePath() });
                    }
                    ((InputStream)o).close();
                    final Object f = this.f;
                    o = new f2(this, file);
                    file = (File)f;
                }
                finally {
                    try {
                        ((InputStream)o).close();
                    }
                    finally {
                        final Throwable t;
                        final Throwable t2;
                        t.addSuppressed(t2);
                    }
                }
            }
            catch (final IOException ex) {
                this.f.d(l4.ERROR, "Error processing envelope.", (Throwable)ex);
                final Object f2 = this.f;
                f3 = new f2(this, file);
                file = (File)f2;
            }
            finally {
                break Label_0240;
            }
            io.sentry.util.j.p(a0, (Class)j.class, (n0)file, (j$a)f3);
            return;
        }
        io.sentry.util.j.p(a0, (Class)j.class, this.f, (j$a)new f2(this, file));
    }
}
