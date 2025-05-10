package io.sentry;

import java.util.Map;
import java.io.OutputStream;
import java.io.Writer;
import java.io.InputStream;
import java.io.Reader;

public interface t0
{
     <T> T a(final Reader p0, final Class<T> p1);
    
    l3 b(final InputStream p0);
    
     <T> void c(final T p0, final Writer p1);
    
     <T, R> T d(final Reader p0, final Class<T> p1, final c1<R> p2);
    
    void e(final l3 p0, final OutputStream p1);
    
    String f(final Map<String, Object> p0);
}
