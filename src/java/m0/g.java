package m0;

import java.util.Iterator;
import java.util.HashMap;

public class g
{
    public static void a(final StringBuilder sb, final HashMap<String, String> hashMap) {
        sb.append("{");
        final Iterator iterator = hashMap.keySet().iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final String s = (String)iterator.next();
            if (n == 0) {
                sb.append(",");
            }
            final String s2 = (String)hashMap.get((Object)s);
            sb.append("\"");
            sb.append(s);
            sb.append("\":");
            if (s2 == null) {
                sb.append("null");
            }
            else {
                sb.append("\"");
                sb.append(s2);
                sb.append("\"");
            }
            n = 0;
        }
        sb.append("}");
    }
}
