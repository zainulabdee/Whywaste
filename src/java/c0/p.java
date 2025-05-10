package c0;

import android.content.Intent;

public class p extends Exception
{
    private final Intent e;
    
    public p(final String s, final Intent e) {
        super(s);
        this.e = e;
    }
    
    public Intent a() {
        return new Intent(this.e);
    }
}
