package io.sentry;

import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.io.StringWriter;
import java.util.Collection;
import io.sentry.protocol.b0;
import io.sentry.protocol.c0;
import io.sentry.protocol.f;
import io.sentry.protocol.a0;
import io.sentry.protocol.x;
import io.sentry.protocol.w;
import io.sentry.protocol.v;
import io.sentry.protocol.u;
import io.sentry.protocol.t;
import io.sentry.protocol.s;
import io.sentry.protocol.r;
import io.sentry.protocol.p;
import io.sentry.protocol.o;
import io.sentry.protocol.n;
import io.sentry.protocol.l;
import io.sentry.protocol.k;
import io.sentry.protocol.j;
import io.sentry.protocol.i;
import io.sentry.protocol.h;
import io.sentry.protocol.g;
import io.sentry.protocol.d;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.c;
import io.sentry.protocol.b;
import io.sentry.protocol.a;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.Charset;

public final class n1 implements t0
{
    private static final Charset c;
    private final q4 a;
    private final Map<Class<?>, c1<?>> b;
    
    static {
        c = Charset.forName("UTF-8");
    }
    
    public n1(final q4 a) {
        this.a = a;
        final HashMap b = new HashMap();
        (this.b = (Map<Class<?>, c1<?>>)b).put((Object)a.class, (Object)new a.a());
        ((Map)b).put((Object)e.class, (Object)new e.a());
        ((Map)b).put((Object)b.class, (Object)new b.a());
        ((Map)b).put((Object)c.class, (Object)new c.a());
        ((Map)b).put((Object)DebugImage.class, (Object)new DebugImage.a());
        ((Map)b).put((Object)d.class, (Object)new d.a());
        ((Map)b).put((Object)io.sentry.protocol.e.class, (Object)new io.sentry.protocol.e.a());
        ((Map)b).put((Object)io.sentry.protocol.e.b.class, (Object)new io.sentry.protocol.e.b.a());
        ((Map)b).put((Object)g.class, (Object)new g.a());
        ((Map)b).put((Object)h.class, (Object)new h.a());
        ((Map)b).put((Object)i.class, (Object)new i.a());
        ((Map)b).put((Object)j.class, (Object)new j.a());
        ((Map)b).put((Object)k.class, (Object)new k.a());
        ((Map)b).put((Object)l2.class, (Object)new l2.b());
        ((Map)b).put((Object)m2.class, (Object)new m2.a());
        ((Map)b).put((Object)io.sentry.profilemeasurements.a.class, (Object)new io.sentry.profilemeasurements.a.a());
        ((Map)b).put((Object)io.sentry.profilemeasurements.b.class, (Object)new io.sentry.profilemeasurements.b.a());
        ((Map)b).put((Object)l.class, (Object)new l.a());
        ((Map)b).put((Object)n.class, (Object)new n.a());
        ((Map)b).put((Object)o.class, (Object)new o.a());
        ((Map)b).put((Object)m3.class, (Object)new m3.a());
        ((Map)b).put((Object)d4.class, (Object)new d4.a());
        ((Map)b).put((Object)e4.class, (Object)new e4.a());
        ((Map)b).put((Object)p.class, (Object)new p.a());
        ((Map)b).put((Object)k4.class, (Object)new k4.a());
        ((Map)b).put((Object)l4.class, (Object)new l4.a());
        ((Map)b).put((Object)m4.class, (Object)new m4.a());
        ((Map)b).put((Object)r.class, (Object)new r.a());
        ((Map)b).put((Object)s.class, (Object)new s.a());
        ((Map)b).put((Object)t.class, (Object)new t.a());
        ((Map)b).put((Object)u.class, (Object)new u.a());
        ((Map)b).put((Object)v.class, (Object)new v.a());
        ((Map)b).put((Object)w.class, (Object)new w.a());
        ((Map)b).put((Object)x.class, (Object)new x.a());
        ((Map)b).put((Object)a5.class, (Object)new a5.a());
        ((Map)b).put((Object)d5.class, (Object)new d5.a());
        ((Map)b).put((Object)f5.class, (Object)new f5.a());
        ((Map)b).put((Object)h5.class, (Object)new h5.a());
        ((Map)b).put((Object)a0.class, (Object)new a0.a());
        ((Map)b).put((Object)f.class, (Object)new f.a());
        ((Map)b).put((Object)u5.class, (Object)new u5.a());
        ((Map)b).put((Object)io.sentry.clientreport.b.class, (Object)new io.sentry.clientreport.b.a());
        ((Map)b).put((Object)c0.class, (Object)new c0.a());
        ((Map)b).put((Object)b0.class, (Object)new b0.a());
    }
    
    private <T> boolean g(final Class<T> cls) {
        return cls.isArray() || Collection.class.isAssignableFrom(cls) || String.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
    }
    
    private String h(final Object o, final boolean b) {
        final StringWriter stringWriter = new StringWriter();
        final k1 k1 = new k1((Writer)stringWriter, this.a.getMaxDepth());
        if (b) {
            k1.q("\t");
        }
        k1.z(this.a.getLogger(), o);
        return stringWriter.toString();
    }
    
    public <T> T a(final Reader reader, final Class<T> clazz) {
        try {
            final i1 i1 = new i1(reader);
            final c1 c1 = (c1)this.b.get((Object)clazz);
            if (c1 != null) {
                return clazz.cast(c1.a(i1, this.a.getLogger()));
            }
            if (this.g(clazz)) {
                return (T)i1.S();
            }
            return null;
        }
        catch (final Exception ex) {
            this.a.getLogger().d(l4.ERROR, "Error when deserializing", (Throwable)ex);
            return null;
        }
    }
    
    public l3 b(final InputStream inputStream) {
        io.sentry.util.n.c((Object)inputStream, "The InputStream object is required.");
        try {
            return this.a.getEnvelopeReader().a(inputStream);
        }
        catch (final IOException ex) {
            this.a.getLogger().d(l4.ERROR, "Error deserializing envelope.", (Throwable)ex);
            return null;
        }
    }
    
    public <T> void c(final T t, final Writer writer) {
        io.sentry.util.n.c((Object)t, "The entity is required.");
        io.sentry.util.n.c((Object)writer, "The Writer object is required.");
        final n0 logger = this.a.getLogger();
        final l4 debug = l4.DEBUG;
        if (logger.b(debug)) {
            this.a.getLogger().a(debug, "Serializing object: %s", new Object[] { this.h(t, true) });
        }
        new k1(writer, this.a.getMaxDepth()).z(this.a.getLogger(), t);
        writer.flush();
    }
    
    public <T, R> T d(final Reader reader, final Class<T> cls, final c1<R> c1) {
        try {
            final i1 i1 = new i1(reader);
            if (!Collection.class.isAssignableFrom(cls)) {
                return (T)i1.S();
            }
            if (c1 == null) {
                return (T)i1.S();
            }
            return (T)i1.P(this.a.getLogger(), (io.sentry.c1<Object>)c1);
        }
        finally {
            final Throwable t;
            this.a.getLogger().d(l4.ERROR, "Error when deserializing", t);
            return null;
        }
    }
    
    public void e(l3 iterator, final OutputStream outputStream) {
        io.sentry.util.n.c((Object)iterator, "The SentryEnvelope object is required.");
        io.sentry.util.n.c((Object)outputStream, "The Stream object is required.");
        final BufferedWriter bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)new BufferedOutputStream(outputStream), n1.c));
        try {
            iterator.b().serialize(new k1((Writer)bufferedWriter, this.a.getMaxDepth()), this.a.getLogger());
            ((Writer)bufferedWriter).write("\n");
            iterator = (l3)iterator.c().iterator();
            while (((Iterator)iterator).hasNext()) {
                final c4 c4 = (c4)((Iterator)iterator).next();
                try {
                    final byte[] w = c4.w();
                    c4.x().serialize(new k1((Writer)bufferedWriter, this.a.getMaxDepth()), this.a.getLogger());
                    ((Writer)bufferedWriter).write("\n");
                    ((Writer)bufferedWriter).flush();
                    outputStream.write(w);
                    ((Writer)bufferedWriter).write("\n");
                }
                catch (final Exception ex) {
                    this.a.getLogger().d(l4.ERROR, "Failed to create envelope item. Dropping it.", (Throwable)ex);
                }
            }
        }
        finally {
            ((Writer)bufferedWriter).flush();
        }
    }
    
    public String f(final Map<String, Object> map) {
        return this.h(map, false);
    }
}
