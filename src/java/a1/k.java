package a1;

final class k
{
    private final j a;
    final Runnable b;
    
    k(final j a, final Runnable b) {
        this.a = a;
        this.b = b;
    }
    
    public Integer a() {
        final j a = this.a;
        Integer value;
        if (a != null) {
            value = a.a();
        }
        else {
            value = null;
        }
        return value;
    }
    
    public boolean b() {
        final j a = this.a;
        return a != null && a.b();
    }
}
