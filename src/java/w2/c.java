package w2;

import c2.k;
import kotlin.jvm.internal.i;
import s2.p1;
import l2.p;
import e2.h;
import c2.q;
import e2.g;
import kotlin.coroutines.jvm.internal.d;

public final class c<T> extends d implements v2.c<T>
{
    public final v2.c<T> e;
    public final g f;
    public final int g;
    private g h;
    private e2.d<? super q> i;
    
    public c(final v2.c<? super T> e, final g f) {
        super((e2.d)b.e, (g)e2.h.e);
        this.e = (v2.c<T>)e;
        this.f = f;
        this.g = ((Number)f.t((Object)0, (p)c$a.e)).intValue();
    }
    
    private final void a(final g g, final g g2, final T t) {
        if (g2 instanceof a) {
            this.d((a)g2, t);
        }
        w2.e.a(this, g);
    }
    
    private final Object b(final e2.d<? super q> i, final T t) {
        final g context = i.getContext();
        p1.e(context);
        final g h = this.h;
        if (h != context) {
            this.a(context, h, t);
            this.h = context;
        }
        this.i = i;
        final Object f = w2.d.a().f((Object)this.e, (Object)t, (Object)this);
        if (!i.a(f, f2.b.c())) {
            this.i = null;
        }
        return f;
    }
    
    private final void d(final a a, final Object o) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
        sb.append((Object)a.e);
        sb.append(", but then emission attempt of value '");
        sb.append(o);
        sb.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(r2.d.e(sb.toString()).toString());
    }
    
    public Object emit(final T t, final e2.d<? super q> d) {
        try {
            final Object b = this.b(d, t);
            if (b == f2.b.c()) {
                kotlin.coroutines.jvm.internal.h.c((e2.d)d);
            }
            if (b == f2.b.c()) {
                return b;
            }
            return q.a;
        }
        finally {
            final Throwable t2;
            this.h = (g)new a(t2, d.getContext());
        }
    }
    
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        final e2.d<? super q> i = this.i;
        kotlin.coroutines.jvm.internal.e e;
        if (i instanceof kotlin.coroutines.jvm.internal.e) {
            e = (kotlin.coroutines.jvm.internal.e)i;
        }
        else {
            e = null;
        }
        return e;
    }
    
    public g getContext() {
        Object o;
        if ((o = this.h) == null) {
            o = e2.h.e;
        }
        return (g)o;
    }
    
    public StackTraceElement getStackTraceElement() {
        return null;
    }
    
    public Object invokeSuspend(final Object o) {
        final Throwable b = k.b(o);
        if (b != null) {
            this.h = (g)new a(b, this.getContext());
        }
        final e2.d<? super q> i = this.i;
        if (i != null) {
            i.resumeWith(o);
        }
        return f2.b.c();
    }
    
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
