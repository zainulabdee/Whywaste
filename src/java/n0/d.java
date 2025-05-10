package n0;

import android.content.Context;

public class d
{
    private static final d b;
    private c a;
    
    static {
        b = new d();
    }
    
    public d() {
        this.a = null;
    }
    
    public static c a(final Context context) {
        return d.b.b(context);
    }
    
    public final c b(final Context context) {
        synchronized (this) {
            if (this.a == null) {
                Context applicationContext = context;
                if (context.getApplicationContext() != null) {
                    applicationContext = context.getApplicationContext();
                }
                this.a = new c(applicationContext);
            }
            return this.a;
        }
    }
}
