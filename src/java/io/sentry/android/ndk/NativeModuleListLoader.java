package io.sentry.android.ndk;

import io.sentry.protocol.DebugImage;

final class NativeModuleListLoader
{
    public static native DebugImage[] nativeLoadModuleList();
    
    public DebugImage[] a() {
        return nativeLoadModuleList();
    }
}
