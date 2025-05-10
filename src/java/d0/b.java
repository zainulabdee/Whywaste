package d0;

import com.google.android.gms.common.api.Status;

public class b extends Exception
{
    @Deprecated
    protected final Status e;
    
    public b(final Status e) {
        final int f = e.f();
        String g;
        if (e.g() != null) {
            g = e.g();
        }
        else {
            g = "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(f);
        sb.append(": ");
        sb.append(g);
        super(sb.toString());
        this.e = e;
    }
    
    public Status a() {
        return this.e;
    }
    
    public int b() {
        return this.e.f();
    }
}
