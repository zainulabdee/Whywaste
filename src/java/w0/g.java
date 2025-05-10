package w0;

import java.util.concurrent.Executor;

public abstract class g<TResult>
{
    public abstract g<TResult> a(final Executor p0, final b p1);
    
    public abstract g<TResult> b(final Executor p0, final c<TResult> p1);
    
    public abstract g<TResult> c(final c<TResult> p0);
    
    public abstract g<TResult> d(final Executor p0, final d p1);
    
    public abstract g<TResult> e(final Executor p0, final e<? super TResult> p1);
    
    public abstract Exception f();
    
    public abstract TResult g();
    
    public abstract <X extends Throwable> TResult h(final Class<X> p0) throws X;
    
    public abstract boolean i();
    
    public abstract boolean j();
    
    public abstract boolean k();
}
