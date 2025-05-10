package io.sentry.android.core;

import java.util.Iterator;
import android.content.IntentFilter;
import io.sentry.q4;
import io.sentry.m0;
import io.sentry.l4;
import android.content.BroadcastReceiver;
import io.sentry.a1;
import io.sentry.z0;
import java.util.ArrayList;
import io.sentry.util.n;
import java.util.List;
import android.content.Context;
import java.io.Closeable;
import io.sentry.Integration;

public final class SystemEventsBreadcrumbsIntegration implements Integration, Closeable
{
    private final Context e;
    SystemEventsBreadcrumbsIntegration.SystemEventsBreadcrumbsIntegration$a f;
    private SentryAndroidOptions g;
    private final List<String> h;
    
    public SystemEventsBreadcrumbsIntegration(final Context context) {
        this(context, c());
    }
    
    public SystemEventsBreadcrumbsIntegration(final Context context, final List<String> list) {
        this.e = (Context)n.c((Object)context, "Context is required");
        this.h = (List<String>)n.c((Object)list, "Actions list is required");
    }
    
    private static List<String> c() {
        final ArrayList list = new ArrayList();
        ((List)list).add((Object)"android.appwidget.action.APPWIDGET_DELETED");
        ((List)list).add((Object)"android.appwidget.action.APPWIDGET_DISABLED");
        ((List)list).add((Object)"android.appwidget.action.APPWIDGET_ENABLED");
        ((List)list).add((Object)"android.appwidget.action.APPWIDGET_HOST_RESTORED");
        ((List)list).add((Object)"android.appwidget.action.APPWIDGET_RESTORED");
        ((List)list).add((Object)"android.appwidget.action.APPWIDGET_UPDATE");
        ((List)list).add((Object)"android.appwidget.action.APPWIDGET_UPDATE_OPTIONS");
        ((List)list).add((Object)"android.intent.action.ACTION_POWER_CONNECTED");
        ((List)list).add((Object)"android.intent.action.ACTION_POWER_DISCONNECTED");
        ((List)list).add((Object)"android.intent.action.ACTION_SHUTDOWN");
        ((List)list).add((Object)"android.intent.action.AIRPLANE_MODE");
        ((List)list).add((Object)"android.intent.action.BATTERY_LOW");
        ((List)list).add((Object)"android.intent.action.BATTERY_OKAY");
        ((List)list).add((Object)"android.intent.action.BOOT_COMPLETED");
        ((List)list).add((Object)"android.intent.action.CAMERA_BUTTON");
        ((List)list).add((Object)"android.intent.action.CONFIGURATION_CHANGED");
        ((List)list).add((Object)"android.intent.action.CONTENT_CHANGED");
        ((List)list).add((Object)"android.intent.action.DATE_CHANGED");
        ((List)list).add((Object)"android.intent.action.DEVICE_STORAGE_LOW");
        ((List)list).add((Object)"android.intent.action.DEVICE_STORAGE_OK");
        ((List)list).add((Object)"android.intent.action.DOCK_EVENT");
        ((List)list).add((Object)"android.intent.action.DREAMING_STARTED");
        ((List)list).add((Object)"android.intent.action.DREAMING_STOPPED");
        ((List)list).add((Object)"android.intent.action.INPUT_METHOD_CHANGED");
        ((List)list).add((Object)"android.intent.action.LOCALE_CHANGED");
        ((List)list).add((Object)"android.intent.action.REBOOT");
        ((List)list).add((Object)"android.intent.action.SCREEN_OFF");
        ((List)list).add((Object)"android.intent.action.SCREEN_ON");
        ((List)list).add((Object)"android.intent.action.TIMEZONE_CHANGED");
        ((List)list).add((Object)"android.intent.action.TIME_SET");
        ((List)list).add((Object)"android.os.action.DEVICE_IDLE_MODE_CHANGED");
        ((List)list).add((Object)"android.os.action.POWER_SAVE_MODE_CHANGED");
        ((List)list).add((Object)"android.intent.action.APP_ERROR");
        ((List)list).add((Object)"android.intent.action.BUG_REPORT");
        ((List)list).add((Object)"android.intent.action.MEDIA_BAD_REMOVAL");
        ((List)list).add((Object)"android.intent.action.MEDIA_MOUNTED");
        ((List)list).add((Object)"android.intent.action.MEDIA_UNMOUNTABLE");
        ((List)list).add((Object)"android.intent.action.MEDIA_UNMOUNTED");
        return (List<String>)list;
    }
    
    public /* synthetic */ void b() {
        z0.a((a1)this);
    }
    
    public void close() {
        final SystemEventsBreadcrumbsIntegration.SystemEventsBreadcrumbsIntegration$a f = this.f;
        if (f != null) {
            this.e.unregisterReceiver((BroadcastReceiver)f);
            this.f = null;
            final SentryAndroidOptions g = this.g;
            if (g != null) {
                ((q4)g).getLogger().a(l4.DEBUG, "SystemEventsBreadcrumbsIntegration remove.", new Object[0]);
            }
        }
    }
    
    public void d(final m0 m0, final q4 q4) {
        n.c((Object)m0, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions;
        if (q4 instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions)q4;
        }
        else {
            sentryAndroidOptions = null;
        }
        final SentryAndroidOptions g = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.g = g;
        ((q4)g).getLogger().a(l4.DEBUG, "SystemEventsBreadcrumbsIntegration enabled: %s", new Object[] { this.g.isEnableSystemEventBreadcrumbs() });
        if (this.g.isEnableSystemEventBreadcrumbs()) {
            this.f = new SystemEventsBreadcrumbsIntegration.SystemEventsBreadcrumbsIntegration$a(m0, ((q4)this.g).getLogger());
            final IntentFilter intentFilter = new IntentFilter();
            final Iterator iterator = this.h.iterator();
            while (iterator.hasNext()) {
                intentFilter.addAction((String)iterator.next());
            }
            try {
                this.e.registerReceiver((BroadcastReceiver)this.f, intentFilter);
                ((q4)this.g).getLogger().a(l4.DEBUG, "SystemEventsBreadcrumbsIntegration installed.", new Object[0]);
                this.b();
            }
            finally {
                this.g.setEnableSystemEventBreadcrumbs(false);
                final Throwable t;
                ((q4)this.g).getLogger().d(l4.ERROR, "Failed to initialize SystemEventsBreadcrumbsIntegration.", t);
            }
        }
    }
}
