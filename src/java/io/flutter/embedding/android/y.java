package io.flutter.embedding.android;

import java.nio.Buffer;
import java.util.Iterator;
import java.util.ArrayList;
import java.nio.ByteBuffer;
import android.view.KeyEvent;
import java.util.HashMap;
import t1.c;

public class y implements z$d
{
    private final c a;
    private final HashMap<Long, Long> b;
    private final HashMap<Long, a0$e> c;
    private final z$b d;
    
    public y(final c a) {
        this.b = (HashMap<Long, Long>)new HashMap();
        this.c = (HashMap<Long, a0$e>)new HashMap();
        this.d = new z$b();
        this.a = a;
        for (final a0$e a0$e : a0.a()) {
            this.c.put((Object)a0$e.c, (Object)a0$e);
        }
    }
    
    private static u$a e(final KeyEvent keyEvent) {
        final boolean b = keyEvent.getRepeatCount() > 0;
        final int action = keyEvent.getAction();
        if (action == 0) {
            u$a u$a;
            if (b) {
                u$a = io.flutter.embedding.android.u$a.h;
            }
            else {
                u$a = io.flutter.embedding.android.u$a.f;
            }
            return u$a;
        }
        if (action == 1) {
            return u$a.g;
        }
        throw new AssertionError((Object)"Unexpected event type");
    }
    
    private Long f(final KeyEvent keyEvent) {
        final Long n = (Long)a0.b.get((Object)(long)keyEvent.getKeyCode());
        if (n != null) {
            return n;
        }
        return i(keyEvent.getKeyCode(), 73014444032L);
    }
    
    private Long g(final KeyEvent keyEvent) {
        final long n = keyEvent.getScanCode();
        if (n == 0L) {
            return i(keyEvent.getKeyCode(), 73014444032L);
        }
        final Long n2 = (Long)a0.a.get((Object)n);
        if (n2 != null) {
            return n2;
        }
        return i(keyEvent.getScanCode(), 73014444032L);
    }
    
    private boolean h(final KeyEvent keyEvent, final z$d$a z$d$a) {
        if (keyEvent.getScanCode() == 0 && keyEvent.getKeyCode() == 0) {
            return false;
        }
        final Long g = this.g(keyEvent);
        final Long f = this.f(keyEvent);
        final ArrayList list = new ArrayList();
        for (final a0$d a0$d : a0.c) {
            this.n(a0$d, (keyEvent.getMetaState() & a0$d.a) != 0x0, f, g, keyEvent, (ArrayList<Runnable>)list);
        }
        for (final a0$e a0$e : this.c.values()) {
            this.o(a0$e, (keyEvent.getMetaState() & a0$e.a) != 0x0, f, keyEvent);
        }
        final int action = keyEvent.getAction();
        boolean b;
        if (action != 0) {
            if (action != 1) {
                return false;
            }
            b = false;
        }
        else {
            b = true;
        }
        final Long n = (Long)this.b.get((Object)g);
        Long n2 = null;
        u$a g2 = null;
        String f2 = null;
        Label_0366: {
            if (b) {
                u$a u$a;
                if (n == null) {
                    u$a = io.flutter.embedding.android.u$a.f;
                }
                else if (keyEvent.getRepeatCount() > 0) {
                    u$a = io.flutter.embedding.android.u$a.h;
                }
                else {
                    this.p(false, n, g, keyEvent.getEventTime());
                    u$a = io.flutter.embedding.android.u$a.f;
                }
                final char charValue = this.d.a(keyEvent.getUnicodeChar());
                g2 = u$a;
                if (charValue != '\0') {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(charValue);
                    final String string = sb.toString();
                    g2 = u$a;
                    f2 = string;
                    break Label_0366;
                }
            }
            else {
                if (n == null) {
                    return false;
                }
                g2 = u$a.g;
            }
            f2 = null;
        }
        if (g2 != u$a.h) {
            if (b) {
                n2 = f;
            }
            this.q(g, n2);
        }
        if (g2 == u$a.f) {
            final a0$e a0$e2 = (a0$e)this.c.get((Object)f);
            if (a0$e2 != null) {
                a0$e2.d ^= true;
            }
        }
        final u u = new u();
        u.a = keyEvent.getEventTime();
        u.b = g2;
        u.d = f;
        u.c = g;
        u.f = f2;
        u.e = false;
        this.m(u, z$d$a);
        final Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            ((Runnable)iterator2.next()).run();
        }
        return true;
    }
    
    private static long i(final long n, final long n2) {
        return (n & 0xFFFFFFFFL) | n2;
    }
    
    private void m(final u u, final z$d$a z$d$a) {
        Object o;
        if (z$d$a == null) {
            o = null;
        }
        else {
            o = new v(z$d$a);
        }
        this.a.b("flutter/keydata", u.a(), (c.b)o);
    }
    
    private void p(final boolean b, Long n, final Long n2, final long a) {
        final u u = new u();
        u.a = a;
        u$a b2;
        if (b) {
            b2 = u$a.f;
        }
        else {
            b2 = u$a.g;
        }
        u.b = b2;
        u.d = n;
        u.c = n2;
        u.f = null;
        u.e = true;
        if (n2 != 0L && n != 0L) {
            if (!b) {
                n = null;
            }
            this.q(n2, n);
        }
        this.m(u, null);
    }
    
    public void a(final KeyEvent keyEvent, final z$d$a z$d$a) {
        if (!this.h(keyEvent, z$d$a)) {
            this.p(true, 0L, 0L, 0L);
            z$d$a.a(true);
        }
    }
    
    void n(final a0$d a0$d, final boolean b, final long n, final long n2, final KeyEvent keyEvent, final ArrayList<Runnable> list) {
        final a0$c[] b2 = a0$d.b;
        final boolean[] array = new boolean[b2.length];
        final Boolean[] array2 = new Boolean[b2.length];
        final int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (true) {
            final a0$c[] b3 = a0$d.b;
            final int length = b3.length;
            final boolean b4 = true;
            if (n5 >= length) {
                break;
            }
            final a0$c a0$c = b3[n5];
            final boolean containsKey = this.b.containsKey((Object)a0$c.a);
            array[n5] = containsKey;
            Label_0250: {
                if (a0$c.b == n) {
                    final int n6 = y$a.a[((Enum)e(keyEvent)).ordinal()];
                    if (n6 != 1) {
                        if (n6 == 2) {
                            array2[n5] = array[n5];
                            break Label_0250;
                        }
                        if (n6 != 3) {
                            break Label_0250;
                        }
                        if (!b) {
                            list.add((Object)new x(this, a0$c, keyEvent));
                        }
                        array2[n5] = array[n5];
                    }
                    else {
                        array2[n5] = Boolean.FALSE;
                        if (!b) {
                            list.add((Object)new w(this, a0$c, n2, keyEvent));
                        }
                    }
                    n4 = 1;
                }
                else {
                    int n7 = b4 ? 1 : 0;
                    if (n4 == 0) {
                        if (containsKey) {
                            n7 = (b4 ? 1 : 0);
                        }
                        else {
                            n7 = 0;
                        }
                    }
                    n4 = n7;
                }
            }
            ++n5;
        }
        int j;
        if (b) {
            for (int i = 0; i < a0$d.b.length; ++i) {
                if (array2[i] == null) {
                    if (n4 != 0) {
                        array2[i] = array[i];
                    }
                    else {
                        array2[i] = Boolean.TRUE;
                        n4 = 1;
                    }
                }
            }
            j = n3;
            if (n4 == 0) {
                array2[0] = Boolean.TRUE;
                j = n3;
            }
        }
        else {
            int n8 = 0;
            while (true) {
                j = n3;
                if (n8 >= a0$d.b.length) {
                    break;
                }
                if (array2[n8] == null) {
                    array2[n8] = Boolean.FALSE;
                }
                ++n8;
            }
        }
        while (j < a0$d.b.length) {
            if (array[j] != array2[j]) {
                final a0$c a0$c2 = a0$d.b[j];
                this.p(array2[j], a0$c2.b, a0$c2.a, keyEvent.getEventTime());
            }
            ++j;
        }
    }
    
    void o(final a0$e a0$e, final boolean b, final long n, final KeyEvent keyEvent) {
        if (a0$e.c == n) {
            return;
        }
        if (a0$e.d != b) {
            final boolean b2 = this.b.containsKey((Object)a0$e.b) ^ true;
            if (b2) {
                a0$e.d ^= true;
            }
            this.p(b2, a0$e.c, a0$e.b, keyEvent.getEventTime());
            if (!b2) {
                a0$e.d ^= true;
            }
            this.p(b2 ^ true, a0$e.c, a0$e.b, keyEvent.getEventTime());
        }
    }
    
    void q(final Long n, final Long n2) {
        if (n2 != null) {
            if (this.b.put((Object)n, (Object)n2) != null) {
                throw new AssertionError((Object)"The key was not empty");
            }
        }
        else if (this.b.remove((Object)n) == null) {
            throw new AssertionError((Object)"The key was empty");
        }
    }
}
