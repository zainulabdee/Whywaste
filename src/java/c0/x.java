package c0;

import android.os.RemoteException;
import android.util.Log;
import f0.f0;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import f0.i;
import com.google.android.gms.common.internal.zzz;

abstract class x extends zzz
{
    private final int f;
    
    protected x(final byte[] array) {
        i.a(array.length == 25);
        this.f = Arrays.hashCode(array);
    }
    
    protected static byte[] m(final String s) {
        try {
            return s.getBytes("ISO-8859-1");
        }
        catch (final UnsupportedEncodingException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public final int b() {
        return this.f;
    }
    
    public final IObjectWrapper d() {
        return ObjectWrapper.wrap((Object)this.n());
    }
    
    public final boolean equals(final Object o) {
        if (o != null) {
            if (o instanceof f0) {
                try {
                    final f0 f0 = (f0)o;
                    if (f0.b() != this.f) {
                        return false;
                    }
                    final IObjectWrapper d = f0.d();
                    return d != null && Arrays.equals(this.n(), (byte[])ObjectWrapper.unwrap(d));
                }
                catch (final RemoteException ex) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)ex);
                }
            }
        }
        return false;
    }
    
    public final int hashCode() {
        return this.f;
    }
    
    abstract byte[] n();
}
