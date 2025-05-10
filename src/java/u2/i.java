package u2;

import kotlin.jvm.internal.e;

public final class i<T>
{
    public static final b a;
    private static final c b;
    
    static {
        a = new b(null);
        b = new c();
    }
    
    public static final /* synthetic */ c a() {
        return i.b;
    }
    
    public static <T> Object b(final Object o) {
        return o;
    }
    
    public static final class b
    {
        private b() {
        }
        
        public final <E> Object a(final Throwable t) {
            return i.b(new i$a(t));
        }
        
        public final <E> Object b() {
            return i.b(i.a());
        }
        
        public final <E> Object c(final E e) {
            return i.b(e);
        }
    }
    
    public static class c
    {
        @Override
        public String toString() {
            return "Failed";
        }
    }
}
