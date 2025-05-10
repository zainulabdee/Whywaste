package io.flutter.view;

import io.flutter.embedding.engine.FlutterJNI;

public final class FlutterCallbackInformation
{
    public final String callbackClassName;
    public final String callbackLibraryPath;
    public final String callbackName;
    
    private FlutterCallbackInformation(final String callbackName, final String callbackClassName, final String callbackLibraryPath) {
        this.callbackName = callbackName;
        this.callbackClassName = callbackClassName;
        this.callbackLibraryPath = callbackLibraryPath;
    }
    
    public static FlutterCallbackInformation lookupCallbackInformation(final long n) {
        return FlutterJNI.nativeLookupCallbackInformation(n);
    }
}
