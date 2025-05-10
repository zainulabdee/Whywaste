package io.flutter.embedding.android;

import java.util.AbstractCollection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.PriorityQueue;
import android.view.MotionEvent;
import android.util.LongSparseArray;

public final class b0
{
    private static b0 c;
    private final LongSparseArray<MotionEvent> a;
    private final PriorityQueue<Long> b;
    
    private b0() {
        this.a = (LongSparseArray<MotionEvent>)new LongSparseArray();
        this.b = (PriorityQueue<Long>)new PriorityQueue();
    }
    
    public static b0 a() {
        if (b0.c == null) {
            b0.c = new b0();
        }
        return b0.c;
    }
    
    public MotionEvent b(final a a) {
        while (!((AbstractCollection)this.b).isEmpty() && (long)this.b.peek() < a.a) {
            this.a.remove((long)this.b.poll());
        }
        if (!((AbstractCollection)this.b).isEmpty() && (long)this.b.peek() == a.a) {
            this.b.poll();
        }
        final MotionEvent motionEvent = (MotionEvent)this.a.get(a.a);
        this.a.remove(a.a);
        return motionEvent;
    }
    
    public a c(final MotionEvent motionEvent) {
        final a b = b0.a.b();
        this.a.put(b.a, (Object)MotionEvent.obtain(motionEvent));
        this.b.add((Object)b.a);
        return b;
    }
    
    public static class a
    {
        private static final AtomicLong b;
        private final long a;
        
        static {
            b = new AtomicLong(0L);
        }
        
        private a(final long a) {
            this.a = a;
        }
        
        public static a b() {
            return c(a.b.incrementAndGet());
        }
        
        public static a c(final long n) {
            return new a(n);
        }
        
        public long d() {
            return this.a;
        }
    }
}
