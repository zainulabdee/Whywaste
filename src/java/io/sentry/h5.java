package io.sentry;

import java.util.Locale;

public enum h5 implements m1
{
    private static final h5[] $VALUES;
    
    ABORTED(409), 
    ALREADY_EXISTS(409), 
    CANCELLED(499), 
    DATA_LOSS(500), 
    DEADLINE_EXCEEDED(504), 
    FAILED_PRECONDITION(400), 
    INTERNAL_ERROR(500), 
    INVALID_ARGUMENT(400), 
    NOT_FOUND(404), 
    OK(200, 299), 
    OUT_OF_RANGE(400), 
    PERMISSION_DENIED(403), 
    RESOURCE_EXHAUSTED(429), 
    UNAUTHENTICATED(401), 
    UNAVAILABLE(503), 
    UNIMPLEMENTED(501), 
    UNKNOWN(500), 
    UNKNOWN_ERROR(500);
    
    private final int maxHttpStatusCode;
    private final int minHttpStatusCode;
    
    private static /* synthetic */ h5[] $values() {
        return new h5[] { h5.OK, h5.CANCELLED, h5.INTERNAL_ERROR, h5.UNKNOWN, h5.UNKNOWN_ERROR, h5.INVALID_ARGUMENT, h5.DEADLINE_EXCEEDED, h5.NOT_FOUND, h5.ALREADY_EXISTS, h5.PERMISSION_DENIED, h5.RESOURCE_EXHAUSTED, h5.FAILED_PRECONDITION, h5.ABORTED, h5.OUT_OF_RANGE, h5.UNIMPLEMENTED, h5.UNAVAILABLE, h5.DATA_LOSS, h5.UNAUTHENTICATED };
    }
    
    static {
        $VALUES = $values();
    }
    
    private h5(final int n2) {
        this.minHttpStatusCode = n2;
        this.maxHttpStatusCode = n2;
    }
    
    private h5(final int minHttpStatusCode, final int maxHttpStatusCode) {
        this.minHttpStatusCode = minHttpStatusCode;
        this.maxHttpStatusCode = maxHttpStatusCode;
    }
    
    public static h5 fromHttpStatusCode(final int n) {
        for (final h5 h5 : values()) {
            if (h5.matches(n)) {
                return h5;
            }
        }
        return null;
    }
    
    public static h5 fromHttpStatusCode(final Integer n, h5 h5) {
        h5 fromHttpStatusCode;
        if (n != null) {
            fromHttpStatusCode = fromHttpStatusCode(n);
        }
        else {
            fromHttpStatusCode = h5;
        }
        if (fromHttpStatusCode != null) {
            h5 = fromHttpStatusCode;
        }
        return h5;
    }
    
    private boolean matches(final int n) {
        return n >= this.minHttpStatusCode && n <= this.maxHttpStatusCode;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.v(this.name().toLowerCase(Locale.ROOT));
    }
    
    public static final class a implements c1<h5>
    {
        public h5 b(final i1 i1, final n0 n0) {
            return h5.valueOf(i1.v().toUpperCase(Locale.ROOT));
        }
    }
}
