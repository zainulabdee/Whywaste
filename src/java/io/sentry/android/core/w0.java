package io.sentry.android.core;

import io.sentry.l4;
import io.sentry.q4;
import io.sentry.n0;

public final class w0
{
    public boolean a(final String s, final n0 n0) {
        return this.c(s, n0) != null;
    }
    
    public boolean b(final String s, final q4 q4) {
        n0 logger;
        if (q4 != null) {
            logger = q4.getLogger();
        }
        else {
            logger = null;
        }
        return this.a(s, logger);
    }
    
    public Class<?> c(final String className, final n0 n0) {
        try {
            return Class.forName(className);
        }
        catch (final UnsatisfiedLinkError unsatisfiedLinkError) {
            if (n0 != null) {
                final l4 error = l4.ERROR;
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to load (UnsatisfiedLinkError) ");
                sb.append(className);
                n0.d(error, sb.toString(), (Throwable)unsatisfiedLinkError);
            }
        }
        catch (final ClassNotFoundException ex) {
            if (n0 != null) {
                final l4 debug = l4.DEBUG;
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Class not available:");
                sb2.append(className);
                n0.d(debug, sb2.toString(), (Throwable)ex);
            }
        }
        finally {
            if (n0 != null) {
                final l4 error2 = l4.ERROR;
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to initialize ");
                sb3.append(className);
                final Throwable t;
                n0.d(error2, sb3.toString(), t);
            }
        }
        return null;
    }
}
