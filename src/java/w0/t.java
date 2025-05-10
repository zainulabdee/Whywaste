package w0;

final class t implements Runnable
{
    final g e;
    final u f;
    
    t(final u f, final g e) {
        this.f = f;
        this.e = e;
    }
    
    public final void run() {
        final Object c = u.c(this.f);
        synchronized (c) {
            final u f = this.f;
            if (u.b(f) != null) {
                u.b(f).b(this.e.g());
            }
        }
    }
}
