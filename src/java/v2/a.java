package v2;

import c2.l;
import kotlin.coroutines.jvm.internal.f;
import c2.q;
import e2.d;

public abstract class a<T> implements b<T>
{
    public final Object a(c<? super T> e, final d<? super q> d) {
        Object o = null;
        Label_0051: {
            if (d instanceof a$a) {
                final kotlin.coroutines.jvm.internal.d d2 = (a$a)d;
                final int h = d2.h;
                if ((h & Integer.MIN_VALUE) != 0x0) {
                    d2.h = h + Integer.MIN_VALUE;
                    o = d2;
                    break Label_0051;
                }
            }
            o = new kotlin.coroutines.jvm.internal.d(this, d) {
                Object e;
                Object f;
                final a<T> g;
                int h;
                
                public final Object invokeSuspend(final Object f) {
                    this.f = f;
                    this.h |= Integer.MIN_VALUE;
                    return this.g.a(null, (d<? super q>)this);
                }
            };
        }
        final Object f = ((a$a)o).f;
        final Object c = f2.b.c();
        final int h2 = ((a$a)o).h;
        Label_0152: {
            if (h2 != 0) {
                if (h2 == 1) {
                    e = ((a$a)o).e;
                    try {
                        l.b(f);
                        break Label_0152;
                    }
                    finally {
                        break Label_0152;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.b(f);
            e = new w2.c((v2.c<? super Object>)e, ((d)o).getContext());
            try {
                ((a$a)o).e = e;
                ((a$a)o).h = 1;
                if (this.b((c<? super T>)e, (d<? super q>)o) == c) {
                    return c;
                }
                ((w2.c)e).releaseIntercepted();
                return q.a;
            }
            finally {}
        }
        ((w2.c)e).releaseIntercepted();
        throw;
    }
    
    public abstract Object b(final c<? super T> p0, final d<? super q> p1);
}
