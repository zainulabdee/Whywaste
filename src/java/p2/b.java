package p2;

import java.util.List;
import java.util.Map;

public interface b<R> extends a
{
    R call(final Object... p0);
    
    R callBy(final Map<Object, ?> p0);
    
    List<Object> getParameters();
    
    j getReturnType();
    
    List<Object> getTypeParameters();
    
    k getVisibility();
    
    boolean isAbstract();
    
    boolean isFinal();
    
    boolean isOpen();
    
    boolean isSuspend();
}
