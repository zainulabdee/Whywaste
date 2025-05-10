package c2;

import kotlin.jvm.internal.i;
import kotlin.jvm.internal.e;
import java.io.Serializable;

public final class k<T> implements Serializable
{
    public static final a e;
    
    static {
        e = new a(null);
    }
    
    public static <T> Object a(final Object o) {
        return o;
    }
    
    public static final Throwable b(final Object o) {
        Throwable e;
        if (o instanceof b) {
            e = ((b)o).e;
        }
        else {
            e = null;
        }
        return e;
    }
    
    public static final boolean c(final Object o) {
        return o instanceof b;
    }
    
    public static final boolean d(final Object o) {
        return o instanceof b ^ true;
    }
    
    public static final class a
    {
        private a() {
        }
    }
    
    public static final class b implements Serializable
    {
        public final Throwable e;
        
        public b(final Throwable e) {
            i.e((Object)e, "exception");
            this.e = e;
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof b && i.a((Object)this.e, (Object)((b)o).e);
        }
        
        @Override
        public int hashCode() {
            return this.e.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failure(");
            sb.append((Object)this.e);
            sb.append(')');
            return sb.toString();
        }
    }
}
