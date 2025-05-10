package d0;

import java.util.List;
import f.e;
import java.util.Iterator;
import android.text.TextUtils;
import f0.i;
import java.util.ArrayList;
import e0.b;
import f.a;

public class c extends Exception
{
    private final a<b<?>, c0.b> e;
    
    public c(final a<b<?>, c0.b> e) {
        this.e = e;
    }
    
    public String getMessage() {
        final ArrayList list = new ArrayList();
        final Iterator iterator = this.e.keySet().iterator();
        boolean b = true;
        while (iterator.hasNext()) {
            final b b2 = (b)iterator.next();
            final c0.b b3 = i.i(((e<K, c0.b>)this.e).get((Object)b2));
            b &= (b3.i() ^ true);
            final String b4 = b2.b();
            final String value = String.valueOf((Object)b3);
            final StringBuilder sb = new StringBuilder(String.valueOf((Object)b4).length() + 2 + value.length());
            sb.append(b4);
            sb.append(": ");
            sb.append(value);
            ((List)list).add((Object)sb.toString());
        }
        final StringBuilder sb2 = new StringBuilder();
        if (b) {
            sb2.append("None of the queried APIs are available. ");
        }
        else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join((CharSequence)"; ", (Iterable)list));
        return sb2.toString();
    }
}
