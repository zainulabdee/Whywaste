package s1;

import java.util.Arrays;
import f1.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import t1.l;
import t1.c;
import t1.g;
import g1.a;
import t1.k;

public class i
{
    public final t1.k a;
    private h b;
    final t1.k.c c;
    
    public i(final a a) {
        final i$a c = new i$a(this);
        this.c = (t1.k.c)c;
        (this.a = new t1.k(a, "flutter/platform", (t1.l)t1.g.a)).e((t1.k.c)c);
    }
    
    private c g(final JSONObject jsonObject) {
        int int1;
        final int n = int1 = jsonObject.getInt("primaryColor");
        if (n != 0) {
            int1 = (n | 0xFF000000);
        }
        return new c(int1, jsonObject.getString("label"));
    }
    
    private int h(final JSONArray jsonArray) {
        int i = 0;
        int n = 0;
        int n2 = 0;
        while (i < jsonArray.length()) {
            final int n3 = i$b.a[f.d(jsonArray.getString(i)).ordinal()];
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3) {
                        if (n3 == 4) {
                            n |= 0x8;
                        }
                    }
                    else {
                        n |= 0x2;
                    }
                }
                else {
                    n |= 0x4;
                }
            }
            else {
                n |= 0x1;
            }
            int n4 = n2;
            if (n2 == 0) {
                n4 = n;
            }
            ++i;
            n2 = n4;
        }
        if (n != 0) {
            int n5 = 9;
            switch (n) {
                case 15: {
                    return 13;
                }
                case 11: {
                    return 2;
                }
                case 10: {
                    return 11;
                }
                case 8: {
                    return 8;
                }
                case 5: {
                    n5 = 12;
                }
                case 4: {
                    return n5;
                }
                case 3:
                case 6:
                case 7:
                case 9:
                case 12:
                case 13:
                case 14: {
                    if (n2 == 2) {
                        return 0;
                    }
                    if (n2 == 4) {
                        return 9;
                    }
                    if (n2 != 8) {
                        break;
                    }
                    return 8;
                }
                case 2: {
                    return 0;
                }
            }
            return 1;
        }
        return -1;
    }
    
    private j i(final JSONObject jsonObject) {
        final boolean null = jsonObject.isNull("statusBarColor");
        Boolean value = null;
        Integer value2;
        if (!null) {
            value2 = jsonObject.getInt("statusBarColor");
        }
        else {
            value2 = null;
        }
        d d;
        if (!jsonObject.isNull("statusBarIconBrightness")) {
            d = s1.i.d.d(jsonObject.getString("statusBarIconBrightness"));
        }
        else {
            d = null;
        }
        Boolean value3;
        if (!jsonObject.isNull("systemStatusBarContrastEnforced")) {
            value3 = jsonObject.getBoolean("systemStatusBarContrastEnforced");
        }
        else {
            value3 = null;
        }
        Integer value4;
        if (!jsonObject.isNull("systemNavigationBarColor")) {
            value4 = jsonObject.getInt("systemNavigationBarColor");
        }
        else {
            value4 = null;
        }
        d d2;
        if (!jsonObject.isNull("systemNavigationBarIconBrightness")) {
            d2 = s1.i.d.d(jsonObject.getString("systemNavigationBarIconBrightness"));
        }
        else {
            d2 = null;
        }
        Integer value5;
        if (!jsonObject.isNull("systemNavigationBarDividerColor")) {
            value5 = jsonObject.getInt("systemNavigationBarDividerColor");
        }
        else {
            value5 = null;
        }
        if (!jsonObject.isNull("systemNavigationBarContrastEnforced")) {
            value = jsonObject.getBoolean("systemNavigationBarContrastEnforced");
        }
        return new j(value2, d, value3, value4, d2, value5, value);
    }
    
    private k j(final String s) {
        final int n = i$b.c[k.d(s).ordinal()];
        if (n == 1) {
            return k.f;
        }
        if (n == 2) {
            return k.g;
        }
        if (n == 3) {
            return k.h;
        }
        if (n != 4) {
            return k.i;
        }
        return k.i;
    }
    
    private List<l> k(final JSONArray jsonArray) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < jsonArray.length(); ++i) {
            final int n = i$b.b[l.d(jsonArray.getString(i)).ordinal()];
            if (n != 1) {
                if (n == 2) {
                    ((List)list).add((Object)l.g);
                }
            }
            else {
                ((List)list).add((Object)l.f);
            }
        }
        return (List<l>)list;
    }
    
    public void l(final h b) {
        this.b = b;
    }
    
    public void m(final boolean b) {
        b.f("PlatformChannel", "Sending 'systemUIChange' message.");
        this.a.c("SystemChrome.systemUIChange", Arrays.asList((Object[])new Boolean[] { b }));
    }
    
    public static class c
    {
        public final int a;
        public final String b;
        
        public c(final int a, final String b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public enum d
    {
        f("Brightness.light"), 
        g("Brightness.dark");
        
        private static final d[] h;
        private String e;
        
        private d(final String e) {
            this.e = e;
        }
        
        static d d(final String s) {
            for (final d d : values()) {
                if (d.e.equals((Object)s)) {
                    return d;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No such Brightness: ");
            sb.append(s);
            throw new NoSuchFieldException(sb.toString());
        }
    }
    
    public enum e
    {
        f("text/plain");
        
        private static final e[] g;
        private String e;
        
        private e(final String e) {
            this.e = e;
        }
        
        static e d(final String s) {
            for (final e e : values()) {
                if (e.e.equals((Object)s)) {
                    return e;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No such ClipboardContentFormat: ");
            sb.append(s);
            throw new NoSuchFieldException(sb.toString());
        }
    }
    
    public enum f
    {
        f("DeviceOrientation.portraitUp"), 
        g("DeviceOrientation.portraitDown"), 
        h("DeviceOrientation.landscapeLeft"), 
        i("DeviceOrientation.landscapeRight");
        
        private static final f[] j;
        private String e;
        
        private f(final String e) {
            this.e = e;
        }
        
        static f d(final String s) {
            for (final f f : values()) {
                if (f.e.equals((Object)s)) {
                    return f;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No such DeviceOrientation: ");
            sb.append(s);
            throw new NoSuchFieldException(sb.toString());
        }
    }
    
    public enum g
    {
        f((String)null), 
        g("HapticFeedbackType.lightImpact"), 
        h("HapticFeedbackType.mediumImpact"), 
        i("HapticFeedbackType.heavyImpact"), 
        j("HapticFeedbackType.selectionClick");
        
        private static final g[] k;
        private final String e;
        
        private g(final String e) {
            this.e = e;
        }
        
        static g d(final String s) {
            for (final g g : values()) {
                final String e = g.e;
                if ((e == null && s == null) || (e != null && e.equals((Object)s))) {
                    return g;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No such HapticFeedbackType: ");
            sb.append(s);
            throw new NoSuchFieldException(sb.toString());
        }
    }
    
    public interface h
    {
        void a(final i p0);
        
        void b();
        
        CharSequence c(final e p0);
        
        void d(final List<l> p0);
        
        void e(final c p0);
        
        void f();
        
        void g();
        
        void h(final String p0);
        
        void i(final g p0);
        
        void j(final int p0);
        
        void k(final j p0);
        
        boolean l();
        
        void m(final k p0);
    }
    
    public enum i
    {
        f("SystemSoundType.click"), 
        g("SystemSoundType.alert");
        
        private static final i[] h;
        private final String e;
        
        private i(final String e) {
            this.e = e;
        }
        
        static i d(final String s) {
            for (final i j : values()) {
                if (j.e.equals((Object)s)) {
                    return j;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No such SoundType: ");
            sb.append(s);
            throw new NoSuchFieldException(sb.toString());
        }
    }
    
    public static class j
    {
        public final Integer a;
        public final d b;
        public final Boolean c;
        public final Integer d;
        public final d e;
        public final Integer f;
        public final Boolean g;
        
        public j(final Integer a, final d b, final Boolean c, final Integer d, final d e, final Integer f, final Boolean g) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
        }
    }
    
    public enum k
    {
        f("SystemUiMode.leanBack"), 
        g("SystemUiMode.immersive"), 
        h("SystemUiMode.immersiveSticky"), 
        i("SystemUiMode.edgeToEdge");
        
        private static final k[] j;
        private String e;
        
        private k(final String e) {
            this.e = e;
        }
        
        static k d(final String s) {
            for (final k k : values()) {
                if (k.e.equals((Object)s)) {
                    return k;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No such SystemUiMode: ");
            sb.append(s);
            throw new NoSuchFieldException(sb.toString());
        }
    }
    
    public enum l
    {
        f("SystemUiOverlay.top"), 
        g("SystemUiOverlay.bottom");
        
        private static final l[] h;
        private String e;
        
        private l(final String e) {
            this.e = e;
        }
        
        static l d(final String s) {
            for (final l l : values()) {
                if (l.e.equals((Object)s)) {
                    return l;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No such SystemUiOverlay: ");
            sb.append(s);
            throw new NoSuchFieldException(sb.toString());
        }
    }
}
