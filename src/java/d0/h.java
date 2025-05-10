package d0;

import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public abstract class h<R extends l>
{
    public abstract void b(final a p0);
    
    public abstract R c(final long p0, final TimeUnit p1);
    
    public interface a
    {
        void a(final Status p0);
    }
}
