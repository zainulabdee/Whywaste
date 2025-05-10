package k1;

import io.flutter.embedding.engine.d;
import io.flutter.plugin.platform.k;
import io.flutter.view.s;
import t1.c;
import android.content.Context;

public interface a
{
    void onAttachedToEngine(final b p0);
    
    void onDetachedFromEngine(final b p0);
    
    public interface a
    {
        String a(final String p0);
    }
    
    public static class b
    {
        private final Context a;
        private final a b;
        private final c c;
        private final s d;
        private final k e;
        private final a f;
        private final d g;
        
        public b(final Context a, final a b, final c c, final s d, final k e, final a f, final d g) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
        }
        
        public Context a() {
            return this.a;
        }
        
        public c b() {
            return this.c;
        }
        
        public a c() {
            return this.f;
        }
        
        public k d() {
            return this.e;
        }
    }
}
