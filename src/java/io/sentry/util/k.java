package io.sentry.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import io.sentry.l4;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.ByteArrayOutputStream;
import io.sentry.m1;
import io.sentry.n0;
import io.sentry.t0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.nio.charset.Charset;

public final class k
{
    private static final Charset a;
    
    static {
        a = Charset.forName("UTF-8");
    }
    
    public static List<Object> a(final AtomicIntegerArray atomicIntegerArray) {
        final int length = atomicIntegerArray.length();
        final ArrayList list = new ArrayList(length);
        for (int i = 0; i < length; ++i) {
            ((List)list).add((Object)atomicIntegerArray.get(i));
        }
        return (List<Object>)list;
    }
    
    public static byte[] b(final t0 t0, final n0 n0, final m1 m1) {
        try {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                final BufferedWriter bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)byteArrayOutputStream, k.a));
                try {
                    t0.c(m1, (Writer)bufferedWriter);
                    final byte[] byteArray = byteArrayOutputStream.toByteArray();
                    ((Writer)bufferedWriter).close();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                finally {
                    try {
                        ((Writer)bufferedWriter).close();
                    }
                    finally {
                        final Throwable t2;
                        ((Throwable)t0).addSuppressed(t2);
                    }
                }
            }
            finally {
                try {
                    byteArrayOutputStream.close();
                }
                finally {
                    final Throwable t3;
                    ((Throwable)t0).addSuppressed(t3);
                }
            }
        }
        finally {
            final Throwable t4;
            n0.d(l4.ERROR, "Could not serialize serializable", t4);
            return null;
        }
    }
    
    public static Map<String, Object> c(final Calendar calendar) {
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"year", (Object)calendar.get(1));
        ((Map)hashMap).put((Object)"month", (Object)calendar.get(2));
        ((Map)hashMap).put((Object)"dayOfMonth", (Object)calendar.get(5));
        ((Map)hashMap).put((Object)"hourOfDay", (Object)calendar.get(11));
        ((Map)hashMap).put((Object)"minute", (Object)calendar.get(12));
        ((Map)hashMap).put((Object)"second", (Object)calendar.get(13));
        return (Map<String, Object>)hashMap;
    }
}
