package io.sentry;

import io.sentry.vendor.gson.stream.a;
import java.util.ArrayList;

public final class h1
{
    private final ArrayList<c> a;
    
    public h1() {
        this.a = (ArrayList<c>)new ArrayList();
    }
    
    private c d() {
        if (this.a.isEmpty()) {
            return null;
        }
        final ArrayList<c> a = this.a;
        return (c)a.get(a.size() - 1);
    }
    
    private boolean e() {
        if (this.g()) {
            return true;
        }
        final c d = this.d();
        this.l();
        if (this.d() instanceof h1.h1$f) {
            final h1.h1$f h1$f = (h1.h1$f)this.d();
            this.l();
            final h1.h1$e h1$e = (h1.h1$e)this.d();
            if (h1$f != null && d != null && h1$e != null) {
                h1$e.a.put((Object)h1$f.a, d.getValue());
            }
        }
        else if (this.d() instanceof h1.h1$d) {
            final h1.h1$d h1$d = (h1.h1$d)this.d();
            if (d != null && h1$d != null) {
                h1$d.a.add(d.getValue());
            }
        }
        return false;
    }
    
    private boolean f(final b b) {
        final Object a = b.a();
        if (this.d() == null && a != null) {
            this.m((c)new h1.h1$g(a));
            return true;
        }
        if (this.d() instanceof h1.h1$f) {
            final h1.h1$f h1$f = (h1.h1$f)this.d();
            this.l();
            ((h1.h1$e)this.d()).a.put((Object)h1$f.a, a);
        }
        else if (this.d() instanceof h1.h1$d) {
            ((h1.h1$d)this.d()).a.add(a);
        }
        return false;
    }
    
    private boolean g() {
        final int size = this.a.size();
        boolean b = true;
        if (size != 1) {
            b = false;
        }
        return b;
    }
    
    private Object j(final i1 i1) {
        try {
            return ((a)i1).p();
        }
        catch (final Exception ex) {
            try {
                return ((a)i1).o();
            }
            catch (final Exception ex2) {
                return ((a)i1).q();
            }
        }
    }
    
    private void k(final i1 i1) {
        boolean b = false;
        Label_0219: {
            switch (h1$a.a[((a)i1).x().ordinal()]) {
                case 10: {
                    b = true;
                    break Label_0219;
                }
                case 9: {
                    ((a)i1).t();
                    b = this.f((b)new g1());
                    break Label_0219;
                }
                case 8: {
                    b = this.f((b)new f1(i1));
                    break Label_0219;
                }
                case 7: {
                    b = this.f((b)new e1(this, i1));
                    break Label_0219;
                }
                case 6: {
                    b = this.f((b)new d1(i1));
                    break Label_0219;
                }
                case 5: {
                    this.m((c)new h1.h1$f(((a)i1).r()));
                    break;
                }
                case 4: {
                    ((a)i1).h();
                    b = this.e();
                    break Label_0219;
                }
                case 3: {
                    ((a)i1).b();
                    this.m((c)new h1.h1$e((h1$a)null));
                    break;
                }
                case 2: {
                    ((a)i1).g();
                    b = this.e();
                    break Label_0219;
                }
                case 1: {
                    ((a)i1).a();
                    this.m((c)new h1.h1$d((h1$a)null));
                    break;
                }
            }
            b = false;
        }
        if (!b) {
            this.k(i1);
        }
    }
    
    private void l() {
        if (this.a.isEmpty()) {
            return;
        }
        final ArrayList<c> a = this.a;
        a.remove(a.size() - 1);
    }
    
    private void m(final c c) {
        this.a.add((Object)c);
    }
    
    public Object c(final i1 i1) {
        this.k(i1);
        final c d = this.d();
        if (d != null) {
            return d.getValue();
        }
        return null;
    }
    
    private interface b
    {
        Object a();
    }
    
    private interface c
    {
        Object getValue();
    }
}
