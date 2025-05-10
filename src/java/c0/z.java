package c0;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

abstract class z extends x
{
    private static final WeakReference h;
    private WeakReference g;
    
    static {
        h = new WeakReference((Object)null);
    }
    
    z(final byte[] array) {
        super(array);
        this.g = z.h;
    }
    
    protected abstract byte[] Z0();
    
    @Override
    final byte[] n() {
        synchronized (this) {
            byte[] z0;
            if ((z0 = (byte[])((Reference)this.g).get()) == null) {
                z0 = this.Z0();
                this.g = new WeakReference((Object)z0);
            }
            return z0;
        }
    }
}
