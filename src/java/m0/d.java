package m0;

public class d implements c
{
    private static final d a;
    
    static {
        a = new d();
    }
    
    private d() {
    }
    
    public static c b() {
        return (c)d.a;
    }
    
    public final long a() {
        return System.currentTimeMillis();
    }
}
