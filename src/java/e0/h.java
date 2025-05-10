package e0;

import android.os.Bundle;
import c0.b;
import android.content.Intent;
import com.google.android.gms.common.internal.a$c;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Collections;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import com.google.android.gms.common.internal.a$e;
import android.os.IBinder;
import android.os.Handler;
import android.content.Context;
import android.content.ComponentName;
import android.content.ServiceConnection;
import d0.a$f;

public final class h implements a$f, ServiceConnection
{
    private static final String l;
    private final String a;
    private final String b;
    private final ComponentName c;
    private final Context d;
    private final d e;
    private final Handler f;
    private final i g;
    private IBinder h;
    private boolean i;
    private String j;
    private String k;
    
    static {
        l = h.class.getSimpleName();
    }
    
    private final void s() {
        if (Thread.currentThread() == this.f.getLooper().getThread()) {
            return;
        }
        throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
    }
    
    private final void t(final String s) {
        String.valueOf((Object)this.h);
    }
    
    public final boolean a() {
        this.s();
        return this.h != null;
    }
    
    public final void b(final a$e a$e) {
    }
    
    public final Set<Scope> c() {
        return (Set<Scope>)Collections.emptySet();
    }
    
    public final void d(final IAccountAccessor accountAccessor, final Set<Scope> set) {
    }
    
    public final void e(final String j) {
        this.s();
        this.j = j;
        this.n();
    }
    
    public final boolean g() {
        return false;
    }
    
    public final int h() {
        return 0;
    }
    
    public final boolean i() {
        this.s();
        return this.i;
    }
    
    public final c0.d[] j() {
        return new c0.d[0];
    }
    
    public final String k() {
        final String a = this.a;
        if (a != null) {
            return a;
        }
        f0.i.i((Object)this.c);
        return this.c.getPackageName();
    }
    
    public final String l() {
        return this.j;
    }
    
    public final void m(final a$c a$c) {
        this.s();
        this.t("Connect started.");
        while (true) {
            if (!this.a()) {
                break Label_0023;
            }
            try {
                this.e("connect() called when already connected");
                try {
                    final Intent intent = new Intent();
                    final ComponentName c = this.c;
                    if (c != null) {
                        intent.setComponent(c);
                    }
                    else {
                        intent.setPackage(this.a).setAction(this.b);
                    }
                    if (!(this.i = this.d.bindService(intent, (ServiceConnection)this, com.google.android.gms.common.internal.d.b()))) {
                        this.h = null;
                        this.g.m(new b(16));
                    }
                    this.t("Finished connect.");
                }
                catch (final SecurityException ex) {
                    this.i = false;
                    this.h = null;
                    throw ex;
                }
            }
            catch (final Exception ex2) {
                continue;
            }
            break;
        }
    }
    
    public final void n() {
        this.s();
        this.t("Disconnect called.");
        while (true) {
            try {
                this.d.unbindService((ServiceConnection)this);
                this.i = false;
                this.h = null;
            }
            catch (final IllegalArgumentException ex) {
                continue;
            }
            break;
        }
    }
    
    public final boolean o() {
        return false;
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.f.post((Runnable)new x(this, binder));
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
        this.f.post((Runnable)new w(this));
    }
    
    public final void r(final String k) {
        this.k = k;
    }
}
