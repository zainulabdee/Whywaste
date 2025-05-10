package io.flutter.plugins.webviewflutter;

import java.util.List;
import java.util.Arrays;
import java.io.Serializable;
import t1.a$e;
import java.util.Collection;
import java.util.Collections;
import t1.a;
import t1.r;
import t1.i;
import t1.c;
import android.util.Log;
import java.util.ArrayList;

public class n
{
    protected static ArrayList<Object> a(final Throwable t) {
        final ArrayList list = new ArrayList(3);
        if (t instanceof n$k) {
            final n$k n$k = (n$k)t;
            list.add((Object)n$k.e);
            list.add((Object)((Throwable)n$k).getMessage());
            list.add(n$k.f);
        }
        else {
            list.add((Object)t.toString());
            list.add((Object)t.getClass().getSimpleName());
            final StringBuilder sb = new StringBuilder();
            sb.append("Cause: ");
            sb.append((Object)t.getCause());
            sb.append(", Stacktrace: ");
            sb.append(Log.getStackTraceString(t));
            list.add((Object)sb.toString());
        }
        return (ArrayList<Object>)list;
    }
    
    public static class n
    {
        private final c a;
        
        public n(final c a) {
            this.a = a;
        }
        
        static i<Object> c() {
            return (i<Object>)new t1.r();
        }
        
        public void b(final Long n, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandlerFlutterApi.create", (i)c()).d((Object)new ArrayList((Collection)Collections.singletonList((Object)n)), (a$e)new g0((a)a));
        }
        
        public interface a<T>
        {
            void a(final T p0);
        }
    }
    
    public interface o
    {
        void a(final Long p0);
        
        Boolean b(final Long p0);
        
        void c(final Long p0, final String p1, final String p2);
    }
    
    public interface p
    {
        void clear();
    }
    
    public static class q
    {
        private final c a;
        
        public q(final c a) {
            this.a = a;
        }
        
        static i<Object> c() {
            return (i<Object>)new t1.r();
        }
        
        public void b(final Long n, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.JavaObjectFlutterApi.dispose", (i)c()).d((Object)new ArrayList((Collection)Collections.singletonList((Object)n)), (a$e)new n0((a)a));
        }
        
        public interface a<T>
        {
            void a(final T p0);
        }
    }
    
    public interface r
    {
        void a(final Long p0);
    }
    
    public static class s
    {
        private final c a;
        
        public s(final c a) {
            this.a = a;
        }
        
        static i<Object> b() {
            return (i<Object>)new t1.r();
        }
        
        public void d(final Long n, final String s, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannelFlutterApi.postMessage", (i)b()).d((Object)new ArrayList((Collection)Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)s })), (a$e)new q0((a)a));
        }
        
        public interface a<T>
        {
            void a(final T p0);
        }
    }
    
    public interface t
    {
        void a(final Long p0, final String p1);
    }
    
    public static class u
    {
        private final c a;
        
        public u(final c a) {
            this.a = a;
        }
        
        static i<Object> c() {
            return (i<Object>)new t1.r();
        }
        
        public void b(final Long n, final List<String> list, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.PermissionRequestFlutterApi.create", (i)c()).d((Object)new ArrayList((Collection)Arrays.asList(new Object[] { n, list })), (a$e)new t0((a)a));
        }
        
        public interface a<T>
        {
            void a(final T p0);
        }
    }
    
    public interface v
    {
        void a(final Long p0, final List<String> p1);
        
        void b(final Long p0);
    }
    
    public interface w<T>
    {
        void a(final T p0);
    }
    
    public static class x
    {
        private final c a;
        
        public x(final c a) {
            this.a = a;
        }
        
        static i<Object> c() {
            return (i<Object>)new t1.r();
        }
        
        public void b(final Long n, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.ViewFlutterApi.create", (i)c()).d((Object)new ArrayList((Collection)Collections.singletonList((Object)n)), (a$e)new x0((a)a));
        }
        
        public interface a<T>
        {
            void a(final T p0);
        }
    }
    
    public static class y
    {
        private final c a;
        
        public y(final c a) {
            this.a = a;
        }
        
        static i<Object> l() {
            return (i<Object>)n$z.d;
        }
        
        public void A(final Long n, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onHideCustomView", (i)l()).d((Object)new ArrayList((Collection)Collections.singletonList((Object)n)), (a$e)new b1((a)a));
        }
        
        public void B(final Long n, final String s, final String s2, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onJsAlert", (i)l()).d((Object)new ArrayList((Collection)Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)s, (Serializable)s2 })), (a$e)new e1((a)a));
        }
        
        public void C(final Long n, final String s, final String s2, final a<Boolean> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onJsConfirm", (i)l()).d((Object)new ArrayList((Collection)Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)s, (Serializable)s2 })), (a$e)new a1((a)a));
        }
        
        public void D(final Long n, final String s, final String s2, final String s3, final a<String> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onJsPrompt", (i)l()).d((Object)new ArrayList((Collection)Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)s, (Serializable)s2, (Serializable)s3 })), (a$e)new y0((a)a));
        }
        
        public void E(final Long n, final Long n2, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onPermissionRequest", (i)l()).d((Object)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { n, n2 })), (a$e)new f1((a)a));
        }
        
        public void F(final Long n, final Long n2, final Long n3, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onProgressChanged", (i)l()).d((Object)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { n, n2, n3 })), (a$e)new h1((a)a));
        }
        
        public void G(final Long n, final Long n2, final Long n3, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onShowCustomView", (i)l()).d((Object)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { n, n2, n3 })), (a$e)new z0((a)a));
        }
        
        public void H(final Long n, final Long n2, final Long n3, final a<List<String>> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onShowFileChooser", (i)l()).d((Object)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { n, n2, n3 })), (a$e)new i1((a)a));
        }
        
        public void x(final Long n, final n$a n$a, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onConsoleMessage", (i)l()).d((Object)new ArrayList((Collection)Arrays.asList(new Object[] { n, n$a })), (a$e)new d1((a)a));
        }
        
        public void y(final Long n, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onGeolocationPermissionsHidePrompt", (i)l()).d((Object)new ArrayList((Collection)Collections.singletonList((Object)n)), (a$e)new c1((a)a));
        }
        
        public void z(final Long n, final Long n2, final String s, final a<Void> a) {
            new t1.a(this.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onGeolocationPermissionsShowPrompt", (i)l()).d((Object)new ArrayList((Collection)Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)n2, (Serializable)s })), (a$e)new g1((a)a));
        }
        
        public interface a<T>
        {
            void a(final T p0);
        }
    }
}
