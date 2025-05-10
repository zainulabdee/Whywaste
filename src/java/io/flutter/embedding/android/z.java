package io.flutter.embedding.android;

import f1.b;
import s1.d;
import android.view.KeyEvent;
import java.util.HashSet;
import io.flutter.plugin.editing.d$a;

public class z implements d$a
{
    protected final z.z$d[] a;
    private final HashSet<KeyEvent> b;
    private final z.z$e c;
    
    public z(final z.z$e c) {
        this.b = (HashSet<KeyEvent>)new HashSet();
        this.c = c;
        this.a = new z.z$d[] { (z.z$d)new y(c.getBinaryMessenger()), (z.z$d)new t(new d(c.getBinaryMessenger())) };
    }
    
    private void d(final KeyEvent keyEvent) {
        final z.z$e c = this.c;
        if (c != null) {
            if (!c.c(keyEvent)) {
                this.b.add((Object)keyEvent);
                this.c.a(keyEvent);
                if (this.b.remove((Object)keyEvent)) {
                    f1.b.g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
                }
            }
        }
    }
    
    public boolean a(final KeyEvent keyEvent) {
        final boolean remove = this.b.remove((Object)keyEvent);
        int i = 0;
        if (remove) {
            return false;
        }
        if (this.a.length > 0) {
            final z.z$c z$c = new z.z$c(this, keyEvent);
            for (z.z$d[] a = this.a; i < a.length; ++i) {
                a[i].a(keyEvent, z$c.a());
            }
        }
        else {
            this.d(keyEvent);
        }
        return true;
    }
    
    public void c() {
        final int size = this.b.size();
        if (size > 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("A KeyboardManager was destroyed with ");
            sb.append(String.valueOf(size));
            sb.append(" unhandled redispatch event(s).");
            f1.b.g("KeyboardManager", sb.toString());
        }
    }
}
