package io.sentry;

import io.sentry.util.p;

public final class d3 implements k3
{
    private final k3 a;
    
    public d3() {
        if (b()) {
            this.a = (k3)new i4();
        }
        else {
            this.a = (k3)new p4();
        }
    }
    
    private static boolean b() {
        return p.b() && p.a();
    }
    
    public j3 a() {
        return this.a.a();
    }
}
