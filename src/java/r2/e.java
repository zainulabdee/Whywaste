package r2;

import kotlin.jvm.internal.i;
import l2.l;

class e
{
    public static <T> void a(final Appendable appendable, final T t, final l<? super T, ? extends CharSequence> l) {
        i.e((Object)appendable, "<this>");
        if (l != null) {
            appendable.append((CharSequence)l.invoke((Object)t));
        }
        else if (t == null || t instanceof CharSequence) {
            appendable.append((CharSequence)t);
        }
        else if (t instanceof Character) {
            appendable.append((char)t);
        }
        else {
            appendable.append((CharSequence)String.valueOf((Object)t));
        }
    }
}
