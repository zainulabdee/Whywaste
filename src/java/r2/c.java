package r2;

import java.util.Iterator;
import kotlin.jvm.internal.i;
import c2.j;
import l2.p;
import q2.b;

final class c implements b<o2.c>
{
    private final CharSequence a;
    private final int b;
    private final int c;
    private final p<CharSequence, Integer, j<Integer, Integer>> d;
    
    public c(final CharSequence a, final int b, final int c, final p<? super CharSequence, ? super Integer, j<Integer, Integer>> d) {
        i.e((Object)a, "input");
        i.e((Object)d, "getNextMatch");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = (p<CharSequence, Integer, j<Integer, Integer>>)d;
    }
    
    public Iterator<o2.c> iterator() {
        return (Iterator<o2.c>)new c$a(this);
    }
}
