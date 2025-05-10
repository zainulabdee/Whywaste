package w0;

final class n implements Runnable
{
    final o e;
    
    n(final o e) {
        this.e = e;
    }
    
    public final void run() {
        final Object c = o.c(this.e);
        synchronized (c) {
            final o e = this.e;
            if (o.b(e) != null) {
                o.b(e).a();
            }
        }
    }
}
