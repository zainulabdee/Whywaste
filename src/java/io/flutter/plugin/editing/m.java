package io.flutter.plugin.editing;

import android.view.autofill.AutofillId;
import android.view.ViewStructure;
import android.view.KeyEvent;
import h.a;
import android.view.inputmethod.EditorInfo;
import io.flutter.embedding.android.z;
import java.util.HashMap;
import java.util.ArrayList;
import f1.b;
import android.view.autofill.AutofillValue;
import android.os.Bundle;
import android.view.WindowInsets$Type;
import androidx.core.app.d;
import android.os.Build$VERSION;
import android.graphics.Rect;
import io.flutter.plugin.platform.v;
import android.view.inputmethod.InputConnection;
import android.util.SparseArray;
import s1.p;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.InputMethodManager;
import android.view.View;

public class m implements e$b
{
    private final View a;
    private final InputMethodManager b;
    private final AutofillManager c;
    private final p d;
    private m.m$c e;
    private p.b f;
    private SparseArray<p.b> g;
    private e h;
    private boolean i;
    private InputConnection j;
    private v k;
    private Rect l;
    private ImeSyncDeferringInsetsCallback m;
    private p.e n;
    private boolean o;
    
    public m(final View a, final p d, final v k) {
        final m$c$a e = m$c$a.e;
        int n = 0;
        this.e = new m.m$c(e, 0);
        this.a = a;
        this.h = new e((p.e)null, a);
        this.b = (InputMethodManager)a.getContext().getSystemService("input_method");
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 26) {
            this.c = (AutofillManager)androidx.core.app.d.a(a.getContext(), (Class)AutofillManager.class);
        }
        else {
            this.c = null;
        }
        if (sdk_INT >= 30) {
            if ((a.getWindowSystemUiVisibility() & 0x2) == 0x0) {
                n = (0x0 | WindowInsets$Type.navigationBars());
            }
            int n2 = n;
            if ((a.getWindowSystemUiVisibility() & 0x4) == 0x0) {
                n2 = (n | WindowInsets$Type.statusBars());
            }
            (this.m = new ImeSyncDeferringInsetsCallback(a, n2, WindowInsets$Type.ime())).install();
        }
        (this.d = d).n((p.f)new p.f(this) {
            final m a;
            
            @Override
            public void a() {
                this.a.m();
            }
            
            @Override
            public void b() {
                final m a = this.a;
                a.F(a.a);
            }
            
            @Override
            public void c(final String s, final Bundle bundle) {
                this.a.B(s, bundle);
            }
            
            @Override
            public void d(final int n, final boolean b) {
                this.a.C(n, b);
            }
            
            @Override
            public void e(final double n, final double n2, final double[] array) {
                this.a.A(n, n2, array);
            }
            
            @Override
            public void f(final int n, final b b) {
                this.a.D(n, b);
            }
            
            @Override
            public void g() {
                this.a.x();
            }
            
            @Override
            public void h(final e e) {
                final m a = this.a;
                a.E(a.a, e);
            }
            
            @Override
            public void i(final boolean b) {
                if (Build$VERSION.SDK_INT >= 26) {
                    if (this.a.c != null) {
                        if (b) {
                            this.a.c.commit();
                        }
                        else {
                            this.a.c.cancel();
                        }
                    }
                }
            }
            
            @Override
            public void j() {
                if (this.a.e.a == m$c$a.h) {
                    this.a.y();
                }
                else {
                    final m a = this.a;
                    a.s(a.a);
                }
            }
        });
        d.k();
        (this.k = k).C(this);
    }
    
    private void A(final double n, final double n2, final double[] array) {
        final double[] array2 = new double[4];
        final boolean b = array[3] == 0.0 && array[7] == 0.0 && array[15] == 1.0;
        final double n3 = array[12];
        final double n4 = array[15];
        array2[0] = (array2[1] = n3 / n4);
        array2[2] = (array2[3] = array[13] / n4);
        final m$d m$d = (m$d)new m$d(this, b, array, array2) {
            final boolean a;
            final double[] b;
            final double[] c;
            final m d;
            
            public void a(double n, final double n2) {
                final boolean a = this.a;
                double n3 = 1.0;
                if (!a) {
                    final double[] b = this.b;
                    n3 = 1.0 / (b[3] * n + b[7] * n2 + b[15]);
                }
                final double[] b2 = this.b;
                final double n4 = (b2[0] * n + b2[4] * n2 + b2[12]) * n3;
                n = (b2[1] * n + b2[5] * n2 + b2[13]) * n3;
                final double[] c = this.c;
                if (n4 < c[0]) {
                    c[0] = n4;
                }
                else if (n4 > c[1]) {
                    c[1] = n4;
                }
                if (n < c[2]) {
                    c[2] = n;
                }
                else if (n > c[3]) {
                    c[3] = n;
                }
            }
        };
        ((m$d)m$d).a(n, 0.0);
        ((m$d)m$d).a(n, n2);
        ((m$d)m$d).a(0.0, n2);
        final Float value = this.a.getContext().getResources().getDisplayMetrics().density;
        this.l = new Rect((int)(array2[0] * value), (int)(array2[2] * value), (int)Math.ceil(array2[1] * value), (int)Math.ceil(array2[3] * value));
    }
    
    private void C(final int n, final boolean b) {
        if (b) {
            this.a.requestFocus();
            this.e = new m.m$c(m$c$a.g, n);
            this.b.restartInput(this.a);
            this.i = false;
        }
        else {
            this.e = new m.m$c(m$c$a.h, n);
            this.j = null;
        }
    }
    
    private void H(p.b b) {
        if (Build$VERSION.SDK_INT < 26) {
            return;
        }
        if (b != null && b.j != null) {
            final p.b[] l = b.l;
            final SparseArray g = new SparseArray();
            this.g = (SparseArray<p.b>)g;
            if (l == null) {
                g.put(b.j.a.hashCode(), (Object)b);
            }
            else {
                for (int length = l.length, i = 0; i < length; ++i) {
                    b = l[i];
                    final p.b.a j = b.j;
                    if (j != null) {
                        this.g.put(j.a.hashCode(), (Object)b);
                        this.c.notifyValueChanged(this.a, j.a.hashCode(), AutofillValue.forText((CharSequence)j.c.a));
                    }
                }
            }
            return;
        }
        this.g = null;
    }
    
    private boolean k() {
        final p.b f = this.f;
        boolean b2;
        final boolean b = b2 = true;
        if (f != null) {
            final p.c g = f.g;
            if (g == null) {
                b2 = b;
            }
            else {
                b2 = (g.a != p.g.p && b);
            }
        }
        return b2;
    }
    
    private static boolean n(final p.e e, final p.e e2) {
        final int n = e.e - e.d;
        if (n != e2.e - e2.d) {
            return true;
        }
        for (int i = 0; i < n; ++i) {
            if (e.a.charAt(e.d + i) != e2.a.charAt(e2.d + i)) {
                return true;
            }
        }
        return false;
    }
    
    private void s(final View view) {
        this.y();
        this.b.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }
    
    private static int t(final p.c c, final boolean b, final boolean b2, final boolean b3, final boolean b4, final p.d d) {
        final p.g a = c.a;
        if (a == p.g.g) {
            return 4;
        }
        if (a == p.g.j) {
            int n = 2;
            if (c.b) {
                n = 4098;
            }
            int n2 = n;
            if (c.c) {
                n2 = (n | 0x2000);
            }
            return n2;
        }
        if (a == p.g.k) {
            return 3;
        }
        if (a == p.g.p) {
            return 0;
        }
        int n3 = 1;
        if (a == p.g.l) {
            n3 = 131073;
        }
        else if (a == p.g.m) {
            n3 = 33;
        }
        else if (a == p.g.n) {
            n3 = 17;
        }
        else if (a == p.g.o) {
            n3 = 145;
        }
        else if (a == p.g.h) {
            n3 = 97;
        }
        else if (a == p.g.i) {
            n3 = 113;
        }
        int n4;
        if (b) {
            n4 = (n3 | 0x80000 | 0x80);
        }
        else {
            int n5 = n3;
            if (b2) {
                n5 = (n3 | 0x8000);
            }
            n4 = n5;
            if (!b3) {
                n4 = (n5 | 0x80000);
            }
        }
        int n6;
        if (d == p.d.f) {
            n6 = (n4 | 0x1000);
        }
        else if (d == p.d.g) {
            n6 = (n4 | 0x2000);
        }
        else {
            n6 = n4;
            if (d == p.d.h) {
                n6 = (n4 | 0x4000);
            }
        }
        return n6;
    }
    
    private boolean v() {
        return this.g != null;
    }
    
    private void w(final String s) {
        if (Build$VERSION.SDK_INT >= 26 && this.c != null) {
            if (this.v()) {
                this.c.notifyValueChanged(this.a, this.f.j.a.hashCode(), AutofillValue.forText((CharSequence)s));
            }
        }
    }
    
    private void x() {
        if (Build$VERSION.SDK_INT >= 26 && this.c != null) {
            if (this.v()) {
                final String a = this.f.j.a;
                final int[] array = new int[2];
                this.a.getLocationOnScreen(array);
                final Rect rect = new Rect(this.l);
                rect.offset(array[0], array[1]);
                this.c.notifyViewEntered(this.a, a.hashCode(), rect);
            }
        }
    }
    
    private void y() {
        if (Build$VERSION.SDK_INT >= 26 && this.c != null) {
            final p.b f = this.f;
            if (f != null && f.j != null) {
                if (this.v()) {
                    this.c.notifyViewExited(this.a, this.f.j.a.hashCode());
                }
            }
        }
    }
    
    public void B(final String s, final Bundle bundle) {
        this.b.sendAppPrivateCommand(this.a, s, bundle);
    }
    
    void D(final int n, final p.b f) {
        this.y();
        this.f = f;
        if (this.k()) {
            this.e = new m.m$c(m$c$a.f, n);
        }
        else {
            this.e = new m.m$c(m$c$a.e, n);
        }
        this.h.l((e$b)this);
        final p.b.a j = f.j;
        p.e c;
        if (j != null) {
            c = j.c;
        }
        else {
            c = null;
        }
        this.h = new e(c, this.a);
        this.H(f);
        this.i = true;
        this.G();
        this.l = null;
        this.h.a((e$b)this);
    }
    
    void E(final View view, final p.e n) {
        if (!this.i) {
            final p.e n2 = this.n;
            if (n2 != null && n2.b() && (this.i = n(this.n, n))) {
                f1.b.e("TextInputPlugin", "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.n = n;
        this.h.n(n);
        if (this.i) {
            this.b.restartInput(view);
            this.i = false;
        }
    }
    
    void F(final View view) {
        if (this.k()) {
            view.requestFocus();
            this.b.showSoftInput(view, 0);
        }
        else {
            this.s(view);
        }
    }
    
    public void G() {
        if (this.e.a == m$c$a.g) {
            this.o = false;
        }
    }
    
    public void a(final boolean b, final boolean b2, final boolean b3) {
        if (b) {
            this.w(this.h.toString());
        }
        final int i = this.h.i();
        final int h = this.h.h();
        final int g = this.h.g();
        final int f = this.h.f();
        final ArrayList e = this.h.e();
        boolean b4 = false;
        Label_0145: {
            Label_0142: {
                if (this.n != null) {
                    if (this.h.toString().equals((Object)this.n.a)) {
                        final p.e n = this.n;
                        if (i == n.b && h == n.c && g == n.d && f == n.e) {
                            break Label_0142;
                        }
                    }
                    b4 = false;
                    break Label_0145;
                }
            }
            b4 = true;
        }
        if (!b4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("send EditingState to flutter: ");
            sb.append(this.h.toString());
            b.f("TextInputPlugin", sb.toString());
            if (this.f.e) {
                this.d.q(this.e.b, (ArrayList<g>)e);
                this.h.c();
            }
            else {
                this.d.p(this.e.b, this.h.toString(), i, h, g, f);
            }
            this.n = new p.e(this.h.toString(), i, h, g, f);
        }
        else {
            this.h.c();
        }
    }
    
    public void j(final SparseArray<AutofillValue> sparseArray) {
        if (Build$VERSION.SDK_INT < 26) {
            return;
        }
        final p.b f = this.f;
        if (f != null && this.g != null) {
            final p.b.a j = f.j;
            if (j != null) {
                final HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); ++i) {
                    final p.b b = (p.b)this.g.get(sparseArray.keyAt(i));
                    if (b != null) {
                        final p.b.a k = b.j;
                        if (k != null) {
                            final String string = ((AutofillValue)sparseArray.valueAt(i)).getTextValue().toString();
                            final p.e e = new p.e(string, string.length(), string.length(), -1, -1);
                            if (k.a.equals((Object)j.a)) {
                                this.h.n(e);
                            }
                            else {
                                hashMap.put((Object)k.a, (Object)e);
                            }
                        }
                    }
                }
                this.d.r(this.e.b, (HashMap<String, p.e>)hashMap);
            }
        }
    }
    
    public void l(final int n) {
        final m.m$c e = this.e;
        final m$c$a a = e.a;
        if ((a == m$c$a.g || a == m$c$a.h) && e.b == n) {
            this.e = new m.m$c(m$c$a.e, 0);
            this.y();
            this.b.hideSoftInputFromWindow(this.a.getApplicationWindowToken(), 0);
            this.b.restartInput(this.a);
            this.i = false;
        }
    }
    
    void m() {
        if (this.e.a == m$c$a.g) {
            return;
        }
        this.h.l((e$b)this);
        this.y();
        this.H(this.f = null);
        this.e = new m.m$c(m$c$a.e, 0);
        this.G();
        this.l = null;
    }
    
    public InputConnection o(final View view, final z z, final EditorInfo editorInfo) {
        final m.m$c e = this.e;
        final m$c$a a = e.a;
        if (a == m$c$a.e) {
            return this.j = null;
        }
        if (a == m$c$a.h) {
            return null;
        }
        if (a != m$c$a.g) {
            final p.b f = this.f;
            final int t = t(f.g, f.a, f.b, f.c, f.d, f.f);
            editorInfo.inputType = t;
            editorInfo.imeOptions = 33554432;
            if (Build$VERSION.SDK_INT >= 26 && !this.f.d) {
                editorInfo.imeOptions = (0x2000000 | 0x1000000);
            }
            final Integer h = this.f.h;
            int intValue;
            if (h == null) {
                if ((t & 0x20000) != 0x0) {
                    intValue = 1;
                }
                else {
                    intValue = 6;
                }
            }
            else {
                intValue = h;
            }
            final p.b f2 = this.f;
            final String i = f2.i;
            if (i != null) {
                editorInfo.actionLabel = (CharSequence)i;
                editorInfo.actionId = intValue;
            }
            editorInfo.imeOptions |= intValue;
            final String[] k = f2.k;
            if (k != null) {
                h.a.a(editorInfo, k);
            }
            final io.flutter.plugin.editing.d j = new io.flutter.plugin.editing.d(view, this.e.b, this.d, (io.flutter.plugin.editing.d.d$a)z, this.h, editorInfo);
            editorInfo.initialSelStart = this.h.i();
            editorInfo.initialSelEnd = this.h.h();
            return this.j = (InputConnection)j;
        }
        if (this.o) {
            return this.j;
        }
        return this.j = this.k.c(e.b).onCreateInputConnection(editorInfo);
    }
    
    public void p() {
        this.k.L();
        this.d.n(null);
        this.y();
        this.h.l((e$b)this);
        final ImeSyncDeferringInsetsCallback m = this.m;
        if (m != null) {
            m.remove();
        }
    }
    
    public InputMethodManager q() {
        return this.b;
    }
    
    public boolean r(final KeyEvent keyEvent) {
        if (this.q().isAcceptingText()) {
            final InputConnection j = this.j;
            if (j != null) {
                boolean b;
                if (j instanceof io.flutter.plugin.editing.d) {
                    b = ((io.flutter.plugin.editing.d)j).f(keyEvent);
                }
                else {
                    b = j.sendKeyEvent(keyEvent);
                }
                return b;
            }
        }
        return false;
    }
    
    public void u() {
        if (this.e.a == m$c$a.g) {
            this.o = true;
        }
    }
    
    public void z(final ViewStructure viewStructure, int i) {
        if (Build$VERSION.SDK_INT >= 26) {
            if (this.v()) {
                final String a = this.f.j.a;
                final AutofillId a2 = io.flutter.plugin.editing.h.a(viewStructure);
                int key;
                p.b.a j;
                ViewStructure child;
                String[] b;
                String d;
                Rect l;
                for (i = 0; i < this.g.size(); ++i) {
                    key = this.g.keyAt(i);
                    j = ((p.b)this.g.valueAt(i)).j;
                    if (j != null) {
                        viewStructure.addChildCount(1);
                        child = viewStructure.newChild(i);
                        i.a(child, a2, key);
                        b = j.b;
                        if (b.length > 0) {
                            io.flutter.plugin.editing.j.a(child, b);
                        }
                        io.flutter.plugin.editing.k.a(child, 1);
                        child.setVisibility(0);
                        d = j.d;
                        if (d != null) {
                            child.setHint((CharSequence)d);
                        }
                        if (a.hashCode() == key) {
                            l = this.l;
                            if (l != null) {
                                child.setDimens(l.left, l.top, 0, 0, l.width(), this.l.height());
                                io.flutter.plugin.editing.l.a(child, AutofillValue.forText((CharSequence)this.h));
                                continue;
                            }
                        }
                        child.setDimens(0, 0, 0, 0, 1, 1);
                        io.flutter.plugin.editing.l.a(child, AutofillValue.forText((CharSequence)j.c.a));
                    }
                }
            }
        }
    }
}
