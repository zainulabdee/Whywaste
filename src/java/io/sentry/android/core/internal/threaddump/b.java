package io.sentry.android.core.internal.threaddump;

import java.io.BufferedReader;
import java.util.ArrayList;

public final class b
{
    private final ArrayList<? extends a> a;
    private final int b;
    private final int c;
    public int d;
    
    public b(final ArrayList<? extends a> a) {
        this.a = a;
        this.b = 0;
        this.c = a.size();
    }
    
    public static b c(final BufferedReader bufferedReader) {
        final ArrayList list = new ArrayList();
        int n = 0;
        while (true) {
            final String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            ++n;
            list.add((Object)new a(n, line));
        }
        return new b((ArrayList<? extends a>)list);
    }
    
    public boolean a() {
        return this.d < this.c;
    }
    
    public a b() {
        final int d = this.d;
        if (d >= this.b && d < this.c) {
            final ArrayList<? extends a> a = this.a;
            this.d = d + 1;
            return (a)a.get(d);
        }
        return null;
    }
    
    public void d() {
        --this.d;
    }
}
