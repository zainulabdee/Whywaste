package k0;

import java.util.Iterator;
import m0.b;
import m0.g;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import m0.f;
import f0.i;

public abstract class a
{
    protected static final <O, I> I f(final a.a$a<I, O> a$a, final Object o) {
        if (a.a$a.m((a.a$a)a$a) != null) {
            return (I)a$a.n(o);
        }
        return (I)o;
    }
    
    private static final void g(final StringBuilder sb, final a.a$a a$a, final Object obj) {
        final int f = a$a.f;
        if (f == 11) {
            final Class l = a$a.l;
            i.i((Object)l);
            sb.append(((a)l.cast(obj)).toString());
            return;
        }
        if (f == 7) {
            sb.append("\"");
            sb.append(m0.f.a((String)obj));
            sb.append("\"");
            return;
        }
        sb.append(obj);
    }
    
    public abstract Map<String, a.a$a<?, ?>> a();
    
    protected Object b(final a.a$a a$a) {
        final String j = a$a.j;
        if (a$a.l != null) {
            i.m(this.c(j) == null, "Concrete field shouldn't be value object: %s", new Object[] { a$a.j });
            try {
                final char upperCase = Character.toUpperCase(j.charAt(0));
                final String substring = j.substring(1);
                final StringBuilder sb = new StringBuilder(String.valueOf((Object)substring).length() + 4);
                sb.append("get");
                sb.append(upperCase);
                sb.append(substring);
                return this.getClass().getMethod(sb.toString(), (Class<?>[])new Class[0]).invoke((Object)this, new Object[0]);
            }
            catch (final Exception ex) {
                throw new RuntimeException((Throwable)ex);
            }
        }
        return this.c(j);
    }
    
    protected abstract Object c(final String p0);
    
    protected boolean d(final a.a$a a$a) {
        if (a$a.h != 11) {
            return this.e(a$a.j);
        }
        if (a$a.i) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }
    
    protected abstract boolean e(final String p0);
    
    @Override
    public String toString() {
        final Map<String, a.a$a<?, ?>> a = this.a();
        final StringBuilder sb = new StringBuilder(100);
        for (final String s : a.keySet()) {
            final a.a$a a$a = (a.a$a)a.get((Object)s);
            if (this.d(a$a)) {
                final ArrayList f = f((a.a$a<ArrayList, Object>)a$a, this.b(a$a));
                if (sb.length() == 0) {
                    sb.append("{");
                }
                else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(s);
                sb.append("\":");
                if (f == null) {
                    sb.append("null");
                }
                else {
                    switch (a$a.h) {
                        default: {
                            if (a$a.g) {
                                final ArrayList list = f;
                                sb.append("[");
                                for (int size = list.size(), i = 0; i < size; ++i) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    final Object value = list.get(i);
                                    if (value != null) {
                                        g(sb, a$a, value);
                                    }
                                }
                                sb.append("]");
                                continue;
                            }
                            g(sb, a$a, f);
                            continue;
                        }
                        case 10: {
                            g.a(sb, (HashMap<String, String>)f);
                            continue;
                        }
                        case 9: {
                            sb.append("\"");
                            sb.append(m0.b.b((byte[])(Object)f));
                            sb.append("\"");
                            continue;
                        }
                        case 8: {
                            sb.append("\"");
                            sb.append(m0.b.a((byte[])(Object)f));
                            sb.append("\"");
                            continue;
                        }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        }
        else {
            sb.append("{}");
        }
        return sb.toString();
    }
    
    public interface b<I, O>
    {
        I c(final O p0);
    }
}
