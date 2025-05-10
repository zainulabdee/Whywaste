package t1;

import java.nio.ByteBuffer;

public interface c
{
    c a(final d p0);
    
    void b(final String p0, final ByteBuffer p1, final b p2);
    
    void c(final String p0, final a p1, final c p2);
    
    c d();
    
    void e(final String p0, final ByteBuffer p1);
    
    void g(final String p0, final a p1);
    
    public interface a
    {
        void a(final ByteBuffer p0, final b p1);
    }
    
    public interface b
    {
        void a(final ByteBuffer p0);
    }
    
    public interface c
    {
    }
    
    public static class d
    {
        private boolean a;
        
        public d() {
            this.a = true;
        }
        
        public boolean a() {
            return this.a;
        }
    }
}
