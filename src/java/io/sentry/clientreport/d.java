package io.sentry.clientreport;

import java.util.Date;
import java.util.List;
import io.sentry.j;
import io.sentry.c4;
import java.util.ArrayList;
import io.sentry.l3;
import io.sentry.l4;
import java.util.Iterator;
import io.sentry.i;
import io.sentry.k4;
import io.sentry.q4;

public final class d implements g
{
    private final h a;
    private final q4 b;
    
    public d(final q4 b) {
        this.b = b;
        this.a = (h)new a();
    }
    
    private i e(final k4 k4) {
        if (k4.Event.equals(k4)) {
            return i.Error;
        }
        if (k4.Session.equals(k4)) {
            return i.Session;
        }
        if (k4.Transaction.equals(k4)) {
            return i.Transaction;
        }
        if (k4.UserFeedback.equals(k4)) {
            return i.UserReport;
        }
        if (k4.Profile.equals(k4)) {
            return i.Profile;
        }
        if (k4.Attachment.equals(k4)) {
            return i.Attachment;
        }
        return i.Default;
    }
    
    private void f(final String s, final String s2, final Long n) {
        this.a.b(new c(s, s2), n);
    }
    
    private void h(final b b) {
        if (b == null) {
            return;
        }
        for (final f f : b.a()) {
            this.f(f.c(), f.a(), f.b());
        }
    }
    
    public void a(final e e, final i i) {
        try {
            this.f(e.getReason(), i.getCategory(), 1L);
        }
        finally {
            final Throwable t;
            this.b.getLogger().c(l4.ERROR, t, "Unable to record lost event.", new Object[0]);
        }
    }
    
    public l3 b(final l3 l3) {
        final b g = this.g();
        if (g == null) {
            return l3;
        }
        try {
            this.b.getLogger().a(l4.DEBUG, "Attaching client report to envelope.", new Object[0]);
            final ArrayList list = new ArrayList();
            final Iterator iterator = l3.c().iterator();
            while (iterator.hasNext()) {
                ((List)list).add((Object)iterator.next());
            }
            ((List)list).add((Object)c4.r(this.b.getSerializer(), g));
            return new l3(l3.b(), (Iterable)list);
        }
        finally {
            final Throwable t;
            this.b.getLogger().c(l4.ERROR, t, "Unable to attach client report to envelope.", new Object[0]);
            return l3;
        }
    }
    
    public void c(final e e, final c4 c4) {
        if (c4 == null) {
            return;
        }
        try {
            final k4 b = c4.x().b();
            if (k4.ClientReport.equals(b)) {
                try {
                    this.h(c4.v(this.b.getSerializer()));
                }
                catch (final Exception ex) {
                    this.b.getLogger().a(l4.ERROR, "Unable to restore counts from previous client report.", new Object[0]);
                }
            }
            else {
                this.f(e.getReason(), this.e(b).getCategory(), 1L);
            }
        }
        finally {
            final Throwable t;
            this.b.getLogger().c(l4.ERROR, t, "Unable to record lost envelope item.", new Object[0]);
        }
    }
    
    public void d(final e e, final l3 l3) {
        if (l3 == null) {
            return;
        }
        try {
            final Iterator iterator = l3.c().iterator();
            while (iterator.hasNext()) {
                this.c(e, (c4)iterator.next());
            }
        }
        finally {
            final Throwable t;
            this.b.getLogger().c(l4.ERROR, t, "Unable to record lost envelope.", new Object[0]);
        }
    }
    
    b g() {
        final Date c = j.c();
        final List a = this.a.a();
        if (a.isEmpty()) {
            return null;
        }
        return new b(c, (List<f>)a);
    }
}
