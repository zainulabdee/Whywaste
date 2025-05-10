package io.sentry.android.core;

import io.sentry.a0;
import io.sentry.e;
import android.hardware.SensorEvent;
import android.hardware.Sensor;
import io.sentry.n0;
import io.sentry.q4;
import io.sentry.l4;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.util.n;
import android.hardware.SensorManager;
import io.sentry.m0;
import android.content.Context;
import android.hardware.SensorEventListener;
import java.io.Closeable;
import io.sentry.Integration;

public final class TempSensorBreadcrumbsIntegration implements Integration, Closeable, SensorEventListener
{
    private final Context e;
    private m0 f;
    private SentryAndroidOptions g;
    SensorManager h;
    
    public TempSensorBreadcrumbsIntegration(final Context context) {
        this.e = (Context)n.c((Object)context, "Context is required");
    }
    
    public /* synthetic */ void b() {
        z0.a((a1)this);
    }
    
    public void close() {
        final SensorManager h = this.h;
        if (h != null) {
            h.unregisterListener((SensorEventListener)this);
            this.h = null;
            final SentryAndroidOptions g = this.g;
            if (g != null) {
                ((q4)g).getLogger().a(l4.DEBUG, "TempSensorBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }
    
    public void d(final m0 m0, final q4 q4) {
        this.f = (m0)n.c((Object)m0, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions;
        if (q4 instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions)q4;
        }
        else {
            sentryAndroidOptions = null;
        }
        final SentryAndroidOptions g = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.g = g;
        final n0 logger = ((q4)g).getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "enableSystemEventsBreadcrumbs enabled: %s", new Object[] { this.g.isEnableSystemEventBreadcrumbs() });
        if (this.g.isEnableSystemEventBreadcrumbs()) {
            try {
                final SensorManager h = (SensorManager)this.e.getSystemService("sensor");
                this.h = h;
                if (h != null) {
                    final Sensor defaultSensor = h.getDefaultSensor(13);
                    if (defaultSensor != null) {
                        this.h.registerListener((SensorEventListener)this, defaultSensor, 3);
                        q4.getLogger().a(debug, "TempSensorBreadcrumbsIntegration installed.", new Object[0]);
                        this.b();
                    }
                    else {
                        ((q4)this.g).getLogger().a(l4.INFO, "TYPE_AMBIENT_TEMPERATURE is not available.", new Object[0]);
                    }
                }
                else {
                    ((q4)this.g).getLogger().a(l4.INFO, "SENSOR_SERVICE is not available.", new Object[0]);
                }
            }
            finally {
                final Throwable t;
                q4.getLogger().c(l4.ERROR, t, "Failed to init. the SENSOR_SERVICE.", new Object[0]);
            }
        }
    }
    
    public void onAccuracyChanged(final Sensor sensor, final int n) {
    }
    
    public void onSensorChanged(final SensorEvent sensorEvent) {
        final float[] values = sensorEvent.values;
        if (values != null && values.length != 0) {
            if (values[0] != 0.0f) {
                if (this.f != null) {
                    final e e = new e();
                    e.q("system");
                    e.m("device.event");
                    e.n("action", (Object)"TYPE_AMBIENT_TEMPERATURE");
                    e.n("accuracy", (Object)sensorEvent.accuracy);
                    e.n("timestamp", (Object)sensorEvent.timestamp);
                    e.o(l4.INFO);
                    e.n("degree", (Object)sensorEvent.values[0]);
                    final a0 a0 = new a0();
                    a0.j("android:sensorEvent", (Object)sensorEvent);
                    this.f.k(e, a0);
                }
            }
        }
    }
}
