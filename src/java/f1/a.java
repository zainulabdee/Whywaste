package f1;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import io.flutter.embedding.engine.FlutterJNI;
import i1.d;

public final class a
{
    private static a e;
    private static boolean f;
    private d a;
    private h1.a b;
    private FlutterJNI.c c;
    private ExecutorService d;
    
    private a(final d a, final h1.a b, final FlutterJNI.c c, final ExecutorService d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static a e() {
        a.f = true;
        if (a.e == null) {
            a.e = new b().a();
        }
        return a.e;
    }
    
    public h1.a a() {
        return this.b;
    }
    
    public ExecutorService b() {
        return this.d;
    }
    
    public d c() {
        return this.a;
    }
    
    public FlutterJNI.c d() {
        return this.c;
    }
    
    public static final class b
    {
        private d a;
        private h1.a b;
        private FlutterJNI.c c;
        private ExecutorService d;
        
        private void b() {
            if (this.c == null) {
                this.c = new FlutterJNI.c();
            }
            if (this.d == null) {
                this.d = Executors.newCachedThreadPool((ThreadFactory)new a());
            }
            if (this.a == null) {
                this.a = new d(this.c.a(), this.d);
            }
        }
        
        public f1.a a() {
            this.b();
            return new f1.a(this.a, this.b, this.c, this.d, null);
        }
        
        private class a implements ThreadFactory
        {
            private int a;
            final b b;
            
            private a(final b b) {
                this.b = b;
                this.a = 0;
            }
            
            public Thread newThread(final Runnable runnable) {
                final Thread thread = new Thread(runnable);
                final StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                sb.append(this.a++);
                thread.setName(sb.toString());
                return thread;
            }
        }
    }
}
