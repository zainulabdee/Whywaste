package f0;

import e0.f;
import android.content.Intent;

final class v extends w
{
    final Intent a;
    final f b;
    
    v(final Intent a, final f b, final int n) {
        this.a = a;
        this.b = b;
    }
    
    public final void a() {
        final Intent a = this.a;
        if (a != null) {
            this.b.startActivityForResult(a, 2);
        }
    }
}
