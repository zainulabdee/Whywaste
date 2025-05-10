package io.sentry;

import java.util.Locale;

public enum l4 implements m1
{
    private static final l4[] $VALUES;
    
    DEBUG, 
    ERROR, 
    FATAL, 
    INFO, 
    WARNING;
    
    private static /* synthetic */ l4[] $values() {
        return new l4[] { l4.DEBUG, l4.INFO, l4.WARNING, l4.ERROR, l4.FATAL };
    }
    
    static {
        $VALUES = $values();
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.v(this.name().toLowerCase(Locale.ROOT));
    }
    
    static final class a implements c1<l4>
    {
        public l4 b(final i1 i1, final n0 n0) {
            return l4.valueOf(i1.v().toUpperCase(Locale.ROOT));
        }
    }
}
