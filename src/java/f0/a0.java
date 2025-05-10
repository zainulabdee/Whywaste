package f0;

import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.api.Status;
import d0.h;
import d0.h$a;

final class a0 implements h$a
{
    final h a;
    final w0.h b;
    final f0.h$a c;
    final c0 d;
    
    a0(final h a, final w0.h b, final f0.h$a c, final c0 d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final void a(final Status status) {
        if (status.i()) {
            this.b.c(this.c.a(this.a.c(0L, TimeUnit.MILLISECONDS)));
            return;
        }
        this.b.b((Exception)f0.a.a(status));
    }
}
