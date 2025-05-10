package v2;

import f2.b;
import c2.q;
import e2.d;
import l2.p;

final class g<T> extends a<T>
{
    private final p<c<? super T>, d<? super q>, Object> e;
    
    public g(final p<? super c<? super T>, ? super d<? super q>, ?> e) {
        this.e = (p<c<? super T>, d<? super q>, Object>)e;
    }
    
    @Override
    public Object b(final c<? super T> c, final d<? super q> d) {
        final Object invoke = this.e.invoke((Object)c, (Object)d);
        if (invoke == b.c()) {
            return invoke;
        }
        return q.a;
    }
}
