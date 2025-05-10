package io.flutter.view;

import java.nio.Buffer;
import android.os.BaseBundle;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Arrays;
import android.text.style.TtsSpan$Builder;
import android.text.style.LocaleSpan;
import java.util.Locale;
import android.text.SpannableString;
import android.view.accessibility.AccessibilityRecord;
import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import java.util.Iterator;
import android.view.WindowInsets;
import java.util.Map$Entry;
import java.util.Set;
import androidx.core.view.l;
import android.opengl.Matrix;
import java.util.HashSet;
import java.nio.ByteBuffer;
import f1.b;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.graphics.Rect;
import android.app.Activity;
import b2.i;
import androidx.core.view.t;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.os.Build$VERSION;
import android.provider.Settings$Global;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import android.database.ContentObserver;
import android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;
import s1.a$b;
import java.util.List;
import java.util.Map;
import android.content.ContentResolver;
import io.flutter.plugin.platform.p;
import android.view.accessibility.AccessibilityManager;
import s1.a;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

public class g extends AccessibilityNodeProvider
{
    private static final int A;
    private static int B;
    private static final int z;
    private final View a;
    private final a b;
    private final AccessibilityManager c;
    private final AccessibilityViewEmbedder d;
    private final io.flutter.plugin.platform.p e;
    private final ContentResolver f;
    private final Map<Integer, l> g;
    private final Map<Integer, h> h;
    private l i;
    private Integer j;
    private Integer k;
    private int l;
    private l m;
    private l n;
    private l o;
    private final List<Integer> p;
    private int q;
    private Integer r;
    private k s;
    private boolean t;
    private boolean u;
    private final a$b v;
    private final AccessibilityManager$AccessibilityStateChangeListener w;
    private final AccessibilityManager$TouchExplorationStateChangeListener x;
    private final ContentObserver y;
    
    static {
        z = (g.i.e | g.h.e | g.j.e | g.k.e);
        A = (i.f.e | i.g.e | i.h.e | i.j.e | i.k.e | i.l.e | i.m.e | i.n.e | i.v.e | i.w.e | i.A.e | i.C.e);
        g.B = 267386881;
    }
    
    public g(final View view, final a a, final AccessibilityManager accessibilityManager, final ContentResolver contentResolver, final io.flutter.plugin.platform.p p5) {
        this(view, a, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), p5);
    }
    
    public g(final View a, final a b, final AccessibilityManager c, final ContentResolver f, final AccessibilityViewEmbedder d, final io.flutter.plugin.platform.p e) {
        this.g = (Map<Integer, l>)new HashMap();
        this.h = (Map<Integer, h>)new HashMap();
        this.l = 0;
        this.p = (List<Integer>)new ArrayList();
        this.q = 0;
        this.r = 0;
        this.t = false;
        this.u = false;
        this.v = (a$b)new g$a(this);
        final AccessibilityManager$AccessibilityStateChangeListener w = (AccessibilityManager$AccessibilityStateChangeListener)new AccessibilityManager$AccessibilityStateChangeListener() {
            final g a;
            
            public void onAccessibilityStateChanged(final boolean b) {
                if (this.a.u) {
                    return;
                }
                if (b) {
                    this.a.b.g(this.a.v);
                    this.a.b.e();
                }
                else {
                    this.a.W(false);
                    this.a.b.g((a$b)null);
                    this.a.b.d();
                }
                if (this.a.s != null) {
                    this.a.s.a(b, this.a.c.isTouchExplorationEnabled());
                }
            }
        };
        this.w = (AccessibilityManager$AccessibilityStateChangeListener)w;
        final ContentObserver y = new ContentObserver(new Handler()) {
            final g a;
            
            public void onChange(final boolean b) {
                this.onChange(b, null);
            }
            
            public void onChange(final boolean b, final Uri uri) {
                if (this.a.u) {
                    return;
                }
                final String string = Settings$Global.getString(this.a.f, "transition_animation_scale");
                if (string != null && string.equals((Object)"0")) {
                    io.flutter.view.g.g(this.a, io.flutter.view.g.f.h.e);
                }
                else {
                    io.flutter.view.g.f(this.a, ~io.flutter.view.g.f.h.e);
                }
                this.a.T();
            }
        };
        this.y = y;
        this.a = a;
        this.b = b;
        this.c = c;
        this.f = f;
        this.d = d;
        this.e = e;
        ((AccessibilityManager$AccessibilityStateChangeListener)w).onAccessibilityStateChanged(c.isEnabled());
        c.addAccessibilityStateChangeListener((AccessibilityManager$AccessibilityStateChangeListener)w);
        final int sdk_INT = Build$VERSION.SDK_INT;
        final AccessibilityManager$TouchExplorationStateChangeListener x = (AccessibilityManager$TouchExplorationStateChangeListener)new AccessibilityManager$TouchExplorationStateChangeListener(this, c) {
            final AccessibilityManager a;
            final g b;
            
            public void onTouchExplorationStateChanged(final boolean b) {
                if (this.b.u) {
                    return;
                }
                if (!b) {
                    this.b.W(false);
                    this.b.L();
                }
                if (this.b.s != null) {
                    this.b.s.a(this.a.isEnabled(), b);
                }
            }
        };
        (this.x = (AccessibilityManager$TouchExplorationStateChangeListener)x).onTouchExplorationStateChanged(c.isTouchExplorationEnabled());
        c.addTouchExplorationStateChangeListener((AccessibilityManager$TouchExplorationStateChangeListener)x);
        y.onChange(false);
        f.registerContentObserver(Settings$Global.getUriFor("transition_animation_scale"), false, (ContentObserver)y);
        if (sdk_INT >= 31) {
            this.X();
        }
        e.a(this);
    }
    
    private l A(final int n) {
        l l;
        if ((l = (l)this.g.get((Object)n)) == null) {
            l = new l(this);
            l.b = n;
            this.g.put((Object)n, (Object)l);
        }
        return l;
    }
    
    private l B() {
        return (l)this.g.get((Object)0);
    }
    
    private void C(final float n, final float n2, final boolean b) {
        if (this.g.isEmpty()) {
            return;
        }
        final l j = this.B().w0(new float[] { n, n2, 0.0f, 1.0f }, b);
        if (j != this.o) {
            if (j != null) {
                this.R(j.b, 128);
            }
            final l o = this.o;
            if (o != null) {
                this.R(o.b, 256);
            }
            this.o = j;
        }
    }
    
    private AccessibilityEvent H(final int n, final int n2) {
        final AccessibilityEvent obtain = AccessibilityEvent.obtain(n2);
        obtain.setPackageName((CharSequence)this.a.getContext().getPackageName());
        ((AccessibilityRecord)obtain).setSource(this.a, n);
        return obtain;
    }
    
    private void L() {
        final l o = this.o;
        if (o != null) {
            this.R(o.b, 256);
            this.o = null;
        }
    }
    
    private void M(final l l) {
        String d0;
        if ((d0 = l.n0()) == null) {
            d0 = " ";
        }
        if (Build$VERSION.SDK_INT >= 28) {
            this.V(d0);
        }
        else {
            final AccessibilityEvent h = this.H(l.b, 32);
            ((AccessibilityRecord)h).getText().add((Object)d0);
            this.S(h);
        }
    }
    
    private boolean N(final l l, final int n, final Bundle bundle, final boolean b) {
        final int int1 = ((BaseBundle)bundle).getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        final boolean boolean1 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        final int i = l.g;
        final int k = l.h;
        this.P(l, int1, b, boolean1);
        if (i != l.g || k != l.h) {
            String q;
            if (l.q != null) {
                q = l.q;
            }
            else {
                q = "";
            }
            final AccessibilityEvent h = this.H(l.b, 8192);
            ((AccessibilityRecord)h).getText().add((Object)q);
            ((AccessibilityRecord)h).setFromIndex(l.g);
            ((AccessibilityRecord)h).setToIndex(l.h);
            ((AccessibilityRecord)h).setItemCount(q.length());
            this.S(h);
        }
        if (int1 != 1) {
            if (int1 != 2) {
                if (int1 == 4 || int1 == 8 || int1 == 16) {
                    return true;
                }
            }
            else {
                if (b) {
                    final g y = io.flutter.view.g.g.y;
                    if (l.u0(y)) {
                        this.b.c(n, y, (Object)boolean1);
                        return true;
                    }
                }
                if (!b) {
                    final g z = io.flutter.view.g.g.z;
                    if (l.u0(z)) {
                        this.b.c(n, z, (Object)boolean1);
                        return true;
                    }
                }
            }
        }
        else {
            if (b) {
                final g o = io.flutter.view.g.g.o;
                if (l.u0(o)) {
                    this.b.c(n, o, (Object)boolean1);
                    return true;
                }
            }
            if (!b) {
                final g p4 = io.flutter.view.g.g.p;
                if (l.u0(p4)) {
                    this.b.c(n, p4, (Object)boolean1);
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean O(final l l, final int n, final Bundle bundle) {
        String string;
        if (bundle != null && ((BaseBundle)bundle).containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) {
            string = ((BaseBundle)bundle).getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        }
        else {
            string = "";
        }
        this.b.c(n, io.flutter.view.g.g.A, (Object)string);
        l.q = string;
        l.r = null;
        return true;
    }
    
    private void P(final l l, final int n, final boolean b, final boolean b2) {
        if (l.h >= 0) {
            if (l.g >= 0) {
                if (n != 1) {
                    if (n != 2) {
                        if (n != 4) {
                            if (n == 8 || n == 16) {
                                if (b) {
                                    l.h = l.q.length();
                                }
                                else {
                                    l.h = 0;
                                }
                            }
                        }
                        else if (b && l.h < l.q.length()) {
                            final Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher((CharSequence)l.q.substring(l.h));
                            if (matcher.find()) {
                                io.flutter.view.g.l.m(l, matcher.start(1));
                            }
                            else {
                                l.h = l.q.length();
                            }
                        }
                        else if (!b && l.h > 0) {
                            final Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher((CharSequence)l.q.substring(0, l.h));
                            if (matcher2.find()) {
                                l.h = matcher2.start(1);
                            }
                            else {
                                l.h = 0;
                            }
                        }
                    }
                    else if (b && l.h < l.q.length()) {
                        final Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher((CharSequence)l.q.substring(l.h));
                        matcher3.find();
                        if (matcher3.find()) {
                            io.flutter.view.g.l.m(l, matcher3.start(1));
                        }
                        else {
                            l.h = l.q.length();
                        }
                    }
                    else if (!b && l.h > 0) {
                        final Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher((CharSequence)l.q.substring(0, l.h));
                        if (matcher4.find()) {
                            l.h = matcher4.start(1);
                        }
                    }
                }
                else if (b && l.h < l.q.length()) {
                    io.flutter.view.g.l.m(l, 1);
                }
                else if (!b && l.h > 0) {
                    io.flutter.view.g.l.n(l, 1);
                }
                if (!b2) {
                    l.g = l.h;
                }
            }
        }
    }
    
    private void R(final int n, final int n2) {
        if (!this.c.isEnabled()) {
            return;
        }
        this.S(this.H(n, n2));
    }
    
    private void S(final AccessibilityEvent accessibilityEvent) {
        if (!this.c.isEnabled()) {
            return;
        }
        this.a.getParent().requestSendAccessibilityEvent(this.a, accessibilityEvent);
    }
    
    private void T() {
        this.b.f(this.l);
    }
    
    private void U(final int n) {
        final AccessibilityEvent h = this.H(n, 2048);
        h.setContentChangeTypes(1);
        this.S(h);
    }
    
    private void V(final String s) {
        androidx.core.view.t.a(this.a, (CharSequence)s);
    }
    
    private void W(final boolean t) {
        if (this.t == t) {
            return;
        }
        this.t = t;
        if (t) {
            this.l |= io.flutter.view.g.f.f.e;
        }
        else {
            this.l &= ~io.flutter.view.g.f.f.e;
        }
        this.T();
    }
    
    private void X() {
        final View a = this.a;
        if (a != null) {
            if (a.getResources() != null) {
                final int fontWeightAdjustment = this.a.getResources().getConfiguration().fontWeightAdjustment;
                if (fontWeightAdjustment != Integer.MAX_VALUE && fontWeightAdjustment >= 300) {
                    this.l |= io.flutter.view.g.f.i.e;
                }
                else {
                    this.l &= io.flutter.view.g.f.i.e;
                }
                this.T();
            }
        }
    }
    
    private boolean Z(final l l) {
        return l.j > 0 && (A0(this.i, (b2.e<l>)new e(l)) || !A0(this.i, (b2.e<l>)new io.flutter.view.f()));
    }
    
    private void c0(final l l) {
        l.Q = null;
        if (l.i != -1) {
            final Integer j = this.j;
            if (j != null && this.d.platformViewOfNode(j) == this.e.c(l.i)) {
                this.R(this.j, 65536);
                this.j = null;
            }
        }
        if (l.i != -1) {
            final View c = this.e.c(l.i);
            if (c != null) {
                c.setImportantForAccessibility(4);
            }
        }
        final l i = this.i;
        if (i == l) {
            this.R(i.b, 65536);
            this.i = null;
        }
        if (this.m == l) {
            this.m = null;
        }
        if (this.o == l) {
            this.o = null;
        }
    }
    
    static /* synthetic */ int f(final g g, int l) {
        l &= g.l;
        return g.l = l;
    }
    
    static /* synthetic */ int g(final g g, int l) {
        l |= g.l;
        return g.l = l;
    }
    
    private AccessibilityEvent v(int fromIndex, final String beforeText, final String s) {
        final AccessibilityEvent h = this.H(fromIndex, 16);
        ((AccessibilityRecord)h).setBeforeText((CharSequence)beforeText);
        ((AccessibilityRecord)h).getText().add((Object)s);
        for (fromIndex = 0; fromIndex < beforeText.length() && fromIndex < s.length() && beforeText.charAt(fromIndex) == s.charAt(fromIndex); ++fromIndex) {}
        if (fromIndex >= beforeText.length() && fromIndex >= s.length()) {
            return null;
        }
        ((AccessibilityRecord)h).setFromIndex(fromIndex);
        int n;
        int n2;
        for (n = beforeText.length() - 1, n2 = s.length() - 1; n >= fromIndex && n2 >= fromIndex && beforeText.charAt(n) == s.charAt(n2); --n, --n2) {}
        ((AccessibilityRecord)h).setRemovedCount(n - fromIndex + 1);
        ((AccessibilityRecord)h).setAddedCount(n2 - fromIndex + 1);
        return h;
    }
    
    private boolean w() {
        final Activity e = b2.i.e(this.a.getContext());
        boolean b2;
        final boolean b = b2 = false;
        if (e != null) {
            if (e.getWindow() == null) {
                b2 = b;
            }
            else {
                final int layoutInDisplayCutoutMode = e.getWindow().getAttributes().layoutInDisplayCutoutMode;
                if (layoutInDisplayCutoutMode != 2) {
                    b2 = b;
                    if (layoutInDisplayCutoutMode != 0) {
                        return b2;
                    }
                }
                b2 = true;
            }
        }
        return b2;
    }
    
    private Rect y(Rect rect) {
        rect = new Rect(rect);
        final int[] array = new int[2];
        this.a.getLocationOnScreen(array);
        rect.offset(array[0], array[1]);
        return rect;
    }
    
    private h z(final int n) {
        h h;
        if ((h = (h)this.h.get((Object)n)) == null) {
            h = new h();
            h.b = n;
            h.a = io.flutter.view.g.B + n;
            this.h.put((Object)n, (Object)h);
        }
        return h;
    }
    
    public boolean D() {
        return this.c.isEnabled();
    }
    
    public boolean E() {
        return this.c.isTouchExplorationEnabled();
    }
    
    public AccessibilityNodeInfo I(final View view, final int n) {
        return AccessibilityNodeInfo.obtain(view, n);
    }
    
    public boolean J(final MotionEvent motionEvent) {
        return this.K(motionEvent, false);
    }
    
    public boolean K(final MotionEvent motionEvent, final boolean b) {
        if (!this.c.isTouchExplorationEnabled()) {
            return false;
        }
        if (this.g.isEmpty()) {
            return false;
        }
        final l j = this.B().w0(new float[] { motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f }, b);
        if (j != null && j.i != -1) {
            return !b && this.d.onAccessibilityHoverEvent(j.b, motionEvent);
        }
        if (motionEvent.getAction() != 9 && motionEvent.getAction() != 7) {
            if (motionEvent.getAction() != 10) {
                final StringBuilder sb = new StringBuilder();
                sb.append("unexpected accessibility hover event: ");
                sb.append((Object)motionEvent);
                b.a("flutter", sb.toString());
                return false;
            }
            this.L();
        }
        else {
            this.C(motionEvent.getX(), motionEvent.getY(), b);
        }
        return true;
    }
    
    public void Q() {
        this.u = true;
        this.e.d();
        this.Y(null);
        this.c.removeAccessibilityStateChangeListener(this.w);
        this.c.removeTouchExplorationStateChangeListener(this.x);
        this.f.unregisterContentObserver(this.y);
        this.b.g((a$b)null);
    }
    
    public void Y(final k s) {
        this.s = s;
    }
    
    void a0(final ByteBuffer byteBuffer, final String[] array) {
        while (((Buffer)byteBuffer).hasRemaining()) {
            final h z = this.z(byteBuffer.getInt());
            z.c = byteBuffer.getInt();
            final int int1 = byteBuffer.getInt();
            final String s = null;
            String s2;
            if (int1 == -1) {
                s2 = null;
            }
            else {
                s2 = array[int1];
            }
            z.d = s2;
            final int int2 = byteBuffer.getInt();
            String s3;
            if (int2 == -1) {
                s3 = s;
            }
            else {
                s3 = array[int2];
            }
            z.e = s3;
        }
    }
    
    void b0(final ByteBuffer byteBuffer, final String[] array, final ByteBuffer[] array2) {
        final ArrayList list = new ArrayList();
        while (((Buffer)byteBuffer).hasRemaining()) {
            final l a = this.A(byteBuffer.getInt());
            a.D0(byteBuffer, array, array2);
            if (a.v0(io.flutter.view.g.i.s)) {
                continue;
            }
            if (a.v0(io.flutter.view.g.i.k)) {
                this.m = a;
            }
            if (a.B) {
                list.add((Object)a);
            }
            if (a.i == -1 || this.e.b(a.i)) {
                continue;
            }
            final View c = this.e.c(a.i);
            if (c == null) {
                continue;
            }
            c.setImportantForAccessibility(0);
        }
        final HashSet set = new HashSet();
        final l b = this.B();
        final ArrayList list2 = new ArrayList();
        if (b != null) {
            final float[] array3 = new float[16];
            Matrix.setIdentityM(array3, 0);
            final int sdk_INT = Build$VERSION.SDK_INT;
            if (sdk_INT >= 23 && (sdk_INT < 28 || this.w())) {
                final WindowInsets a2 = androidx.core.view.l.a(this.a);
                if (a2 != null) {
                    if (!this.r.equals((Object)a2.getSystemWindowInsetLeft())) {
                        b.Y = true;
                        b.W = true;
                    }
                    final Integer value = a2.getSystemWindowInsetLeft();
                    this.r = value;
                    Matrix.translateM(array3, 0, (float)value, 0.0f, 0.0f);
                }
            }
            b.C0(array3, (Set<l>)set, false);
            b.e0((List<l>)list2);
        }
        final Iterator iterator = ((List)list2).iterator();
        l l = null;
        while (iterator.hasNext()) {
            final l i = (l)iterator.next();
            if (!this.p.contains((Object)i.b)) {
                l = i;
            }
        }
        l j;
        if ((j = l) == null) {
            j = l;
            if (((List)list2).size() > 0) {
                j = (l)((List)list2).get(((List)list2).size() - 1);
            }
        }
        if (j != null && (j.b != this.q || ((List)list2).size() != this.p.size())) {
            this.q = j.b;
            this.M(j);
        }
        this.p.clear();
        final Iterator iterator2 = ((List)list2).iterator();
        while (iterator2.hasNext()) {
            this.p.add((Object)((l)iterator2.next()).b);
        }
        final Iterator iterator3 = this.g.entrySet().iterator();
        while (iterator3.hasNext()) {
            final l k = (l)((Map$Entry)iterator3.next()).getValue();
            if (!((Set)set).contains((Object)k)) {
                this.c0(k);
                iterator3.remove();
            }
        }
        this.U(0);
        for (final l m : list) {
            if (m.h0()) {
                final AccessibilityEvent h = this.H(m.b, 4096);
                final float r = m.l;
                float s = m.m;
                float n = r;
                if (Float.isInfinite(m.m)) {
                    n = r;
                    if (r > 70000.0f) {
                        n = 70000.0f;
                    }
                    s = 100000.0f;
                }
                float n4;
                float n5;
                if (Float.isInfinite(m.n)) {
                    final float n2 = s + 100000.0f;
                    float n3 = n;
                    if (n < -70000.0f) {
                        n3 = -70000.0f;
                    }
                    n4 = n3 + 100000.0f;
                    n5 = n2;
                }
                else {
                    n5 = s - m.n;
                    n4 = n - m.n;
                }
                if (!m.s0(io.flutter.view.g.g.j) && !m.s0(io.flutter.view.g.g.k)) {
                    if (m.s0(io.flutter.view.g.g.h) || m.s0(io.flutter.view.g.g.i)) {
                        ((AccessibilityRecord)h).setScrollX((int)n4);
                        ((AccessibilityRecord)h).setMaxScrollX((int)n5);
                    }
                }
                else {
                    ((AccessibilityRecord)h).setScrollY((int)n4);
                    ((AccessibilityRecord)h).setMaxScrollY((int)n5);
                }
                if (m.j > 0) {
                    ((AccessibilityRecord)h).setItemCount(m.j);
                    ((AccessibilityRecord)h).setFromIndex(m.k);
                    final Iterator iterator5 = m.S.iterator();
                    int n6 = 0;
                    while (iterator5.hasNext()) {
                        if (!((l)iterator5.next()).v0(io.flutter.view.g.i.s)) {
                            ++n6;
                        }
                    }
                    ((AccessibilityRecord)h).setToIndex(m.k + n6 - 1);
                }
                this.S(h);
            }
            if (m.v0(io.flutter.view.g.i.u) && m.g0()) {
                this.U(m.b);
            }
            final l i2 = this.i;
            if (i2 != null && i2.b == m.b) {
                final i h2 = io.flutter.view.g.i.h;
                if (!m.t0(h2) && m.v0(h2)) {
                    final AccessibilityEvent h3 = this.H(m.b, 4);
                    ((AccessibilityRecord)h3).getText().add((Object)m.o);
                    this.S(h3);
                }
            }
            final l m2 = this.m;
            Label_1088: {
                if (m2 != null && m2.b == m.b) {
                    final l n7 = this.n;
                    if (n7 == null || n7.b != this.m.b) {
                        this.n = this.m;
                        this.S(this.H(m.b, 8));
                        break Label_1088;
                    }
                }
                if (this.m == null) {
                    this.n = null;
                }
            }
            final l m3 = this.m;
            if (m3 != null && m3.b == m.b) {
                final i j2 = io.flutter.view.g.i.j;
                if (!m.t0(j2) || !m.v0(j2)) {
                    continue;
                }
                final l i3 = this.i;
                if (i3 != null && i3.b != this.m.b) {
                    continue;
                }
                final String a3 = m.J;
                String q = "";
                String a4;
                if (a3 != null) {
                    a4 = m.J;
                }
                else {
                    a4 = "";
                }
                if (m.q != null) {
                    q = m.q;
                }
                final AccessibilityEvent v = this.v(m.b, a4, q);
                if (v != null) {
                    this.S(v);
                }
                if (m.E == m.g && m.F == m.h) {
                    continue;
                }
                final AccessibilityEvent h4 = this.H(m.b, 8192);
                ((AccessibilityRecord)h4).getText().add((Object)q);
                ((AccessibilityRecord)h4).setFromIndex(m.g);
                ((AccessibilityRecord)h4).setToIndex(m.h);
                ((AccessibilityRecord)h4).setItemCount(q.length());
                this.S(h4);
            }
        }
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(final int n) {
        final boolean b = true;
        this.W(true);
        if (n >= 65536) {
            return this.d.createAccessibilityNodeInfo(n);
        }
        if (n == -1) {
            final AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.a);
            this.a.onInitializeAccessibilityNodeInfo(obtain);
            if (this.g.containsKey((Object)0)) {
                obtain.addChild(this.a, 0);
            }
            return obtain;
        }
        final l l = (l)this.g.get((Object)n);
        if (l == null) {
            return null;
        }
        if (l.i == -1 || !this.e.b(l.i)) {
            final AccessibilityNodeInfo i = this.I(this.a, n);
            final int sdk_INT = Build$VERSION.SDK_INT;
            final String s = "";
            i.setViewIdResourceName("");
            i.setPackageName((CharSequence)this.a.getContext().getPackageName());
            i.setClassName((CharSequence)"android.view.View");
            i.setSource(this.a, n);
            i.setFocusable(l.x0());
            final l m = this.m;
            if (m != null) {
                i.setFocused(m.b == n);
            }
            final l j = this.i;
            if (j != null) {
                i.setAccessibilityFocused(j.b == n);
            }
            final i k = io.flutter.view.g.i.j;
            if (l.v0(k)) {
                i.setPassword(l.v0(io.flutter.view.g.i.p));
                final i z = io.flutter.view.g.i.z;
                if (!l.v0(z)) {
                    i.setClassName((CharSequence)"android.widget.EditText");
                }
                i.setEditable(l.v0(z) ^ true);
                if (l.g != -1 && l.h != -1) {
                    i.setTextSelection(l.g, l.h);
                }
                final l i2 = this.i;
                if (i2 != null && i2.b == n) {
                    i.setLiveRegion(1);
                }
                boolean b2;
                if (l.u0(io.flutter.view.g.g.o)) {
                    i.addAction(256);
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                int n2 = b2 ? 1 : 0;
                if (l.u0(io.flutter.view.g.g.p)) {
                    i.addAction(512);
                    n2 = ((b2 ? 1 : 0) | 0x1);
                }
                int n3 = n2;
                if (l.u0(io.flutter.view.g.g.y)) {
                    i.addAction(256);
                    n3 = (n2 | 0x2);
                }
                int movementGranularities = n3;
                if (l.u0(io.flutter.view.g.g.z)) {
                    i.addAction(512);
                    movementGranularities = (n3 | 0x2);
                }
                i.setMovementGranularities(movementGranularities);
                if (l.e >= 0) {
                    int length;
                    if (l.q == null) {
                        length = 0;
                    }
                    else {
                        length = l.q.length();
                    }
                    l.f;
                    l.e;
                    i.setMaxTextLength(length - l.f + l.e);
                }
            }
            if (l.u0(io.flutter.view.g.g.q)) {
                i.addAction(131072);
            }
            if (l.u0(io.flutter.view.g.g.r)) {
                i.addAction(16384);
            }
            if (l.u0(io.flutter.view.g.g.s)) {
                i.addAction(65536);
            }
            if (l.u0(io.flutter.view.g.g.t)) {
                i.addAction(32768);
            }
            if (l.u0(io.flutter.view.g.g.A)) {
                i.addAction(2097152);
            }
            if (l.v0(io.flutter.view.g.i.i) || l.v0(io.flutter.view.g.i.B)) {
                i.setClassName((CharSequence)"android.widget.Button");
            }
            if (l.v0(io.flutter.view.g.i.t)) {
                i.setClassName((CharSequence)"android.widget.ImageView");
            }
            if (l.u0(io.flutter.view.g.g.x)) {
                i.setDismissable(true);
                i.addAction(1048576);
            }
            if (l.Q != null) {
                i.setParent(this.a, l.Q.b);
            }
            else {
                i.setParent(this.a);
            }
            if (l.z != -1 && sdk_INT >= 22) {
                io.flutter.view.a.a(i, this.a, l.z);
            }
            final Rect f = l.k0();
            if (l.Q != null) {
                final Rect f2 = l.Q.k0();
                final Rect boundsInParent = new Rect(f);
                boundsInParent.offset(-f2.left, -f2.top);
                i.setBoundsInParent(boundsInParent);
            }
            else {
                i.setBoundsInParent(f);
            }
            i.setBoundsInScreen(this.y(f));
            i.setVisibleToUser(true);
            i.setEnabled(!l.v0(io.flutter.view.g.i.l) || l.v0(io.flutter.view.g.i.m));
            if (l.u0(io.flutter.view.g.g.f)) {
                if (l.U != null) {
                    i.addAction(new AccessibilityNodeInfo$AccessibilityAction(16, (CharSequence)l.U.e));
                    i.setClickable(true);
                }
                else {
                    i.addAction(16);
                    i.setClickable(true);
                }
            }
            if (l.u0(io.flutter.view.g.g.g)) {
                if (l.V != null) {
                    i.addAction(new AccessibilityNodeInfo$AccessibilityAction(32, (CharSequence)l.V.e));
                    i.setLongClickable(true);
                }
                else {
                    i.addAction(32);
                    i.setLongClickable(true);
                }
            }
            final g h = io.flutter.view.g.g.h;
            if (l.u0(h) || l.u0(io.flutter.view.g.g.j) || l.u0(io.flutter.view.g.g.i) || l.u0(io.flutter.view.g.g.k)) {
                i.setScrollable(true);
                if (l.v0(io.flutter.view.g.i.x)) {
                    if (!l.u0(h) && !l.u0(io.flutter.view.g.g.i)) {
                        if (this.Z(l)) {
                            i.setCollectionInfo(AccessibilityNodeInfo$CollectionInfo.obtain(l.j, 0, false));
                        }
                        else {
                            i.setClassName((CharSequence)"android.widget.ScrollView");
                        }
                    }
                    else if (this.Z(l)) {
                        i.setCollectionInfo(AccessibilityNodeInfo$CollectionInfo.obtain(0, l.j, false));
                    }
                    else {
                        i.setClassName((CharSequence)"android.widget.HorizontalScrollView");
                    }
                }
                if (l.u0(h) || l.u0(io.flutter.view.g.g.j)) {
                    i.addAction(4096);
                }
                if (l.u0(io.flutter.view.g.g.i) || l.u0(io.flutter.view.g.g.k)) {
                    i.addAction(8192);
                }
            }
            final g l2 = io.flutter.view.g.g.l;
            if (l.u0(l2) || l.u0(io.flutter.view.g.g.m)) {
                i.setClassName((CharSequence)"android.widget.SeekBar");
                if (l.u0(l2)) {
                    i.addAction(4096);
                }
                if (l.u0(io.flutter.view.g.g.m)) {
                    i.addAction(8192);
                }
            }
            if (l.v0(io.flutter.view.g.i.u)) {
                i.setLiveRegion(1);
            }
            if (l.v0(k)) {
                i.setText(l.q0());
                if (sdk_INT >= 28) {
                    io.flutter.view.b.a(i, l.p0());
                }
            }
            else if (!l.v0(io.flutter.view.g.i.q)) {
                Object contentDescription;
                final CharSequence charSequence = (CharSequence)(contentDescription = l.r0());
                if (sdk_INT < 28) {
                    contentDescription = charSequence;
                    if (l.y != null) {
                        Object o = s;
                        if (charSequence != null) {
                            o = charSequence;
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append(o);
                        sb.append("\n");
                        sb.append(l.y);
                        contentDescription = sb.toString();
                    }
                }
                if (contentDescription != null) {
                    i.setContentDescription((CharSequence)contentDescription);
                }
            }
            if (sdk_INT >= 28 && l.y != null) {
                io.flutter.view.c.a(i, (CharSequence)l.y);
            }
            final boolean h2 = l.v0(io.flutter.view.g.i.f);
            final boolean h3 = l.v0(io.flutter.view.g.i.v);
            boolean checkable = b;
            if (!h2) {
                checkable = (h3 && b);
            }
            i.setCheckable(checkable);
            if (h2) {
                i.setChecked(l.v0(io.flutter.view.g.i.g));
                if (l.v0(io.flutter.view.g.i.n)) {
                    i.setClassName((CharSequence)"android.widget.RadioButton");
                }
                else {
                    i.setClassName((CharSequence)"android.widget.CheckBox");
                }
            }
            else if (h3) {
                i.setChecked(l.v0(io.flutter.view.g.i.w));
                i.setClassName((CharSequence)"android.widget.Switch");
            }
            i.setSelected(l.v0(io.flutter.view.g.i.h));
            if (sdk_INT >= 28) {
                io.flutter.view.d.a(i, l.v0(io.flutter.view.g.i.o));
            }
            final l i3 = this.i;
            if (i3 != null && i3.b == n) {
                i.addAction(128);
            }
            else {
                i.addAction(64);
            }
            if (l.T != null) {
                for (final h h4 : l.T) {
                    i.addAction(new AccessibilityNodeInfo$AccessibilityAction(h4.a, (CharSequence)h4.d));
                }
            }
            for (final l l3 : l.R) {
                if (l3.v0(io.flutter.view.g.i.s)) {
                    continue;
                }
                if (l3.i != -1) {
                    final View c = this.e.c(l3.i);
                    if (!this.e.b(l3.i)) {
                        i.addChild(c);
                        continue;
                    }
                }
                i.addChild(this.a, l3.b);
            }
            return i;
        }
        final View c2 = this.e.c(l.i);
        if (c2 == null) {
            return null;
        }
        return this.d.getRootNode(c2, l.b, l.k0());
    }
    
    public AccessibilityNodeInfo findFocus(final int n) {
        if (n != 1) {
            if (n != 2) {
                return null;
            }
        }
        else {
            final l m = this.m;
            if (m != null) {
                return this.createAccessibilityNodeInfo(m.b);
            }
            final Integer k = this.k;
            if (k != null) {
                return this.createAccessibilityNodeInfo(k);
            }
        }
        final l i = this.i;
        if (i != null) {
            return this.createAccessibilityNodeInfo(i.b);
        }
        final Integer j = this.j;
        if (j != null) {
            return this.createAccessibilityNodeInfo(j);
        }
        return null;
    }
    
    public boolean performAction(final int n, int n2, final Bundle bundle) {
        if (n >= 65536) {
            final boolean performAction = this.d.performAction(n, n2, bundle);
            if (performAction && n2 == 128) {
                this.j = null;
            }
            return performAction;
        }
        final l i = (l)this.g.get((Object)n);
        final int n3 = 0;
        if (i == null) {
            return false;
        }
        switch (n2) {
            default: {
                final h h = (h)this.h.get((Object)(n2 - io.flutter.view.g.B));
                if (h != null) {
                    this.b.c(n, io.flutter.view.g.g.w, (Object)h.b);
                    return true;
                }
                return false;
            }
            case 16908342: {
                this.b.b(n, io.flutter.view.g.g.n);
                return true;
            }
            case 2097152: {
                return this.O(i, n, bundle);
            }
            case 1048576: {
                this.b.b(n, io.flutter.view.g.g.x);
                return true;
            }
            case 131072: {
                final HashMap hashMap = new HashMap();
                n2 = n3;
                if (bundle != null) {
                    n2 = n3;
                    if (((BaseBundle)bundle).containsKey("ACTION_ARGUMENT_SELECTION_START_INT")) {
                        n2 = n3;
                        if (((BaseBundle)bundle).containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                            n2 = 1;
                        }
                    }
                }
                if (n2 != 0) {
                    ((Map)hashMap).put((Object)"base", (Object)((BaseBundle)bundle).getInt("ACTION_ARGUMENT_SELECTION_START_INT"));
                    ((Map)hashMap).put((Object)"extent", (Object)((BaseBundle)bundle).getInt("ACTION_ARGUMENT_SELECTION_END_INT"));
                }
                else {
                    ((Map)hashMap).put((Object)"base", (Object)i.h);
                    ((Map)hashMap).put((Object)"extent", (Object)i.h);
                }
                this.b.c(n, io.flutter.view.g.g.q, (Object)hashMap);
                final l l = (l)this.g.get((Object)n);
                l.g = (int)((Map)hashMap).get((Object)"base");
                l.h = (int)((Map)hashMap).get((Object)"extent");
                return true;
            }
            case 65536: {
                this.b.b(n, io.flutter.view.g.g.s);
                return true;
            }
            case 32768: {
                this.b.b(n, io.flutter.view.g.g.t);
                return true;
            }
            case 16384: {
                this.b.b(n, io.flutter.view.g.g.r);
                return true;
            }
            case 8192: {
                final g k = io.flutter.view.g.g.k;
                if (i.u0(k)) {
                    this.b.b(n, k);
                }
                else {
                    final g j = io.flutter.view.g.g.i;
                    if (i.u0(j)) {
                        this.b.b(n, j);
                    }
                    else {
                        final g m = io.flutter.view.g.g.m;
                        if (!i.u0(m)) {
                            return false;
                        }
                        i.q = i.u;
                        i.r = i.v;
                        this.R(n, 4);
                        this.b.b(n, m);
                    }
                }
                return true;
            }
            case 4096: {
                final g j2 = io.flutter.view.g.g.j;
                if (i.u0(j2)) {
                    this.b.b(n, j2);
                }
                else {
                    final g h2 = io.flutter.view.g.g.h;
                    if (i.u0(h2)) {
                        this.b.b(n, h2);
                    }
                    else {
                        final g l2 = io.flutter.view.g.g.l;
                        if (!i.u0(l2)) {
                            return false;
                        }
                        i.q = i.s;
                        i.r = i.t;
                        this.R(n, 4);
                        this.b.b(n, l2);
                    }
                }
                return true;
            }
            case 512: {
                return this.N(i, n, bundle, false);
            }
            case 256: {
                return this.N(i, n, bundle, true);
            }
            case 128: {
                final l i2 = this.i;
                if (i2 != null && i2.b == n) {
                    this.i = null;
                }
                final Integer j3 = this.j;
                if (j3 != null && j3 == n) {
                    this.j = null;
                }
                this.b.b(n, io.flutter.view.g.g.v);
                this.R(n, 65536);
                return true;
            }
            case 64: {
                if (this.i == null) {
                    this.a.invalidate();
                }
                this.i = i;
                this.b.b(n, io.flutter.view.g.g.u);
                this.R(n, 32768);
                if (i.u0(io.flutter.view.g.g.l) || i.u0(io.flutter.view.g.g.m)) {
                    this.R(n, 4);
                }
                return true;
            }
            case 32: {
                this.b.b(n, io.flutter.view.g.g.g);
                return true;
            }
            case 16: {
                this.b.b(n, io.flutter.view.g.g.f);
                return true;
            }
        }
    }
    
    public boolean x(final View view, final View view2, final AccessibilityEvent accessibilityEvent) {
        if (!this.d.requestSendAccessibilityEvent(view, view2, accessibilityEvent)) {
            return false;
        }
        final Integer recordFlutterId = this.d.getRecordFlutterId(view, (AccessibilityRecord)accessibilityEvent);
        if (recordFlutterId == null) {
            return false;
        }
        final int eventType = accessibilityEvent.getEventType();
        if (eventType != 8) {
            if (eventType != 128) {
                if (eventType != 32768) {
                    if (eventType == 65536) {
                        this.k = null;
                        this.j = null;
                    }
                }
                else {
                    this.j = recordFlutterId;
                    this.i = null;
                }
            }
            else {
                this.o = null;
            }
        }
        else {
            this.k = recordFlutterId;
            this.m = null;
        }
        return true;
    }
    
    private enum f
    {
        f(1), 
        g(2), 
        h(4), 
        i(8), 
        j(16), 
        k(32), 
        l(64);
        
        private static final f[] m;
        final int e;
        
        private f(final int e) {
            this.e = e;
        }
    }
    
    public enum g
    {
        A(2097152);
        
        private static final g[] B;
        
        f(1), 
        g(2), 
        h(4), 
        i(8), 
        j(16), 
        k(32), 
        l(64), 
        m(128), 
        n(256), 
        o(512), 
        p(1024), 
        q(2048), 
        r(4096), 
        s(8192), 
        t(16384), 
        u(32768), 
        v(65536), 
        w(131072), 
        x(262144), 
        y(524288), 
        z(1048576);
        
        public final int e;
        
        private g(final int e) {
            this.e = e;
        }
    }
    
    private static class h
    {
        private int a;
        private int b;
        private int c;
        private String d;
        private String e;
        
        h() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
        }
    }
    
    enum i
    {
        A(2097152), 
        B(4194304), 
        C(8388608), 
        D(16777216), 
        E(33554432);
        
        private static final i[] F;
        
        f(1), 
        g(2), 
        h(4), 
        i(8), 
        j(16), 
        k(32), 
        l(64), 
        m(128), 
        n(256), 
        o(512), 
        p(1024), 
        q(2048), 
        r(4096), 
        s(8192), 
        t(16384), 
        u(32768), 
        v(65536), 
        w(131072), 
        x(262144), 
        y(524288), 
        z(1048576);
        
        final int e;
        
        private i(final int e) {
            this.e = e;
        }
    }
    
    public interface k
    {
        void a(final boolean p0, final boolean p1);
    }
    
    private static class l
    {
        private p A;
        private boolean B;
        private int C;
        private int D;
        private int E;
        private int F;
        private float G;
        private float H;
        private float I;
        private String J;
        private String K;
        private float L;
        private float M;
        private float N;
        private float O;
        private float[] P;
        private l Q;
        private List<l> R;
        private List<l> S;
        private List<h> T;
        private h U;
        private h V;
        private boolean W;
        private float[] X;
        private boolean Y;
        private float[] Z;
        final g a;
        private Rect a0;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private float l;
        private float m;
        private float n;
        private String o;
        private List<n> p;
        private String q;
        private List<n> r;
        private String s;
        private List<n> t;
        private String u;
        private List<n> v;
        private String w;
        private List<n> x;
        private String y;
        private int z;
        
        l(final g a) {
            this.b = -1;
            this.z = -1;
            this.B = false;
            this.R = (List<l>)new ArrayList();
            this.S = (List<l>)new ArrayList();
            this.W = true;
            this.Y = true;
            this.a = a;
        }
        
        private static boolean A0(final l l, final b2.e<l> e) {
            return l != null && l.j0(e) != null;
        }
        
        private void B0(final float[] array, final float[] array2, final float[] array3) {
            Matrix.multiplyMV(array, 0, array2, 0, array3, 0);
            final float n = array[3];
            array[0] /= n;
            array[1] /= n;
            array[2] /= n;
            array[3] = 0.0f;
        }
        
        private void C0(float[] array, final Set<l> set, boolean b) {
            set.add((Object)this);
            if (this.Y) {
                b = true;
            }
            if (b) {
                if (this.Z == null) {
                    this.Z = new float[16];
                }
                if (this.P == null) {
                    this.P = new float[16];
                }
                Matrix.multiplyMM(this.Z, 0, array, 0, this.P, 0);
                final float[] array2 = { 0.0f, 0.0f, 0.0f, 1.0f };
                final float[] array3 = new float[4];
                final float[] array4 = new float[4];
                array = new float[4];
                final float[] array5 = new float[4];
                array2[0] = this.L;
                array2[1] = this.M;
                this.B0(array3, this.Z, array2);
                array2[0] = this.N;
                array2[1] = this.M;
                this.B0(array4, this.Z, array2);
                array2[0] = this.N;
                array2[1] = this.O;
                this.B0(array, this.Z, array2);
                array2[0] = this.L;
                array2[1] = this.O;
                this.B0(array5, this.Z, array2);
                if (this.a0 == null) {
                    this.a0 = new Rect();
                }
                this.a0.set(Math.round(this.z0(array3[0], array4[0], array[0], array5[0])), Math.round(this.z0(array3[1], array4[1], array[1], array5[1])), Math.round(this.y0(array3[0], array4[0], array[0], array5[0])), Math.round(this.y0(array3[1], array4[1], array[1], array5[1])));
                this.Y = false;
            }
            int b2 = -1;
            for (final l l : this.R) {
                l.z = b2;
                b2 = l.b;
                l.C0(this.Z, set, b);
            }
        }
        
        private void D0(final ByteBuffer byteBuffer, final String[] array, final ByteBuffer[] array2) {
            this.B = true;
            this.J = this.q;
            this.K = this.o;
            this.C = this.c;
            this.D = this.d;
            this.E = this.g;
            this.F = this.h;
            this.G = this.l;
            this.H = this.m;
            this.I = this.n;
            this.c = byteBuffer.getInt();
            this.d = byteBuffer.getInt();
            this.e = byteBuffer.getInt();
            this.f = byteBuffer.getInt();
            this.g = byteBuffer.getInt();
            this.h = byteBuffer.getInt();
            this.i = byteBuffer.getInt();
            this.j = byteBuffer.getInt();
            this.k = byteBuffer.getInt();
            this.l = byteBuffer.getFloat();
            this.m = byteBuffer.getFloat();
            this.n = byteBuffer.getFloat();
            final int int1 = byteBuffer.getInt();
            String o;
            if (int1 == -1) {
                o = null;
            }
            else {
                o = array[int1];
            }
            this.o = o;
            this.p = this.o0(byteBuffer, array2);
            final int int2 = byteBuffer.getInt();
            String q;
            if (int2 == -1) {
                q = null;
            }
            else {
                q = array[int2];
            }
            this.q = q;
            this.r = this.o0(byteBuffer, array2);
            final int int3 = byteBuffer.getInt();
            String s;
            if (int3 == -1) {
                s = null;
            }
            else {
                s = array[int3];
            }
            this.s = s;
            this.t = this.o0(byteBuffer, array2);
            final int int4 = byteBuffer.getInt();
            String u;
            if (int4 == -1) {
                u = null;
            }
            else {
                u = array[int4];
            }
            this.u = u;
            this.v = this.o0(byteBuffer, array2);
            final int int5 = byteBuffer.getInt();
            String w;
            if (int5 == -1) {
                w = null;
            }
            else {
                w = array[int5];
            }
            this.w = w;
            this.x = this.o0(byteBuffer, array2);
            final int int6 = byteBuffer.getInt();
            String y;
            if (int6 == -1) {
                y = null;
            }
            else {
                y = array[int6];
            }
            this.y = y;
            this.A = io.flutter.view.g.p.d(byteBuffer.getInt());
            this.L = byteBuffer.getFloat();
            this.M = byteBuffer.getFloat();
            this.N = byteBuffer.getFloat();
            this.O = byteBuffer.getFloat();
            if (this.P == null) {
                this.P = new float[16];
            }
            final int n = 0;
            for (int i = 0; i < 16; ++i) {
                this.P[i] = byteBuffer.getFloat();
            }
            this.W = true;
            this.Y = true;
            final int int7 = byteBuffer.getInt();
            this.R.clear();
            this.S.clear();
            for (int j = 0; j < int7; ++j) {
                final l o2 = this.a.A(byteBuffer.getInt());
                o2.Q = this;
                this.R.add((Object)o2);
            }
            for (int k = 0; k < int7; ++k) {
                final l o3 = this.a.A(byteBuffer.getInt());
                o3.Q = this;
                this.S.add((Object)o3);
            }
            final int int8 = byteBuffer.getInt();
            if (int8 == 0) {
                this.T = null;
            }
            else {
                final List<h> t = this.T;
                int l;
                if (t == null) {
                    this.T = (List<h>)new ArrayList(int8);
                    l = n;
                }
                else {
                    t.clear();
                    l = n;
                }
                while (l < int8) {
                    final h q2 = this.a.z(byteBuffer.getInt());
                    if (q2.c == io.flutter.view.g.g.f.e) {
                        this.U = q2;
                    }
                    else if (q2.c == io.flutter.view.g.g.g.e) {
                        this.V = q2;
                    }
                    else {
                        this.T.add((Object)q2);
                    }
                    this.T.add((Object)q2);
                    ++l;
                }
            }
        }
        
        private void e0(final List<l> list) {
            if (this.v0(io.flutter.view.g.i.q)) {
                list.add((Object)this);
            }
            final Iterator iterator = this.R.iterator();
            while (iterator.hasNext()) {
                ((l)iterator.next()).e0(list);
            }
        }
        
        private SpannableString f0(final String s, final List<n> list) {
            if (s == null) {
                return null;
            }
            final SpannableString spannableString = new SpannableString((CharSequence)s);
            if (list != null) {
                for (final n n : list) {
                    final int n2 = g$e.a[n.c.ordinal()];
                    if (n2 != 1) {
                        if (n2 != 2) {
                            continue;
                        }
                        spannableString.setSpan((Object)new LocaleSpan(Locale.forLanguageTag(((g$j)n).d)), n.a, n.b, 0);
                    }
                    else {
                        spannableString.setSpan((Object)new TtsSpan$Builder("android.type.verbatim").build(), n.a, n.b, 0);
                    }
                }
            }
            return spannableString;
        }
        
        private boolean g0() {
            final String o = this.o;
            boolean b = false;
            if (o == null && this.K == null) {
                return false;
            }
            if (o != null) {
                final String k = this.K;
                if (k != null && o.equals((Object)k)) {
                    return b;
                }
            }
            b = true;
            return b;
        }
        
        private boolean h0() {
            return !Float.isNaN(this.l) && !Float.isNaN(this.G) && this.G != this.l;
        }
        
        private void i0() {
            if (!this.W) {
                return;
            }
            this.W = false;
            if (this.X == null) {
                this.X = new float[16];
            }
            if (!Matrix.invertM(this.X, 0, this.P, 0)) {
                Arrays.fill(this.X, 0.0f);
            }
        }
        
        private l j0(final b2.e<l> e) {
            for (l l = this.Q; l != null; l = l.Q) {
                if (e.test((Object)l)) {
                    return l;
                }
            }
            return null;
        }
        
        private Rect k0() {
            return this.a0;
        }
        
        private CharSequence l0() {
            return (CharSequence)this.f0(this.w, this.x);
        }
        
        static /* synthetic */ int m(final l l, int h) {
            h += l.h;
            return l.h = h;
        }
        
        private CharSequence m0() {
            return (CharSequence)this.f0(this.o, this.p);
        }
        
        static /* synthetic */ int n(final l l, int h) {
            h = l.h - h;
            return l.h = h;
        }
        
        private String n0() {
            if (this.v0(io.flutter.view.g.i.r)) {
                final String o = this.o;
                if (o != null && !o.isEmpty()) {
                    return this.o;
                }
            }
            final Iterator iterator = this.R.iterator();
            while (iterator.hasNext()) {
                final String n0 = ((l)iterator.next()).n0();
                if (n0 != null && !n0.isEmpty()) {
                    return n0;
                }
            }
            return null;
        }
        
        private List<n> o0(final ByteBuffer byteBuffer, final ByteBuffer[] array) {
            final int int1 = byteBuffer.getInt();
            if (int1 == -1) {
                return null;
            }
            final ArrayList list = new ArrayList(int1);
            for (int i = 0; i < int1; ++i) {
                final int int2 = byteBuffer.getInt();
                final int int3 = byteBuffer.getInt();
                final o o = io.flutter.view.g.o.values()[byteBuffer.getInt()];
                final int n = g$e.a[o.ordinal()];
                if (n != 1) {
                    if (n == 2) {
                        final ByteBuffer byteBuffer2 = array[byteBuffer.getInt()];
                        final g$j g$j = new g$j((g$a)null);
                        ((n)g$j).a = int2;
                        ((n)g$j).b = int3;
                        ((n)g$j).c = o;
                        g$j.d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                        ((List)list).add((Object)g$j);
                    }
                }
                else {
                    byteBuffer.getInt();
                    final g$m g$m = new g$m((g$a)null);
                    ((n)g$m).a = int2;
                    ((n)g$m).b = int3;
                    ((n)g$m).c = o;
                    ((List)list).add((Object)g$m);
                }
            }
            return (List<n>)list;
        }
        
        private CharSequence p0() {
            final CharSequence m0 = this.m0();
            final CharSequence l0 = this.l0();
            CharSequence charSequence = null;
            CharSequence concat;
            for (int i = 0; i < 2; ++i, charSequence = concat) {
                final CharSequence charSequence2 = (new CharSequence[] { m0, l0 })[i];
                concat = charSequence;
                if (charSequence2 != null) {
                    concat = charSequence;
                    if (charSequence2.length() > 0) {
                        if (charSequence != null && charSequence.length() != 0) {
                            concat = TextUtils.concat(new CharSequence[] { charSequence, (CharSequence)", ", charSequence2 });
                        }
                        else {
                            concat = charSequence2;
                        }
                    }
                }
            }
            return charSequence;
        }
        
        private CharSequence q0() {
            return (CharSequence)this.f0(this.q, this.r);
        }
        
        private CharSequence r0() {
            final CharSequence q0 = this.q0();
            final CharSequence m0 = this.m0();
            final CharSequence l0 = this.l0();
            CharSequence charSequence = null;
            CharSequence concat;
            for (int i = 0; i < 3; ++i, charSequence = concat) {
                final CharSequence charSequence2 = (new CharSequence[] { q0, m0, l0 })[i];
                concat = charSequence;
                if (charSequence2 != null) {
                    concat = charSequence;
                    if (charSequence2.length() > 0) {
                        if (charSequence != null && charSequence.length() != 0) {
                            concat = TextUtils.concat(new CharSequence[] { charSequence, (CharSequence)", ", charSequence2 });
                        }
                        else {
                            concat = charSequence2;
                        }
                    }
                }
            }
            return charSequence;
        }
        
        private boolean s0(final g g) {
            return (g.e & this.D) != 0x0;
        }
        
        private boolean t0(final i i) {
            return (i.e & this.C) != 0x0;
        }
        
        private boolean u0(final g g) {
            return (g.e & this.d) != 0x0;
        }
        
        private boolean v0(final i i) {
            return (i.e & this.c) != 0x0;
        }
        
        private l w0(final float[] array, final boolean b) {
            final float n = array[3];
            final boolean b2 = false;
            final float n2 = array[0] / n;
            final float n3 = array[1] / n;
            final float l = this.L;
            l j;
            final l i = j = null;
            if (n2 >= l) {
                j = i;
                if (n2 < this.N) {
                    j = i;
                    if (n3 >= this.M) {
                        if (n3 >= this.O) {
                            j = i;
                        }
                        else {
                            final float[] array2 = new float[4];
                            for (final l k : this.S) {
                                if (k.v0(io.flutter.view.g.i.s)) {
                                    continue;
                                }
                                k.i0();
                                Matrix.multiplyMV(array2, 0, k.X, 0, array, 0);
                                final l w0 = k.w0(array2, b);
                                if (w0 != null) {
                                    return w0;
                                }
                            }
                            int n4 = b2 ? 1 : 0;
                            if (b) {
                                n4 = (b2 ? 1 : 0);
                                if (this.i != -1) {
                                    n4 = 1;
                                }
                            }
                            if (!this.x0()) {
                                j = i;
                                if (n4 == 0) {
                                    return j;
                                }
                            }
                            j = this;
                        }
                    }
                }
            }
            return j;
        }
        
        private boolean x0() {
            final boolean v0 = this.v0(io.flutter.view.g.i.q);
            final boolean b = false;
            if (v0) {
                return false;
            }
            if (this.v0(io.flutter.view.g.i.A)) {
                return true;
            }
            if ((this.d & ~io.flutter.view.g.z) == 0x0 && (this.c & io.flutter.view.g.A) == 0x0) {
                final String o = this.o;
                if (o == null || o.isEmpty()) {
                    final String q = this.q;
                    if (q == null || q.isEmpty()) {
                        final String w = this.w;
                        boolean b2 = b;
                        if (w == null) {
                            return b2;
                        }
                        b2 = b;
                        if (w.isEmpty()) {
                            return b2;
                        }
                    }
                }
            }
            return true;
        }
        
        private float y0(final float n, final float n2, final float n3, final float n4) {
            return Math.max(n, Math.max(n2, Math.max(n3, n4)));
        }
        
        private float z0(final float n, final float n2, final float n3, final float n4) {
            return Math.min(n, Math.min(n2, Math.min(n3, n4)));
        }
    }
    
    private static class n
    {
        int a;
        int b;
        o c;
    }
    
    private enum o
    {
        e, 
        f;
        
        private static final o[] g;
    }
    
    private enum p
    {
        e, 
        f, 
        g;
        
        private static final p[] h;
        
        public static p d(final int n) {
            if (n == 1) {
                return p.g;
            }
            if (n != 2) {
                return p.e;
            }
            return p.f;
        }
    }
}
