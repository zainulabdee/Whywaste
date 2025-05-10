package s1;

import io.flutter.embedding.engine.FlutterJNI$a;
import io.flutter.view.g$g;
import t1.i;
import t1.c;
import t1.r;
import io.flutter.embedding.engine.FlutterJNI;

public class a
{
    public final t1.a<Object> a;
    public final FlutterJNI b;
    private a.a$b c;
    final t1.a.d<Object> d;
    
    public a(final g1.a a, final FlutterJNI b) {
        final a$a d = new a$a(this);
        this.d = (t1.a.d<Object>)d;
        (this.a = new t1.a<Object>(a, "flutter/accessibility", (i<Object>)r.a)).e((t1.a.d<Object>)d);
        this.b = b;
    }
    
    public void b(final int n, final g$g g$g) {
        this.b.dispatchSemanticsAction(n, g$g);
    }
    
    public void c(final int n, final g$g g$g, final Object o) {
        this.b.dispatchSemanticsAction(n, g$g, o);
    }
    
    public void d() {
        this.b.setSemanticsEnabled(false);
    }
    
    public void e() {
        this.b.setSemanticsEnabled(true);
    }
    
    public void f(final int accessibilityFeatures) {
        this.b.setAccessibilityFeatures(accessibilityFeatures);
    }
    
    public void g(final a.a$b a$b) {
        this.c = a$b;
        this.b.setAccessibilityDelegate((FlutterJNI$a)a$b);
    }
}
