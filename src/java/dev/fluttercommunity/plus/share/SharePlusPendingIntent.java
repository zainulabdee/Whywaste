package dev.fluttercommunity.plus.share;

import android.content.ComponentName;
import android.os.Build$VERSION;
import kotlin.jvm.internal.i;
import android.content.Intent;
import android.content.Context;
import kotlin.jvm.internal.e;
import android.content.BroadcastReceiver;

public final class SharePlusPendingIntent extends BroadcastReceiver
{
    public static final a a;
    private static String b;
    
    static {
        a = new a(null);
        SharePlusPendingIntent.b = "";
    }
    
    public static final /* synthetic */ String a() {
        return SharePlusPendingIntent.b;
    }
    
    public static final /* synthetic */ void b(final String b) {
        SharePlusPendingIntent.b = b;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        i.e((Object)context, "context");
        i.e((Object)intent, "intent");
        ComponentName componentName;
        if (Build$VERSION.SDK_INT >= 33) {
            componentName = (ComponentName)intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT", (Class)ComponentName.class);
        }
        else {
            componentName = (ComponentName)intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
        }
        if (componentName != null) {
            final String flattenToString = componentName.flattenToString();
            i.d((Object)flattenToString, "chosenComponent.flattenToString()");
            SharePlusPendingIntent.b = flattenToString;
        }
    }
    
    public static final class a
    {
        private a() {
        }
        
        public final String a() {
            return SharePlusPendingIntent.a();
        }
        
        public final void b(final String s) {
            i.e((Object)s, "<set-?>");
            SharePlusPendingIntent.b(s);
        }
    }
}
