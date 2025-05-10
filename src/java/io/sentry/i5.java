package io.sentry;

import io.sentry.util.n;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.Iterator;
import java.util.Deque;

final class i5
{
    private final Deque<a> a;
    private final n0 b;
    
    public i5(final i5 i5) {
        this(i5.b, new a((a)i5.a.getLast()));
        final Iterator descendingIterator = i5.a.descendingIterator();
        if (descendingIterator.hasNext()) {
            descendingIterator.next();
        }
        while (descendingIterator.hasNext()) {
            this.b(new a((a)descendingIterator.next()));
        }
    }
    
    public i5(final n0 n0, final a a) {
        final LinkedBlockingDeque a2 = new LinkedBlockingDeque();
        this.a = (Deque<a>)a2;
        this.b = n.c(n0, "logger is required");
        ((Deque)a2).push((Object)n.c(a, "rootStackItem is required"));
    }
    
    a a() {
        return (a)this.a.peek();
    }
    
    void b(final a a) {
        this.a.push((Object)a);
    }
    
    static final class a
    {
        private final q4 a;
        private volatile r0 b;
        private volatile r2 c;
        
        a(final a a) {
            this.a = a.a;
            this.b = a.b;
            this.c = new r2(a.c);
        }
        
        a(final q4 q4, final r0 r0, final r2 r2) {
            this.b = n.c(r0, "ISentryClient is required.");
            this.c = n.c(r2, "Scope is required.");
            this.a = n.c(q4, "Options is required");
        }
        
        public r0 a() {
            return this.b;
        }
        
        public q4 b() {
            return this.a;
        }
        
        public r2 c() {
            return this.c;
        }
    }
}
