package d0;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zact;
import android.os.Handler;
import com.google.android.gms.common.api.internal.o;
import java.util.Set;
import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import w0.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.GoogleApiActivity;
import e0.s;
import java.lang.reflect.InvocationTargetException;
import m0.h;
import f0.i;
import android.app.Activity;
import com.google.android.gms.common.api.internal.c;
import e0.m;
import android.os.Looper;
import e0.b;
import android.content.Context;

public abstract class e<O extends d0.a.d>
{
    private final Context a;
    private final String b;
    private final d0.a<O> c;
    private final O d;
    private final b<O> e;
    private final Looper f;
    private final int g;
    private final f h;
    private final m i;
    protected final c j;
    
    public e(final Activity activity, final d0.a<O> a, final O o, final a a2) {
        this((Context)activity, activity, (d0.a<d0.a.d>)a, o, a2);
    }
    
    @Deprecated
    public e(final Activity activity, final d0.a<O> a, final O o, final m m) {
        final a.a a2 = new a.a();
        a2.c(m);
        a2.b(((Context)activity).getMainLooper());
        this(activity, (d0.a<d0.a.d>)a, o, a2.a());
    }
    
    private e(final Context context, final Activity activity, final d0.a<O> c, final O d, final a a) {
        f0.i.j(context, "Null context is not permitted.");
        f0.i.j(c, "Api must not be null.");
        f0.i.j(a, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.a = context.getApplicationContext();
        final boolean i = m0.h.i();
        String b;
        final String s = b = null;
        if (i) {
            try {
                b = (String)Context.class.getMethod("getAttributionTag", (Class<?>[])new Class[0]).invoke((Object)context, new Object[0]);
            }
            catch (final NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
                b = s;
            }
        }
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = a.b;
        final b<O> a2 = e0.b.a(c, d, b);
        this.e = a2;
        this.h = (f)new s(this);
        final c y = com.google.android.gms.common.api.internal.c.y(this.a);
        this.j = y;
        this.g = y.n();
        this.i = a.a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            com.google.android.gms.common.api.internal.h.u(activity, y, (b)a2);
        }
        y.c(this);
    }
    
    public e(final Context context, final d0.a<O> a, final O o, final a a2) {
        this(context, null, (d0.a<d0.a.d>)a, o, a2);
    }
    
    private final <A extends d0.a.b, T extends com.google.android.gms.common.api.internal.b<? extends l, A>> T r(final int n, final T t) {
        ((BasePendingResult)t).k();
        this.j.E(this, n, (com.google.android.gms.common.api.internal.b)t);
        return t;
    }
    
    private final <TResult, A extends d0.a.b> g<TResult> s(final int n, final d<A, TResult> d) {
        final w0.h h = new w0.h();
        this.j.F(this, n, (d)d, h, this.i);
        return (g<TResult>)h.a();
    }
    
    public f d() {
        return this.h;
    }
    
    protected f0.b.a e() {
        final f0.b.a a = new f0.b.a();
        final d0.a.d d = this.d;
        Account account = null;
        Label_0069: {
            if (d instanceof a$d$b) {
                final GoogleSignInAccount d2 = ((a$d$b)d).d();
                if (d2 != null) {
                    account = d2.b();
                    break Label_0069;
                }
            }
            final d0.a.d d3 = this.d;
            if (d3 instanceof a$d$a) {
                account = ((a$d$a)d3).b();
            }
            else {
                account = null;
            }
        }
        a.d(account);
        final d0.a.d d4 = this.d;
        Set set;
        if (d4 instanceof a$d$b) {
            final GoogleSignInAccount d5 = ((a$d$b)d4).d();
            if (d5 == null) {
                set = Collections.emptySet();
            }
            else {
                set = d5.m();
            }
        }
        else {
            set = Collections.emptySet();
        }
        a.c((Collection<Scope>)set);
        a.e(this.a.getClass().getName());
        a.b(this.a.getPackageName());
        return a;
    }
    
    public <TResult, A extends d0.a.b> g<TResult> f(final d<A, TResult> d) {
        return this.s(2, (com.google.android.gms.common.api.internal.d<d0.a.b, TResult>)d);
    }
    
    public <A extends d0.a.b, T extends com.google.android.gms.common.api.internal.b<? extends l, A>> T g(final T t) {
        this.r(0, t);
        return t;
    }
    
    public <A extends d0.a.b, T extends com.google.android.gms.common.api.internal.b<? extends l, A>> T h(final T t) {
        this.r(1, t);
        return t;
    }
    
    public <TResult, A extends d0.a.b> g<TResult> i(final d<A, TResult> d) {
        return this.s(1, (com.google.android.gms.common.api.internal.d<d0.a.b, TResult>)d);
    }
    
    public final b<O> j() {
        return this.e;
    }
    
    public O k() {
        return this.d;
    }
    
    public Context l() {
        return this.a;
    }
    
    protected String m() {
        return this.b;
    }
    
    public Looper n() {
        return this.f;
    }
    
    public final int o() {
        return this.g;
    }
    
    public final a$f p(final Looper looper, final o<O> o) {
        final a$f a = f0.i.i((a$a)this.c.a()).a(this.a, looper, this.e().a(), (Object)this.d, (f$a)o, (f$b)o);
        final String m = this.m();
        if (m != null && a instanceof com.google.android.gms.common.internal.a) {
            ((com.google.android.gms.common.internal.a)a).O(m);
        }
        if (m != null && a instanceof e0.h) {
            ((e0.h)a).r(m);
        }
        return a;
    }
    
    public final zact q(final Context context, final Handler handler) {
        return new zact(context, handler, this.e().a());
    }
    
    public static class a
    {
        public static final e.a c;
        public final m a;
        public final Looper b;
        
        static {
            c = new e.a.a().a();
        }
        
        private a(final m a, final Account account, final Looper b) {
            this.a = a;
            this.b = b;
        }
        
        public static class a
        {
            private m a;
            private Looper b;
            
            public e.a a() {
                if (this.a == null) {
                    this.a = (m)new e0.a();
                }
                if (this.b == null) {
                    this.b = Looper.getMainLooper();
                }
                return new e.a(this.a, null, this.b, null);
            }
            
            public a b(final Looper b) {
                f0.i.j(b, "Looper must not be null.");
                this.b = b;
                return this;
            }
            
            public a c(final m a) {
                f0.i.j(a, "StatusExceptionMapper must not be null.");
                this.a = a;
                return this;
            }
        }
    }
}
