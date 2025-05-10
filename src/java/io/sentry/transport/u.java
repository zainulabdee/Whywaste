package io.sentry.transport;

import java.net.Authenticator$RequestorType;
import java.net.PasswordAuthentication;
import io.sentry.util.n;
import java.net.Authenticator;

final class u extends Authenticator
{
    private final String a;
    private final String b;
    
    u(final String s, final String s2) {
        this.a = n.c(s, "user is required");
        this.b = n.c(s2, "password is required");
    }
    
    protected PasswordAuthentication getPasswordAuthentication() {
        if (this.getRequestorType() == Authenticator$RequestorType.PROXY) {
            return new PasswordAuthentication(this.a, this.b.toCharArray());
        }
        return null;
    }
}
