package io.sentry.util;

import java.util.Locale;
import java.security.NoSuchAlgorithmException;
import io.sentry.l4;
import java.math.BigInteger;
import java.security.MessageDigest;
import io.sentry.n0;
import java.nio.charset.Charset;

public final class r
{
    private static final Charset a;
    
    static {
        a = Charset.forName("UTF-8");
    }
    
    public static String a(final String ex, final n0 n0) {
        if (ex != null) {
            if (!((String)ex).isEmpty()) {
                try {
                    return new StringBuilder(new BigInteger(1, MessageDigest.getInstance("SHA-1").digest(((String)ex).getBytes(r.a))).toString(16)).toString();
                }
                catch (final NoSuchAlgorithmException ex) {
                    n0.d(l4.INFO, "SHA-1 isn't available to calculate the hash.", (Throwable)ex);
                }
                finally {
                    final Throwable t;
                    n0.a(l4.INFO, "string: %s could not calculate its hash", t, ex);
                }
            }
        }
        return null;
    }
    
    public static String b(final String s) {
        String string = s;
        if (s != null) {
            if (s.isEmpty()) {
                string = s;
            }
            else {
                final StringBuilder sb = new StringBuilder();
                final String substring = s.substring(0, 1);
                final Locale root = Locale.ROOT;
                sb.append(substring.toUpperCase(root));
                sb.append(s.substring(1).toLowerCase(root));
                string = sb.toString();
            }
        }
        return string;
    }
    
    public static String c(final String s) {
        if (s != null) {
            int lastIndex = s.lastIndexOf(".");
            String substring = s;
            if (lastIndex >= 0) {
                final int length = s.length();
                ++lastIndex;
                substring = s;
                if (length > lastIndex) {
                    substring = s.substring(lastIndex);
                }
            }
            return substring;
        }
        return null;
    }
    
    public static String d(final String s) {
        String s2 = s;
        if (s.equals((Object)"0000-0000")) {
            s2 = "00000000-0000-0000-0000-000000000000";
        }
        return s2;
    }
    
    public static String e(final String s, final String s2) {
        String substring = s;
        if (s != null) {
            substring = s;
            if (s2 != null) {
                substring = s;
                if (s.startsWith(s2)) {
                    substring = s;
                    if (s.endsWith(s2)) {
                        substring = s.substring(s2.length(), s.length() - s2.length());
                    }
                }
            }
        }
        return substring;
    }
}
