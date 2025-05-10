package s1;

import f1.b;
import java.util.HashMap;
import java.util.Map;
import t1.i;
import t1.c;
import t1.f;
import t1.a;

public class m
{
    public final t1.a<Object> a;
    
    public m(final g1.a a) {
        this.a = new t1.a<Object>(a, "flutter/settings", (i<Object>)f.a);
    }
    
    public a a() {
        return new a(this.a);
    }
    
    public static class a
    {
        private final t1.a<Object> a;
        private Map<String, Object> b;
        
        a(final t1.a<Object> a) {
            this.b = (Map<String, Object>)new HashMap();
            this.a = a;
        }
        
        public void a() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Sending message: \ntextScaleFactor: ");
            sb.append(this.b.get((Object)"textScaleFactor"));
            sb.append("\nalwaysUse24HourFormat: ");
            sb.append(this.b.get((Object)"alwaysUse24HourFormat"));
            sb.append("\nplatformBrightness: ");
            sb.append(this.b.get((Object)"platformBrightness"));
            f1.b.f("SettingsChannel", sb.toString());
            this.a.c(this.b);
        }
        
        public a b(final boolean b) {
            this.b.put((Object)"brieflyShowPassword", (Object)b);
            return this;
        }
        
        public a c(final boolean b) {
            this.b.put((Object)"nativeSpellCheckServiceDefined", (Object)b);
            return this;
        }
        
        public a d(final b b) {
            this.b.put((Object)"platformBrightness", (Object)b.e);
            return this;
        }
        
        public a e(final float n) {
            this.b.put((Object)"textScaleFactor", (Object)n);
            return this;
        }
        
        public a f(final boolean b) {
            this.b.put((Object)"alwaysUse24HourFormat", (Object)b);
            return this;
        }
    }
    
    public enum b
    {
        f("light"), 
        g("dark");
        
        private static final b[] h;
        public String e;
        
        private b(final String e) {
            this.e = e;
        }
    }
}
