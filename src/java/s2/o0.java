package s2;

import e2.g;

final class o0 extends RuntimeException
{
    private final g e;
    
    public o0(final g e) {
        this.e = e;
    }
    
    public Throwable fillInStackTrace() {
        ((Throwable)this).setStackTrace(new StackTraceElement[0]);
        return (Throwable)this;
    }
    
    public String getLocalizedMessage() {
        return this.e.toString();
    }
}
