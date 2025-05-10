package s1;

import java.util.List;
import android.os.BaseBundle;
import android.os.Build$VERSION;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Map$Entry;
import android.os.Bundle;
import java.io.Serializable;
import java.util.Arrays;
import f1.b;
import java.util.Map;
import java.util.Iterator;
import org.json.JSONArray;
import java.util.HashMap;
import java.util.ArrayList;
import t1.l;
import t1.c;
import t1.g;
import g1.a;
import t1.k;

public class p
{
    public final k a;
    private f b;
    final k.c c;
    
    public p(final g1.a a) {
        final p$a c = new p$a(this);
        this.c = (k.c)c;
        (this.a = new k(a, "flutter/textinput", (l)t1.g.a)).e((k.c)c);
    }
    
    private static HashMap<Object, Object> c(final ArrayList<io.flutter.plugin.editing.g> list) {
        final HashMap hashMap = new HashMap();
        final JSONArray jsonArray = new JSONArray();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            jsonArray.put((Object)((io.flutter.plugin.editing.g)iterator.next()).b());
        }
        hashMap.put((Object)"deltas", (Object)jsonArray);
        return (HashMap<Object, Object>)hashMap;
    }
    
    private static HashMap<Object, Object> d(final String s, final int n, final int n2, final int n3, final int n4) {
        final HashMap hashMap = new HashMap();
        hashMap.put((Object)"text", (Object)s);
        hashMap.put((Object)"selectionBase", (Object)n);
        hashMap.put((Object)"selectionExtent", (Object)n2);
        hashMap.put((Object)"composingBase", (Object)n3);
        hashMap.put((Object)"composingExtent", (Object)n4);
        return (HashMap<Object, Object>)hashMap;
    }
    
    public void b(final int n, final Map<String, Object> map) {
        f1.b.f("TextInputChannel", "Sending 'commitContent' message.");
        this.a.c("TextInputClient.performAction", Arrays.asList(new Object[] { n, "TextInputAction.commitContent", map }));
    }
    
    public void e(final int n) {
        f1.b.f("TextInputChannel", "Sending 'done' message.");
        this.a.c("TextInputClient.performAction", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)"TextInputAction.done" }));
    }
    
    public void f(final int n) {
        f1.b.f("TextInputChannel", "Sending 'go' message.");
        this.a.c("TextInputClient.performAction", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)"TextInputAction.go" }));
    }
    
    public void g(final int n) {
        f1.b.f("TextInputChannel", "Sending 'newline' message.");
        this.a.c("TextInputClient.performAction", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)"TextInputAction.newline" }));
    }
    
    public void h(final int n) {
        f1.b.f("TextInputChannel", "Sending 'next' message.");
        this.a.c("TextInputClient.performAction", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)"TextInputAction.next" }));
    }
    
    public void i(final int n, final String s, final Bundle bundle) {
        final HashMap hashMap = new HashMap();
        hashMap.put((Object)"action", (Object)s);
        if (bundle != null) {
            final HashMap hashMap2 = new HashMap();
            for (final String s2 : ((BaseBundle)bundle).keySet()) {
                final Object value = ((BaseBundle)bundle).get(s2);
                if (value instanceof byte[]) {
                    hashMap2.put((Object)s2, (Object)bundle.getByteArray(s2));
                }
                else if (value instanceof Byte) {
                    hashMap2.put((Object)s2, (Object)bundle.getByte(s2));
                }
                else if (value instanceof char[]) {
                    hashMap2.put((Object)s2, (Object)bundle.getCharArray(s2));
                }
                else if (value instanceof Character) {
                    hashMap2.put((Object)s2, (Object)bundle.getChar(s2));
                }
                else if (value instanceof CharSequence[]) {
                    hashMap2.put((Object)s2, (Object)bundle.getCharSequenceArray(s2));
                }
                else if (value instanceof CharSequence) {
                    hashMap2.put((Object)s2, (Object)bundle.getCharSequence(s2));
                }
                else if (value instanceof float[]) {
                    hashMap2.put((Object)s2, (Object)bundle.getFloatArray(s2));
                }
                else {
                    if (!(value instanceof Float)) {
                        continue;
                    }
                    hashMap2.put((Object)s2, (Object)bundle.getFloat(s2));
                }
            }
            hashMap.put((Object)"data", (Object)hashMap2);
        }
        this.a.c("TextInputClient.performPrivateCommand", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)hashMap }));
    }
    
    public void j(final int n) {
        f1.b.f("TextInputChannel", "Sending 'previous' message.");
        this.a.c("TextInputClient.performAction", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)"TextInputAction.previous" }));
    }
    
    public void k() {
        this.a.c("TextInputClient.requestExistingInputState", null);
    }
    
    public void l(final int n) {
        f1.b.f("TextInputChannel", "Sending 'search' message.");
        this.a.c("TextInputClient.performAction", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)"TextInputAction.search" }));
    }
    
    public void m(final int n) {
        f1.b.f("TextInputChannel", "Sending 'send' message.");
        this.a.c("TextInputClient.performAction", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)"TextInputAction.send" }));
    }
    
    public void n(final f b) {
        this.b = b;
    }
    
    public void o(final int n) {
        f1.b.f("TextInputChannel", "Sending 'unspecified' message.");
        this.a.c("TextInputClient.performAction", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)"TextInputAction.unspecified" }));
    }
    
    public void p(final int n, final String s, final int n2, final int n3, final int n4, final int n5) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Sending message to update editing state: \nText: ");
        sb.append(s);
        sb.append("\nSelection start: ");
        sb.append(n2);
        sb.append("\nSelection end: ");
        sb.append(n3);
        sb.append("\nComposing start: ");
        sb.append(n4);
        sb.append("\nComposing end: ");
        sb.append(n5);
        f1.b.f("TextInputChannel", sb.toString());
        this.a.c("TextInputClient.updateEditingState", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)d(s, n2, n3, n4, n5) }));
    }
    
    public void q(final int n, final ArrayList<io.flutter.plugin.editing.g> list) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Sending message to update editing state with deltas: \nNumber of deltas: ");
        sb.append(list.size());
        f1.b.f("TextInputChannel", sb.toString());
        this.a.c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)c(list) }));
    }
    
    public void r(final int n, final HashMap<String, e> hashMap) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Sending message to update editing state for ");
        sb.append(String.valueOf(hashMap.size()));
        sb.append(" field(s).");
        f1.b.f("TextInputChannel", sb.toString());
        final HashMap hashMap2 = new HashMap();
        for (final Map$Entry map$Entry : hashMap.entrySet()) {
            final e e = (e)map$Entry.getValue();
            hashMap2.put((Object)map$Entry.getKey(), (Object)d(e.a, e.b, e.c, -1, -1));
        }
        this.a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList((Object[])new Serializable[] { (Serializable)n, (Serializable)hashMap2 }));
    }
    
    public static class b
    {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final d f;
        public final c g;
        public final Integer h;
        public final String i;
        public final a j;
        public final String[] k;
        public final b[] l;
        
        public b(final boolean a, final boolean b, final boolean c, final boolean d, final boolean e, final d f, final c g, final Integer h, final String i, final a j, final String[] k, final b[] l) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
            this.k = k;
            this.l = l;
        }
        
        public static b a(final JSONObject jsonObject) {
            final String string = jsonObject.getString("inputAction");
            if (string != null) {
                final boolean null = jsonObject.isNull("fields");
                final int n = 0;
                final a a = null;
                b[] array;
                if (!null) {
                    final JSONArray jsonArray = jsonObject.getJSONArray("fields");
                    final int length = jsonArray.length();
                    array = new b[length];
                    for (int i = 0; i < length; ++i) {
                        array[i] = a(jsonArray.getJSONObject(i));
                    }
                }
                else {
                    array = null;
                }
                final Integer b = b(string);
                final ArrayList list = new ArrayList();
                JSONArray jsonArray2;
                if (jsonObject.isNull("contentCommitMimeTypes")) {
                    jsonArray2 = null;
                }
                else {
                    jsonArray2 = jsonObject.getJSONArray("contentCommitMimeTypes");
                }
                if (jsonArray2 != null) {
                    for (int j = n; j < jsonArray2.length(); ++j) {
                        ((List)list).add((Object)jsonArray2.optString(j));
                    }
                }
                final boolean optBoolean = jsonObject.optBoolean("obscureText");
                final boolean optBoolean2 = jsonObject.optBoolean("autocorrect", true);
                final boolean optBoolean3 = jsonObject.optBoolean("enableSuggestions");
                final boolean optBoolean4 = jsonObject.optBoolean("enableIMEPersonalizedLearning");
                final boolean optBoolean5 = jsonObject.optBoolean("enableDeltaModel");
                final d d = p.d.d(jsonObject.getString("textCapitalization"));
                final c a2 = c.a(jsonObject.getJSONObject("inputType"));
                String string2;
                if (jsonObject.isNull("actionLabel")) {
                    string2 = null;
                }
                else {
                    string2 = jsonObject.getString("actionLabel");
                }
                a a3;
                if (jsonObject.isNull("autofill")) {
                    a3 = a;
                }
                else {
                    a3 = p.b.a.a(jsonObject.getJSONObject("autofill"));
                }
                return new b(optBoolean, optBoolean2, optBoolean3, optBoolean4, optBoolean5, d, a2, b, string2, a3, (String[])((List)list).toArray((Object[])new String[((List)list).size()]), array);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }
        
        private static Integer b(final String s) {
            s.hashCode();
            final int hashCode = s.hashCode();
            int n = 1;
            final Integer value = 1;
            final Integer value2 = 0;
            Label_0261: {
                switch (hashCode) {
                    case 2110497650: {
                        if (!s.equals((Object)"TextInputAction.previous")) {
                            break;
                        }
                        n = 8;
                        break Label_0261;
                    }
                    case 1539450297: {
                        if (!s.equals((Object)"TextInputAction.newline")) {
                            break;
                        }
                        n = 7;
                        break Label_0261;
                    }
                    case 1241689507: {
                        if (!s.equals((Object)"TextInputAction.go")) {
                            break;
                        }
                        n = 6;
                        break Label_0261;
                    }
                    case 469250275: {
                        if (!s.equals((Object)"TextInputAction.search")) {
                            break;
                        }
                        n = 5;
                        break Label_0261;
                    }
                    case -736940669: {
                        if (!s.equals((Object)"TextInputAction.send")) {
                            break;
                        }
                        n = 4;
                        break Label_0261;
                    }
                    case -737080013: {
                        if (!s.equals((Object)"TextInputAction.none")) {
                            break;
                        }
                        n = 3;
                        break Label_0261;
                    }
                    case -737089298: {
                        if (!s.equals((Object)"TextInputAction.next")) {
                            break;
                        }
                        n = 2;
                        break Label_0261;
                    }
                    case -737377923: {
                        if (!s.equals((Object)"TextInputAction.done")) {
                            break;
                        }
                        break Label_0261;
                    }
                    case -810971940: {
                        if (!s.equals((Object)"TextInputAction.unspecified")) {
                            break;
                        }
                        n = 0;
                        break Label_0261;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    return value2;
                }
                case 8: {
                    return 7;
                }
                case 7: {
                    return value;
                }
                case 6: {
                    return 2;
                }
                case 5: {
                    return 3;
                }
                case 4: {
                    return 4;
                }
                case 3: {
                    return value;
                }
                case 2: {
                    return 5;
                }
                case 1: {
                    return 6;
                }
                case 0: {
                    return value2;
                }
            }
        }
        
        public static class a
        {
            public final String a;
            public final String[] b;
            public final e c;
            public final String d;
            
            public a(final String a, final String[] b, final String d, final e c) {
                this.a = a;
                this.b = b;
                this.d = d;
                this.c = c;
            }
            
            public static a a(final JSONObject jsonObject) {
                final String string = jsonObject.getString("uniqueIdentifier");
                final JSONArray jsonArray = jsonObject.getJSONArray("hints");
                String string2;
                if (jsonObject.isNull("hintText")) {
                    string2 = null;
                }
                else {
                    string2 = jsonObject.getString("hintText");
                }
                final JSONObject jsonObject2 = jsonObject.getJSONObject("editingValue");
                final String[] array = new String[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); ++i) {
                    array[i] = b(jsonArray.getString(i));
                }
                return new a(string, array, string2, e.a(jsonObject2));
            }
            
            private static String b(final String s) {
                final int sdk_INT = Build$VERSION.SDK_INT;
                int n = 26;
                if (sdk_INT < 26) {
                    return s;
                }
                s.hashCode();
                Label_0962: {
                    switch (s.hashCode()) {
                        case 2011773919: {
                            if (!s.equals((Object)"birthdayDay")) {
                                break;
                            }
                            n = 35;
                            break Label_0962;
                        }
                        case 2011152728: {
                            if (!s.equals((Object)"postalCode")) {
                                break;
                            }
                            n = 34;
                            break Label_0962;
                        }
                        case 1921869058: {
                            if (!s.equals((Object)"postalAddressExtended")) {
                                break;
                            }
                            n = 33;
                            break Label_0962;
                        }
                        case 1662667945: {
                            if (!s.equals((Object)"postalAddress")) {
                                break;
                            }
                            n = 32;
                            break Label_0962;
                        }
                        case 1469046696: {
                            if (!s.equals((Object)"givenName")) {
                                break;
                            }
                            n = 31;
                            break Label_0962;
                        }
                        case 1216985755: {
                            if (!s.equals((Object)"password")) {
                                break;
                            }
                            n = 30;
                            break Label_0962;
                        }
                        case 1069376125: {
                            if (!s.equals((Object)"birthday")) {
                                break;
                            }
                            n = 29;
                            break Label_0962;
                        }
                        case 991032982: {
                            if (!s.equals((Object)"newUsername")) {
                                break;
                            }
                            n = 28;
                            break Label_0962;
                        }
                        case 892233837: {
                            if (!s.equals((Object)"telephoneNumber")) {
                                break;
                            }
                            n = 27;
                            break Label_0962;
                        }
                        case 798554127: {
                            if (!s.equals((Object)"familyName")) {
                                break;
                            }
                            break Label_0962;
                        }
                        case 588174851: {
                            if (!s.equals((Object)"birthdayMonth")) {
                                break;
                            }
                            n = 25;
                            break Label_0962;
                        }
                        case 253202685: {
                            if (!s.equals((Object)"addressState")) {
                                break;
                            }
                            n = 24;
                            break Label_0962;
                        }
                        case 96619420: {
                            if (!s.equals((Object)"email")) {
                                break;
                            }
                            n = 23;
                            break Label_0962;
                        }
                        case 3373707: {
                            if (!s.equals((Object)"name")) {
                                break;
                            }
                            n = 22;
                            break Label_0962;
                        }
                        case -265713450: {
                            if (!s.equals((Object)"username")) {
                                break;
                            }
                            n = 21;
                            break Label_0962;
                        }
                        case -549230602: {
                            if (!s.equals((Object)"telephoneNumberCountryCode")) {
                                break;
                            }
                            n = 20;
                            break Label_0962;
                        }
                        case -613352043: {
                            if (!s.equals((Object)"creditCardExpirationYear")) {
                                break;
                            }
                            n = 19;
                            break Label_0962;
                        }
                        case -613980922: {
                            if (!s.equals((Object)"creditCardExpirationDate")) {
                                break;
                            }
                            n = 18;
                            break Label_0962;
                        }
                        case -747304516: {
                            if (!s.equals((Object)"nameSuffix")) {
                                break;
                            }
                            n = 17;
                            break Label_0962;
                        }
                        case -818219584: {
                            if (!s.equals((Object)"middleName")) {
                                break;
                            }
                            n = 16;
                            break Label_0962;
                        }
                        case -835992323: {
                            if (!s.equals((Object)"namePrefix")) {
                                break;
                            }
                            n = 15;
                            break Label_0962;
                        }
                        case -1151034798: {
                            if (!s.equals((Object)"creditCardNumber")) {
                                break;
                            }
                            n = 14;
                            break Label_0962;
                        }
                        case -1186060294: {
                            if (!s.equals((Object)"postalAddressExtendedPostalCode")) {
                                break;
                            }
                            n = 13;
                            break Label_0962;
                        }
                        case -1249512767: {
                            if (!s.equals((Object)"gender")) {
                                break;
                            }
                            n = 12;
                            break Label_0962;
                        }
                        case -1377792129: {
                            if (!s.equals((Object)"addressCity")) {
                                break;
                            }
                            n = 11;
                            break Label_0962;
                        }
                        case -1413737489: {
                            if (!s.equals((Object)"middleInitial")) {
                                break;
                            }
                            n = 10;
                            break Label_0962;
                        }
                        case -1476752575: {
                            if (!s.equals((Object)"countryName")) {
                                break;
                            }
                            n = 9;
                            break Label_0962;
                        }
                        case -1567118045: {
                            if (!s.equals((Object)"telephoneNumberDevice")) {
                                break;
                            }
                            n = 8;
                            break Label_0962;
                        }
                        case -1658955742: {
                            if (!s.equals((Object)"fullStreetAddress")) {
                                break;
                            }
                            n = 7;
                            break Label_0962;
                        }
                        case -1682373820: {
                            if (!s.equals((Object)"creditCardExpirationDay")) {
                                break;
                            }
                            n = 6;
                            break Label_0962;
                        }
                        case -1757573738: {
                            if (!s.equals((Object)"creditCardSecurityCode")) {
                                break;
                            }
                            n = 5;
                            break Label_0962;
                        }
                        case -1821235109: {
                            if (!s.equals((Object)"newPassword")) {
                                break;
                            }
                            n = 4;
                            break Label_0962;
                        }
                        case -1825589953: {
                            if (!s.equals((Object)"telephoneNumberNational")) {
                                break;
                            }
                            n = 3;
                            break Label_0962;
                        }
                        case -1844815832: {
                            if (!s.equals((Object)"creditCardExpirationMonth")) {
                                break;
                            }
                            n = 2;
                            break Label_0962;
                        }
                        case -1917283616: {
                            if (!s.equals((Object)"oneTimeCode")) {
                                break;
                            }
                            n = 1;
                            break Label_0962;
                        }
                        case -2058889126: {
                            if (!s.equals((Object)"birthdayYear")) {
                                break;
                            }
                            n = 0;
                            break Label_0962;
                        }
                    }
                    n = -1;
                }
                switch (n) {
                    default: {
                        return s;
                    }
                    case 35: {
                        return "birthDateDay";
                    }
                    case 34: {
                        return "postalCode";
                    }
                    case 33: {
                        return "extendedAddress";
                    }
                    case 32: {
                        return "postalAddress";
                    }
                    case 31: {
                        return "personGivenName";
                    }
                    case 30: {
                        return "password";
                    }
                    case 29: {
                        return "birthDateFull";
                    }
                    case 28: {
                        return "newUsername";
                    }
                    case 27: {
                        return "phoneNumber";
                    }
                    case 26: {
                        return "personFamilyName";
                    }
                    case 25: {
                        return "birthDateMonth";
                    }
                    case 24: {
                        return "addressRegion";
                    }
                    case 23: {
                        return "emailAddress";
                    }
                    case 22: {
                        return "personName";
                    }
                    case 21: {
                        return "username";
                    }
                    case 20: {
                        return "phoneCountryCode";
                    }
                    case 19: {
                        return "creditCardExpirationYear";
                    }
                    case 18: {
                        return "creditCardExpirationDate";
                    }
                    case 17: {
                        return "personNameSuffix";
                    }
                    case 16: {
                        return "personMiddleName";
                    }
                    case 15: {
                        return "personNamePrefix";
                    }
                    case 14: {
                        return "creditCardNumber";
                    }
                    case 13: {
                        return "extendedPostalCode";
                    }
                    case 12: {
                        return "gender";
                    }
                    case 11: {
                        return "addressLocality";
                    }
                    case 10: {
                        return "personMiddleInitial";
                    }
                    case 9: {
                        return "addressCountry";
                    }
                    case 8: {
                        return "phoneNumberDevice";
                    }
                    case 7: {
                        return "streetAddress";
                    }
                    case 6: {
                        return "creditCardExpirationDay";
                    }
                    case 5: {
                        return "creditCardSecurityCode";
                    }
                    case 4: {
                        return "newPassword";
                    }
                    case 3: {
                        return "phoneNational";
                    }
                    case 2: {
                        return "creditCardExpirationMonth";
                    }
                    case 1: {
                        return "smsOTPCode";
                    }
                    case 0: {
                        return "birthDateYear";
                    }
                }
            }
        }
    }
    
    public static class c
    {
        public final g a;
        public final boolean b;
        public final boolean c;
        
        public c(final g a, final boolean b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public static c a(final JSONObject jsonObject) {
            return new c(g.d(jsonObject.getString("name")), jsonObject.optBoolean("signed", false), jsonObject.optBoolean("decimal", false));
        }
    }
    
    public enum d
    {
        f("TextCapitalization.characters"), 
        g("TextCapitalization.words"), 
        h("TextCapitalization.sentences"), 
        i("TextCapitalization.none");
        
        private static final d[] j;
        private final String e;
        
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
            sb.append("No such TextCapitalization: ");
            sb.append(s);
            throw new NoSuchFieldException(sb.toString());
        }
    }
    
    public static class e
    {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        
        public e(final String a, final int b, final int c, final int d, final int e) {
            if ((b != -1 || c != -1) && (b < 0 || c < 0)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("invalid selection: (");
                sb.append(String.valueOf(b));
                sb.append(", ");
                sb.append(String.valueOf(c));
                sb.append(")");
                throw new IndexOutOfBoundsException(sb.toString());
            }
            if ((d != -1 || e != -1) && (d < 0 || d > e)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("invalid composing range: (");
                sb2.append(String.valueOf(d));
                sb2.append(", ");
                sb2.append(String.valueOf(e));
                sb2.append(")");
                throw new IndexOutOfBoundsException(sb2.toString());
            }
            if (e > a.length()) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("invalid composing start: ");
                sb3.append(String.valueOf(d));
                throw new IndexOutOfBoundsException(sb3.toString());
            }
            if (b > a.length()) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("invalid selection start: ");
                sb4.append(String.valueOf(b));
                throw new IndexOutOfBoundsException(sb4.toString());
            }
            if (c <= a.length()) {
                this.a = a;
                this.b = b;
                this.c = c;
                this.d = d;
                this.e = e;
                return;
            }
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("invalid selection end: ");
            sb5.append(String.valueOf(c));
            throw new IndexOutOfBoundsException(sb5.toString());
        }
        
        public static e a(final JSONObject jsonObject) {
            return new e(jsonObject.getString("text"), jsonObject.getInt("selectionBase"), jsonObject.getInt("selectionExtent"), jsonObject.getInt("composingBase"), jsonObject.getInt("composingExtent"));
        }
        
        public boolean b() {
            final int d = this.d;
            return d >= 0 && this.e > d;
        }
        
        public boolean c() {
            return this.b >= 0;
        }
    }
    
    public interface f
    {
        void a();
        
        void b();
        
        void c(final String p0, final Bundle p1);
        
        void d(final int p0, final boolean p1);
        
        void e(final double p0, final double p1, final double[] p2);
        
        void f(final int p0, final b p1);
        
        void g();
        
        void h(final e p0);
        
        void i(final boolean p0);
        
        void j();
    }
    
    public enum g
    {
        f("TextInputType.text"), 
        g("TextInputType.datetime"), 
        h("TextInputType.name"), 
        i("TextInputType.address"), 
        j("TextInputType.number"), 
        k("TextInputType.phone"), 
        l("TextInputType.multiline"), 
        m("TextInputType.emailAddress"), 
        n("TextInputType.url"), 
        o("TextInputType.visiblePassword"), 
        p("TextInputType.none");
        
        private static final g[] q;
        private final String e;
        
        private g(final String e) {
            this.e = e;
        }
        
        static g d(final String s) {
            for (final g g : values()) {
                if (g.e.equals((Object)s)) {
                    return g;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No such TextInputType: ");
            sb.append(s);
            throw new NoSuchFieldException(sb.toString());
        }
    }
}
