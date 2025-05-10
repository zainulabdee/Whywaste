package io.sentry.android.core;

import io.sentry.l4;
import android.os.Build$VERSION;
import android.os.Build;
import io.sentry.util.n;
import io.sentry.n0;

public final class l0
{
    final n0 a;
    
    public l0(final n0 n0) {
        this.a = n.c(n0, "The ILogger object is required.");
    }
    
    public String a() {
        return Build.TAGS;
    }
    
    public String b() {
        return Build.MANUFACTURER;
    }
    
    public String c() {
        return Build.MODEL;
    }
    
    public int d() {
        return Build$VERSION.SDK_INT;
    }
    
    public String e() {
        return Build$VERSION.RELEASE;
    }
    
    public Boolean f() {
        try {
            if (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) {
                final String fingerprint = Build.FINGERPRINT;
                if (!fingerprint.startsWith("generic") && !fingerprint.startsWith("unknown")) {
                    final String hardware = Build.HARDWARE;
                    if (!hardware.contains((CharSequence)"goldfish") && !hardware.contains((CharSequence)"ranchu")) {
                        final String model = Build.MODEL;
                        if (!model.contains((CharSequence)"google_sdk") && !model.contains((CharSequence)"Emulator") && !model.contains((CharSequence)"Android SDK built for x86") && !Build.MANUFACTURER.contains((CharSequence)"Genymotion")) {
                            final String product = Build.PRODUCT;
                            if (!product.contains((CharSequence)"sdk_google") && !product.contains((CharSequence)"google_sdk") && !product.contains((CharSequence)"sdk") && !product.contains((CharSequence)"sdk_x86") && !product.contains((CharSequence)"vbox86p") && !product.contains((CharSequence)"emulator")) {
                                if (!product.contains((CharSequence)"simulator")) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        finally {
            final Throwable t;
            this.a.d(l4.ERROR, "Error checking whether application is running in an emulator.", t);
            return null;
        }
    }
}
