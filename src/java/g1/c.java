package g1;

import java.util.concurrent.Executor;
import java.nio.Buffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import f1.a;
import java.util.concurrent.ExecutorService;
import java.util.LinkedList;
import java.util.Iterator;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.List;
import java.util.Map;
import io.flutter.embedding.engine.FlutterJNI;

class c implements c, f
{
    private final FlutterJNI a;
    private final Map<String, c$f> b;
    private Map<String, List<c$b>> c;
    private final Object d;
    private final AtomicBoolean e;
    private final Map<Integer, b> f;
    private int g;
    private final c$d h;
    private WeakHashMap<c, c$d> i;
    private c$i j;
    
    c(final FlutterJNI flutterJNI) {
        this(flutterJNI, (c$i)new e());
    }
    
    c(final FlutterJNI a, final c$i j) {
        this.b = (Map<String, c$f>)new HashMap();
        this.c = (Map<String, List<c$b>>)new HashMap();
        this.d = new Object();
        this.e = new AtomicBoolean(false);
        this.f = (Map<Integer, b>)new HashMap();
        this.g = 1;
        this.h = (c$d)new g1.g();
        this.i = (WeakHashMap<c, c$d>)new WeakHashMap();
        this.a = a;
        this.j = j;
    }
    
    private void j(final String s, final c$f c$f, final ByteBuffer byteBuffer, final int n, final long n2) {
        c$d b;
        if (c$f != null) {
            b = c$f.b;
        }
        else {
            b = null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("PlatformChannel ScheduleHandler on ");
        sb.append(s);
        b2.f.b(sb.toString(), n);
        final g1.b b2 = new g1.b(this, s, n, c$f, byteBuffer, n2);
        c$d h = b;
        if (b == null) {
            h = this.h;
        }
        h.a((Runnable)b2);
    }
    
    private static void k(final Error error) {
        final Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() != null) {
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, (Throwable)error);
            return;
        }
        throw error;
    }
    
    private void l(final c$f c$f, final ByteBuffer byteBuffer, final int n) {
        if (c$f != null) {
            try {
                f1.b.f("DartMessenger", "Deferring to registered handler to process message.");
                c$f.a.a(byteBuffer, new g(this.a, n));
            }
            catch (final Error error) {
                k(error);
            }
            catch (final Exception ex) {
                f1.b.c("DartMessenger", "Uncaught exception in binary message listener", (Throwable)ex);
                this.a.invokePlatformMessageEmptyResponseCallback(n);
            }
        }
        else {
            f1.b.f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
            this.a.invokePlatformMessageEmptyResponseCallback(n);
        }
    }
    
    @Override
    public c a(final d d) {
        final c$d a = this.j.a(d);
        final j j = new j(null);
        this.i.put((Object)j, (Object)a);
        return j;
    }
    
    @Override
    public void b(final String s, final ByteBuffer byteBuffer, final b b) {
        final StringBuilder sb = new StringBuilder();
        sb.append("DartMessenger#send on ");
        sb.append(s);
        b2.f.a(sb.toString());
        try {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Sending message with callback over channel '");
            sb2.append(s);
            sb2.append("'");
            f1.b.f("DartMessenger", sb2.toString());
            final int n = this.g++;
            if (b != null) {
                this.f.put((Object)n, (Object)b);
            }
            if (byteBuffer == null) {
                this.a.dispatchEmptyPlatformMessage(s, n);
            }
            else {
                this.a.dispatchPlatformMessage(s, byteBuffer, ((Buffer)byteBuffer).position(), n);
            }
        }
        finally {
            b2.f.d();
        }
    }
    
    @Override
    public void c(final String s, final a a, final c c) {
        if (a == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Removing handler for channel '");
            sb.append(s);
            sb.append("'");
            f1.b.f("DartMessenger", sb.toString());
            final Object d = this.d;
            synchronized (d) {
                this.b.remove((Object)s);
                return;
            }
        }
        c$d c$d = null;
        if (c != null) {
            c$d = (c$d)this.i.get((Object)c);
            if (c$d == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Setting handler for channel '");
        sb2.append(s);
        sb2.append("'");
        f1.b.f("DartMessenger", sb2.toString());
        final Object d2 = this.d;
        synchronized (d2) {
            this.b.put((Object)s, (Object)new c$f(a, c$d));
            final List list = (List)this.c.remove((Object)s);
            if (list == null) {
                return;
            }
            monitorexit(d2);
            for (final c$b c$b : list) {
                this.j(s, (c$f)this.b.get((Object)s), c$b.a, c$b.b, c$b.c);
            }
        }
    }
    
    @Override
    public void e(final String s, final ByteBuffer byteBuffer) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Sending message over channel '");
        sb.append(s);
        sb.append("'");
        f1.b.f("DartMessenger", sb.toString());
        this.b(s, byteBuffer, null);
    }
    
    public void f(final int n, final ByteBuffer byteBuffer) {
        f1.b.f("DartMessenger", "Received message reply from Dart.");
        final b b = (b)this.f.remove((Object)n);
        if (b != null) {
            try {
                f1.b.f("DartMessenger", "Invoking registered callback for reply from Dart.");
                b.a(byteBuffer);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
            }
            catch (final Error error) {
                k(error);
            }
            catch (final Exception ex) {
                f1.b.c("DartMessenger", "Uncaught exception in binary message reply handler", (Throwable)ex);
            }
        }
    }
    
    @Override
    public void g(final String s, final a a) {
        this.c(s, a, null);
    }
    
    public void h(final String s, final ByteBuffer byteBuffer, final int n, final long n2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Received message from Dart over channel '");
        sb.append(s);
        sb.append("'");
        f1.b.f("DartMessenger", sb.toString());
        final Object d = this.d;
        synchronized (d) {
            final c$f c$f = (c$f)this.b.get((Object)s);
            final boolean b = this.e.get() && c$f == null;
            if (b) {
                if (!this.c.containsKey((Object)s)) {
                    this.c.put((Object)s, (Object)new LinkedList());
                }
                ((List)this.c.get((Object)s)).add((Object)new c$b(byteBuffer, n, n2));
            }
            monitorexit(d);
            if (!b) {
                this.j(s, c$f, byteBuffer, n, n2);
            }
        }
    }
    
    static class c implements c$d
    {
        private final ExecutorService a;
        
        c(final ExecutorService a) {
            this.a = a;
        }
        
        public void a(final Runnable runnable) {
            ((Executor)this.a).execute(runnable);
        }
    }
    
    private static class e implements c$i
    {
        ExecutorService a;
        
        e() {
            this.a = f1.a.e().b();
        }
        
        public c$d a(final d d) {
            if (d.a()) {
                return (c$d)new h(this.a);
            }
            return (c$d)new c(this.a);
        }
    }
    
    static class g implements b
    {
        private final FlutterJNI a;
        private final int b;
        private final AtomicBoolean c;
        
        g(final FlutterJNI a, final int b) {
            this.c = new AtomicBoolean(false);
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void a(final ByteBuffer byteBuffer) {
            if (!this.c.getAndSet(true)) {
                if (byteBuffer == null) {
                    this.a.invokePlatformMessageEmptyResponseCallback(this.b);
                }
                else {
                    this.a.invokePlatformMessageResponseCallback(this.b, byteBuffer, ((Buffer)byteBuffer).position());
                }
                return;
            }
            throw new IllegalStateException("Reply already submitted");
        }
    }
    
    static class h implements c$d
    {
        private final ExecutorService a;
        private final ConcurrentLinkedQueue<Runnable> b;
        private final AtomicBoolean c;
        
        h(final ExecutorService a) {
            this.a = a;
            this.b = (ConcurrentLinkedQueue<Runnable>)new ConcurrentLinkedQueue();
            this.c = new AtomicBoolean(false);
        }
        
        private void d() {
            if (this.c.compareAndSet(false, true)) {
                try {
                    final Runnable runnable = (Runnable)this.b.poll();
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                finally {
                    this.c.set(false);
                    if (!this.b.isEmpty()) {
                        ((Executor)this.a).execute((Runnable)new g1.e(this));
                    }
                }
            }
        }
        
        public void a(final Runnable runnable) {
            this.b.add((Object)runnable);
            ((Executor)this.a).execute((Runnable)new g1.d(this));
        }
    }
    
    private static class j implements c
    {
    }
}
