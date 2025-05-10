package io.sentry;

import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import io.sentry.protocol.u;
import java.util.List;

public final class s4
{
    private final q4 a;
    
    public s4(final q4 a) {
        this.a = a;
    }
    
    public List<u> a(final StackTraceElement[] array) {
        List<u> list2;
        if (array != null && array.length > 0) {
            final ArrayList list = new ArrayList();
            for (final StackTraceElement stackTraceElement : array) {
                if (stackTraceElement != null) {
                    final String className = stackTraceElement.getClassName();
                    if (!className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                        final u u = new u();
                        u.t(this.b(className));
                        u.w(className);
                        u.s(stackTraceElement.getMethodName());
                        u.r(stackTraceElement.getFileName());
                        if (stackTraceElement.getLineNumber() >= 0) {
                            u.u(Integer.valueOf(stackTraceElement.getLineNumber()));
                        }
                        u.x(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                        ((List)list).add((Object)u);
                    }
                }
            }
            Collections.reverse((List)list);
            list2 = (List<u>)list;
        }
        else {
            list2 = null;
        }
        return list2;
    }
    
    public Boolean b(final String s) {
        if (s != null && !s.isEmpty()) {
            final Iterator iterator = this.a.getInAppIncludes().iterator();
            while (iterator.hasNext()) {
                if (s.startsWith((String)iterator.next())) {
                    return Boolean.TRUE;
                }
            }
            final Iterator iterator2 = this.a.getInAppExcludes().iterator();
            while (iterator2.hasNext()) {
                if (s.startsWith((String)iterator2.next())) {
                    return Boolean.FALSE;
                }
            }
            return null;
        }
        return Boolean.TRUE;
    }
}
