package s2;

import kotlin.jvm.internal.i;
import java.util.concurrent.CancellationException;

public final class m1 extends CancellationException
{
    public final transient l1 e;
    
    public m1(final String s, final Throwable t, final l1 e) {
        super(s);
        this.e = e;
        if (t != null) {
            ((Throwable)this).initCause(t);
        }
    }
    
    public boolean equals(final Object o) {
        if (o != this) {
            if (o instanceof m1) {
                final m1 m1 = (m1)o;
                if (i.a((Object)((Throwable)m1).getMessage(), (Object)((Throwable)this).getMessage()) && i.a((Object)m1.e, (Object)this.e) && i.a((Object)((Throwable)m1).getCause(), (Object)((Throwable)this).getCause())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public Throwable fillInStackTrace() {
        ((Throwable)this).setStackTrace(new StackTraceElement[0]);
        return (Throwable)this;
    }
    
    public int hashCode() {
        final String message = ((Throwable)this).getMessage();
        i.b((Object)message);
        final int hashCode = message.hashCode();
        final int hashCode2 = this.e.hashCode();
        final Throwable cause = ((Throwable)this).getCause();
        int hashCode3;
        if (cause != null) {
            hashCode3 = cause.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        return (hashCode * 31 + hashCode2) * 31 + hashCode3;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; job=");
        sb.append((Object)this.e);
        return sb.toString();
    }
}
