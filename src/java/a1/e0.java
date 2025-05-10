package a1;

import java.util.Locale;
import android.util.Log;
import b1.a;
import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;

public class e0
{
    public static List<Object> a(final Cursor cursor, final int n) {
        final ArrayList list = new ArrayList(n);
        for (int i = 0; i < n; ++i) {
            final Object b = b(cursor, i);
            if (a.c) {
                String s = null;
                if (b != null) {
                    if (b.getClass().isArray()) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("array(");
                        sb.append(b.getClass().getComponentType().getName());
                        sb.append(")");
                        s = sb.toString();
                    }
                    else {
                        s = b.getClass().getName();
                    }
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("column ");
                sb2.append(i);
                sb2.append(" ");
                sb2.append(cursor.getType(i));
                sb2.append(": ");
                sb2.append(b);
                String string;
                if (s == null) {
                    string = "";
                }
                else {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(" (");
                    sb3.append(s);
                    sb3.append(")");
                    string = sb3.toString();
                }
                sb2.append(string);
                Log.d("Sqflite", sb2.toString());
            }
            ((List)list).add(b);
        }
        return (List<Object>)list;
    }
    
    public static Object b(final Cursor cursor, final int n) {
        final int type = cursor.getType(n);
        if (type == 1) {
            return cursor.getLong(n);
        }
        if (type == 2) {
            return cursor.getDouble(n);
        }
        if (type == 3) {
            return cursor.getString(n);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(n);
    }
    
    static Locale c(final String s) {
        return Locale.forLanguageTag(s);
    }
    
    static Locale d(final String s) {
        return c(s);
    }
}
