package io.sentry.util;

import io.sentry.n0;
import io.sentry.l4;
import java.util.Properties;
import io.sentry.q4;

public final class c
{
    public static String a = "sentry-debug-meta.properties";
    
    private static void a(final q4 q4, final Properties properties) {
        if (q4.getBundleIds().isEmpty()) {
            final String property = properties.getProperty("io.sentry.bundle-ids");
            final n0 logger = q4.getLogger();
            final l4 debug = l4.DEBUG;
            int i = 0;
            logger.a(debug, "Bundle IDs found: %s", property);
            if (property != null) {
                for (String[] split = property.split(",", -1); i < split.length; ++i) {
                    q4.addBundleId(split[i]);
                }
            }
        }
    }
    
    private static void b(final q4 q4, final Properties properties) {
        if (q4.getProguardUuid() == null) {
            final String property = properties.getProperty("io.sentry.ProguardUuids");
            q4.getLogger().a(l4.DEBUG, "Proguard UUID found: %s", property);
            q4.setProguardUuid(property);
        }
    }
    
    public static void c(final q4 q4, final Properties properties) {
        if (properties != null) {
            b(q4, properties);
            a(q4, properties);
        }
    }
}
