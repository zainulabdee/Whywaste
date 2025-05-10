package io.sentry.flutter;

import c2.q;
import l2.l;
import java.util.Map;

public final class SentryFlutterPluginKt
{
    private static final <T> void getIfNotNull(final Map<String, ?> map, final String s, final l<? super T, q> l) {
        Object value;
        if (!((value = map.get((Object)s)) instanceof Object)) {
            value = null;
        }
        if (value != null) {
            l.invoke(value);
        }
    }
}
