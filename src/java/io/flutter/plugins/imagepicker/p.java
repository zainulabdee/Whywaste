package io.flutter.plugins.imagepicker;

import java.util.List;
import android.util.Log;
import java.util.ArrayList;

public class p
{
    protected static ArrayList<Object> a(final Throwable t) {
        final ArrayList list = new ArrayList(3);
        if (t instanceof d) {
            final d d = (d)t;
            list.add((Object)d.e);
            list.add((Object)((Throwable)d).getMessage());
            list.add(d.f);
        }
        else {
            list.add((Object)t.toString());
            list.add((Object)t.getClass().getSimpleName());
            final StringBuilder sb = new StringBuilder();
            sb.append("Cause: ");
            sb.append((Object)t.getCause());
            sb.append(", Stacktrace: ");
            sb.append(Log.getStackTraceString(t));
            list.add((Object)sb.toString());
        }
        return (ArrayList<Object>)list;
    }
    
    public static final class a
    {
        private String a;
        private String b;
        
        a() {
        }
        
        static p.a a(final ArrayList<Object> list) {
            final p.a a = new p.a();
            a.b((String)list.get(0));
            a.c((String)list.get(1));
            return a;
        }
        
        public void b(final String a) {
            if (a != null) {
                this.a = a;
                return;
            }
            throw new IllegalStateException("Nonnull field \"code\" is null.");
        }
        
        public void c(final String b) {
            this.b = b;
        }
        
        ArrayList<Object> d() {
            final ArrayList list = new ArrayList(2);
            list.add((Object)this.a);
            list.add((Object)this.b);
            return (ArrayList<Object>)list;
        }
        
        public static final class a
        {
            private String a;
            private String b;
            
            public p.a a() {
                final p.a a = new p.a();
                a.b(this.a);
                a.c(this.b);
                return a;
            }
            
            public a b(final String a) {
                this.a = a;
                return this;
            }
            
            public a c(final String b) {
                this.b = b;
                return this;
            }
        }
    }
    
    public static final class b
    {
        private c a;
        private p.a b;
        private List<String> c;
        
        b() {
        }
        
        static b a(final ArrayList<Object> list) {
            final b b = new b();
            final Object value = list.get(0);
            final p.a a = null;
            c c;
            if (value == null) {
                c = null;
            }
            else {
                c = p.c.values()[(int)value];
            }
            b.d(c);
            final Object value2 = list.get(1);
            Object a2;
            if (value2 == null) {
                a2 = a;
            }
            else {
                a2 = p.a.a((ArrayList<Object>)value2);
            }
            b.b((p.a)a2);
            b.c((List<String>)list.get(2));
            return b;
        }
        
        public void b(final p.a b) {
            this.b = b;
        }
        
        public void c(final List<String> c) {
            if (c != null) {
                this.c = c;
                return;
            }
            throw new IllegalStateException("Nonnull field \"paths\" is null.");
        }
        
        public void d(final c a) {
            if (a != null) {
                this.a = a;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }
        
        ArrayList<Object> e() {
            final ArrayList list = new ArrayList(3);
            final c a = this.a;
            final Object o = null;
            Object value;
            if (a == null) {
                value = null;
            }
            else {
                value = a.e;
            }
            list.add(value);
            final p.a b = this.b;
            Object d;
            if (b == null) {
                d = o;
            }
            else {
                d = b.d();
            }
            list.add(d);
            list.add((Object)this.c);
            return (ArrayList<Object>)list;
        }
        
        public static final class a
        {
            private c a;
            private p.a b;
            private List<String> c;
            
            public b a() {
                final b b = new b();
                b.d(this.a);
                b.b(this.b);
                b.c(this.c);
                return b;
            }
            
            public a b(final p.a b) {
                this.b = b;
                return this;
            }
            
            public a c(final List<String> c) {
                this.c = c;
                return this;
            }
            
            public a d(final c a) {
                this.a = a;
                return this;
            }
        }
    }
    
    public enum c
    {
        f(0), 
        g(1);
        
        private static final c[] h;
        final int e;
        
        static {
            h = d();
        }
        
        private c(final int e) {
            this.e = e;
        }
        
        private static /* synthetic */ c[] d() {
            return new c[] { c.f, c.g };
        }
    }
    
    public static class d extends RuntimeException
    {
        public final String e;
        public final Object f;
        
        public d(final String e, final String s, final Object f) {
            super(s);
            this.e = e;
            this.f = f;
        }
    }
    
    public static final class e
    {
        private Boolean a;
        private Boolean b;
        
        e() {
        }
        
        static e a(final ArrayList<Object> list) {
            final e e = new e();
            e.d((Boolean)list.get(0));
            e.e((Boolean)list.get(1));
            return e;
        }
        
        public Boolean b() {
            return this.a;
        }
        
        public Boolean c() {
            return this.b;
        }
        
        public void d(final Boolean a) {
            if (a != null) {
                this.a = a;
                return;
            }
            throw new IllegalStateException("Nonnull field \"allowMultiple\" is null.");
        }
        
        public void e(final Boolean b) {
            if (b != null) {
                this.b = b;
                return;
            }
            throw new IllegalStateException("Nonnull field \"usePhotoPicker\" is null.");
        }
        
        ArrayList<Object> f() {
            final ArrayList list = new ArrayList(2);
            list.add((Object)this.a);
            list.add((Object)this.b);
            return (ArrayList<Object>)list;
        }
    }
    
    public interface f
    {
        void a(final i p0, final e p1, final j<List<String>> p2);
        
        void b(final l p0, final h p1, final e p2, final j<List<String>> p3);
        
        void c(final l p0, final n p1, final e p2, final j<List<String>> p3);
        
        b d();
    }
    
    public static final class h
    {
        private Double a;
        private Double b;
        private Long c;
        
        h() {
        }
        
        static h a(final ArrayList<Object> list) {
            final h h = new h();
            h.f((Double)list.get(0));
            h.e((Double)list.get(1));
            final Object value = list.get(2);
            Long value2;
            if (value == null) {
                value2 = null;
            }
            else {
                long longValue;
                if (value instanceof Integer) {
                    longValue = (int)value;
                }
                else {
                    longValue = (long)value;
                }
                value2 = longValue;
            }
            h.g(value2);
            return h;
        }
        
        public Double b() {
            return this.b;
        }
        
        public Double c() {
            return this.a;
        }
        
        public Long d() {
            return this.c;
        }
        
        public void e(final Double b) {
            this.b = b;
        }
        
        public void f(final Double a) {
            this.a = a;
        }
        
        public void g(final Long c) {
            if (c != null) {
                this.c = c;
                return;
            }
            throw new IllegalStateException("Nonnull field \"quality\" is null.");
        }
        
        ArrayList<Object> h() {
            final ArrayList list = new ArrayList(3);
            list.add((Object)this.a);
            list.add((Object)this.b);
            list.add((Object)this.c);
            return (ArrayList<Object>)list;
        }
    }
    
    public static final class i
    {
        private h a;
        
        i() {
        }
        
        static i a(final ArrayList<Object> list) {
            final i i = new i();
            final Object value = list.get(0);
            Object a;
            if (value == null) {
                a = null;
            }
            else {
                a = h.a((ArrayList<Object>)value);
            }
            i.c((h)a);
            return i;
        }
        
        public h b() {
            return this.a;
        }
        
        public void c(final h a) {
            if (a != null) {
                this.a = a;
                return;
            }
            throw new IllegalStateException("Nonnull field \"imageSelectionOptions\" is null.");
        }
        
        ArrayList<Object> d() {
            final ArrayList list = new ArrayList(1);
            final h a = this.a;
            Object h;
            if (a == null) {
                h = null;
            }
            else {
                h = a.h();
            }
            list.add(h);
            return (ArrayList<Object>)list;
        }
    }
    
    public interface j<T>
    {
        void a(final T p0);
        
        void b(final Throwable p0);
    }
    
    public enum k
    {
        f(0), 
        g(1);
        
        private static final k[] h;
        final int e;
        
        static {
            h = d();
        }
        
        private k(final int e) {
            this.e = e;
        }
        
        private static /* synthetic */ k[] d() {
            return new k[] { k.f, k.g };
        }
    }
    
    public static final class l
    {
        private m a;
        private k b;
        
        l() {
        }
        
        static l a(final ArrayList<Object> list) {
            final l l = new l();
            final Object value = list.get(0);
            final k k = null;
            m m;
            if (value == null) {
                m = null;
            }
            else {
                m = p.m.values()[(int)value];
            }
            l.e(m);
            final Object value2 = list.get(1);
            k i;
            if (value2 == null) {
                i = k;
            }
            else {
                i = p.k.values()[(int)value2];
            }
            l.d(i);
            return l;
        }
        
        public k b() {
            return this.b;
        }
        
        public m c() {
            return this.a;
        }
        
        public void d(final k b) {
            this.b = b;
        }
        
        public void e(final m a) {
            if (a != null) {
                this.a = a;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }
        
        ArrayList<Object> f() {
            final ArrayList list = new ArrayList(2);
            final m a = this.a;
            final Object o = null;
            Object value;
            if (a == null) {
                value = null;
            }
            else {
                value = a.e;
            }
            list.add(value);
            final k b = this.b;
            Object value2;
            if (b == null) {
                value2 = o;
            }
            else {
                value2 = b.e;
            }
            list.add(value2);
            return (ArrayList<Object>)list;
        }
    }
    
    public enum m
    {
        f(0), 
        g(1);
        
        private static final m[] h;
        final int e;
        
        static {
            h = d();
        }
        
        private m(final int e) {
            this.e = e;
        }
        
        private static /* synthetic */ m[] d() {
            return new m[] { m.f, m.g };
        }
    }
    
    public static final class n
    {
        private Long a;
        
        static n a(final ArrayList<Object> list) {
            final n n = new n();
            final Object value = list.get(0);
            Long value2;
            if (value == null) {
                value2 = null;
            }
            else {
                long longValue;
                if (value instanceof Integer) {
                    longValue = (int)value;
                }
                else {
                    longValue = (long)value;
                }
                value2 = longValue;
            }
            n.c(value2);
            return n;
        }
        
        public Long b() {
            return this.a;
        }
        
        public void c(final Long a) {
            this.a = a;
        }
        
        ArrayList<Object> d() {
            final ArrayList list = new ArrayList(1);
            list.add((Object)this.a);
            return (ArrayList<Object>)list;
        }
    }
}
