package a1;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.Collection;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;

class q implements o
{
    final String a;
    final int b;
    final int c;
    private final LinkedList<k> d;
    private final Set<m> e;
    private final Set<m> f;
    private final Map<Integer, m> g;
    
    q(final String a, final int b, final int c) {
        this.d = (LinkedList<k>)new LinkedList();
        this.e = (Set<m>)new HashSet();
        this.f = (Set<m>)new HashSet();
        this.g = (Map<Integer, m>)new HashMap();
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private k f(final m m) {
        synchronized (this) {
            final ListIterator listIterator = ((AbstractList)this.d).listIterator();
            while (true) {
                final boolean hasNext = listIterator.hasNext();
                m i = null;
                if (!hasNext) {
                    return null;
                }
                final k k = (k)listIterator.next();
                if (k.a() != null) {
                    i = (m)this.g.get((Object)k.a());
                }
                if (i != null && i != m) {
                    continue;
                }
                listIterator.remove();
                return k;
            }
        }
    }
    
    private void h(final m m) {
        synchronized (this) {
            final HashSet set = new HashSet((Collection)this.e);
            this.f.remove((Object)m);
            this.e.add((Object)m);
            if (!m.b() && m.d() != null) {
                this.g.remove((Object)m.d());
            }
            this.i(m);
            final Iterator iterator = ((Set)set).iterator();
            while (iterator.hasNext()) {
                this.i((m)iterator.next());
            }
        }
    }
    
    private void i(final m m) {
        synchronized (this) {
            final k f = this.f(m);
            if (f != null) {
                this.f.add((Object)m);
                this.e.remove((Object)m);
                if (f.a() != null) {
                    this.g.put((Object)f.a(), (Object)m);
                }
                m.e(f);
            }
        }
    }
    
    public void b() {
        synchronized (this) {
            final Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                ((m)iterator.next()).f();
            }
            final Iterator iterator2 = this.f.iterator();
            while (iterator2.hasNext()) {
                ((m)iterator2.next()).f();
            }
        }
    }
    
    public void c(final k k) {
        synchronized (this) {
            this.d.add((Object)k);
            final Iterator iterator = ((Set)new HashSet((Collection)this.e)).iterator();
            while (iterator.hasNext()) {
                this.i((m)iterator.next());
            }
        }
    }
    
    protected m e(final String s, final int n) {
        return new m(s, n);
    }
    
    public void start() {
        monitorenter(this);
        int i = 0;
        try {
            while (i < this.b) {
                final StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(i);
                final m e = this.e(sb.toString(), this.c);
                e.g((Runnable)new p(this, e));
                this.e.add((Object)e);
                ++i;
            }
        }
        finally {
            monitorexit(this);
        }
    }
}
