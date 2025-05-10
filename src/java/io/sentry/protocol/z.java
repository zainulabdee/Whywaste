package io.sentry.protocol;

import java.util.Locale;

public enum z
{
    private static final z[] $VALUES;
    
    COMPONENT, 
    CUSTOM, 
    ROUTE, 
    TASK, 
    URL, 
    VIEW;
    
    private static /* synthetic */ z[] $values() {
        return new z[] { z.CUSTOM, z.URL, z.ROUTE, z.VIEW, z.COMPONENT, z.TASK };
    }
    
    static {
        $VALUES = $values();
    }
    
    public String apiName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
