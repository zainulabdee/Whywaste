package io.flutter.plugins.imagepicker;

import java.util.HashSet;
import android.net.Uri;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import android.content.Context;

class c
{
    private final Context a;
    
    c(final Context a) {
        this.a = a;
    }
    
    private void h(final String s) {
        this.a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().putString("flutter_image_picker_type", s).apply();
    }
    
    void a() {
        this.a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().clear().apply();
    }
    
    Map<String, Object> b() {
        final HashMap hashMap = new HashMap();
        final Context a = this.a;
        final boolean b = false;
        final SharedPreferences sharedPreferences = a.getSharedPreferences("flutter_image_picker_shared_preference", 0);
        final boolean contains = sharedPreferences.contains("flutter_image_picker_image_path");
        final int n = 1;
        int n2 = b ? 1 : 0;
        if (contains) {
            final Set stringSet = sharedPreferences.getStringSet("flutter_image_picker_image_path", (Set)null);
            n2 = (b ? 1 : 0);
            if (stringSet != null) {
                ((Map)hashMap).put((Object)"pathList", (Object)new ArrayList((Collection)stringSet));
                n2 = 1;
            }
        }
        if (sharedPreferences.contains("flutter_image_picker_error_code")) {
            final p.a.a a2 = new p.a.a();
            a2.b(sharedPreferences.getString("flutter_image_picker_error_code", ""));
            if (sharedPreferences.contains("flutter_image_picker_error_message")) {
                a2.c(sharedPreferences.getString("flutter_image_picker_error_message", ""));
            }
            ((Map)hashMap).put((Object)"error", (Object)a2.a());
            n2 = n;
        }
        if (n2 != 0) {
            if (sharedPreferences.contains("flutter_image_picker_type")) {
                p.c c;
                if (sharedPreferences.getString("flutter_image_picker_type", "").equals((Object)"video")) {
                    c = p.c.g;
                }
                else {
                    c = p.c.f;
                }
                ((Map)hashMap).put((Object)"type", (Object)c);
            }
            if (sharedPreferences.contains("flutter_image_picker_max_width")) {
                ((Map)hashMap).put((Object)"maxWidth", (Object)Double.longBitsToDouble(sharedPreferences.getLong("flutter_image_picker_max_width", 0L)));
            }
            if (sharedPreferences.contains("flutter_image_picker_max_height")) {
                ((Map)hashMap).put((Object)"maxHeight", (Object)Double.longBitsToDouble(sharedPreferences.getLong("flutter_image_picker_max_height", 0L)));
            }
            ((Map)hashMap).put((Object)"imageQuality", (Object)sharedPreferences.getInt("flutter_image_picker_image_quality", 100));
        }
        return (Map<String, Object>)hashMap;
    }
    
    String c() {
        return this.a.getSharedPreferences("flutter_image_picker_shared_preference", 0).getString("flutter_image_picker_pending_image_uri", "");
    }
    
    void d(final p.h h) {
        final SharedPreferences$Editor edit = this.a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit();
        if (h.c() != null) {
            edit.putLong("flutter_image_picker_max_width", Double.doubleToRawLongBits((double)h.c()));
        }
        if (h.b() != null) {
            edit.putLong("flutter_image_picker_max_height", Double.doubleToRawLongBits((double)h.b()));
        }
        edit.putInt("flutter_image_picker_image_quality", h.d().intValue());
        edit.apply();
    }
    
    void e(final Uri uri) {
        this.a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().putString("flutter_image_picker_pending_image_uri", uri.getPath()).apply();
    }
    
    void f(final ArrayList<String> list, final String s, final String s2) {
        final SharedPreferences$Editor edit = this.a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit();
        if (list != null) {
            edit.putStringSet("flutter_image_picker_image_path", (Set)new HashSet((Collection)list));
        }
        if (s != null) {
            edit.putString("flutter_image_picker_error_code", s);
        }
        if (s2 != null) {
            edit.putString("flutter_image_picker_error_message", s2);
        }
        edit.apply();
    }
    
    void g(final b b) {
        final int n = c$a.a[b.ordinal()];
        if (n != 1) {
            if (n == 2) {
                this.h("video");
            }
        }
        else {
            this.h("image");
        }
    }
    
    public enum b
    {
        e, 
        f;
        
        private static final b[] g;
        
        static {
            g = d();
        }
        
        private static /* synthetic */ b[] d() {
            return new b[] { b.e, b.f };
        }
    }
}
