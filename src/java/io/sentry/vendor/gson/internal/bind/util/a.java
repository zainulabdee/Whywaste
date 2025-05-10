package io.sentry.vendor.gson.internal.bind.util;

import java.util.Calendar;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Date;
import java.util.TimeZone;

public class a
{
    public static final TimeZone a;
    
    static {
        a = TimeZone.getTimeZone("UTC");
    }
    
    private static boolean a(final String s, final int n, final char c) {
        return n < s.length() && s.charAt(n) == c;
    }
    
    public static String b(final Date date, final boolean b) {
        return c(date, b, io.sentry.vendor.gson.internal.bind.util.a.a);
    }
    
    public static String c(final Date time, final boolean b, final TimeZone timeZone) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        ((Calendar)gregorianCalendar).setTime(time);
        int n;
        if (b) {
            n = 4;
        }
        else {
            n = 0;
        }
        int n2;
        if (timeZone.getRawOffset() == 0) {
            n2 = 1;
        }
        else {
            n2 = 6;
        }
        final StringBuilder sb = new StringBuilder(19 + n + n2);
        e(sb, ((Calendar)gregorianCalendar).get(1), 4);
        char c = '-';
        sb.append('-');
        e(sb, ((Calendar)gregorianCalendar).get(2) + 1, 2);
        sb.append('-');
        e(sb, ((Calendar)gregorianCalendar).get(5), 2);
        sb.append('T');
        e(sb, ((Calendar)gregorianCalendar).get(11), 2);
        sb.append(':');
        e(sb, ((Calendar)gregorianCalendar).get(12), 2);
        sb.append(':');
        e(sb, ((Calendar)gregorianCalendar).get(13), 2);
        if (b) {
            sb.append('.');
            e(sb, ((Calendar)gregorianCalendar).get(14), 3);
        }
        final int offset = timeZone.getOffset(((Calendar)gregorianCalendar).getTimeInMillis());
        if (offset != 0) {
            final int n3 = offset / 60000;
            final int abs = Math.abs(n3 / 60);
            final int abs2 = Math.abs(n3 % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            e(sb, abs, 2);
            sb.append(':');
            e(sb, abs2, 2);
        }
        else {
            sb.append('Z');
        }
        return sb.toString();
    }
    
    private static int d(final String s, int i) {
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (char1 < '0' || char1 > '9') {
                return i;
            }
            ++i;
        }
        return s.length();
    }
    
    private static void e(final StringBuilder sb, int i, final int n) {
        final String string = Integer.toString(i);
        for (i = n - string.length(); i > 0; --i) {
            sb.append('0');
        }
        sb.append(string);
    }
    
    public static Date f(String string, final ParsePosition parsePosition) {
        Object o = null;
        try {
            final int index = parsePosition.getIndex();
            final int n = index + 4;
            final int g = g(string, index, n);
            int n2 = n;
            if (a(string, n, '-')) {
                n2 = n + 1;
            }
            final int n3 = n2 + 2;
            final int g2 = g(string, n2, n3);
            int n4 = n3;
            if (a(string, n3, '-')) {
                n4 = n3 + 1;
            }
            int n5 = n4 + 2;
            final int g3 = g(string, n4, n5);
            final boolean a = a(string, n5, 'T');
            if (!a && string.length() <= n5) {
                o = new GregorianCalendar(g, g2 - 1, g3);
                parsePosition.setIndex(n5);
                return ((Calendar)o).getTime();
            }
            int g6 = 0;
            int n17 = 0;
            int n18 = 0;
            int n19 = 0;
            Label_0446: {
                if (a) {
                    final int n6 = n5 + 1;
                    final int n7 = n6 + 2;
                    final int g4 = g(string, n6, n7);
                    int n8 = n7;
                    if (a(string, n7, ':')) {
                        n8 = n7 + 1;
                    }
                    final int n9 = n8 + 2;
                    final int g5 = g(string, n8, n9);
                    int n10 = n9;
                    if (a(string, n9, ':')) {
                        n10 = n9 + 1;
                    }
                    if (string.length() > n10) {
                        final char char1 = string.charAt(n10);
                        if (char1 != 'Z' && char1 != '+' && char1 != '-') {
                            final int n11 = n10 + 2;
                            final int n12 = g6 = g(string, n10, n11);
                            if (n12 > 59 && (g6 = n12) < 63) {
                                g6 = 59;
                            }
                            if (a(string, n11, '.')) {
                                final int n13 = n11 + 1;
                                final int d = d(string, n13 + 1);
                                final int min = Math.min(d, n13 + 3);
                                int g7 = g(string, n13, min);
                                final int n14 = min - n13;
                                if (n14 != 1) {
                                    if (n14 == 2) {
                                        g7 *= 10;
                                    }
                                }
                                else {
                                    g7 *= 100;
                                }
                                final int n15 = g5;
                                final int n16 = g7;
                                n17 = g4;
                                n5 = d;
                                n18 = n15;
                                n19 = n16;
                                break Label_0446;
                            }
                            final int n20 = g5;
                            n17 = g4;
                            n5 = n11;
                            final int n21 = 0;
                            n18 = n20;
                            n19 = n21;
                            break Label_0446;
                        }
                    }
                    final int n22 = g5;
                    n5 = n10;
                    n17 = g4;
                    n18 = n22;
                }
                else {
                    n17 = 0;
                    n18 = 0;
                }
                n19 = 0;
                g6 = 0;
            }
            if (string.length() > n5) {
                final char char2 = string.charAt(n5);
                if (char2 == 'Z') {
                    o = io.sentry.vendor.gson.internal.bind.util.a.a;
                    ++n5;
                }
                else {
                    if (char2 != '+' && char2 != '-') {
                        o = new StringBuilder();
                        ((StringBuilder)o).append("Invalid time zone indicator '");
                        ((StringBuilder)o).append(char2);
                        ((StringBuilder)o).append("'");
                        throw new IndexOutOfBoundsException(((StringBuilder)o).toString());
                    }
                    o = string.substring(n5);
                    if (((String)o).length() < 5) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append((String)o);
                        sb.append("00");
                        o = sb.toString();
                    }
                    n5 += ((String)o).length();
                    if (!"+0000".equals(o) && !"+00:00".equals(o)) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("GMT");
                        sb2.append((String)o);
                        final String string2 = sb2.toString();
                        o = TimeZone.getTimeZone(string2);
                        final String id = ((TimeZone)o).getID();
                        if (!id.equals((Object)string2) && !id.replace((CharSequence)":", (CharSequence)"").equals((Object)string2)) {
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("Mismatching time zone indicator: ");
                            sb3.append(string2);
                            sb3.append(" given, resolves to ");
                            sb3.append(((TimeZone)o).getID());
                            throw new IndexOutOfBoundsException(sb3.toString());
                        }
                    }
                    else {
                        o = io.sentry.vendor.gson.internal.bind.util.a.a;
                    }
                }
                final GregorianCalendar gregorianCalendar = new GregorianCalendar((TimeZone)o);
                ((Calendar)gregorianCalendar).setLenient(false);
                ((Calendar)gregorianCalendar).set(1, g);
                ((Calendar)gregorianCalendar).set(2, g2 - 1);
                ((Calendar)gregorianCalendar).set(5, g3);
                ((Calendar)gregorianCalendar).set(11, n17);
                ((Calendar)gregorianCalendar).set(12, n18);
                ((Calendar)gregorianCalendar).set(13, g6);
                ((Calendar)gregorianCalendar).set(14, n19);
                parsePosition.setIndex(n5);
                return ((Calendar)gregorianCalendar).getTime();
            }
            o = new IllegalArgumentException("No time zone indicator");
            throw o;
        }
        catch (final IllegalArgumentException o) {}
        catch (final NumberFormatException o) {}
        catch (final IndexOutOfBoundsException ex) {}
        if (string == null) {
            string = null;
        }
        else {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append('\"');
            sb4.append(string);
            sb4.append('\"');
            string = sb4.toString();
        }
        final String message = ((Throwable)o).getMessage();
        String string3 = null;
        Label_1014: {
            if (message != null) {
                string3 = message;
                if (!message.isEmpty()) {
                    break Label_1014;
                }
            }
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("(");
            sb5.append(((Throwable)o).getClass().getName());
            sb5.append(")");
            string3 = sb5.toString();
        }
        final StringBuilder sb6 = new StringBuilder();
        sb6.append("Failed to parse date [");
        sb6.append(string);
        sb6.append("]: ");
        sb6.append(string3);
        final ParseException ex2 = new ParseException(sb6.toString(), parsePosition.getIndex());
        ((Throwable)ex2).initCause((Throwable)o);
        throw ex2;
    }
    
    private static int g(final String s, final int n, final int n2) {
        if (n >= 0 && n2 <= s.length() && n <= n2) {
            int i;
            int n3;
            if (n < n2) {
                i = n + 1;
                final int digit = Character.digit(s.charAt(n), 10);
                if (digit < 0) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid number: ");
                    sb.append(s.substring(n, n2));
                    throw new NumberFormatException(sb.toString());
                }
                n3 = -digit;
            }
            else {
                i = n;
                n3 = 0;
            }
            while (i < n2) {
                final int digit2 = Character.digit(s.charAt(i), 10);
                if (digit2 < 0) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid number: ");
                    sb2.append(s.substring(n, n2));
                    throw new NumberFormatException(sb2.toString());
                }
                n3 = n3 * 10 - digit2;
                ++i;
            }
            return -n3;
        }
        throw new NumberFormatException(s);
    }
}
