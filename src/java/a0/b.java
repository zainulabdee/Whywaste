package a0;

public class b
{
    static int b = 31;
    private int a;
    
    public b() {
        this.a = 1;
    }
    
    public b a(final Object o) {
        final int b = a0.b.b;
        final int a = this.a;
        int hashCode;
        if (o == null) {
            hashCode = 0;
        }
        else {
            hashCode = o.hashCode();
        }
        this.a = b * a + hashCode;
        return this;
    }
    
    public int b() {
        return this.a;
    }
    
    public final b c(final boolean b) {
        this.a = b.b * this.a + (b ? 1 : 0);
        return this;
    }
}
