package io.sentry.android.ndk;

final class NativeScope implements b
{
    public static native void nativeAddBreadcrumb(final String p0, final String p1, final String p2, final String p3, final String p4, final String p5);
    
    public static native void nativeRemoveExtra(final String p0);
    
    public static native void nativeRemoveTag(final String p0);
    
    public static native void nativeRemoveUser();
    
    public static native void nativeSetExtra(final String p0, final String p1);
    
    public static native void nativeSetTag(final String p0, final String p1);
    
    public static native void nativeSetUser(final String p0, final String p1, final String p2, final String p3);
    
    public void a(final String s) {
        nativeRemoveTag(s);
    }
    
    public void b(final String s, final String s2) {
        nativeSetTag(s, s2);
    }
    
    public void c(final String s) {
        nativeRemoveExtra(s);
    }
    
    public void d(final String s, final String s2) {
        nativeSetExtra(s, s2);
    }
    
    public void e(final String s, final String s2, final String s3, final String s4) {
        nativeSetUser(s, s2, s3, s4);
    }
    
    public void f(final String s, final String s2, final String s3, final String s4, final String s5, final String s6) {
        nativeAddBreadcrumb(s, s2, s3, s4, s5, s6);
    }
    
    public void g() {
        nativeRemoveUser();
    }
}
