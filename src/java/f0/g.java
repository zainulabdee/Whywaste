package f0;

import android.os.BaseBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import android.os.Bundle;

public final class g
{
    public static boolean a(final Bundle bundle, final Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (((BaseBundle)bundle).size() != ((BaseBundle)bundle2).size()) {
            return false;
        }
        final Set keySet = ((BaseBundle)bundle).keySet();
        if (!keySet.containsAll((Collection)((BaseBundle)bundle2).keySet())) {
            return false;
        }
        for (final String s : keySet) {
            if (!b(((BaseBundle)bundle).get(s), ((BaseBundle)bundle2).get(s))) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean b(final Object o, final Object obj) {
        boolean b = false;
        if (o != obj) {
            if (o == null) {
                return b;
            }
            if (!o.equals(obj)) {
                return false;
            }
        }
        b = true;
        return b;
    }
    
    public static int c(final Object... array) {
        return Arrays.hashCode(array);
    }
    
    public static a d(final Object o) {
        return new a(o, null);
    }
    
    public static final class a
    {
        private final List a;
        private final Object b;
        
        public a a(final String s, final Object o) {
            final List a = this.a;
            i.i(s);
            final String value = String.valueOf(o);
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("=");
            sb.append(value);
            a.add((Object)sb.toString());
            return this;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(100);
            sb.append(this.b.getClass().getSimpleName());
            sb.append('{');
            for (int size = this.a.size(), i = 0; i < size; ++i) {
                sb.append((String)this.a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }
}
