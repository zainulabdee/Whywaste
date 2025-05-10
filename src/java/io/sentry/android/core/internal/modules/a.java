package io.sentry.android.core.internal.modules;

import java.io.FileNotFoundException;
import java.io.IOException;
import io.sentry.l4;
import java.util.TreeMap;
import java.util.Map;
import io.sentry.n0;
import android.content.Context;
import io.sentry.internal.modules.d;

public final class a extends d
{
    private final Context d;
    
    public a(final Context d, final n0 n0) {
        super(n0);
        this.d = d;
    }
    
    protected Map<String, String> b() {
        final TreeMap treeMap = new TreeMap();
        try {
            return (Map<String, String>)this.c(this.d.getAssets().open("sentry-external-modules.txt"));
        }
        catch (final IOException ex) {
            super.a.d(l4.ERROR, "Error extracting modules.", (Throwable)ex);
        }
        catch (final FileNotFoundException ex2) {
            super.a.a(l4.INFO, "%s file was not found.", new Object[] { "sentry-external-modules.txt" });
        }
        return (Map<String, String>)treeMap;
    }
}
