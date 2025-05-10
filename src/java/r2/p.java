package r2;

import o2.d;
import kotlin.jvm.internal.i;

class p extends o
{
    public static final String b0(String substring, final int n) {
        kotlin.jvm.internal.i.e((Object)substring, "<this>");
        if (n >= 0) {
            substring = substring.substring(d.c(n, substring.length()));
            kotlin.jvm.internal.i.d((Object)substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Requested character count ");
        sb.append(n);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }
}
