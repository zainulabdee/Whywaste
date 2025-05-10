package io.sentry;

import java.util.Random;
import java.util.AbstractMap;
import java.io.Closeable;
import io.sentry.util.v;
import java.io.IOException;
import java.util.Comparator;
import java.util.Collections;
import io.sentry.hints.d;
import io.sentry.util.j;
import io.sentry.protocol.q;
import java.util.Iterator;
import io.sentry.protocol.c;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map$Entry;
import java.util.Map;
import java.util.HashMap;
import io.sentry.util.n;
import java.security.SecureRandom;
import io.sentry.transport.p;

public final class h3 implements r0
{
    private boolean a;
    private final q4 b;
    private final p c;
    private final SecureRandom d;
    private final h3.h3$b e;
    
    h3(final q4 q4) {
        final SecureRandom secureRandom = null;
        this.e = new h3.h3$b((h3$a)null);
        this.b = (q4)n.c((Object)q4, "SentryOptions is required.");
        this.a = true;
        Object transportFactory;
        if ((transportFactory = q4.getTransportFactory()) instanceof d2) {
            transportFactory = new a();
            q4.setTransportFactory((x0)transportFactory);
        }
        this.c = ((x0)transportFactory).a(q4, new p2(q4).a());
        SecureRandom d;
        if (q4.getSampleRate() == null) {
            d = secureRandom;
        }
        else {
            d = new SecureRandom();
        }
        this.d = d;
    }
    
    private void h(final r2 r2, final a0 a0) {
        if (r2 != null) {
            a0.a(r2.i());
        }
    }
    
    private <T extends e3> T i(final T t, final r2 r2) {
        if (r2 != null) {
            if (t.K() == null) {
                t.Z(r2.q());
            }
            if (t.Q() == null) {
                t.e0(r2.w());
            }
            if (t.N() == null) {
                t.d0((Map)new HashMap(r2.t()));
            }
            else {
                for (final Map$Entry map$Entry : r2.t().entrySet()) {
                    if (!t.N().containsKey(map$Entry.getKey())) {
                        t.N().put((Object)map$Entry.getKey(), (Object)map$Entry.getValue());
                    }
                }
            }
            if (t.B() == null) {
                t.R((List)new ArrayList((Collection)r2.j()));
            }
            else {
                this.w(t, (Collection<e>)r2.j());
            }
            if (t.H() == null) {
                t.W((Map)new HashMap(r2.m()));
            }
            else {
                for (final Map$Entry map$Entry2 : r2.m().entrySet()) {
                    if (!t.H().containsKey(map$Entry2.getKey())) {
                        t.H().put((Object)map$Entry2.getKey(), map$Entry2.getValue());
                    }
                }
            }
            final c c = t.C();
            for (final Map$Entry map$Entry3 : ((AbstractMap)new c(r2.k())).entrySet()) {
                if (!((AbstractMap)c).containsKey(map$Entry3.getKey())) {
                    ((AbstractMap)c).put((Object)map$Entry3.getKey(), map$Entry3.getValue());
                }
            }
        }
        return t;
    }
    
    private e4 j(final e4 e4, final r2 r2, final a0 a0) {
        e4 r3 = e4;
        if (r2 != null) {
            this.i(e4, r2);
            if (e4.t0() == null) {
                e4.D0(r2.v());
            }
            if (e4.p0() == null) {
                e4.x0((List<String>)r2.n());
            }
            if (r2.o() != null) {
                e4.y0(r2.o());
            }
            final u0 s = r2.s();
            if (e4.C().e() == null) {
                if (s == null) {
                    e4.C().m((d5)p5.o(r2.p()));
                }
                else {
                    e4.C().m(s.i());
                }
            }
            r3 = this.r(e4, a0, (List<x>)r2.l());
        }
        return r3;
    }
    
    private l3 k(final e3 e3, final List<b> list, final a5 a5, final m5 m5, final l2 l2) {
        final ArrayList list2 = new ArrayList();
        q g;
        if (e3 != null) {
            ((List)list2).add((Object)c4.s(this.b.getSerializer(), e3));
            g = e3.G();
        }
        else {
            g = null;
        }
        if (a5 != null) {
            ((List)list2).add((Object)c4.u(this.b.getSerializer(), a5));
        }
        q q = g;
        if (l2 != null) {
            ((List)list2).add((Object)c4.t(l2, this.b.getMaxTraceFileSize(), this.b.getSerializer()));
            if ((q = g) == null) {
                q = new q(l2.A());
            }
        }
        if (list != null) {
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((List)list2).add((Object)c4.q(this.b.getSerializer(), this.b.getLogger(), (b)iterator.next(), this.b.getMaxAttachmentSize()));
            }
        }
        if (!((List)list2).isEmpty()) {
            return new l3(new m3(q, this.b.getSdkVersion(), m5), (Iterable)list2);
        }
        return null;
    }
    
    private e4 l(final e4 e4, final a0 a0) {
        final q4$b beforeSend = this.b.getBeforeSend();
        e4 e5 = e4;
        if (beforeSend != null) {
            try {
                beforeSend.execute(e4, a0);
            }
            finally {
                final Throwable t;
                this.b.getLogger().d(l4.ERROR, "The BeforeSend callback threw an exception. It will be added as breadcrumb and continue.", t);
                e5 = null;
            }
        }
        return e5;
    }
    
    private io.sentry.protocol.x m(final io.sentry.protocol.x x, final a0 a0) {
        final q4$c beforeSendTransaction = this.b.getBeforeSendTransaction();
        io.sentry.protocol.x x2 = x;
        if (beforeSendTransaction != null) {
            try {
                beforeSendTransaction.a(x, a0);
            }
            finally {
                final Throwable t;
                this.b.getLogger().d(l4.ERROR, "The BeforeSendTransaction callback threw an exception. It will be added as breadcrumb and continue.", t);
                x2 = null;
            }
        }
        return x2;
    }
    
    private List<b> n(final List<b> list) {
        if (list == null) {
            return null;
        }
        final ArrayList list2 = new ArrayList();
        for (final b b : list) {
            if (b.j()) {
                ((List)list2).add((Object)b);
            }
        }
        return (List<b>)list2;
    }
    
    private List<b> o(final a0 a0) {
        final List e = a0.e();
        final b f = a0.f();
        if (f != null) {
            e.add((Object)f);
        }
        final b h = a0.h();
        if (h != null) {
            e.add((Object)h);
        }
        final b g = a0.g();
        if (g != null) {
            e.add((Object)g);
        }
        return (List<b>)e;
    }
    
    private e4 r(e4 e4, final a0 a0, List<x> e5) {
        final Iterator iterator = ((List)e5).iterator();
        e5 = e4;
        e4 e6;
        x x;
        do {
            e6 = e5;
            if (!iterator.hasNext()) {
                return e6;
            }
            x = (x)iterator.next();
            try {
                final boolean b = x instanceof io.sentry.c;
                final boolean g = j.g(a0, (Class)d.class);
                if (g && b) {
                    e4 = x.c(e5, a0);
                }
                else {
                    if (g || b) {
                        continue;
                    }
                    e4 = x.c(e5, a0);
                }
            }
            finally {
                final Throwable t;
                this.b.getLogger().c(l4.ERROR, t, "An exception occurred while processing event by processor: %s", new Object[] { x.getClass().getName() });
                e6 = e5;
            }
        } while ((e5 = e6) != null);
        this.b.getLogger().a(l4.DEBUG, "Event was dropped by a processor: %s", new Object[] { x.getClass().getName() });
        this.b.getClientReportRecorder().a(io.sentry.clientreport.e.EVENT_PROCESSOR, i.Error);
        return e6;
    }
    
    private io.sentry.protocol.x s(io.sentry.protocol.x x, final a0 a0, final List<x> list) {
        final Iterator iterator = list.iterator();
        io.sentry.protocol.x x2;
        x x3;
        do {
            x2 = x;
            if (!iterator.hasNext()) {
                return x2;
            }
            x3 = (x)iterator.next();
            try {
                x3.b(x, a0);
            }
            finally {
                final Throwable t;
                this.b.getLogger().c(l4.ERROR, t, "An exception occurred while processing transaction by processor: %s", new Object[] { x3.getClass().getName() });
                x2 = x;
            }
            x = x2;
        } while (x2 != null);
        this.b.getLogger().a(l4.DEBUG, "Transaction was dropped by a processor: %s", new Object[] { x3.getClass().getName() });
        this.b.getClientReportRecorder().a(io.sentry.clientreport.e.EVENT_PROCESSOR, i.Transaction);
        return x2;
    }
    
    private boolean t() {
        final Double sampleRate = this.b.getSampleRate();
        boolean b2;
        final boolean b = b2 = true;
        if (sampleRate != null) {
            b2 = b;
            if (this.d != null) {
                b2 = (this.b.getSampleRate() >= ((Random)this.d).nextDouble() && b);
            }
        }
        return b2;
    }
    
    private boolean u(final e3 e3, final a0 a0) {
        if (j.s(a0)) {
            return true;
        }
        this.b.getLogger().a(l4.DEBUG, "Event was cached so not applying scope: %s", new Object[] { e3.G() });
        return false;
    }
    
    private boolean v(final a5 a5, final a5 a6) {
        if (a6 == null) {
            return false;
        }
        if (a5 == null) {
            return true;
        }
        final a5.a5$b l = a6.l();
        final a5$b crashed = a5$b.Crashed;
        return (l == crashed && a5.l() != crashed) || (a6.e() > 0 && a5.e() <= 0);
    }
    
    private void w(final e3 e3, final Collection<e> collection) {
        final List b = e3.B();
        if (b != null && !collection.isEmpty()) {
            b.addAll((Collection)collection);
            Collections.sort(b, (Comparator)this.e);
        }
    }
    
    public void a(final a5 a5, final a0 a6) {
        n.c((Object)a5, "Session is required.");
        if (a5.h() != null) {
            if (!a5.h().isEmpty()) {
                try {
                    this.g(l3.a(this.b.getSerializer(), a5, this.b.getSdkVersion()), a6);
                    return;
                }
                catch (final IOException ex) {
                    this.b.getLogger().d(l4.ERROR, "Failed to capture session.", (Throwable)ex);
                    return;
                }
            }
        }
        this.b.getLogger().a(l4.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
    }
    
    public q b(io.sentry.protocol.x b, final m5 m5, final r2 r2, a0 g, final l2 l2) {
        io.sentry.exception.b b2 = b;
        n.c((Object)b, "Transaction is required.");
        Object o;
        if (g == null) {
            o = new a0();
        }
        else {
            o = g;
        }
        if (this.u((e3)b, (a0)o)) {
            this.h(r2, (a0)o);
        }
        final n0 logger = this.b.getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "Capturing transaction: %s", new Object[] { ((e3)b).G() });
        final Object f = q.f;
        if (((e3)b).G() != null) {
            g = ((e3)b).G();
        }
        else {
            g = f;
        }
        if (this.u((e3)b, (a0)o)) {
            final Object o2 = this.i((io.sentry.protocol.x)b, r2);
            if ((b = (io.sentry.exception.b)o2) != null) {
                b = (io.sentry.exception.b)o2;
                if (r2 != null) {
                    b = (io.sentry.exception.b)this.s((io.sentry.protocol.x)o2, (a0)o, (List<x>)r2.l());
                }
            }
            if ((b2 = b) == null) {
                this.b.getLogger().a(debug, "Transaction was dropped by applyScope", new Object[0]);
                b2 = b;
            }
        }
        if ((b = b2) != null) {
            b = (io.sentry.exception.b)this.s((io.sentry.protocol.x)b2, (a0)o, (List<x>)this.b.getEventProcessors());
        }
        if (b == null) {
            this.b.getLogger().a(debug, "Transaction was dropped by Event processors.", new Object[0]);
            return (q)f;
        }
        b = (io.sentry.exception.b)this.m((io.sentry.protocol.x)b, (a0)o);
        if (b == null) {
            this.b.getLogger().a(debug, "Transaction was dropped by beforeSendTransaction.", new Object[0]);
            this.b.getClientReportRecorder().a(io.sentry.clientreport.e.BEFORE_SEND, i.Transaction);
            return (q)f;
        }
        try {
            final l3 k = this.k((e3)b, this.n(this.o((a0)o)), null, m5, l2);
            ((a0)o).b();
            b = (io.sentry.exception.b)f;
            if (k != null) {
                this.c.k(k, (a0)o);
                b = (io.sentry.exception.b)g;
                return (q)b;
            }
            return (q)b;
        }
        catch (final io.sentry.exception.b b) {}
        catch (final IOException ex) {}
        this.b.getLogger().c(l4.WARNING, (Throwable)b, "Capturing transaction %s failed.", new Object[] { g });
        b = (io.sentry.exception.b)q.f;
        return (q)b;
    }
    
    public q c(e4 o, final r2 r2, final a0 a0) {
        n.c(o, "SentryEvent is required.");
        a0 a2 = a0;
        if (a0 == null) {
            a2 = new a0();
        }
        if (this.u((e3)o, a2)) {
            this.h(r2, a2);
        }
        final n0 logger = this.b.getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "Capturing event: %s", new Object[] { ((e3)o).G() });
        final Throwable o2 = ((e3)o).O();
        if (o2 != null && this.b.containsIgnoredExceptionForType(o2)) {
            this.b.getLogger().a(debug, "Event was dropped as the exception %s is ignored", new Object[] { o2.getClass() });
            this.b.getClientReportRecorder().a(io.sentry.clientreport.e.EVENT_PROCESSOR, i.Error);
            return q.f;
        }
        Object o3 = o;
        if (this.u((e3)o, a2)) {
            o = this.j((e4)o, r2, a2);
            if ((o3 = o) == null) {
                this.b.getLogger().a(debug, "Event was dropped by applyScope", new Object[0]);
                return q.f;
            }
        }
        final e4 r3 = this.r((e4)o3, a2, (List<x>)this.b.getEventProcessors());
        if ((o = r3) != null) {
            final e4 l = this.l(r3, a2);
            if ((o = l) == null) {
                this.b.getLogger().a(debug, "Event was dropped by beforeSend", new Object[0]);
                this.b.getClientReportRecorder().a(io.sentry.clientreport.e.BEFORE_SEND, i.Error);
                o = l;
            }
        }
        if (o == null) {
            return q.f;
        }
        List<b> o4 = null;
        a5 i;
        if (r2 != null) {
            i = r2.I((r2$b)new f3());
        }
        else {
            i = null;
        }
        final a5 x = this.x((e4)o, a2, r2);
        Object o5;
        if (!this.t()) {
            this.b.getLogger().a(debug, "Event %s was dropped due to sampling decision.", new Object[] { ((e3)o).G() });
            this.b.getClientReportRecorder().a(io.sentry.clientreport.e.SAMPLE_RATE, io.sentry.i.Error);
            o5 = null;
        }
        else {
            o5 = o;
        }
        final boolean v = this.v(i, x);
        if (o5 == null && !v) {
            this.b.getLogger().a(debug, "Not sending session update for dropped event as it did not cause the session health to change.", new Object[0]);
            return q.f;
        }
        final q q = (q)(o = io.sentry.protocol.q.f);
        if (o5 != null) {
            o = q;
            if (((e3)o5).G() != null) {
                o = ((e3)o5).G();
            }
        }
        Object f = null;
        Label_0599: {
            m5 m5 = null;
            Label_0497: {
                Label_0495: {
                    if (r2 != null) {
                        Label_0568: {
                            try {
                                final v0 u = r2.u();
                                if (u != null) {
                                    m5 = ((u0)u).c();
                                }
                                else {
                                    m5 = io.sentry.util.v.g(r2, this.b).h();
                                }
                                break Label_0497;
                            }
                            catch (final io.sentry.exception.b b) {
                                break Label_0568;
                            }
                            catch (final IOException b) {
                                break Label_0568;
                            }
                            break Label_0495;
                        }
                        final io.sentry.exception.b b;
                        this.b.getLogger().c(l4.WARNING, (Throwable)b, "Capturing event %s failed.", new Object[] { o });
                        f = io.sentry.protocol.q.f;
                        break Label_0599;
                    }
                }
                m5 = null;
            }
            if (o5 != null) {
                o4 = this.o(a2);
            }
            final l3 k = this.k((e3)o5, o4, x, m5, null);
            a2.b();
            f = o;
            if (k != null) {
                this.c.k(k, a2);
                f = o;
            }
        }
        if (r2 != null) {
            final v0 u2 = r2.u();
            if (u2 != null && j.g(a2, (Class)io.sentry.hints.p.class)) {
                u2.k(h5.ABORTED, false);
            }
        }
        return (q)f;
    }
    
    public void close() {
        this.b.getLogger().a(l4.INFO, "Closing SentryClient.", new Object[0]);
        try {
            this.e(this.b.getShutdownTimeoutMillis());
            ((Closeable)this.c).close();
        }
        catch (final IOException ex) {
            this.b.getLogger().d(l4.WARNING, "Failed to close the connection to the Sentry Server.", (Throwable)ex);
        }
        for (final x x : this.b.getEventProcessors()) {
            if (x instanceof Closeable) {
                try {
                    ((Closeable)x).close();
                }
                catch (final IOException ex2) {
                    this.b.getLogger().a(l4.WARNING, "Failed to close the event processor {}.", new Object[] { x, ex2 });
                }
            }
        }
        this.a = false;
    }
    
    public void e(final long n) {
        this.c.e(n);
    }
    
    public q g(final l3 l3, final a0 a0) {
        n.c((Object)l3, "SentryEnvelope is required.");
        a0 a2 = a0;
        if (a0 == null) {
            a2 = new a0();
        }
        try {
            a2.b();
            this.c.k(l3, a2);
            final q a3 = l3.b().a();
            if (a3 != null) {
                return a3;
            }
            return q.f;
        }
        catch (final IOException ex) {
            this.b.getLogger().d(l4.ERROR, "Failed to capture envelope.", (Throwable)ex);
            return q.f;
        }
    }
    
    a5 x(final e4 e4, final a0 a0, final r2 r2) {
        if (j.s(a0)) {
            if (r2 != null) {
                return r2.I((r2$b)new g3(this, e4, a0));
            }
            this.b.getLogger().a(l4.INFO, "Scope is null on client.captureEvent", new Object[0]);
        }
        return null;
    }
}
