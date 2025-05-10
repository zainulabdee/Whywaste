package a0;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.net.URLConnection;
import d0.l;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.android.gms.common.api.Status;
import d0.h;
import d0.f;
import f0.i;
import e0.n;
import i0.a;

public final class e implements Runnable
{
    private static final a g;
    private final String e;
    private final n f;
    
    static {
        g = new a("RevokeAccessOperation", new String[0]);
    }
    
    public e(final String s) {
        this.e = i.e(s);
        this.f = new n((f)null);
    }
    
    public static h a(final String s) {
        if (s == null) {
            return d0.i.a(new Status(4), null);
        }
        final e e = new e(s);
        new Thread((Runnable)e).start();
        return (h)e.f;
    }
    
    public final void run() {
        Object m;
        Object o;
        Object k = o = (m = Status.m);
        Label_0299: {
            Label_0275: {
                try {
                    m = k;
                    o = k;
                    final String e = this.e;
                    m = k;
                    o = k;
                    m = k;
                    o = k;
                    final StringBuilder sb = new StringBuilder();
                    m = k;
                    o = k;
                    sb.append("https://accounts.google.com/o/oauth2/revoke?token=");
                    m = k;
                    o = k;
                    sb.append(e);
                    m = k;
                    o = k;
                    final URL url = new URL(sb.toString());
                    m = k;
                    o = k;
                    final HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    m = k;
                    o = k;
                    ((URLConnection)httpURLConnection).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    m = k;
                    o = k;
                    final int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        m = k;
                        o = k;
                        k = Status.k;
                    }
                    else {
                        m = k;
                        o = k;
                        a0.e.g.b("Unable to revoke access!", new Object[0]);
                    }
                    m = k;
                    o = k;
                    final a g = a0.e.g;
                    m = k;
                    o = k;
                    m = k;
                    o = k;
                    final StringBuilder sb2 = new StringBuilder();
                    m = k;
                    o = k;
                    sb2.append("Response Code: ");
                    m = k;
                    o = k;
                    sb2.append(responseCode);
                    m = k;
                    o = k;
                    g.a(sb2.toString(), new Object[0]);
                    break Label_0299;
                }
                catch (final Exception ex) {}
                catch (final IOException ex2) {
                    break Label_0275;
                }
                final Exception ex;
                a0.e.g.b("Exception when revoking access: ".concat(String.valueOf((Object)ex.toString())), new Object[0]);
                k = m;
                break Label_0299;
            }
            final IOException ex2;
            a0.e.g.b("IOException when revoking access: ".concat(String.valueOf((Object)ex2.toString())), new Object[0]);
            k = o;
        }
        ((BasePendingResult)this.f).g((l)k);
    }
}
