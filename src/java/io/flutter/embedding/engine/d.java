package io.flutter.embedding.engine;

import io.flutter.plugin.platform.v;
import java.util.ArrayList;
import android.content.Context;
import java.util.List;

public class d
{
    final List<a> a;
    
    public d(final Context context, final String[] array) {
        this.a = (List<a>)new ArrayList();
        final i1.d c = f1.a.e().c();
        if (!c.j()) {
            c.l(context.getApplicationContext());
            c.e(context.getApplicationContext(), array);
        }
    }
    
    public a a(final b b) {
        final Context b2 = b.b();
        final g1.a.b c = b.c();
        final String e = b.e();
        final List<String> d = b.d();
        v f = b.f();
        if (f == null) {
            f = new v();
        }
        final boolean a = b.a();
        final boolean g = b.g();
        Object a2;
        if (c == null) {
            a2 = g1.a.b.a();
        }
        else {
            a2 = c;
        }
        a x;
        if (this.a.size() == 0) {
            final a b3 = this.b(b2, f, a, g);
            if (e != null) {
                b3.m().c(e);
            }
            b3.i().j((g1.a.b)a2, (List)d);
            x = b3;
        }
        else {
            x = ((a)this.a.get(0)).x(b2, (g1.a.b)a2, e, d, f, a, g);
        }
        this.a.add((Object)x);
        x.d((a.b)new d$a(this, x));
        return x;
    }
    
    a b(final Context context, final v v, final boolean b, final boolean b2) {
        return new a(context, null, null, v, null, b, b2, this);
    }
    
    public static class b
    {
        private Context a;
        private g1.a.b b;
        private String c;
        private List<String> d;
        private v e;
        private boolean f;
        private boolean g;
        
        public b(final Context a) {
            this.f = true;
            this.g = false;
            this.a = a;
        }
        
        public boolean a() {
            return this.f;
        }
        
        public Context b() {
            return this.a;
        }
        
        public g1.a.b c() {
            return this.b;
        }
        
        public List<String> d() {
            return this.d;
        }
        
        public String e() {
            return this.c;
        }
        
        public v f() {
            return this.e;
        }
        
        public boolean g() {
            return this.g;
        }
        
        public b h(final boolean f) {
            this.f = f;
            return this;
        }
        
        public b i(final g1.a.b b) {
            this.b = b;
            return this;
        }
        
        public b j(final List<String> d) {
            this.d = d;
            return this;
        }
        
        public b k(final String c) {
            this.c = c;
            return this;
        }
        
        public b l(final boolean g) {
            this.g = g;
            return this;
        }
    }
}
