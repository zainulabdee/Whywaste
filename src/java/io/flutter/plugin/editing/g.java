package io.flutter.plugin.editing;

import org.json.JSONException;
import f1.b;
import org.json.JSONObject;

public final class g
{
    private CharSequence a;
    private CharSequence b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    
    public g(final CharSequence charSequence, final int e, final int f, final int g, final int h) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.a(charSequence, (CharSequence)"", -1, -1);
    }
    
    public g(final CharSequence charSequence, final int n, final int n2, final CharSequence charSequence2, final int e, final int f, final int g, final int h) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.a(charSequence, (CharSequence)charSequence2.toString(), n, n2);
    }
    
    private void a(final CharSequence a, final CharSequence b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public JSONObject b() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("oldText", (Object)this.a.toString());
            jsonObject.put("deltaText", (Object)this.b.toString());
            jsonObject.put("deltaStart", this.c);
            jsonObject.put("deltaEnd", this.d);
            jsonObject.put("selectionBase", this.e);
            jsonObject.put("selectionExtent", this.f);
            jsonObject.put("composingBase", this.g);
            jsonObject.put("composingExtent", this.h);
        }
        catch (final JSONException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("unable to create JSONObject: ");
            sb.append((Object)ex);
            f1.b.b("TextEditingDelta", sb.toString());
        }
        return jsonObject;
    }
}
