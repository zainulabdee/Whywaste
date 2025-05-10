package s2;

import c2.k$a;
import java.util.concurrent.CancellationException;
import e2.g;
import c2.q;
import c2.l;
import c2.k;
import e2.g$c;
import kotlinx.coroutines.internal.f;
import kotlin.jvm.internal.i;
import c2.a;
import e2.d;
import kotlinx.coroutines.scheduling.h;

public abstract class q0<T> extends h
{
    public int g;
    
    public q0(final int g) {
        this.g = g;
    }
    
    public void a(final Object o, final Throwable t) {
    }
    
    public abstract d<T> b();
    
    public Throwable d(final Object o) {
        final boolean b = o instanceof v;
        Throwable a = null;
        v v;
        if (b) {
            v = (v)o;
        }
        else {
            v = null;
        }
        if (v != null) {
            a = v.a;
        }
        return a;
    }
    
    public <T> T f(final Object o) {
        return (T)o;
    }
    
    public final void g(final Throwable t, final Throwable t2) {
        if (t == null && t2 == null) {
            return;
        }
        if (t != null && t2 != null) {
            a.a(t, t2);
        }
        Throwable t3;
        if ((t3 = t) == null) {
            t3 = t2;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fatal exception in coroutines machinery for ");
        sb.append((Object)this);
        sb.append(". Please read KDoc to 'handleFatalException' method and report this incident to maintainers");
        final String string = sb.toString();
        i.b((Object)t3);
        f0.a(this.b().getContext(), (Throwable)new j0(string, t3));
    }
    
    public abstract Object h();
    
    public final void run() {
        final kotlinx.coroutines.scheduling.i f = super.f;
        try {
            final f f2 = (f)this.b();
            final d i = f2.i;
            final Object k = f2.k;
            final g context = i.getContext();
            final Object c = kotlinx.coroutines.internal.f0.c(context, k);
            Object o;
            if (c != kotlinx.coroutines.internal.f0.a) {
                o = b0.f(i, context, c);
            }
            else {
                o = null;
            }
            try {
                final g context2 = i.getContext();
                final Object h = this.h();
                final Throwable d = this.d(h);
                l1 l1;
                if (d == null && r0.b(this.g)) {
                    l1 = (l1)context2.b((g$c)s2.l1.d);
                }
                else {
                    l1 = null;
                }
                if (l1 != null && !l1.a()) {
                    final CancellationException n = l1.n();
                    this.a(h, (Throwable)n);
                    final k$a e = c2.k.e;
                    i.resumeWith(c2.k.a(l.a((Throwable)n)));
                }
                else if (d != null) {
                    final k$a e2 = c2.k.e;
                    i.resumeWith(c2.k.a(l.a(d)));
                }
                else {
                    final k$a e3 = c2.k.e;
                    i.resumeWith(c2.k.a(this.f(h)));
                }
                final q a = q.a;
                if (o == null || ((e2)o).E0()) {
                    kotlinx.coroutines.internal.f0.a(context, c);
                }
                try {
                    f.a();
                    o = c2.k.a((Object)q.a);
                }
                finally {
                    o = c2.k.e;
                    final Throwable t;
                    o = c2.k.a(l.a(t));
                }
                this.g(null, c2.k.b(o));
            }
            finally {
                if (o == null || ((e2)o).E0()) {
                    kotlinx.coroutines.internal.f0.a(context, c);
                }
            }
        }
        finally {
            Object a2;
            try {
                final k$a e4 = k.e;
                f.a();
                k.a((Object)q.a);
            }
            finally {
                final k$a e5 = k.e;
                final Throwable t2;
                a2 = k.a(l.a(t2));
            }
            final Throwable t3;
            this.g(t3, k.b(a2));
        }
    }
}
