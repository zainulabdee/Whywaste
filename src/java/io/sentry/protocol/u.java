package io.sentry.protocol;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.m4;
import java.util.Map;
import io.sentry.m1;

public final class u implements m1
{
    private String e;
    private String f;
    private String g;
    private Integer h;
    private Integer i;
    private String j;
    private String k;
    private Boolean l;
    private String m;
    private Boolean n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private Map<String, Object> t;
    private String u;
    private m4 v;
    
    public void r(final String e) {
        this.e = e;
    }
    
    public void s(final String f) {
        this.f = f;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("filename").v(this.e);
        }
        if (this.f != null) {
            k1.y("function").v(this.f);
        }
        if (this.g != null) {
            k1.y("module").v(this.g);
        }
        if (this.h != null) {
            k1.y("lineno").u((Number)this.h);
        }
        if (this.i != null) {
            k1.y("colno").u((Number)this.i);
        }
        if (this.j != null) {
            k1.y("abs_path").v(this.j);
        }
        if (this.k != null) {
            k1.y("context_line").v(this.k);
        }
        if (this.l != null) {
            k1.y("in_app").t(this.l);
        }
        if (this.m != null) {
            k1.y("package").v(this.m);
        }
        if (this.n != null) {
            k1.y("native").t(this.n);
        }
        if (this.o != null) {
            k1.y("platform").v(this.o);
        }
        if (this.p != null) {
            k1.y("image_addr").v(this.p);
        }
        if (this.q != null) {
            k1.y("symbol_addr").v(this.q);
        }
        if (this.r != null) {
            k1.y("instruction_addr").v(this.r);
        }
        if (this.u != null) {
            k1.y("raw_function").v(this.u);
        }
        if (this.s != null) {
            k1.y("symbol").v(this.s);
        }
        if (this.v != null) {
            k1.y("lock").z(n0, this.v);
        }
        final Map<String, Object> t = this.t;
        if (t != null) {
            for (final String s : t.keySet()) {
                final Object value = this.t.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public void t(final Boolean l) {
        this.l = l;
    }
    
    public void u(final Integer h) {
        this.h = h;
    }
    
    public void v(final m4 v) {
        this.v = v;
    }
    
    public void w(final String g) {
        this.g = g;
    }
    
    public void x(final Boolean n) {
        this.n = n;
    }
    
    public void y(final String m) {
        this.m = m;
    }
    
    public void z(final Map<String, Object> t) {
        this.t = t;
    }
    
    public static final class a implements c1<u>
    {
        public u b(final i1 i1, final n0 n0) {
            final u u = new u();
            i1.b();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1874684019: {
                        if (!r.equals((Object)"platform")) {
                            break;
                        }
                        n2 = 16;
                        break;
                    }
                    case 1713445842: {
                        if (!r.equals((Object)"abs_path")) {
                            break;
                        }
                        n2 = 15;
                        break;
                    }
                    case 1380938712: {
                        if (!r.equals((Object)"function")) {
                            break;
                        }
                        n2 = 14;
                        break;
                    }
                    case 1116694660: {
                        if (!r.equals((Object)"context_line")) {
                            break;
                        }
                        n2 = 13;
                        break;
                    }
                    case 410194178: {
                        if (!r.equals((Object)"instruction_addr")) {
                            break;
                        }
                        n2 = 12;
                        break;
                    }
                    case 94842689: {
                        if (!r.equals((Object)"colno")) {
                            break;
                        }
                        n2 = 11;
                        break;
                    }
                    case 3327275: {
                        if (!r.equals((Object)"lock")) {
                            break;
                        }
                        n2 = 10;
                        break;
                    }
                    case -330260936: {
                        if (!r.equals((Object)"symbol_addr")) {
                            break;
                        }
                        n2 = 9;
                        break;
                    }
                    case -734768633: {
                        if (!r.equals((Object)"filename")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case -807062458: {
                        if (!r.equals((Object)"package")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case -887523944: {
                        if (!r.equals((Object)"symbol")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case -1052618729: {
                        if (!r.equals((Object)"native")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case -1068784020: {
                        if (!r.equals((Object)"module")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case -1102671691: {
                        if (!r.equals((Object)"lineno")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -1113875953: {
                        if (!r.equals((Object)"raw_function")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1184392185: {
                        if (!r.equals((Object)"in_app")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1443345323: {
                        if (!r.equals((Object)"image_addr")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        Object o = map;
                        if (map == null) {
                            o = new ConcurrentHashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                        continue;
                    }
                    case 16: {
                        u.o = i1.U();
                        continue;
                    }
                    case 15: {
                        u.j = i1.U();
                        continue;
                    }
                    case 14: {
                        u.f = i1.U();
                        continue;
                    }
                    case 13: {
                        u.k = i1.U();
                        continue;
                    }
                    case 12: {
                        u.r = i1.U();
                        continue;
                    }
                    case 11: {
                        u.i = i1.O();
                        continue;
                    }
                    case 10: {
                        u.v = i1.T(n0, (io.sentry.c1<m4>)new m4.a());
                        continue;
                    }
                    case 9: {
                        u.q = i1.U();
                        continue;
                    }
                    case 8: {
                        u.e = i1.U();
                        continue;
                    }
                    case 7: {
                        u.m = i1.U();
                        continue;
                    }
                    case 6: {
                        u.s = i1.U();
                        continue;
                    }
                    case 5: {
                        u.n = i1.J();
                        continue;
                    }
                    case 4: {
                        u.g = i1.U();
                        continue;
                    }
                    case 3: {
                        u.h = i1.O();
                        continue;
                    }
                    case 2: {
                        u.u = i1.U();
                        continue;
                    }
                    case 1: {
                        u.l = i1.J();
                        continue;
                    }
                    case 0: {
                        u.p = i1.U();
                        continue;
                    }
                }
            }
            u.z(map);
            i1.h();
            return u;
        }
    }
}
