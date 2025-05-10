package i0;

import java.util.Locale;
import android.util.Log;
import f0.d;

public class a
{
    private final String a;
    private final String b;
    private final d c;
    private final int d;
    
    public a(final String a, final String... array) {
        final int length = array.length;
        String string;
        if (length == 0) {
            string = "";
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (final String s : array) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(s);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.b = string;
        this.a = a;
        this.c = new d(a);
        int d;
        for (d = 2; d <= 7 && !Log.isLoggable(this.a, d); ++d) {}
        this.d = d;
    }
    
    public void a(final String s, final Object... array) {
        if (this.d(3)) {
            Log.d(this.a, this.c(s, array));
        }
    }
    
    public void b(final String s, final Object... array) {
        Log.e(this.a, this.c(s, array));
    }
    
    protected String c(final String s, final Object... array) {
        String format = s;
        if (array != null) {
            format = s;
            if (array.length > 0) {
                format = String.format(Locale.US, s, array);
            }
        }
        return this.b.concat(format);
    }
    
    public boolean d(final int n) {
        return this.d <= n;
    }
    
    public void e(final String s, final Object... array) {
        Log.w(this.a, this.c(s, array));
    }
}
