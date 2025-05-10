package t1;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.lang.reflect.Array;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

public class h
{
    public static Object a(final Object o) {
        if (o == null) {
            return JSONObject.NULL;
        }
        Object o2 = o;
        if (o instanceof JSONArray) {
            return o2;
        }
        if (o instanceof JSONObject) {
            o2 = o;
            return o2;
        }
        if (o.equals(JSONObject.NULL)) {
            return o;
        }
        try {
            if (o instanceof Collection) {
                final JSONArray jsonArray = new JSONArray();
                final Iterator iterator = ((Collection)o).iterator();
                while (iterator.hasNext()) {
                    jsonArray.put(a(iterator.next()));
                }
                return jsonArray;
            }
            if (o.getClass().isArray()) {
                final JSONArray jsonArray2 = new JSONArray();
                for (int length = Array.getLength(o), i = 0; i < length; ++i) {
                    jsonArray2.put(a(Array.get(o, i)));
                }
                return jsonArray2;
            }
            if (o instanceof Map) {
                final JSONObject jsonObject = new JSONObject();
                for (final Map$Entry map$Entry : ((Map)o).entrySet()) {
                    jsonObject.put((String)map$Entry.getKey(), a(map$Entry.getValue()));
                }
                return jsonObject;
            }
            Object string = o;
            if (!(o instanceof Boolean)) {
                string = o;
                if (!(o instanceof Byte)) {
                    string = o;
                    if (!(o instanceof Character)) {
                        string = o;
                        if (!(o instanceof Double)) {
                            string = o;
                            if (!(o instanceof Float)) {
                                string = o;
                                if (!(o instanceof Integer)) {
                                    string = o;
                                    if (!(o instanceof Long)) {
                                        string = o;
                                        if (!(o instanceof Short)) {
                                            if (o instanceof String) {
                                                string = o;
                                            }
                                            else {
                                                if (!o.getClass().getPackage().getName().startsWith("java.")) {
                                                    o2 = null;
                                                    return o2;
                                                }
                                                string = o.toString();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return string;
        }
        catch (final Exception ex) {
            return null;
        }
    }
}
