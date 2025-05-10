package io.sentry;

import java.math.RoundingMode;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import io.sentry.vendor.gson.internal.bind.util.a;
import java.util.Date;

public final class j
{
    public static long a(final Date date) {
        return h(date.getTime());
    }
    
    public static double b(final Date date) {
        return i((double)date.getTime());
    }
    
    public static Date c() {
        return Calendar.getInstance(a.a).getTime();
    }
    
    public static Date d(final long timeInMillis) {
        final Calendar instance = Calendar.getInstance(a.a);
        instance.setTimeInMillis(timeInMillis);
        return instance.getTime();
    }
    
    public static Date e(final String s) {
        try {
            return a.f(s, new ParsePosition(0));
        }
        catch (final ParseException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("timestamp is not ISO format ");
            sb.append(s);
            throw new IllegalArgumentException(sb.toString());
        }
    }
    
    public static Date f(final String s) {
        try {
            return d(new BigDecimal(s).setScale(3, RoundingMode.DOWN).movePointRight(3).longValue());
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("timestamp is not millis format ");
            sb.append(s);
            throw new IllegalArgumentException(sb.toString());
        }
    }
    
    public static String g(final Date date) {
        return a.b(date, true);
    }
    
    public static long h(final long n) {
        return n * 1000000L;
    }
    
    public static double i(final double n) {
        return n / 1000.0;
    }
    
    public static Date j(final long n) {
        return d(k((double)n).longValue());
    }
    
    public static double k(final double n) {
        return n / 1000000.0;
    }
    
    public static double l(final long n) {
        return n / 1.0E9;
    }
    
    public static long m(final long n) {
        return n * 1000000000L;
    }
    
    public static Date n(final j3 j3) {
        if (j3 == null) {
            return null;
        }
        return o(j3);
    }
    
    public static Date o(final j3 j3) {
        return j(j3.i());
    }
}
