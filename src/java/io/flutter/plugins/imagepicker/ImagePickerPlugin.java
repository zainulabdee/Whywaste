package io.flutter.plugins.imagepicker;

import android.content.Context;
import java.util.List;
import t1.o;
import android.app.Activity;
import android.app.Application;
import t1.c;
import k1.a$b;
import k1.a;

public class ImagePickerPlugin implements a, l1.a, p$f
{
    private a$b a;
    ImagePickerPlugin.ImagePickerPlugin$b b;
    
    private l f() {
        final ImagePickerPlugin.ImagePickerPlugin$b b = this.b;
        if (b != null && b.a() != null) {
            return this.b.b();
        }
        return null;
    }
    
    private void g(final l l, final p$l p$l) {
        final p$k b = p$l.b();
        if (b != null) {
            l$c l$c;
            if (ImagePickerPlugin$a.a[((Enum)b).ordinal()] != 1) {
                l$c = io.flutter.plugins.imagepicker.l$c.e;
            }
            else {
                l$c = io.flutter.plugins.imagepicker.l$c.f;
            }
            l.V(l$c);
        }
    }
    
    private void h(final c c, final Application application, final Activity activity, final o o, final l1.c c2) {
        this.b = new ImagePickerPlugin.ImagePickerPlugin$b(this, application, activity, c, (p$f)this, o, c2);
    }
    
    private void i() {
        final ImagePickerPlugin.ImagePickerPlugin$b b = this.b;
        if (b != null) {
            b.c();
            this.b = null;
        }
    }
    
    public void a(final p$i p$i, final p$e p$e, final p$j<List<String>> p$j) {
        final l f = this.f();
        if (f == null) {
            p$j.b((Throwable)new p$d("no_activity", "image_picker plugin requires a foreground activity.", (Object)null));
            return;
        }
        f.k(p$i, p$e, p$j);
    }
    
    public void b(final p$l p$l, final p$h p$h, final p$e p$e, final p$j<List<String>> p$j) {
        final l f = this.f();
        if (f == null) {
            p$j.b((Throwable)new p$d("no_activity", "image_picker plugin requires a foreground activity.", (Object)null));
            return;
        }
        this.g(f, p$l);
        if (p$e.b()) {
            f.l(p$h, p$e.c(), p$j);
        }
        else {
            final int n = ImagePickerPlugin$a.b[((Enum)p$l.c()).ordinal()];
            if (n != 1) {
                if (n == 2) {
                    f.X(p$h, p$j);
                }
            }
            else {
                f.j(p$h, p$e.c(), p$j);
            }
        }
    }
    
    public void c(final p$l p$l, final p$n p$n, final p$e p$e, final p$j<List<String>> p$j) {
        final l f = this.f();
        if (f == null) {
            p$j.b((Throwable)new p$d("no_activity", "image_picker plugin requires a foreground activity.", (Object)null));
            return;
        }
        this.g(f, p$l);
        if (p$e.b()) {
            p$j.b((Throwable)new RuntimeException("Multi-video selection is not implemented"));
        }
        else {
            final int n = ImagePickerPlugin$a.b[((Enum)p$l.c()).ordinal()];
            if (n != 1) {
                if (n == 2) {
                    f.Y(p$n, p$j);
                }
            }
            else {
                f.m(p$n, p$e.c(), p$j);
            }
        }
    }
    
    public p$b d() {
        final l f = this.f();
        if (f != null) {
            return f.T();
        }
        throw new p$d("no_activity", "image_picker plugin requires a foreground activity.", (Object)null);
    }
    
    final l e(final Activity activity) {
        return new l(activity, new io.flutter.plugins.imagepicker.o((Context)activity, new io.flutter.plugins.imagepicker.a()), new io.flutter.plugins.imagepicker.c((Context)activity));
    }
    
    public void onAttachedToActivity(final l1.c c) {
        this.h(this.a.b(), (Application)this.a.a(), c.d(), null, c);
    }
    
    public void onAttachedToEngine(final a$b a) {
        this.a = a;
    }
    
    public void onDetachedFromActivity() {
        this.i();
    }
    
    public void onDetachedFromActivityForConfigChanges() {
        this.onDetachedFromActivity();
    }
    
    public void onDetachedFromEngine(final a$b a$b) {
        this.a = null;
    }
    
    public void onReattachedToActivityForConfigChanges(final l1.c c) {
        this.onAttachedToActivity(c);
    }
}
