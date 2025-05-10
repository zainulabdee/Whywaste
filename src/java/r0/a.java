package r0;

import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;

public class a implements IInterface
{
    private final IBinder f;
    private final String g;
    
    protected a(final IBinder f, final String g) {
        this.f = f;
        this.g = g;
    }
    
    public final IBinder asBinder() {
        return this.f;
    }
    
    protected final Parcel j(final int n, final Parcel parcel) {
        final Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f.transact(n, parcel, obtain, 0);
                obtain.readException();
                parcel.recycle();
                return obtain;
            }
            finally {}
        }
        catch (final RuntimeException ex) {
            obtain.recycle();
            throw ex;
        }
        parcel.recycle();
    }
    
    protected final Parcel m() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        return obtain;
    }
}
