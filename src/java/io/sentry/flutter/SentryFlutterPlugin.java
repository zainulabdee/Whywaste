package io.sentry.flutter;

import java.util.Collection;
import java.lang.ref.Reference;
import k1.a$b;
import l1.c;
import j2.f;
import java.io.File;
import java.util.UUID;
import io.sentry.s2;
import java.util.LinkedHashMap;
import io.sentry.protocol.DebugImage;
import java.util.ArrayList;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.c3$a;
import io.sentry.android.core.e1;
import io.sentry.j3;
import io.sentry.android.core.j0;
import android.util.Log;
import d2.a0;
import c2.n;
import io.sentry.protocol.q;
import java.util.List;
import t1.j;
import java.util.Iterator;
import java.util.Set;
import io.sentry.protocol.r;
import io.sentry.q4;
import io.sentry.c3;
import io.sentry.e;
import io.sentry.h0;
import t1.k$d;
import java.util.Map;
import kotlin.jvm.internal.i;
import io.sentry.protocol.o;
import io.sentry.e4;
import io.sentry.android.core.h;
import android.content.Context;
import t1.k;
import android.app.Activity;
import java.lang.ref.WeakReference;
import t1.k$c;
import k1.a;

public final class SentryFlutterPlugin implements a, k$c, l1.a
{
    private WeakReference<Activity> activity;
    private final String androidSdk;
    private boolean autoPerformanceTracingEnabled;
    private k channel;
    private Context context;
    private final String flutterSdk;
    private h framesTracker;
    private final String nativeSdk;
    
    public SentryFlutterPlugin() {
        this.flutterSdk = "sentry.dart.flutter";
        this.androidSdk = "sentry.java.android.flutter";
        this.nativeSdk = "sentry.native.android.flutter";
    }
    
    private final void addBreadcrumb(final Map<String, ?> map, final k$d k$d) {
        if (map != null) {
            final h0 u = h0.u();
            i.d((Object)u, "HubAdapter.getInstance()");
            final q4 r = u.r();
            i.d((Object)r, "HubAdapter.getInstance().options");
            c3.c(e.f((Map<String, Object>)map, r));
        }
        k$d.a((Object)"");
    }
    
    private final void addPackages(final e4 e4, final o o) {
        final o l = e4.L();
        if (l != null) {
            i.d((Object)l, "it");
            if (i.a((Object)l.f(), (Object)this.flutterSdk)) {
                if (o != null) {
                    final Set<r> g = o.g();
                    if (g != null) {
                        for (final r r : g) {
                            i.d((Object)r, "sentryPackage");
                            l.d(r.a(), r.b());
                        }
                    }
                }
                if (o != null) {
                    final Set<String> e5 = o.e();
                    if (e5 != null) {
                        final Iterator iterator2 = ((Iterable)e5).iterator();
                        while (iterator2.hasNext()) {
                            l.c((String)iterator2.next());
                        }
                    }
                }
            }
        }
    }
    
    private final void beginNativeFrames(final k$d k$d) {
        if (!this.autoPerformanceTracingEnabled) {
            k$d.a((Object)null);
            return;
        }
        final WeakReference<Activity> activity = this.activity;
        if (activity != null) {
            final Activity activity2 = (Activity)((Reference)activity).get();
            if (activity2 != null) {
                final h framesTracker = this.framesTracker;
                if (framesTracker != null) {
                    framesTracker.e(activity2);
                }
            }
        }
        k$d.a((Object)null);
    }
    
    private final void captureEnvelope(final j j, final k$d k$d) {
        if (!c3.q()) {
            k$d.b("1", "The Sentry Android SDK is disabled", (Object)null);
            return;
        }
        List b;
        if ((b = (List)j.b()) == null) {
            b = d2.k.b();
        }
        if (((Collection)b).isEmpty() ^ true) {
            final byte[] array = (byte[])d2.k.i(b);
            if (array != null && (array.length == 0 ^ true)) {
                if (!this.writeEnvelope(array)) {
                    k$d.b("2", "SentryOptions or outboxPath are null or empty", (Object)null);
                }
                k$d.a((Object)"");
                return;
            }
        }
        k$d.b("3", "Envelope is null or empty", (Object)null);
    }
    
    private final void clearBreadcrumbs(final k$d k$d) {
        c3.g();
        k$d.a((Object)"");
    }
    
    private final void closeNativeSdk(final k$d k$d) {
        h0.u().close();
        final h framesTracker = this.framesTracker;
        if (framesTracker != null) {
            framesTracker.p();
        }
        this.framesTracker = null;
        k$d.a((Object)"");
    }
    
    private final void endNativeFrames(final String s, final k$d k$d) {
        final WeakReference<Activity> activity = this.activity;
        Activity activity2;
        if (activity != null) {
            activity2 = (Activity)((Reference)activity).get();
        }
        else {
            activity2 = null;
        }
        if (this.autoPerformanceTracingEnabled && activity2 != null && s != null) {
            final q q = new q(s);
            final h framesTracker = this.framesTracker;
            if (framesTracker != null) {
                framesTracker.n(activity2, q);
            }
            final h framesTracker2 = this.framesTracker;
            Map q2;
            if (framesTracker2 != null) {
                q2 = framesTracker2.q(q);
            }
            else {
                q2 = null;
            }
            int intValue = 0;
            Label_0143: {
                if (q2 != null) {
                    final io.sentry.protocol.h h = (io.sentry.protocol.h)q2.get((Object)"frames_total");
                    if (h != null) {
                        final Number a = h.a();
                        if (a != null) {
                            intValue = a.intValue();
                            break Label_0143;
                        }
                    }
                }
                intValue = 0;
            }
            int intValue2 = 0;
            Label_0191: {
                if (q2 != null) {
                    final io.sentry.protocol.h h2 = (io.sentry.protocol.h)q2.get((Object)"frames_slow");
                    if (h2 != null) {
                        final Number a2 = h2.a();
                        if (a2 != null) {
                            intValue2 = a2.intValue();
                            break Label_0191;
                        }
                    }
                }
                intValue2 = 0;
            }
            int intValue3 = 0;
            Label_0233: {
                if (q2 != null) {
                    final io.sentry.protocol.h h3 = (io.sentry.protocol.h)q2.get((Object)"frames_frozen");
                    if (h3 != null) {
                        final Number a3 = h3.a();
                        if (a3 != null) {
                            intValue3 = a3.intValue();
                            break Label_0233;
                        }
                    }
                }
                intValue3 = 0;
            }
            if (intValue == 0 && intValue2 == 0 && intValue3 == 0) {
                k$d.a((Object)null);
            }
            else {
                k$d.a((Object)a0.e(new c2.j[] { n.a((Object)"totalFrames", (Object)intValue), n.a((Object)"slowFrames", (Object)intValue2), n.a((Object)"frozenFrames", (Object)intValue3) }));
            }
            return;
        }
        if (s == null) {
            Log.w("Sentry", "Parameter id cannot be null when calling endNativeFrames.");
        }
        k$d.a((Object)null);
    }
    
    private final void fetchNativeAppStart(final k$d k$d) {
        if (!this.autoPerformanceTracingEnabled) {
            k$d.a((Object)null);
            return;
        }
        final j0 e = j0.e();
        i.d((Object)e, "AppStartState.getInstance()");
        final j3 d = e.d();
        final j0 e2 = j0.e();
        i.d((Object)e2, "AppStartState.getInstance()");
        final Boolean f = e2.f();
        if (d == null) {
            Log.w("Sentry", "App start won't be sent due to missing appStartTime");
            k$d.a((Object)null);
        }
        else if (f == null) {
            Log.w("Sentry", "App start won't be sent due to missing isColdStart");
            k$d.a((Object)null);
        }
        else {
            k$d.a((Object)a0.e(new c2.j[] { n.a((Object)"appStartTime", (Object)io.sentry.j.k((double)d.i())), n.a((Object)"isColdStart", (Object)f) }));
        }
    }
    
    private final void initNativeSdk(final j j, final k$d k$d) {
        if (this.context == null) {
            k$d.b("1", "Context is null", (Object)null);
            return;
        }
        Map d;
        if ((d = (Map)j.b()) == null) {
            d = a0.d();
        }
        if (d.isEmpty()) {
            k$d.b("4", "Arguments is null or empty", (Object)null);
            return;
        }
        final Context context = this.context;
        if (context == null) {
            i.o("context");
        }
        e1.d(context, (c3$a)new SentryFlutterPlugin$initNativeSdk.SentryFlutterPlugin$initNativeSdk$2(this, d));
        k$d.a((Object)"");
    }
    
    private final void loadImageList(final k$d k$d) {
        final h0 u = h0.u();
        i.d((Object)u, "HubAdapter.getInstance()");
        final q4 r = u.r();
        if (r != null) {
            final SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions)r;
            final ArrayList list = new ArrayList();
            final List a = sentryAndroidOptions.getDebugImagesLoader().a();
            if (a != null) {
                for (final DebugImage debugImage : a) {
                    final LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ((Map)linkedHashMap).put((Object)"image_addr", (Object)debugImage.getImageAddr());
                    ((Map)linkedHashMap).put((Object)"image_size", (Object)debugImage.getImageSize());
                    ((Map)linkedHashMap).put((Object)"code_file", (Object)debugImage.getCodeFile());
                    ((Map)linkedHashMap).put((Object)"type", (Object)debugImage.getType());
                    ((Map)linkedHashMap).put((Object)"debug_id", (Object)debugImage.getDebugId());
                    ((Map)linkedHashMap).put((Object)"code_id", (Object)debugImage.getCodeId());
                    ((Map)linkedHashMap).put((Object)"debug_file", (Object)debugImage.getDebugFile());
                    ((List)list).add((Object)linkedHashMap);
                }
            }
            k$d.a((Object)list);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type io.sentry.android.core.SentryAndroidOptions");
    }
    
    private final void removeContexts(final String s, final k$d k$d) {
        if (s == null) {
            k$d.a((Object)"");
            return;
        }
        c3.i((s2)new SentryFlutterPlugin$removeContexts.SentryFlutterPlugin$removeContexts$1(s, k$d));
    }
    
    private final void removeExtra(final String s, final k$d k$d) {
        if (s == null) {
            k$d.a((Object)"");
            return;
        }
        c3.u(s);
        k$d.a((Object)"");
    }
    
    private final void removeTag(final String s, final k$d k$d) {
        if (s == null) {
            k$d.a((Object)"");
            return;
        }
        c3.v(s);
        k$d.a((Object)"");
    }
    
    private final void setContexts(final String s, final Object o, final k$d k$d) {
        if (s != null && o != null) {
            c3.i((s2)new SentryFlutterPlugin$setContexts.SentryFlutterPlugin$setContexts$1(s, o, k$d));
            return;
        }
        k$d.a((Object)"");
    }
    
    private final void setEventEnvironmentTag(final e4 e4, final String s, final String s2) {
        e4.c0("event.origin", s);
        e4.c0("event.environment", s2);
    }
    
    static /* synthetic */ void setEventEnvironmentTag$default(final SentryFlutterPlugin sentryFlutterPlugin, final e4 e4, String s, final String s2, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            s = "android";
        }
        sentryFlutterPlugin.setEventEnvironmentTag(e4, s, s2);
    }
    
    private final void setEventOriginTag(final e4 e4) {
        final o l = e4.L();
        if (l != null) {
            i.d((Object)l, "it");
            final String f = l.f();
            if (i.a((Object)f, (Object)this.flutterSdk)) {
                this.setEventEnvironmentTag(e4, "flutter", "dart");
            }
            else if (i.a((Object)f, (Object)this.androidSdk)) {
                setEventEnvironmentTag$default(this, e4, null, "java", 2, null);
            }
            else if (i.a((Object)f, (Object)this.nativeSdk)) {
                setEventEnvironmentTag$default(this, e4, null, "native", 2, null);
            }
        }
    }
    
    private final void setExtra(final String s, final String s2, final k$d k$d) {
        if (s != null && s2 != null) {
            c3.w(s, s2);
            k$d.a((Object)"");
            return;
        }
        k$d.a((Object)"");
    }
    
    private final void setTag(final String s, final String s2, final k$d k$d) {
        if (s != null && s2 != null) {
            c3.x(s, s2);
            k$d.a((Object)"");
            return;
        }
        k$d.a((Object)"");
    }
    
    private final void setUser(final Map<String, ?> map, final k$d k$d) {
        if (map != null) {
            final h0 u = h0.u();
            i.d((Object)u, "HubAdapter.getInstance()");
            final q4 r = u.r();
            i.d((Object)r, "HubAdapter.getInstance().options");
            c3.y(io.sentry.protocol.a0.j((Map<String, Object>)map, r));
        }
        else {
            c3.y((io.sentry.protocol.a0)null);
        }
        k$d.a((Object)"");
    }
    
    private final boolean writeEnvelope(final byte[] array) {
        final h0 u = h0.u();
        i.d((Object)u, "HubAdapter.getInstance()");
        final q4 r = u.r();
        i.d((Object)r, "HubAdapter.getInstance().options");
        final String outboxPath = r.getOutboxPath();
        if (outboxPath == null || ((CharSequence)outboxPath).length() == 0) {
            return false;
        }
        f.a(new File(r.getOutboxPath(), UUID.randomUUID().toString()), array);
        return true;
    }
    
    public void onAttachedToActivity(final c c) {
        i.e((Object)c, "binding");
        this.activity = (WeakReference<Activity>)new WeakReference((Object)c.d());
    }
    
    public void onAttachedToEngine(final a$b a$b) {
        i.e((Object)a$b, "flutterPluginBinding");
        final Context a = a$b.a();
        i.d((Object)a, "flutterPluginBinding.applicationContext");
        this.context = a;
        (this.channel = new k(a$b.b(), "sentry_flutter")).e((k$c)this);
    }
    
    public void onDetachedFromActivity() {
        this.activity = null;
        this.framesTracker = null;
    }
    
    public void onDetachedFromActivityForConfigChanges() {
    }
    
    public void onDetachedFromEngine(final a$b a$b) {
        i.e((Object)a$b, "binding");
        final k channel = this.channel;
        if (channel == null) {
            return;
        }
        if (channel == null) {
            i.o("channel");
        }
        channel.e((k$c)null);
    }
    
    public void onMethodCall(final j j, final k$d k$d) {
        i.e((Object)j, "call");
        i.e((Object)k$d, "result");
        final String a = j.a;
        if (a != null) {
            switch (a.hashCode()) {
                case 2133203272: {
                    if (a.equals((Object)"removeContexts")) {
                        this.removeContexts((String)j.a("key"), k$d);
                        return;
                    }
                    break;
                }
                case 1985026893: {
                    if (a.equals((Object)"setUser")) {
                        this.setUser((Map<String, ?>)j.a("user"), k$d);
                        return;
                    }
                    break;
                }
                case 1838399555: {
                    if (a.equals((Object)"clearBreadcrumbs")) {
                        this.clearBreadcrumbs(k$d);
                        return;
                    }
                    break;
                }
                case 1422008102: {
                    if (a.equals((Object)"setContexts")) {
                        this.setContexts((String)j.a("key"), j.a("value"), k$d);
                        return;
                    }
                    break;
                }
                case 1391678670: {
                    if (a.equals((Object)"setExtra")) {
                        this.setExtra((String)j.a("key"), (String)j.a("value"), k$d);
                        return;
                    }
                    break;
                }
                case 1282363510: {
                    if (a.equals((Object)"removeTag")) {
                        this.removeTag((String)j.a("key"), k$d);
                        return;
                    }
                    break;
                }
                case 1126756228: {
                    if (a.equals((Object)"addBreadcrumb")) {
                        this.addBreadcrumb((Map<String, ?>)j.a("breadcrumb"), k$d);
                        return;
                    }
                    break;
                }
                case 783581208: {
                    if (a.equals((Object)"endNativeFrames")) {
                        this.endNativeFrames((String)j.a("id"), k$d);
                        return;
                    }
                    break;
                }
                case 545314163: {
                    if (a.equals((Object)"initNativeSdk")) {
                        this.initNativeSdk(j, k$d);
                        return;
                    }
                    break;
                }
                case 263988819: {
                    if (a.equals((Object)"loadImageList")) {
                        this.loadImageList(k$d);
                        return;
                    }
                    break;
                }
                case 145462582: {
                    if (a.equals((Object)"captureEnvelope")) {
                        this.captureEnvelope(j, k$d);
                        return;
                    }
                    break;
                }
                case -317432340: {
                    if (a.equals((Object)"removeExtra")) {
                        this.removeExtra((String)j.a("key"), k$d);
                        return;
                    }
                    break;
                }
                case -366888622: {
                    if (a.equals((Object)"fetchNativeAppStart")) {
                        this.fetchNativeAppStart(k$d);
                        return;
                    }
                    break;
                }
                case -853417589: {
                    if (a.equals((Object)"closeNativeSdk")) {
                        this.closeNativeSdk(k$d);
                        return;
                    }
                    break;
                }
                case -905799720: {
                    if (a.equals((Object)"setTag")) {
                        this.setTag((String)j.a("key"), (String)j.a("value"), k$d);
                        return;
                    }
                    break;
                }
                case -1446499610: {
                    if (a.equals((Object)"beginNativeFrames")) {
                        this.beginNativeFrames(k$d);
                        return;
                    }
                    break;
                }
            }
        }
        k$d.c();
    }
    
    public void onReattachedToActivityForConfigChanges(final c c) {
        i.e((Object)c, "binding");
    }
}
