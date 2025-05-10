package io.sentry;

import io.sentry.protocol.b0;

public final class b
{
    private byte[] a;
    private final m1 b;
    private String c;
    private final String d;
    private final String e;
    private final boolean f;
    private String g;
    
    public b(final m1 b, final String d, final String e, final String g, final boolean f) {
        this.a = null;
        this.b = b;
        this.d = d;
        this.e = e;
        this.g = g;
        this.f = f;
    }
    
    public b(final byte[] a, final String d, final String e, final String g, final boolean f) {
        this.a = a;
        this.b = null;
        this.d = d;
        this.e = e;
        this.g = g;
        this.f = f;
    }
    
    public b(final byte[] array, final String s, final String s2, final boolean b) {
        this(array, s, s2, "event.attachment", b);
    }
    
    public static b a(final byte[] array) {
        return new b(array, "screenshot.png", "image/png", false);
    }
    
    public static b b(final byte[] array) {
        return new b(array, "thread-dump.txt", "text/plain", false);
    }
    
    public static b c(final b0 b0) {
        return new b((m1)b0, "view-hierarchy.json", "application/json", "event.view_hierarchy", false);
    }
    
    public String d() {
        return this.g;
    }
    
    public byte[] e() {
        return this.a;
    }
    
    public String f() {
        return this.e;
    }
    
    public String g() {
        return this.d;
    }
    
    public String h() {
        return this.c;
    }
    
    public m1 i() {
        return this.b;
    }
    
    boolean j() {
        return this.f;
    }
}
