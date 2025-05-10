package io.flutter.plugin.editing;

import android.text.Selection;
import android.text.Spannable;
import java.util.Collection;
import f1.b;
import java.util.Iterator;
import android.text.Editable;
import android.view.View;
import s1.p$e;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import android.text.SpannableStringBuilder;

class e extends SpannableStringBuilder
{
    private int e;
    private int f;
    private ArrayList<b> g;
    private ArrayList<b> h;
    private ArrayList<g> i;
    private String j;
    private String k;
    private int l;
    private int m;
    private int n;
    private int o;
    private BaseInputConnection p;
    
    public e(final p$e p$e, final View view) {
        this.e = 0;
        this.f = 0;
        this.g = (ArrayList<b>)new ArrayList();
        this.h = (ArrayList<b>)new ArrayList();
        this.i = (ArrayList<g>)new ArrayList();
        this.p = new BaseInputConnection(this, view, true, this) {
            final Editable a;
            final e b;
            
            public Editable getEditable() {
                return this.a;
            }
        };
        if (p$e != null) {
            this.n(p$e);
        }
    }
    
    private void j(final b b, final boolean b2, final boolean b3, final boolean b4) {
        ++this.f;
        b.a(b2, b3, b4);
        --this.f;
    }
    
    private void k(final boolean b, final boolean b2, final boolean b3) {
        if (b || b2 || b3) {
            final Iterator iterator = this.g.iterator();
            while (iterator.hasNext()) {
                this.j((b)iterator.next(), b, b2, b3);
            }
        }
    }
    
    public void a(final b b) {
        if (this.f > 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("adding a listener ");
            sb.append(b.toString());
            sb.append(" in a listener callback");
            b.b("ListenableEditingState", sb.toString());
        }
        if (this.e > 0) {
            b.g("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            this.h.add((Object)b);
        }
        else {
            this.g.add((Object)b);
        }
    }
    
    public void b() {
        ++this.e;
        if (this.f > 0) {
            f1.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.e == 1 && !this.g.isEmpty()) {
            this.k = this.toString();
            this.l = this.i();
            this.m = this.h();
            this.n = this.g();
            this.o = this.f();
        }
    }
    
    public void c() {
        this.i.clear();
    }
    
    public void d() {
        final int e = this.e;
        if (e == 0) {
            f1.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (e == 1) {
            final Iterator iterator = this.h.iterator();
            while (iterator.hasNext()) {
                this.j((b)iterator.next(), true, true, true);
            }
            if (!this.g.isEmpty()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("didFinishBatchEdit with ");
                sb.append(String.valueOf(this.g.size()));
                sb.append(" listener(s)");
                f1.b.f("ListenableEditingState", sb.toString());
                final boolean equals = this.toString().equals((Object)this.k);
                final int l = this.l;
                final int i = this.i();
                boolean b = false;
                final boolean b2 = l != i || this.m != this.h();
                if (this.n != this.g() || this.o != this.f()) {
                    b = true;
                }
                this.k(equals ^ true, b2, b);
            }
        }
        this.g.addAll((Collection)this.h);
        this.h.clear();
        --this.e;
    }
    
    public ArrayList<g> e() {
        final ArrayList list = new ArrayList((Collection)this.i);
        this.i.clear();
        return (ArrayList<g>)list;
    }
    
    public final int f() {
        return BaseInputConnection.getComposingSpanEnd((Spannable)this);
    }
    
    public final int g() {
        return BaseInputConnection.getComposingSpanStart((Spannable)this);
    }
    
    public final int h() {
        return Selection.getSelectionEnd((CharSequence)this);
    }
    
    public final int i() {
        return Selection.getSelectionStart((CharSequence)this);
    }
    
    public void l(final b b) {
        if (this.f > 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("removing a listener ");
            sb.append(b.toString());
            sb.append(" in a listener callback");
            b.b("ListenableEditingState", sb.toString());
        }
        this.g.remove((Object)b);
        if (this.e > 0) {
            this.h.remove((Object)b);
        }
    }
    
    public void m(final int n, final int n2) {
        if (n >= 0 && n < n2) {
            this.p.setComposingRegion(n, n2);
        }
        else {
            BaseInputConnection.removeComposingSpans((Spannable)this);
        }
    }
    
    public void n(final p$e p$e) {
        this.b();
        this.replace(0, this.length(), (CharSequence)p$e.a);
        if (p$e.c()) {
            Selection.setSelection((Spannable)this, p$e.b, p$e.c);
        }
        else {
            Selection.removeSelection((Spannable)this);
        }
        this.m(p$e.d, p$e.e);
        this.c();
        this.d();
    }
    
    public SpannableStringBuilder replace(final int n, final int n2, final CharSequence charSequence, final int n3, final int n4) {
        if (this.f > 0) {
            f1.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        final String string = this.toString();
        final int n5 = n2 - n;
        boolean b = n5 != n4 - n3;
        for (int n6 = 0; n6 < n5 && !b; b |= (this.charAt(n + n6) != charSequence.charAt(n3 + n6)), ++n6) {}
        if (b) {
            this.j = null;
        }
        final int i = this.i();
        final int h = this.h();
        final int g = this.g();
        final int f = this.f();
        final SpannableStringBuilder replace = super.replace(n, n2, charSequence, n3, n4);
        this.i.add((Object)new g((CharSequence)string, n, n2, charSequence, this.i(), this.h(), this.g(), this.f()));
        if (this.e > 0) {
            return replace;
        }
        this.k(b, this.i() != i || this.h() != h, this.g() != g || this.f() != f);
        return replace;
    }
    
    public void setSpan(final Object o, final int n, final int n2, final int n3) {
        super.setSpan(o, n, n2, n3);
        this.i.add((Object)new g((CharSequence)this.toString(), this.i(), this.h(), this.g(), this.f()));
    }
    
    public String toString() {
        String j = this.j;
        if (j == null) {
            j = super.toString();
            this.j = j;
        }
        return j;
    }
    
    interface b
    {
        void a(final boolean p0, final boolean p1, final boolean p2);
    }
}
