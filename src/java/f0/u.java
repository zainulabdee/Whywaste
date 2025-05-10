package f0;

import android.app.Activity;
import android.content.Intent;

final class u extends w
{
    final Intent a;
    final Activity b;
    final int c;
    
    u(final Intent a, final Activity b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void a() {
        final Intent a = this.a;
        if (a != null) {
            this.b.startActivityForResult(a, this.c);
        }
    }
}
