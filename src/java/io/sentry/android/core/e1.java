package io.sentry.android.core;

import java.util.List;
import java.lang.reflect.InvocationTargetException;
import io.sentry.l4;
import io.sentry.android.core.internal.util.c;
import io.sentry.e2;
import java.util.Iterator;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.Integration;
import java.util.ArrayList;
import io.sentry.q4;
import io.sentry.c3;
import android.content.Context;
import io.sentry.n0;
import android.os.SystemClock;
import io.sentry.j3;

public final class e1
{
    private static final j3 a;
    private static final long b;
    
    static {
        a = s.a();
        b = SystemClock.uptimeMillis();
    }
    
    private static void b(final q4 q4, final boolean b, final boolean b2) {
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (final Integration integration : q4.getIntegrations()) {
            if (b && integration instanceof FragmentLifecycleIntegration) {
                ((List)list2).add((Object)integration);
            }
            if (b2 && integration instanceof SentryTimberIntegration) {
                ((List)list).add((Object)integration);
            }
        }
        final int size = ((List)list2).size();
        final int n = 0;
        if (size > 1) {
            for (int i = 0; i < ((List)list2).size() - 1; ++i) {
                q4.getIntegrations().remove((Object)((List)list2).get(i));
            }
        }
        if (((List)list).size() > 1) {
            for (int j = n; j < ((List)list).size() - 1; ++j) {
                q4.getIntegrations().remove((Object)((List)list).get(j));
            }
        }
    }
    
    public static void c(final Context context, final n0 n0, final c3.a<SentryAndroidOptions> a) {
        synchronized (e1.class) {
            j0.e().i(e1.b, e1.a);
            try {
                c3.n((e2<q4>)e2.a(SentryAndroidOptions.class), (c3.a<q4>)new d1(n0, context, (c3.a)a), true);
                final io.sentry.m0 m = c3.m();
                if (m.r().isEnableAutoSessionTracking() && m0.n(context)) {
                    m.f(c.a("session.start"));
                    m.p();
                }
            }
            catch (final InvocationTargetException ex) {
                n0.d(l4.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable)ex);
                throw new RuntimeException("Failed to initialize Sentry's SDK", (Throwable)ex);
            }
            catch (final NoSuchMethodException ex2) {
                n0.d(l4.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable)ex2);
                throw new RuntimeException("Failed to initialize Sentry's SDK", (Throwable)ex2);
            }
            catch (final InstantiationException ex3) {
                n0.d(l4.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable)ex3);
                throw new RuntimeException("Failed to initialize Sentry's SDK", (Throwable)ex3);
            }
            catch (final IllegalAccessException ex4) {
                n0.d(l4.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable)ex4);
                throw new RuntimeException("Failed to initialize Sentry's SDK", (Throwable)ex4);
            }
        }
    }
    
    public static void d(final Context context, final c3.a<SentryAndroidOptions> a) {
        c(context, (n0)new t(), a);
    }
}
