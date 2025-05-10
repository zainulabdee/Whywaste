package io.sentry.transport;

import java.net.Authenticator;

final class l
{
    private static final l a;
    
    static {
        a = new l();
    }
    
    private l() {
    }
    
    public static l a() {
        return l.a;
    }
    
    public void b(final Authenticator default1) {
        Authenticator.setDefault(default1);
    }
}
