package w0;

import java.util.concurrent.CountDownLatch;

final class l implements m
{
    private final CountDownLatch a = new CountDownLatch(1);
    
    public final void a() {
        this.a.countDown();
    }
    
    public final void b(final Object o) {
        this.a.countDown();
    }
    
    public final void c(final Exception ex) {
        this.a.countDown();
    }
    
    public final void d() {
        this.a.await();
    }
}
