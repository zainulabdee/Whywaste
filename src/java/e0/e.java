package e0;

import androidx.fragment.app.d;
import f0.i;
import android.app.Activity;

public class e
{
    private final Object a;
    
    public e(final Activity a) {
        i.j(a, "Activity must not be null");
        this.a = a;
    }
    
    public final Activity a() {
        return (Activity)this.a;
    }
    
    public final d b() {
        return (d)this.a;
    }
    
    public final boolean c() {
        return this.a instanceof Activity;
    }
    
    public final boolean d() {
        return this.a instanceof d;
    }
}
