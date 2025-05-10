package io.sentry.android.ndk;

import java.util.Collection;
import io.sentry.protocol.a0;
import io.sentry.d5;
import io.sentry.j;
import java.util.Locale;
import io.sentry.e;
import io.sentry.p0;
import java.util.Map;
import io.sentry.l4;
import io.sentry.util.n;
import io.sentry.q4;
import io.sentry.q0;

public final class c implements q0
{
    private final q4 a;
    private final b b;
    
    public c(final q4 q4) {
        this(q4, (b)new NativeScope());
    }
    
    c(final q4 q4, final b b) {
        this.a = (q4)n.c((Object)q4, "The SentryOptions object is required.");
        this.b = (b)n.c((Object)b, "The NativeScope object is required.");
    }
    
    public void a(final String s) {
        try {
            this.b.a(s);
        }
        finally {
            final Throwable t;
            this.a.getLogger().c(l4.ERROR, t, "Scope sync removeTag(%s) has an error.", new Object[] { s });
        }
    }
    
    public void b(final String s, final String s2) {
        try {
            this.b.b(s, s2);
        }
        finally {
            final Throwable t;
            this.a.getLogger().c(l4.ERROR, t, "Scope sync setTag(%s) has an error.", new Object[] { s });
        }
    }
    
    public void c(final String s) {
        try {
            this.b.c(s);
        }
        finally {
            final Throwable t;
            this.a.getLogger().c(l4.ERROR, t, "Scope sync removeExtra(%s) has an error.", new Object[] { s });
        }
    }
    
    public void d(final String s, final String s2) {
        try {
            this.b.d(s, s2);
        }
        finally {
            final Throwable t;
            this.a.getLogger().c(l4.ERROR, t, "Scope sync setExtra(%s) has an error.", new Object[] { s });
        }
    }
    
    public void f(final e e) {
        try {
            final l4 i = e.i();
            final String s = null;
            String lowerCase;
            if (i != null) {
                lowerCase = e.i().name().toLowerCase(Locale.ROOT);
            }
            else {
                lowerCase = null;
            }
            final String g = j.g(e.k());
            String s2 = null;
            try {
                final Map<String, Object> h = e.h();
                if (!h.isEmpty()) {
                    this.a.getSerializer().f((Map)h);
                }
            }
            finally {
                final Throwable t;
                this.a.getLogger().c(l4.ERROR, t, "Breadcrumb data is not serializable.", new Object[0]);
                s2 = s;
            }
            this.b.f(lowerCase, e.j(), e.g(), e.l(), g, s2);
        }
        finally {
            final Throwable t2;
            this.a.getLogger().c(l4.ERROR, t2, "Scope sync addBreadcrumb has an error.", new Object[0]);
        }
    }
    
    public void h(final a0 a0) {
        while (true) {
            if (a0 == null) {
                try {
                    this.b.g();
                    return;
                    this.b.e(a0.m(), a0.l(), a0.n(), a0.p());
                }
                finally {
                    final Throwable t;
                    this.a.getLogger().c(l4.ERROR, t, "Scope sync setUser has an error.", new Object[0]);
                }
                return;
            }
            continue;
        }
    }
}
