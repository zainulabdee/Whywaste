package z0;

import android.os.BaseBundle;
import android.os.Bundle;
import android.net.Uri;
import android.os.Parcel;
import android.util.Log;
import android.content.Intent;

public class a
{
    public static String a(final Intent intent) {
        final String b = b(intent);
        if (b != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("handleIntent: (Data) (short deep link)");
            sb.append(b);
            Log.d("com.llfbandit.app_links", sb.toString());
            return b;
        }
        return c(intent);
    }
    
    private static String b(final Intent intent) {
        final byte[] byteArrayExtra = intent.getByteArrayExtra("com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA");
        if (byteArrayExtra != null && byteArrayExtra.length != 0) {
            final Parcel obtain = Parcel.obtain();
            obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            obtain.setDataPosition(0);
            return z2.a.b(obtain, obtain.readInt());
        }
        return null;
    }
    
    private static String c(final Intent intent) {
        final String action = intent.getAction();
        String s2;
        final String s = s2 = intent.getDataString();
        if ("android.intent.action.SEND".equals((Object)action)) {
            final Bundle extras = intent.getExtras();
            s2 = s;
            if (extras != null) {
                if (((BaseBundle)extras).containsKey("android.intent.extra.TEXT")) {
                    final CharSequence charSequence = extras.getCharSequence("android.intent.extra.TEXT");
                    s2 = s;
                    if (charSequence != null) {
                        s2 = charSequence.toString();
                    }
                }
                else {
                    s2 = s;
                    if (((BaseBundle)extras).containsKey("android.intent.extra.STREAM")) {
                        final Uri uri = (Uri)extras.getParcelable("android.intent.extra.STREAM");
                        s2 = s;
                        if (uri != null) {
                            s2 = uri.toString();
                        }
                    }
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("handleIntent: (Action) ");
        sb.append(action);
        Log.d("com.llfbandit.app_links", sb.toString());
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("handleIntent: (Data) ");
        sb2.append(s2);
        Log.d("com.llfbandit.app_links", sb2.toString());
        return s2;
    }
}
