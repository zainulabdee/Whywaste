package s1;

import java.util.HashMap;
import java.util.Map;
import t1.c;
import t1.s;
import g1.a;
import t1.k;

public class l
{
    public final boolean a;
    private byte[] b;
    private k c;
    private k.d d;
    private boolean e;
    private boolean f;
    private final k.c g;
    
    public l(final a a, final boolean b) {
        this(new k(a, "flutter/restoration", (t1.l)s.b), b);
    }
    
    l(final k c, final boolean a) {
        this.e = false;
        this.f = false;
        final l$b g = new l$b(this);
        this.g = (k.c)g;
        this.c = c;
        this.a = a;
        c.e((k.c)g);
    }
    
    private Map<String, Object> i(final byte[] array) {
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"enabled", (Object)Boolean.TRUE);
        ((Map)hashMap).put((Object)"data", (Object)array);
        return (Map<String, Object>)hashMap;
    }
    
    public void g() {
        this.b = null;
    }
    
    public byte[] h() {
        return this.b;
    }
    
    public void j(final byte[] array) {
        this.e = true;
        final k.d d = this.d;
        if (d != null) {
            d.a(this.i(array));
            this.d = null;
            this.b = array;
        }
        else if (this.f) {
            this.c.d("push", this.i(array), (k.d)new l$a(this, array));
        }
        else {
            this.b = array;
        }
    }
}
