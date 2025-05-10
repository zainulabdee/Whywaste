package io.flutter.plugins.webviewflutter;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class l implements n$j
{
    final k a;
    
    public l(final k a) {
        this.a = a;
    }
    
    public String a(final String s) {
        return this.a.a(s);
    }
    
    public List<String> b(final String s) {
        try {
            final String[] b = this.a.b(s);
            if (b == null) {
                return (List<String>)new ArrayList();
            }
            return (List<String>)Arrays.asList((Object[])b);
        }
        catch (final IOException ex) {
            throw new RuntimeException(((Throwable)ex).getMessage());
        }
    }
}
