package io.flutter.plugin.platform;

import s1.i$g;
import s1.i$d;
import android.view.Window;
import androidx.core.view.g0;
import android.view.View;
import android.view.View$OnSystemUiVisibilityChangeListener;
import android.graphics.Bitmap;
import android.app.ActivityManager$TaskDescription;
import android.os.Build$VERSION;
import androidx.activity.l;
import android.content.ClipData$Item;
import android.content.ClipData;
import f1.b;
import java.io.FileNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import s1.i$e;
import s1.i$k;
import s1.i$l;
import java.util.List;
import s1.i$c;
import s1.i$i;
import s1.i$h;
import s1.i$j;
import s1.i;
import android.app.Activity;

public class f
{
    private final Activity a;
    private final i b;
    private final d c;
    private i$j d;
    private int e;
    final i$h f;
    
    public f(final Activity a, final i b, final d c) {
        final f$a f = new f$a(this);
        this.f = (i$h)f;
        this.a = a;
        (this.b = b).l((i$h)f);
        this.c = c;
        this.e = 1280;
    }
    
    private boolean n() {
        final ClipboardManager clipboardManager = (ClipboardManager)this.a.getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return false;
        }
        final ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
        return primaryClipDescription != null && primaryClipDescription.hasMimeType("text/*");
    }
    
    private CharSequence p(final i$e i$e) {
        final ClipboardManager clipboardManager = (ClipboardManager)this.a.getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            final ClipData primaryClip = clipboardManager.getPrimaryClip();
            if (primaryClip == null) {
                return null;
            }
            if (i$e != null && i$e != i$e.f) {
                return null;
            }
            final ClipData$Item item = primaryClip.getItemAt(0);
            if (item.getUri() != null) {
                ((Context)this.a).getContentResolver().openTypedAssetFileDescriptor(item.getUri(), "text/*", (Bundle)null);
            }
            return item.coerceToText((Context)this.a);
        }
        catch (final FileNotFoundException ex) {
            return null;
        }
        catch (final SecurityException ex2) {
            f1.b.h("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", (Throwable)ex2);
            return null;
        }
    }
    
    private void q(final i$i i$i) {
        if (i$i == i$i.f) {
            this.a.getWindow().getDecorView().playSoundEffect(0);
        }
    }
    
    private void r() {
        final d c = this.c;
        if (c != null && c.b()) {
            return;
        }
        final Activity a = this.a;
        if (a instanceof l) {
            ((l)a).i().e();
        }
        else {
            a.finish();
        }
    }
    
    private void s() {
        this.A();
    }
    
    private void t(final String s) {
        ((ClipboardManager)this.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence)"text label?", (CharSequence)s));
    }
    
    private void u(final i$c i$c) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT < 28 && sdk_INT > 21) {
            this.a.setTaskDescription(new ActivityManager$TaskDescription(i$c.b, (Bitmap)null, i$c.a));
        }
        if (sdk_INT >= 28) {
            this.a.setTaskDescription(new ActivityManager$TaskDescription(i$c.b, 0, i$c.a));
        }
    }
    
    private void v() {
        final View decorView = this.a.getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener((View$OnSystemUiVisibilityChangeListener)new View$OnSystemUiVisibilityChangeListener(this, decorView) {
            final View a;
            final f b;
            
            public void onSystemUiVisibilityChange(final int n) {
                this.a.post((Runnable)new g(this, n));
            }
        });
    }
    
    private void w(final i$k i$k) {
        int e;
        if (i$k == i$k.f) {
            e = 1798;
        }
        else if (i$k == i$k.g) {
            e = 3846;
        }
        else if (i$k == i$k.h) {
            e = 5894;
        }
        else {
            if (i$k != i$k.i || Build$VERSION.SDK_INT < 29) {
                return;
            }
            e = 1792;
        }
        this.e = e;
        this.A();
    }
    
    private void x(final List<i$l> list) {
        int e;
        if (list.size() == 0) {
            e = 5894;
        }
        else {
            e = 1798;
        }
        for (int i = 0; i < list.size(); ++i) {
            final int n = f$c.b[((Enum)list.get(i)).ordinal()];
            if (n != 1) {
                if (n == 2) {
                    e = (e & 0xFFFFFDFF & 0xFFFFFFFD);
                }
            }
            else {
                e &= 0xFFFFFFFB;
            }
        }
        this.e = e;
        this.A();
    }
    
    private void y(final int requestedOrientation) {
        this.a.setRequestedOrientation(requestedOrientation);
    }
    
    private void z(final i$j d) {
        final Window window = this.a.getWindow();
        final g0 g0 = new g0(window, window.getDecorView());
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        if (sdk_INT >= 23) {
            final i$d b = d.b;
            if (b != null) {
                final int n = f$c.c[((Enum)b).ordinal()];
                if (n != 1) {
                    if (n == 2) {
                        g0.b(false);
                    }
                }
                else {
                    g0.b(true);
                }
            }
            final Integer a = d.a;
            if (a != null) {
                window.setStatusBarColor((int)a);
            }
        }
        final Boolean c = d.c;
        if (c != null && sdk_INT >= 29) {
            io.flutter.plugin.platform.c.a(window, (boolean)c);
        }
        if (sdk_INT >= 26) {
            final i$d e = d.e;
            if (e != null) {
                final int n2 = f$c.c[((Enum)e).ordinal()];
                if (n2 != 1) {
                    if (n2 == 2) {
                        g0.a(false);
                    }
                }
                else {
                    g0.a(true);
                }
            }
            final Integer d2 = d.d;
            if (d2 != null) {
                window.setNavigationBarColor((int)d2);
            }
        }
        final Integer f = d.f;
        if (f != null && sdk_INT >= 28) {
            d.a(window, (int)f);
        }
        final Boolean g2 = d.g;
        if (g2 != null && sdk_INT >= 29) {
            io.flutter.plugin.platform.e.a(window, (boolean)g2);
        }
        this.d = d;
    }
    
    public void A() {
        this.a.getWindow().getDecorView().setSystemUiVisibility(this.e);
        final i$j d = this.d;
        if (d != null) {
            this.z(d);
        }
    }
    
    void B(final i$g i$g) {
        final View decorView = this.a.getWindow().getDecorView();
        final int n = f$c.a[((Enum)i$g).ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n == 5) {
                            decorView.performHapticFeedback(4);
                        }
                    }
                    else if (Build$VERSION.SDK_INT >= 23) {
                        decorView.performHapticFeedback(6);
                    }
                }
                else {
                    decorView.performHapticFeedback(3);
                }
            }
            else {
                decorView.performHapticFeedback(1);
            }
        }
        else {
            decorView.performHapticFeedback(0);
        }
    }
    
    public void o() {
        this.b.l((i$h)null);
    }
    
    public interface d
    {
        boolean b();
    }
}
