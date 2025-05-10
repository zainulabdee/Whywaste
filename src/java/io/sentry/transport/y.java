package io.sentry.transport;

import io.sentry.util.r;
import java.util.List;
import java.util.Iterator;
import io.sentry.l4;
import io.sentry.clientreport.e;
import java.util.ArrayList;
import io.sentry.c4;
import io.sentry.l3;
import io.sentry.a0;
import io.sentry.hints.j;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Date;
import io.sentry.i;
import java.util.Map;
import io.sentry.q4;

public final class y
{
    private final o a;
    private final q4 b;
    private final Map<i, Date> c;
    
    public y(final q4 q4) {
        this(m.b(), q4);
    }
    
    public y(final o a, final q4 b) {
        this.c = (Map<i, Date>)new ConcurrentHashMap();
        this.a = a;
        this.b = b;
    }
    
    private void c(final i i, final Date date) {
        final Date date2 = (Date)this.c.get((Object)i);
        if (date2 == null || date.after(date2)) {
            this.c.put((Object)i, (Object)date);
        }
    }
    
    private i e(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2141246174: {
                if (!s.equals((Object)"transaction")) {
                    break;
                }
                n = 4;
                break;
            }
            case 1984987798: {
                if (!s.equals((Object)"session")) {
                    break;
                }
                n = 3;
                break;
            }
            case 96891546: {
                if (!s.equals((Object)"event")) {
                    break;
                }
                n = 2;
                break;
            }
            case -309425751: {
                if (!s.equals((Object)"profile")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1963501277: {
                if (!s.equals((Object)"attachment")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return i.Unknown;
            }
            case 4: {
                return i.Transaction;
            }
            case 3: {
                return i.Session;
            }
            case 2: {
                return i.Error;
            }
            case 1: {
                return i.Profile;
            }
            case 0: {
                return i.Attachment;
            }
        }
    }
    
    private boolean f(final String s) {
        final i e = this.e(s);
        final Date date = new Date(this.a.a());
        final Date date2 = (Date)this.c.get((Object)i.All);
        if (date2 != null && !date.after(date2)) {
            return true;
        }
        if (i.Unknown.equals(e)) {
            return false;
        }
        final Date date3 = (Date)this.c.get((Object)e);
        return date3 != null && (date.after(date3) ^ true);
    }
    
    private static void i(final a0 a0, final boolean b) {
        io.sentry.util.j.n(a0, io.sentry.hints.o.class, (io.sentry.util.j.a<io.sentry.hints.o>)new w());
        io.sentry.util.j.n(a0, j.class, (io.sentry.util.j.a<j>)new x(b));
    }
    
    private long j(final String s) {
        Label_0020: {
            if (s == null) {
                break Label_0020;
            }
            try {
                return (long)(Double.parseDouble(s) * 1000.0);
                n = 60000L;
                return n;
            }
            catch (final NumberFormatException ex) {
                return 60000L;
            }
        }
    }
    
    public l3 d(final l3 l3, final a0 a0) {
        final Iterator iterator = l3.c().iterator();
        List list = null;
        while (iterator.hasNext()) {
            final c4 c4 = (c4)iterator.next();
            if (this.f(c4.x().b().getItemType())) {
                Object o;
                if ((o = list) == null) {
                    o = new ArrayList();
                }
                ((List)o).add((Object)c4);
                this.b.getClientReportRecorder().c(e.RATELIMIT_BACKOFF, c4);
                list = (List)o;
            }
        }
        if (list == null) {
            return l3;
        }
        this.b.getLogger().a(l4.INFO, "%d items will be dropped due rate limiting.", list.size());
        final ArrayList list2 = new ArrayList();
        for (final c4 c5 : l3.c()) {
            if (!list.contains((Object)c5)) {
                ((List)list2).add((Object)c5);
            }
        }
        if (((List)list2).isEmpty()) {
            this.b.getLogger().a(l4.INFO, "Envelope discarded due all items rate limited.", new Object[0]);
            i(a0, false);
            return null;
        }
        return new l3(l3.b(), (Iterable<c4>)list2);
    }
    
    public void k(String obj, String b, int i) {
        if (obj != null) {
            final String[] split = ((String)obj).split(",", -1);
            int length;
            String[] split2;
            long j;
            Date date;
            String[] split3;
            int length2;
            int k;
            String s;
            for (length = split.length, i = 0; i < length; ++i) {
                split2 = split[i].replace((CharSequence)" ", (CharSequence)"").split(":", -1);
                if (split2.length > 0) {
                    j = this.j(split2[0]);
                    if (split2.length > 1) {
                        obj = split2[1];
                        date = new Date(this.a.a() + j);
                        if (obj != null && !((String)obj).isEmpty()) {
                            split3 = ((String)obj).split(";", -1);
                            for (length2 = split3.length, k = 0; k < length2; ++k) {
                                s = split3[k];
                                obj = i.Unknown;
                                try {
                                    b = r.b(s);
                                    if (b != null) {
                                        obj = i.valueOf(b);
                                    }
                                    else {
                                        this.b.getLogger().a(l4.ERROR, "Couldn't capitalize: %s", s);
                                    }
                                }
                                catch (final IllegalArgumentException ex) {
                                    this.b.getLogger().c(l4.INFO, (Throwable)ex, "Unknown category: %s", s);
                                }
                                if (!i.Unknown.equals(obj)) {
                                    this.c((i)obj, date);
                                }
                            }
                        }
                        else {
                            this.c(i.All, date);
                        }
                    }
                }
            }
        }
        else if (i == 429) {
            this.c(i.All, new Date(this.a.a() + this.j(b)));
        }
    }
}
