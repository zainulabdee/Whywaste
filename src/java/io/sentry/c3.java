package io.sentry;

import io.sentry.util.thread.d;
import io.sentry.internal.modules.a;
import java.util.Arrays;
import io.sentry.internal.modules.f;
import io.sentry.internal.modules.c;
import io.sentry.internal.modules.b;
import java.util.concurrent.RejectedExecutionException;
import io.sentry.transport.r;
import io.sentry.config.h;
import java.util.Iterator;
import io.sentry.protocol.q;
import java.io.File;

public final class c3
{
    private static final ThreadLocal<m0> a;
    private static volatile m0 b;
    private static volatile boolean c;
    
    static {
        a = new ThreadLocal();
        c3.b = (m0)t1.u();
        c3.c = false;
    }
    
    public static v0 A(final p5 p2, final r5 r5) {
        return m().i(p2, r5);
    }
    
    public static void c(final e e) {
        m().f(e);
    }
    
    public static void d(final e e, final a0 a0) {
        m().k(e, a0);
    }
    
    private static <T extends q4> void e(final a<T> a, final T t) {
        try {
            a.configure(t);
        }
        finally {
            final Throwable t2;
            t.getLogger().d(l4.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", t2);
        }
    }
    
    public static q f(final e4 e4, final a0 a0) {
        return m().s(e4, a0);
    }
    
    public static void g() {
        m().t();
    }
    
    public static void h() {
        synchronized (c3.class) {
            final m0 m = m();
            c3.b = (m0)t1.u();
            c3.a.remove();
            m.close();
        }
    }
    
    public static void i(final s2 s2) {
        m().l(s2);
    }
    
    public static void j() {
        m().n();
    }
    
    private static void k(final q4 q4, final m0 m0) {
        try {
            q4.getExecutorService().submit((Runnable)new j2(q4, m0));
        }
        finally {
            final Throwable t;
            q4.getLogger().d(l4.DEBUG, "Failed to finalize previous session.", t);
        }
    }
    
    public static void l(final long n) {
        m().e(n);
    }
    
    public static m0 m() {
        if (c3.c) {
            return c3.b;
        }
        final ThreadLocal<m0> a = c3.a;
        final m0 m0 = (m0)a.get();
        if (m0 != null) {
            final m0 clone = m0;
            if (!(m0 instanceof t1)) {
                return clone;
            }
        }
        final m0 clone = c3.b.clone();
        a.set((Object)clone);
        return clone;
    }
    
    public static <T extends q4> void n(final e2<T> e2, final a<T> a, final boolean b) {
        final q4 q4 = e2.b();
        e((a<q4>)a, q4);
        o(q4, b);
    }
    
    private static void o(final q4 q4, final boolean c) {
        synchronized (c3.class) {
            if (q()) {
                q4.getLogger().a(l4.WARNING, "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
            }
            if (!p(q4)) {
                return;
            }
            q4.getLogger().a(l4.INFO, "GlobalHubMode: '%s'", String.valueOf(c));
            c3.c = c;
            final m0 m = m();
            c3.b = (m0)new g0(q4);
            c3.a.set((Object)c3.b);
            m.close();
            if (q4.getExecutorService().isClosed()) {
                q4.setExecutorService((s0)new g4());
            }
            final Iterator iterator = q4.getIntegrations().iterator();
            while (iterator.hasNext()) {
                ((Integration)iterator.next()).d((m0)h0.u(), q4);
            }
            t(q4);
            k(q4, (m0)h0.u());
        }
    }
    
    private static boolean p(final q4 q4) {
        if (q4.isEnableExternalConfiguration()) {
            q4.merge(y.g(h.a(), q4.getLogger()));
        }
        final String dsn = q4.getDsn();
        if (dsn == null) {
            throw new IllegalArgumentException("DSN is required. Use empty string to disable SDK.");
        }
        if (dsn.isEmpty()) {
            h();
            return false;
        }
        new p(dsn);
        n0 n2;
        final n0 n0 = n2 = q4.getLogger();
        if (q4.isDebug()) {
            n2 = n0;
            if (n0 instanceof u1) {
                q4.setLogger((n0)new l5());
                n2 = q4.getLogger();
            }
        }
        final l4 info = l4.INFO;
        n2.a(info, "Initializing SDK with DSN: '%s'", q4.getDsn());
        final String outboxPath = q4.getOutboxPath();
        if (outboxPath != null) {
            new File(outboxPath).mkdirs();
        }
        else {
            n2.a(info, "No outbox dir path is defined in options.", new Object[0]);
        }
        final String cacheDirPath = q4.getCacheDirPath();
        if (cacheDirPath != null) {
            new File(cacheDirPath).mkdirs();
            if (q4.getEnvelopeDiskCache() instanceof r) {
                q4.setEnvelopeDiskCache(io.sentry.cache.e.x(q4));
            }
        }
        final String profilingTracesDirPath = q4.getProfilingTracesDirPath();
        if (q4.isProfilingEnabled() && profilingTracesDirPath != null) {
            final File file = new File(profilingTracesDirPath);
            file.mkdirs();
            final File[] listFiles = file.listFiles();
            try {
                q4.getExecutorService().submit((Runnable)new a3(listFiles));
            }
            catch (final RejectedExecutionException ex) {
                q4.getLogger().d(l4.ERROR, "Failed to call the executor. Old profiles will not be deleted. Did you call Sentry.close()?", (Throwable)ex);
            }
        }
        if (q4.getModulesLoader() instanceof io.sentry.internal.modules.e) {
            q4.setModulesLoader((b)new io.sentry.internal.modules.a(Arrays.asList((Object[])new b[] { (b)new c(q4.getLogger()), (b)new f(q4.getLogger()) }), q4.getLogger()));
        }
        if (q4.getDebugMetaLoader() instanceof io.sentry.internal.debugmeta.b) {
            q4.setDebugMetaLoader((io.sentry.internal.debugmeta.a)new io.sentry.internal.debugmeta.c(q4.getLogger()));
        }
        io.sentry.util.c.c(q4, q4.getDebugMetaLoader().a());
        if (q4.getMainThreadChecker() instanceof d) {
            q4.setMainThreadChecker((io.sentry.util.thread.b)io.sentry.util.thread.c.d());
        }
        if (q4.getCollectors().isEmpty()) {
            q4.addCollector((i0)new b1());
        }
        return true;
    }
    
    public static boolean q() {
        return m().isEnabled();
    }
    
    private static void t(final q4 q4) {
        try {
            q4.getExecutorService().submit((Runnable)new b3(q4));
        }
        finally {
            final Throwable t;
            q4.getLogger().d(l4.DEBUG, "Failed to notify options observers.", t);
        }
    }
    
    public static void u(final String s) {
        m().c(s);
    }
    
    public static void v(final String s) {
        m().a(s);
    }
    
    public static void w(final String s, final String s2) {
        m().d(s, s2);
    }
    
    public static void x(final String s, final String s2) {
        m().b(s, s2);
    }
    
    public static void y(final io.sentry.protocol.a0 a0) {
        m().h(a0);
    }
    
    public static void z() {
        m().p();
    }
    
    public interface a<T extends q4>
    {
        void configure(final T p0);
    }
}
