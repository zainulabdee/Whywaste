package io.sentry;

import java.net.URI;
import java.util.Map;
import java.util.HashMap;
import io.sentry.util.n;

final class p2
{
    private final q4 a;
    
    public p2(final q4 q4) {
        this.a = n.c(q4, "options is required");
    }
    
    o2 a() {
        final p p = new p(this.a.getDsn());
        final URI c = p.c();
        final StringBuilder sb = new StringBuilder();
        sb.append(c.getPath());
        sb.append("/envelope/");
        final String string = c.resolve(sb.toString()).toString();
        final String a = p.a();
        final String b = p.b();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Sentry sentry_version=7,sentry_client=");
        sb2.append(this.a.getSentryClientName());
        sb2.append(",sentry_key=");
        sb2.append(a);
        String string2;
        if (b != null && b.length() > 0) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(",sentry_secret=");
            sb3.append(b);
            string2 = sb3.toString();
        }
        else {
            string2 = "";
        }
        sb2.append(string2);
        final String string3 = sb2.toString();
        final String sentryClientName = this.a.getSentryClientName();
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"User-Agent", (Object)sentryClientName);
        ((Map)hashMap).put((Object)"X-Sentry-Auth", (Object)string3);
        return new o2(string, (Map<String, String>)hashMap);
    }
}
