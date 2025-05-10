package e0;

public final class g<L>
{
    private final L a;
    private final String b;
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof g)) {
            return false;
        }
        final g g = (g)o;
        return this.a == g.a && this.b.equals((Object)g.b);
    }
    
    @Override
    public int hashCode() {
        return System.identityHashCode((Object)this.a) * 31 + this.b.hashCode();
    }
}
