package a1;

import java.util.Arrays;
import android.database.sqlite.SQLiteProgram;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class d0
{
    private final String a;
    private final List<Object> b;
    
    public d0(final String a, final List<Object> list) {
        this.a = a;
        Object b = list;
        if (list == null) {
            b = new ArrayList();
        }
        this.b = (List<Object>)b;
    }
    
    private Object[] e(final List<Object> list) {
        final ArrayList list2 = new ArrayList();
        if (list != null) {
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((List)list2).add(f(iterator.next()));
            }
        }
        return ((List)list2).toArray(new Object[0]);
    }
    
    private static Object f(final Object o) {
        if (o == null) {
            return null;
        }
        Object o2 = o;
        if (o instanceof List) {
            final List list = (List)o;
            o2 = new byte[list.size()];
            for (int i = 0; i < list.size(); ++i) {
                o2[i] = (byte)(int)list.get(i);
            }
        }
        return o2;
    }
    
    public void a(final SQLiteProgram sqLiteProgram) {
        final List<Object> b = this.b;
        if (b != null) {
            int n;
            for (int size = b.size(), i = 0; i < size; i = n) {
                final Object f = f(this.b.get(i));
                n = i + 1;
                if (f == null) {
                    sqLiteProgram.bindNull(n);
                }
                else if (f instanceof byte[]) {
                    sqLiteProgram.bindBlob(n, (byte[])f);
                }
                else if (f instanceof Double) {
                    sqLiteProgram.bindDouble(n, (double)f);
                }
                else if (f instanceof Integer) {
                    sqLiteProgram.bindLong(n, (long)(int)f);
                }
                else if (f instanceof Long) {
                    sqLiteProgram.bindLong(n, (long)f);
                }
                else if (f instanceof String) {
                    sqLiteProgram.bindString(n, (String)f);
                }
                else {
                    if (!(f instanceof Boolean)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Could not bind ");
                        sb.append(f);
                        sb.append(" from index ");
                        sb.append(i);
                        sb.append(": Supported types are null, byte[], double, long, boolean and String");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    long n2;
                    if (f) {
                        n2 = 1L;
                    }
                    else {
                        n2 = 0L;
                    }
                    sqLiteProgram.bindLong(n, n2);
                }
            }
        }
    }
    
    public List<Object> b() {
        return this.b;
    }
    
    public String c() {
        return this.a;
    }
    
    public Object[] d() {
        return this.e(this.b);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof d0)) {
            return false;
        }
        final d0 d0 = (d0)o;
        final String a = this.a;
        if (a != null) {
            if (!a.equals((Object)d0.a)) {
                return false;
            }
        }
        else if (d0.a != null) {
            return false;
        }
        if (this.b.size() != d0.b.size()) {
            return false;
        }
        for (int i = 0; i < this.b.size(); ++i) {
            if (this.b.get(i) instanceof byte[] && d0.b.get(i) instanceof byte[]) {
                if (!Arrays.equals((byte[])this.b.get(i), (byte[])d0.b.get(i))) {
                    return false;
                }
            }
            else if (!this.b.get(i).equals(d0.b.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final String a = this.a;
        int hashCode;
        if (a != null) {
            hashCode = a.hashCode();
        }
        else {
            hashCode = 0;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        final List<Object> b = this.b;
        String string;
        if (b != null && !b.isEmpty()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            sb2.append((Object)this.b);
            string = sb2.toString();
        }
        else {
            string = "";
        }
        sb.append(string);
        return sb.toString();
    }
}
