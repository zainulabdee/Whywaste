package j;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class a
{
    private final Map<b<?>, Object> a;
    
    public a() {
        this.a = (Map<b<?>, Object>)new LinkedHashMap();
    }
    
    public final Map<b<?>, Object> a() {
        return this.a;
    }
    
    public interface b<T>
    {
    }
}
