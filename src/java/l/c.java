package l;

import androidx.lifecycle.k;
import kotlin.jvm.internal.i;
import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.lifecycle.j;
import androidx.savedstate.Recreator;
import androidx.lifecycle.f$b;
import kotlin.jvm.internal.e;
import androidx.savedstate.a;

public final class c
{
    public static final a d;
    private final d a;
    private final androidx.savedstate.a b;
    private boolean c;
    
    static {
        d = new a(null);
    }
    
    private c(final d a) {
        this.a = a;
        this.b = new androidx.savedstate.a();
    }
    
    public static final c a(final d d) {
        return c.d.a(d);
    }
    
    public final androidx.savedstate.a b() {
        return this.b;
    }
    
    public final void c() {
        final f a = ((k)this.a).a();
        if (a.b() == f$b.f) {
            a.a((j)new Recreator(this.a));
            this.b.e(a);
            this.c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }
    
    public final void d(final Bundle bundle) {
        if (!this.c) {
            this.c();
        }
        final f a = ((k)this.a).a();
        if (a.b().e(f$b.h) ^ true) {
            this.b.f(bundle);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("performRestore cannot be called when owner is ");
        sb.append((Object)a.b());
        throw new IllegalStateException(sb.toString().toString());
    }
    
    public final void e(final Bundle bundle) {
        i.e((Object)bundle, "outBundle");
        this.b.g(bundle);
    }
    
    public static final class a
    {
        private a() {
        }
        
        public final c a(final d d) {
            i.e((Object)d, "owner");
            return new c(d, null);
        }
    }
}
