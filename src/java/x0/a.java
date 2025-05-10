package x0;

import java.util.Objects;
import java.io.IOException;
import java.util.Iterator;

public class a
{
    private final String a;
    
    private a(final String s) {
        this.a = d.a(s);
    }
    
    public static a e(final char c) {
        return new a(String.valueOf(c));
    }
    
    public <A extends Appendable> A a(final A a, final Iterator<?> iterator) {
        d.a(a);
        if (iterator.hasNext()) {
            a.append(this.f(iterator.next()));
            while (iterator.hasNext()) {
                a.append((CharSequence)this.a);
                a.append(this.f(iterator.next()));
            }
        }
        return a;
    }
    
    public final StringBuilder b(final StringBuilder sb, final Iterator<?> iterator) {
        try {
            this.a(sb, iterator);
            return sb;
        }
        catch (final IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public final String c(final Iterable<?> iterable) {
        return this.d((Iterator<?>)iterable.iterator());
    }
    
    public final String d(final Iterator<?> iterator) {
        return this.b(new StringBuilder(), iterator).toString();
    }
    
    CharSequence f(final Object o) {
        Objects.requireNonNull(o);
        Object string;
        if (o instanceof CharSequence) {
            string = o;
        }
        else {
            string = o.toString();
        }
        return (CharSequence)string;
    }
}
