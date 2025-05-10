package z1;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import android.util.Base64;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import android.content.SharedPreferences$Editor;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.math.BigInteger;
import android.util.Log;
import android.content.Context;
import t1.c;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import android.content.SharedPreferences;
import k1.a;

public class l implements k1.a, a$b
{
    private SharedPreferences a;
    private k b;
    
    public l() {
        this((k)new a());
    }
    
    l(final k b) {
        this.b = b;
    }
    
    private Map<String, Object> h(final String s, final Set<String> set) {
        final Map all = this.a.getAll();
        final HashMap hashMap = new HashMap();
        for (final String s2 : all.keySet()) {
            if (s2.startsWith(s) && (set == null || set.contains((Object)s2))) {
                ((Map)hashMap).put((Object)s2, this.j(s2, all.get((Object)s2)));
            }
        }
        return (Map<String, Object>)hashMap;
    }
    
    private void i(final c c, final Context context) {
        this.a = context.getSharedPreferences("FlutterSharedPreferences", 0);
        try {
            j.j(c, (a$b)this);
        }
        catch (final Exception ex) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", (Throwable)ex);
        }
    }
    
    private Object j(String s, final Object o) {
        if (o instanceof String) {
            s = (String)o;
            if (s.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                return this.b.b(s.substring(40));
            }
            if (s.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")) {
                return new BigInteger(s.substring(44), 36);
            }
            if (s.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                return Double.valueOf(s.substring(40));
            }
        }
        else if (o instanceof Set) {
            final ArrayList list = new ArrayList((Collection)o);
            final SharedPreferences$Editor remove = this.a.edit().remove(s);
            final StringBuilder sb = new StringBuilder();
            sb.append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu");
            sb.append(this.b.a((List)list));
            remove.putString(s, sb.toString()).apply();
            return list;
        }
        return o;
    }
    
    public Boolean a(final String s, final Long n) {
        return this.a.edit().putLong(s, (long)n).commit();
    }
    
    public Map<String, Object> b(final String s, final List<String> list) {
        Object o;
        if (list == null) {
            o = null;
        }
        else {
            o = new HashSet((Collection)list);
        }
        return this.h(s, (Set<String>)o);
    }
    
    public Boolean c(final String s, final String s2) {
        if (!s2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") && !s2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy") && !s2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
            return this.a.edit().putString(s, s2).commit();
        }
        throw new RuntimeException("StorageError: This string cannot be stored as it clashes with special identifier prefixes");
    }
    
    public Boolean d(final String s, final List<String> list) {
        final SharedPreferences$Editor edit = this.a.edit();
        final Map all = this.a.getAll();
        final ArrayList list2 = new ArrayList();
        for (final String s2 : all.keySet()) {
            if (s2.startsWith(s) && (list == null || list.contains((Object)s2))) {
                list2.add((Object)s2);
            }
        }
        final Iterator iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            edit.remove((String)iterator2.next());
        }
        return edit.commit();
    }
    
    public Boolean e(final String s, final List<String> list) {
        final SharedPreferences$Editor edit = this.a.edit();
        final StringBuilder sb = new StringBuilder();
        sb.append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu");
        sb.append(this.b.a((List)list));
        return edit.putString(s, sb.toString()).commit();
    }
    
    public Boolean f(final String s, final Boolean b) {
        return this.a.edit().putBoolean(s, (boolean)b).commit();
    }
    
    public Boolean g(final String s, final Double n) {
        final String string = Double.toString((double)n);
        final SharedPreferences$Editor edit = this.a.edit();
        final StringBuilder sb = new StringBuilder();
        sb.append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu");
        sb.append(string);
        return edit.putString(s, sb.toString()).commit();
    }
    
    public void onAttachedToEngine(final k1.a$b a$b) {
        this.i(a$b.b(), a$b.a());
    }
    
    public void onDetachedFromEngine(final k1.a$b a$b) {
        j.j(a$b.b(), (a$b)null);
    }
    
    public Boolean remove(final String s) {
        return this.a.edit().remove(s).commit();
    }
    
    static class a implements k
    {
        public String a(final List<String> list) {
            try {
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                final ObjectOutputStream objectOutputStream = new ObjectOutputStream((OutputStream)byteArrayOutputStream);
                objectOutputStream.writeObject((Object)list);
                objectOutputStream.flush();
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            }
            catch (final IOException ex) {
                throw new RuntimeException((Throwable)ex);
            }
        }
        
        public List<String> b(String ex) {
            try {
                ex = (ClassNotFoundException)new ObjectInputStream((InputStream)new ByteArrayInputStream(Base64.decode((String)ex, 0))).readObject();
                return (List<String>)ex;
            }
            catch (final ClassNotFoundException ex) {}
            catch (final IOException ex2) {}
            throw new RuntimeException((Throwable)ex);
        }
    }
}
