package io.sentry.android.core.internal.util;

import android.net.ConnectivityManager$NetworkCallback;
import android.net.NetworkCapabilities;
import android.net.Network;
import io.sentry.android.core.l0;
import android.net.NetworkInfo;
import io.sentry.l4;
import io.sentry.n0;
import android.net.ConnectivityManager;
import android.content.Context;

public final class f
{
    private static a a(final Context context, final ConnectivityManager connectivityManager, final n0 n0) {
        if (!m.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            n0.a(l4.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return a.NO_PERMISSION;
        }
        try {
            final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                n0.a(l4.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
                return a.NOT_CONNECTED;
            }
            a a;
            if (activeNetworkInfo.isConnected()) {
                a = f.a.CONNECTED;
            }
            else {
                a = f.a.NOT_CONNECTED;
            }
            return a;
        }
        finally {
            final Throwable t;
            n0.d(l4.ERROR, "Could not retrieve Connection Status", t);
            return a.UNKNOWN;
        }
    }
    
    public static a b(final Context context, final n0 n0) {
        final ConnectivityManager e = e(context, n0);
        if (e == null) {
            return a.UNKNOWN;
        }
        return a(context, e, n0);
    }
    
    public static String c(final Context context, final n0 n0, final l0 l0) {
        final ConnectivityManager e = e(context, n0);
        if (e == null) {
            return null;
        }
        final boolean a = m.a(context, "android.permission.ACCESS_NETWORK_STATE");
        final int n2 = 0;
        int hasTransport = 0;
        if (!a) {
            n0.a(l4.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return null;
        }
        try {
            final int d = l0.d();
            boolean hasTransport2 = true;
            int hasTransport3;
            if (d >= 23) {
                final Network a2 = io.sentry.android.core.internal.util.e.a(e);
                if (a2 == null) {
                    n0.a(l4.INFO, "Network is null and cannot check network status", new Object[0]);
                    return null;
                }
                final NetworkCapabilities networkCapabilities = e.getNetworkCapabilities(a2);
                if (networkCapabilities == null) {
                    n0.a(l4.INFO, "NetworkCapabilities is null and cannot check network type", new Object[0]);
                    return null;
                }
                hasTransport = (networkCapabilities.hasTransport(3) ? 1 : 0);
                hasTransport3 = (networkCapabilities.hasTransport(1) ? 1 : 0);
                hasTransport2 = networkCapabilities.hasTransport(0);
            }
            else {
                final NetworkInfo activeNetworkInfo = e.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    n0.a(l4.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
                    return null;
                }
                final int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type != 9) {
                            hasTransport3 = 0;
                        }
                        else {
                            hasTransport3 = 0;
                            hasTransport = 1;
                        }
                    }
                    else {
                        hasTransport3 = 1;
                    }
                    hasTransport2 = false;
                }
                else {
                    final int n3 = 0;
                    hasTransport = n2;
                    hasTransport3 = n3;
                }
            }
            if (hasTransport != 0) {
                return "ethernet";
            }
            if (hasTransport3 != 0) {
                return "wifi";
            }
            if (hasTransport2) {
                return "cellular";
            }
        }
        finally {
            final Throwable t;
            n0.d(l4.ERROR, "Failed to retrieve network info", t);
        }
        return null;
    }
    
    public static String d(final NetworkCapabilities networkCapabilities, final l0 l0) {
        if (l0.d() < 21) {
            return null;
        }
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(0)) {
            return "cellular";
        }
        return null;
    }
    
    private static ConnectivityManager e(final Context context, final n0 n0) {
        final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivityManager == null) {
            n0.a(l4.INFO, "ConnectivityManager is null and cannot check network status", new Object[0]);
        }
        return connectivityManager;
    }
    
    public static boolean f(final Context context, final n0 n0, final l0 l0, final ConnectivityManager$NetworkCallback connectivityManager$NetworkCallback) {
        if (l0.d() < 24) {
            n0.a(l4.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        final ConnectivityManager e = e(context, n0);
        if (e == null) {
            return false;
        }
        if (!m.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            n0.a(l4.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        try {
            d.a(e, connectivityManager$NetworkCallback);
            return true;
        }
        finally {
            final Throwable t;
            n0.d(l4.ERROR, "registerDefaultNetworkCallback failed", t);
            return false;
        }
    }
    
    public static void g(final Context context, final n0 n0, final l0 l0, final ConnectivityManager$NetworkCallback connectivityManager$NetworkCallback) {
        if (l0.d() < 21) {
            return;
        }
        final ConnectivityManager e = e(context, n0);
        if (e == null) {
            return;
        }
        try {
            e.unregisterNetworkCallback(connectivityManager$NetworkCallback);
        }
        finally {
            final Throwable t;
            n0.d(l4.ERROR, "unregisterNetworkCallback failed", t);
        }
    }
    
    public enum a
    {
        private static final a[] $VALUES;
        
        CONNECTED, 
        NOT_CONNECTED, 
        NO_PERMISSION, 
        UNKNOWN;
        
        private static /* synthetic */ a[] $values() {
            return new a[] { a.CONNECTED, a.NOT_CONNECTED, a.NO_PERMISSION, a.UNKNOWN };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
