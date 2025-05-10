package f0;

public final class j
{
    private static j b;
    private static final k c;
    private k a;
    
    static {
        c = new k(0, false, false, 0, 0);
    }
    
    private j() {
    }
    
    public static j b() {
        synchronized (j.class) {
            if (j.b == null) {
                j.b = new j();
            }
            return j.b;
        }
    }
    
    public k a() {
        return this.a;
    }
    
    public final void c(final k a) {
        monitorenter(this);
        Label_0020: {
            if (a != null) {
                break Label_0020;
            }
            try {
                this.a = j.c;
                return;
                Label_0054: {
                    this.a = a;
                }
                return;
                final k a2 = this.a;
                iftrue(Label_0054:)(a2 == null || a2.i() < a.i());
            }
            finally {
                monitorexit(this);
            }
        }
    }
}
