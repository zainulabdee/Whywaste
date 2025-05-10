package io.sentry.vendor.gson.stream;

public enum b
{
    private static final b[] $VALUES;
    
    BEGIN_ARRAY, 
    BEGIN_OBJECT, 
    BOOLEAN, 
    END_ARRAY, 
    END_DOCUMENT, 
    END_OBJECT, 
    NAME, 
    NULL, 
    NUMBER, 
    STRING;
    
    private static /* synthetic */ b[] $values() {
        return new b[] { b.BEGIN_ARRAY, b.END_ARRAY, b.BEGIN_OBJECT, b.END_OBJECT, b.NAME, b.STRING, b.NUMBER, b.BOOLEAN, b.NULL, b.END_DOCUMENT };
    }
    
    static {
        $VALUES = $values();
    }
}
