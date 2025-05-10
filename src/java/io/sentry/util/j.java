package io.sentry.util;

import io.sentry.hints.c;
import io.sentry.hints.d;
import io.sentry.a0;
import io.sentry.n0;

public final class j
{
    public static a0 e(final Object o) {
        final a0 a0 = new a0();
        r(a0, o);
        return a0;
    }
    
    public static Object f(final a0 a0) {
        return a0.c("sentry:typeCheckHint");
    }
    
    public static boolean g(final a0 a0, final Class<?> clazz) {
        return clazz.isInstance(f(a0));
    }
    
    public static boolean h(final a0 a0) {
        return Boolean.TRUE.equals((Object)a0.d("sentry:isFromHybridSdk", Boolean.class));
    }
    
    public static <T> void m(final a0 a0, final Class<T> clazz, final c<Object> c) {
        o(a0, clazz, (a<T>)new g(), (b)new h((c)c));
    }
    
    public static <T> void n(final a0 a0, final Class<T> clazz, final a<T> a2) {
        o(a0, clazz, a2, (b)new f());
    }
    
    public static <T> void o(final a0 a0, final Class<T> clazz, final a<T> a2, final b b) {
        final Object f = f(a0);
        if (g(a0, clazz) && f != null) {
            a2.accept((T)f);
        }
        else {
            b.a(f, clazz);
        }
    }
    
    public static <T> void p(final a0 a0, final Class<T> clazz, final n0 n0, final a<T> a2) {
        o(a0, clazz, a2, (b)new i(n0));
    }
    
    public static void q(final a0 a0, final String s) {
        if (s.startsWith("sentry.javascript") || s.startsWith("sentry.dart") || s.startsWith("sentry.dotnet")) {
            a0.j("sentry:isFromHybridSdk", Boolean.TRUE);
        }
    }
    
    public static void r(final a0 a0, final Object o) {
        a0.j("sentry:typeCheckHint", o);
    }
    
    public static boolean s(final a0 a0) {
        return (!g(a0, io.sentry.hints.f.class) && !g(a0, d.class)) || g(a0, io.sentry.hints.c.class);
    }
    
    @FunctionalInterface
    public interface a<T>
    {
        void accept(final T p0);
    }
    
    @FunctionalInterface
    public interface b
    {
        void a(final Object p0, final Class<?> p1);
    }
    
    @FunctionalInterface
    public interface c<T>
    {
        void accept(final T p0);
    }
}
