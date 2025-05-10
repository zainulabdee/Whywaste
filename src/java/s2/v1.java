package s2;

public abstract class v1 extends c0
{
    protected final String A() {
        final v1 c = t0.c();
        if (this == c) {
            return "Dispatchers.Main";
        }
        v1 z;
        try {
            z = c.z();
        }
        catch (final UnsupportedOperationException ex) {
            z = null;
        }
        if (this == z) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
    
    @Override
    public String toString() {
        String s;
        if ((s = this.A()) == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(k0.a((Object)this));
            sb.append('@');
            sb.append(k0.b((Object)this));
            s = sb.toString();
        }
        return s;
    }
    
    public abstract v1 z();
}
