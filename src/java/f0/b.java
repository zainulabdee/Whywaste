package f0;

import java.util.Iterator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import android.view.View;
import d0.a;
import java.util.Map;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import android.accounts.Account;

public final class b
{
    private final Account a;
    private final Set<Scope> b;
    private final Set<Scope> c;
    private final Map<d0.a<?>, s> d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final u0.a i;
    private Integer j;
    
    public b(final Account a, final Set<Scope> set, final Map<d0.a<?>, s> map, final int e, final View f, final String g, final String h, final u0.a a2, final boolean b) {
        this.a = a;
        Set b2;
        if (set == null) {
            b2 = Collections.emptySet();
        }
        else {
            b2 = Collections.unmodifiableSet((Set)set);
        }
        this.b = (Set<Scope>)b2;
        Map emptyMap = map;
        if (map == null) {
            emptyMap = Collections.emptyMap();
        }
        this.d = (Map<d0.a<?>, s>)emptyMap;
        this.f = f;
        this.e = e;
        this.g = g;
        this.h = h;
        u0.a n;
        if ((n = a2) == null) {
            n = u0.a.n;
        }
        this.i = n;
        final HashSet set2 = new HashSet((Collection)b2);
        final Iterator iterator = emptyMap.values().iterator();
        while (iterator.hasNext()) {
            ((Set)set2).addAll((Collection)((s)iterator.next()).a);
        }
        this.c = (Set<Scope>)Collections.unmodifiableSet((Set)set2);
    }
    
    public Account a() {
        return this.a;
    }
    
    @Deprecated
    public String b() {
        final Account a = this.a;
        if (a != null) {
            return a.name;
        }
        return null;
    }
    
    public Account c() {
        final Account a = this.a;
        if (a != null) {
            return a;
        }
        return new Account("<<default account>>", "com.google");
    }
    
    public Set<Scope> d() {
        return this.c;
    }
    
    public Set<Scope> e(final d0.a<?> a) {
        final s s = (s)this.d.get((Object)a);
        if (s != null && !s.a.isEmpty()) {
            final HashSet set = new HashSet((Collection)this.b);
            ((Set)set).addAll((Collection)s.a);
            return (Set<Scope>)set;
        }
        return this.b;
    }
    
    public String f() {
        return this.g;
    }
    
    public Set<Scope> g() {
        return this.b;
    }
    
    public final u0.a h() {
        return this.i;
    }
    
    public final Integer i() {
        return this.j;
    }
    
    public final String j() {
        return this.h;
    }
    
    public final void k(final Integer j) {
        this.j = j;
    }
    
    public static final class a
    {
        private Account a;
        private f.b<Scope> b;
        private String c;
        private String d;
        private u0.a e;
        
        public a() {
            this.e = u0.a.n;
        }
        
        public b a() {
            return new b(this.a, (Set<Scope>)this.b, null, 0, null, this.c, this.d, this.e, false);
        }
        
        public a b(final String c) {
            this.c = c;
            return this;
        }
        
        public final a c(final Collection<Scope> collection) {
            if (this.b == null) {
                this.b = new f.b<Scope>();
            }
            this.b.addAll(collection);
            return this;
        }
        
        public final a d(final Account a) {
            this.a = a;
            return this;
        }
        
        public final a e(final String d) {
            this.d = d;
            return this;
        }
    }
}
