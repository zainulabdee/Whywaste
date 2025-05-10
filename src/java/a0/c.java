package a0;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import org.json.JSONException;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import f0.i;
import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
import android.content.SharedPreferences;
import java.util.concurrent.locks.Lock;

public class c
{
    private static final Lock c;
    private static c d;
    private final Lock a;
    private final SharedPreferences b;
    
    static {
        c = (Lock)new ReentrantLock();
    }
    
    c(final Context context) {
        this.a = (Lock)new ReentrantLock();
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }
    
    public static c b(final Context context) {
        i.i(context);
        final Lock c = a0.c.c;
        c.lock();
        try {
            if (a0.c.d == null) {
                a0.c.d = new c(context.getApplicationContext());
            }
            final c d = a0.c.d;
            c.unlock();
            return d;
        }
        finally {
            a0.c.c.unlock();
        }
    }
    
    private static final String i(final String s, final String s2) {
        final StringBuilder sb = new StringBuilder(s.length() + 1 + String.valueOf((Object)s2).length());
        sb.append(s);
        sb.append(":");
        sb.append(s2);
        return sb.toString();
    }
    
    public void a() {
        this.a.lock();
        try {
            this.b.edit().clear().apply();
        }
        finally {
            this.a.unlock();
        }
    }
    
    public GoogleSignInAccount c() {
        final String g = this.g("defaultGoogleSignInAccount");
        final boolean empty = TextUtils.isEmpty((CharSequence)g);
        final GoogleSignInAccount googleSignInAccount = null;
        if (empty) {
            return googleSignInAccount;
        }
        final String g2 = this.g(i("googleSignInAccount", g));
        GoogleSignInAccount q = googleSignInAccount;
        if (g2 == null) {
            return q;
        }
        try {
            q = GoogleSignInAccount.q(g2);
            return q;
        }
        catch (final JSONException ex) {
            q = googleSignInAccount;
            return q;
        }
    }
    
    public GoogleSignInOptions d() {
        final String g = this.g("defaultGoogleSignInAccount");
        final boolean empty = TextUtils.isEmpty((CharSequence)g);
        final GoogleSignInOptions googleSignInOptions = null;
        if (empty) {
            return googleSignInOptions;
        }
        final String g2 = this.g(i("googleSignInOptions", g));
        GoogleSignInOptions m = googleSignInOptions;
        if (g2 == null) {
            return m;
        }
        try {
            m = GoogleSignInOptions.m(g2);
            return m;
        }
        catch (final JSONException ex) {
            m = googleSignInOptions;
            return m;
        }
    }
    
    public String e() {
        return this.g("refreshToken");
    }
    
    public void f(final GoogleSignInAccount googleSignInAccount, final GoogleSignInOptions googleSignInOptions) {
        i.i(googleSignInAccount);
        i.i(googleSignInOptions);
        this.h("defaultGoogleSignInAccount", googleSignInAccount.r());
        i.i(googleSignInAccount);
        i.i(googleSignInOptions);
        final String r = googleSignInAccount.r();
        this.h(i("googleSignInAccount", r), googleSignInAccount.s());
        this.h(i("googleSignInOptions", r), googleSignInOptions.q());
    }
    
    protected final String g(String string) {
        this.a.lock();
        try {
            string = this.b.getString(string, (String)null);
            return string;
        }
        finally {
            this.a.unlock();
        }
    }
    
    protected final void h(final String s, final String s2) {
        this.a.lock();
        try {
            this.b.edit().putString(s, s2).apply();
        }
        finally {
            this.a.unlock();
        }
    }
}
