package io.sentry.config;

import java.util.Properties;
import java.util.List;
import io.sentry.n0;
import java.util.ArrayList;
import io.sentry.l5;

public final class h
{
    public static g a() {
        final l5 l5 = new l5();
        final ArrayList list = new ArrayList();
        ((List)list).add((Object)new j());
        ((List)list).add((Object)new d());
        final String property = System.getProperty("sentry.properties.file");
        if (property != null) {
            final Properties a = new e(property, (n0)l5).a();
            if (a != null) {
                ((List)list).add((Object)new i(a));
            }
        }
        final String getenv = System.getenv("SENTRY_PROPERTIES_FILE");
        if (getenv != null) {
            final Properties a2 = new e(getenv, (n0)l5).a();
            if (a2 != null) {
                ((List)list).add((Object)new i(a2));
            }
        }
        final Properties a3 = new b((n0)l5).a();
        if (a3 != null) {
            ((List)list).add((Object)new i(a3));
        }
        final Properties a4 = new e("sentry.properties", (n0)l5).a();
        if (a4 != null) {
            ((List)list).add((Object)new i(a4));
        }
        return (g)new c((List)list);
    }
}
