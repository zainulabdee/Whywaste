package a0;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class q
{
    private static q d;
    final c a;
    GoogleSignInAccount b;
    GoogleSignInOptions c;
    
    private q(final Context context) {
        final c b = a0.c.b(context);
        this.a = b;
        this.b = b.c();
        this.c = b.d();
    }
    
    public static q c(final Context context) {
        synchronized (q.class) {
            return f(context.getApplicationContext());
        }
    }
    
    private static q f(final Context context) {
        synchronized (q.class) {
            final q d = q.d;
            if (d != null) {
                return d;
            }
            return q.d = new q(context);
        }
    }
    
    public final GoogleSignInAccount a() {
        synchronized (this) {
            return this.b;
        }
    }
    
    public final GoogleSignInOptions b() {
        synchronized (this) {
            return this.c;
        }
    }
    
    public final void d() {
        synchronized (this) {
            this.a.a();
            this.b = null;
            this.c = null;
        }
    }
    
    public final void e(final GoogleSignInOptions c, final GoogleSignInAccount b) {
        synchronized (this) {
            this.a.f(b, c);
            this.b = b;
            this.c = c;
        }
    }
}
