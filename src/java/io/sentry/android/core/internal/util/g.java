package io.sentry.android.core.internal.util;

import android.content.ContentProvider;
import io.sentry.n0;
import io.sentry.u1;
import io.sentry.android.core.l0;

public final class g
{
    private final l0 a;
    
    public g() {
        this(new l0((n0)u1.e()));
    }
    
    public g(final l0 a) {
        this.a = a;
    }
    
    public void a(final ContentProvider contentProvider) {
        final int d = this.a.d();
        if (d < 26 || d > 28) {
            return;
        }
        final String callingPackage = contentProvider.getCallingPackage();
        final String packageName = contentProvider.getContext().getPackageName();
        if (callingPackage != null && callingPackage.equals((Object)packageName)) {
            return;
        }
        throw new SecurityException("Provider does not allow for granting of Uri permissions");
    }
}
