package s2;

public class o1 extends s1 implements t
{
    private final boolean f;
    
    public o1(final l1 l1) {
        super(true);
        this.Y(l1);
        this.f = this.z0();
    }
    
    private final boolean z0() {
        final q u = this.U();
        r r;
        if (u instanceof r) {
            r = (r)u;
        }
        else {
            r = null;
        }
        if (r != null) {
            s1 s1;
            if ((s1 = r.z()) != null) {
                while (!s1.R()) {
                    final q u2 = s1.U();
                    r r2;
                    if (u2 instanceof r) {
                        r2 = (r)u2;
                    }
                    else {
                        r2 = null;
                    }
                    if (r2 == null || (s1 = r2.z()) == null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean R() {
        return this.f;
    }
    
    @Override
    public boolean S() {
        return true;
    }
}
