package io.sentry;

import java.util.TimeZone;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import io.sentry.vendor.gson.stream.b;
import java.util.Date;
import java.io.Reader;
import io.sentry.vendor.gson.stream.a;

public final class i1 extends a
{
    public i1(final Reader reader) {
        super(reader);
    }
    
    public static Date I(final String s, final n0 n0) {
        if (s == null) {
            return null;
        }
        try {
            return j.e(s);
        }
        catch (final Exception ex) {
            n0.d(l4.DEBUG, "Error when deserializing UTC timestamp format, it might be millis timestamp format.", (Throwable)ex);
            try {
                return j.f(s);
            }
            catch (final Exception ex2) {
                n0.d(l4.ERROR, "Error when deserializing millis timestamp format.", (Throwable)ex2);
                return null;
            }
        }
    }
    
    public Boolean J() {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        return this.n();
    }
    
    public Date K(final n0 n0) {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        return I(this.v(), n0);
    }
    
    public Double L() {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        return this.o();
    }
    
    public Float M() {
        return (float)this.o();
    }
    
    public Float N() {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        return this.M();
    }
    
    public Integer O() {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        return this.p();
    }
    
    public <T> List<T> P(final n0 n0, final c1<T> c1) {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        this.a();
        final ArrayList list = new ArrayList();
        do {
            try {
                ((List)list).add(c1.a(this, n0));
            }
            catch (final Exception ex) {
                n0.d(l4.ERROR, "Failed to deserialize object in list.", (Throwable)ex);
            }
        } while (this.x() == b.BEGIN_OBJECT);
        this.g();
        return (List<T>)list;
    }
    
    public Long Q() {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        return this.q();
    }
    
    public <T> Map<String, T> R(final n0 n0, final c1<T> c1) {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        this.b();
        final HashMap hashMap = new HashMap();
        do {
            try {
                ((Map)hashMap).put((Object)this.r(), c1.a(this, n0));
            }
            catch (final Exception ex) {
                n0.d(l4.ERROR, "Failed to deserialize object in map.", (Throwable)ex);
            }
        } while (this.x() == b.BEGIN_OBJECT || this.x() == b.NAME);
        this.h();
        return (Map<String, T>)hashMap;
    }
    
    public Object S() {
        return new h1().c(this);
    }
    
    public <T> T T(final n0 n0, final c1<T> c1) {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        return (T)c1.a(this, n0);
    }
    
    public String U() {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        return this.v();
    }
    
    public TimeZone V(final n0 n0) {
        if (this.x() == b.NULL) {
            this.t();
            return null;
        }
        try {
            return TimeZone.getTimeZone(this.v());
        }
        catch (final Exception ex) {
            n0.d(l4.ERROR, "Error when deserializing TimeZone", (Throwable)ex);
            return null;
        }
    }
    
    public void W(final n0 n0, final Map<String, Object> map, final String s) {
        try {
            map.put((Object)s, this.S());
        }
        catch (final Exception ex) {
            n0.c(l4.ERROR, (Throwable)ex, "Error deserializing unknown key: %s", new Object[] { s });
        }
    }
}
