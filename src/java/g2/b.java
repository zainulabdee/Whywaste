package g2;

import kotlin.jvm.internal.i;

public final class b
{
    public static final a a;
    
    static {
        a a2 = null;
        try {
            final i2.a instance = i2.a.class.newInstance();
            i.d((Object)instance, "forName(\"kotlin.internal\u2026entations\").newInstance()");
            Label_0028: {
                if (instance == null) {
                    break Label_0028;
                }
                try {
                    a2 = (a)instance;
                }
                catch (final ClassCastException ex) {
                    final ClassLoader classLoader = ((a)instance).getClass().getClassLoader();
                    final ClassLoader classLoader2 = a.class.getClassLoader();
                    if (!i.a((Object)classLoader, (Object)classLoader2)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Instance class was loaded from a different classloader: ");
                        sb.append((Object)classLoader);
                        sb.append(", base type classloader: ");
                        sb.append((Object)classLoader2);
                        throw new ClassNotFoundException(sb.toString(), (Throwable)ex);
                    }
                    throw ex;
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
            }
        }
        catch (final ClassNotFoundException ex2) {
            try {
                final Object instance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                i.d(instance2, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                Label_0148: {
                    if (instance2 == null) {
                        break Label_0148;
                    }
                    try {
                        a2 = (a)instance2;
                    }
                    catch (final ClassCastException ex3) {
                        final ClassLoader classLoader3 = ((a)instance2).getClass().getClassLoader();
                        final ClassLoader classLoader4 = a.class.getClassLoader();
                        if (!i.a((Object)classLoader3, (Object)classLoader4)) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Instance class was loaded from a different classloader: ");
                            sb2.append((Object)classLoader3);
                            sb2.append(", base type classloader: ");
                            sb2.append((Object)classLoader4);
                            throw new ClassNotFoundException(sb2.toString(), (Throwable)ex3);
                        }
                        throw ex3;
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                }
            }
            catch (final ClassNotFoundException ex4) {
                try {
                    final h2.a instance3 = h2.a.class.newInstance();
                    i.d((Object)instance3, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                    Label_0265: {
                        if (instance3 == null) {
                            break Label_0265;
                        }
                        try {
                            a2 = (a)instance3;
                        }
                        catch (final ClassCastException ex5) {
                            final ClassLoader classLoader5 = ((a)instance3).getClass().getClassLoader();
                            final ClassLoader classLoader6 = a.class.getClassLoader();
                            if (!i.a((Object)classLoader5, (Object)classLoader6)) {
                                final StringBuilder sb3 = new StringBuilder();
                                sb3.append("Instance class was loaded from a different classloader: ");
                                sb3.append((Object)classLoader5);
                                sb3.append(", base type classloader: ");
                                sb3.append((Object)classLoader6);
                                throw new ClassNotFoundException(sb3.toString(), (Throwable)ex5);
                            }
                            throw ex5;
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                    }
                }
                catch (final ClassNotFoundException ex6) {
                    try {
                        final Object instance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                        i.d(instance4, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                        Label_0389: {
                            if (instance4 == null) {
                                break Label_0389;
                            }
                            try {
                                a2 = (a)instance4;
                            }
                            catch (final ClassCastException ex7) {
                                final ClassLoader classLoader7 = ((a)instance4).getClass().getClassLoader();
                                final ClassLoader classLoader8 = a.class.getClassLoader();
                                if (!i.a((Object)classLoader7, (Object)classLoader8)) {
                                    final StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Instance class was loaded from a different classloader: ");
                                    sb4.append((Object)classLoader7);
                                    sb4.append(", base type classloader: ");
                                    sb4.append((Object)classLoader8);
                                    throw new ClassNotFoundException(sb4.toString(), (Throwable)ex7);
                                }
                                throw ex7;
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            }
                        }
                    }
                    catch (final ClassNotFoundException ex8) {
                        a2 = new a();
                    }
                }
            }
        }
        a = a2;
    }
}
