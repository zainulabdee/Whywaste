package c1;

import java.util.List;
import t1.k$d;
import java.util.HashMap;
import java.util.Map;

public class c extends a
{
    final Map<String, Object> a;
    final c.c$a b;
    final boolean c;
    
    public c(final Map<String, Object> a, final boolean c) {
        this.b = new c.c$a(this);
        this.a = a;
        this.c = c;
    }
    
    public <T> T c(final String s) {
        return (T)this.a.get((Object)s);
    }
    
    @Override
    public boolean e() {
        return this.c;
    }
    
    public String getMethod() {
        return (String)this.a.get((Object)"method");
    }
    
    public boolean i(final String s) {
        return this.a.containsKey((Object)s);
    }
    
    public f n() {
        return (f)this.b;
    }
    
    public Map<String, Object> o() {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        ((Map)hashMap2).put((Object)"code", (Object)this.b.b);
        ((Map)hashMap2).put((Object)"message", (Object)this.b.c);
        ((Map)hashMap2).put((Object)"data", this.b.d);
        ((Map)hashMap).put((Object)"error", (Object)hashMap2);
        return (Map<String, Object>)hashMap;
    }
    
    public Map<String, Object> p() {
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"result", this.b.a);
        return (Map<String, Object>)hashMap;
    }
    
    public void q(final k$d k$d) {
        final c.c$a b = this.b;
        k$d.b(b.b, b.c, b.d);
    }
    
    public void r(final List<Map<String, Object>> list) {
        if (!this.e()) {
            list.add((Object)this.o());
        }
    }
    
    public void s(final List<Map<String, Object>> list) {
        if (!this.e()) {
            list.add((Object)this.p());
        }
    }
}
