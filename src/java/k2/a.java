package k2;

import kotlin.jvm.internal.b;
import kotlin.jvm.internal.i;
import p2.c;

public final class a
{
    public static final <T> Class<T> a(final c<T> c) {
        i.e((Object)c, "<this>");
        final Class b = ((b)c).b();
        i.c((Object)b, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return b;
    }
    
    public static final <T> Class<T> b(final c<T> c) {
        i.e((Object)c, "<this>");
        Object b = ((b)c).b();
        if (!((Class)b).isPrimitive()) {
            i.c(b, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return (Class<T>)b;
        }
        final String name = ((Class)b).getName();
        switch (name.hashCode()) {
            case 109413500: {
                if (!name.equals((Object)"short")) {
                    break;
                }
                b = Short.class;
                break;
            }
            case 97526364: {
                if (!name.equals((Object)"float")) {
                    break;
                }
                b = Float.class;
                break;
            }
            case 64711720: {
                if (!name.equals((Object)"boolean")) {
                    break;
                }
                b = Boolean.class;
                break;
            }
            case 3625364: {
                if (!name.equals((Object)"void")) {
                    break;
                }
                b = Void.class;
                break;
            }
            case 3327612: {
                if (!name.equals((Object)"long")) {
                    break;
                }
                b = Long.class;
                break;
            }
            case 3052374: {
                if (!name.equals((Object)"char")) {
                    break;
                }
                b = Character.class;
                break;
            }
            case 3039496: {
                if (!name.equals((Object)"byte")) {
                    break;
                }
                b = Byte.class;
                break;
            }
            case 104431: {
                if (!name.equals((Object)"int")) {
                    break;
                }
                b = Integer.class;
                break;
            }
            case -1325958191: {
                if (!name.equals((Object)"double")) {
                    break;
                }
                b = Double.class;
                break;
            }
        }
        i.c(b, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return (Class<T>)b;
    }
}
