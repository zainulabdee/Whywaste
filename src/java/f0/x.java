package f0;

import d0.a$f;
import android.content.Context;
import c0.h;
import android.util.SparseIntArray;

public final class x
{
    private final SparseIntArray a;
    private h b;
    
    public x(final h b) {
        this.a = new SparseIntArray();
        i.i(b);
        this.b = b;
    }
    
    public final int a(final Context context, final int n) {
        return this.a.get(n, -1);
    }
    
    public final int b(final Context context, final a$f a$f) {
        i.i(context);
        i.i(a$f);
        final boolean g = a$f.g();
        final int n = 0;
        if (!g) {
            return 0;
        }
        final int h = a$f.h();
        int n2 = this.a(context, h);
        if (n2 == -1) {
            while (true) {
                for (int i = 0; i < this.a.size(); ++i) {
                    final int key = this.a.keyAt(i);
                    if (key > h && this.a.get(key) == 0) {
                        n2 = n;
                        if (n2 == -1) {
                            n2 = this.b.g(context, h);
                        }
                        this.a.put(h, n2);
                        return n2;
                    }
                }
                n2 = -1;
                continue;
            }
        }
        return n2;
    }
    
    public final void c() {
        this.a.clear();
    }
}
