package s2;

final class v0 implements g1
{
    private final boolean e;
    
    public v0(final boolean e) {
        this.e = e;
    }
    
    public boolean a() {
        return this.e;
    }
    
    public w1 h() {
        return null;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        String s;
        if (this.a()) {
            s = "Active";
        }
        else {
            s = "New";
        }
        sb.append(s);
        sb.append('}');
        return sb.toString();
    }
}
