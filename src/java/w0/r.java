package w0;

import f0.i;

final class r implements Runnable
{
    final g e;
    final s f;
    
    r(final s f, final g e) {
        this.f = f;
        this.e = e;
    }
    
    public final void run() {
        final Object c = s.c(this.f);
        synchronized (c) {
            final s f = this.f;
            if (s.b(f) != null) {
                s.b(f).c((Exception)i.i((Object)this.e.f()));
            }
        }
    }
}
