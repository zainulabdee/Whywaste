package d0;

import c0.d;

public final class n extends UnsupportedOperationException
{
    private final d e;
    
    public n(final d e) {
        this.e = e;
    }
    
    public String getMessage() {
        return "Missing ".concat(String.valueOf((Object)this.e));
    }
}
