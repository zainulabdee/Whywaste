package u2;

import kotlinx.coroutines.internal.b0;
import c2.q;
import l2.l;

public class n<E> extends a<E>
{
    public n(final l<? super E, q> l) {
        super(l);
    }
    
    @Override
    protected Object i(final E e) {
        u2.q<?> k;
        do {
            final Object i = super.i(e);
            final b0 b = u2.b.b;
            if (i == b) {
                return b;
            }
            if (i == u2.b.c) {
                k = this.k(e);
                if (k == null) {
                    return b;
                }
                continue;
            }
            else {
                if (i instanceof j) {
                    return i;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid offerInternal result ");
                sb.append(i);
                throw new IllegalStateException(sb.toString().toString());
            }
        } while (!(k instanceof j));
        return k;
    }
    
    @Override
    protected final boolean r() {
        return true;
    }
    
    @Override
    protected final boolean s() {
        return true;
    }
}
