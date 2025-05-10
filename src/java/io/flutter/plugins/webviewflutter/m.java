package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.platform.h;
import android.view.View;
import android.content.Context;
import t1.i;
import t1.r;
import io.flutter.plugin.platform.j;

class m extends j
{
    private final c4 b;
    
    m(final c4 b) {
        super((i)r.a);
        this.b = b;
    }
    
    public io.flutter.plugin.platform.i a(final Context context, final int n, final Object o) {
        final Integer n2 = (Integer)o;
        if (n2 == null) {
            throw new IllegalStateException("An identifier is required to retrieve a View instance.");
        }
        final Object i = this.b.i((long)n2);
        if (i instanceof io.flutter.plugin.platform.i) {
            return (io.flutter.plugin.platform.i)i;
        }
        if (i instanceof View) {
            return (io.flutter.plugin.platform.i)new io.flutter.plugin.platform.i(this, i) {
                final Object e;
                final m f;
                
                public void d() {
                }
                
                public View getView() {
                    return (View)this.e;
                }
            };
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unable to find a PlatformView or View instance: ");
        sb.append(o);
        sb.append(", ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }
}
