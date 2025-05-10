package w0;

final class p implements Runnable
{
    final g e;
    final q f;
    
    p(final q f, final g e) {
        this.f = f;
        this.e = e;
    }
    
    public final void run() {
        final Object c = q.c(this.f);
        synchronized (c) {
            final q f = this.f;
            if (q.b(f) != null) {
                q.b(f).a(this.e);
            }
        }
    }
}
