package io.sentry;

import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class l5 implements n0
{
    private String e(final Throwable t) {
        final StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter((Writer)stringWriter));
        return stringWriter.toString();
    }
    
    public void a(final l4 l4, final String s, final Object... array) {
        System.out.println(String.format("%s: %s", new Object[] { l4, String.format(s, array) }));
    }
    
    public boolean b(final l4 l4) {
        return true;
    }
    
    public void c(final l4 l4, final Throwable t, final String s, final Object... array) {
        if (t == null) {
            this.a(l4, s, array);
        }
        else {
            System.out.println(String.format("%s: %s \n %s\n%s", new Object[] { l4, String.format(s, array), t.toString(), this.e(t) }));
        }
    }
    
    public void d(final l4 l4, final String s, final Throwable t) {
        if (t == null) {
            this.a(l4, s, new Object[0]);
        }
        else {
            System.out.println(String.format("%s: %s\n%s", new Object[] { l4, String.format(s, new Object[] { t.toString() }), this.e(t) }));
        }
    }
}
