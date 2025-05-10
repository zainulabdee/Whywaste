package io.sentry.android.ndk;

import io.sentry.android.core.t0;
import io.sentry.q0;
import io.sentry.q4;
import io.sentry.android.core.SentryAndroidOptions;

public final class SentryNdk
{
    static {
        System.loadLibrary("log");
        System.loadLibrary("sentry");
        System.loadLibrary("sentry-android");
    }
    
    private SentryNdk() {
    }
    
    public static void close() {
        shutdown();
    }
    
    public static void init(final SentryAndroidOptions sentryAndroidOptions) {
        d.a(((q4)sentryAndroidOptions).getSdkVersion());
        initSentryNative(sentryAndroidOptions);
        if (((q4)sentryAndroidOptions).isEnableScopeSync()) {
            ((q4)sentryAndroidOptions).addScopeObserver((q0)new c((q4)sentryAndroidOptions));
        }
        sentryAndroidOptions.setDebugImagesLoader((t0)new a(sentryAndroidOptions, new NativeModuleListLoader()));
    }
    
    private static native void initSentryNative(final SentryAndroidOptions p0);
    
    private static native void shutdown();
}
