package io.sentry.android.core.internal.util;

import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import java.util.concurrent.TimeUnit;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import java.io.ByteArrayOutputStream;
import io.sentry.util.thread.b;
import io.sentry.l4;
import io.sentry.android.core.l0;
import android.app.Activity;
import io.sentry.n0;
import java.util.concurrent.CountDownLatch;
import android.graphics.Canvas;
import android.view.View;

public class p
{
    private static boolean b(final Activity activity, final l0 l0) {
        final int d = l0.d();
        boolean b = true;
        if (d >= 17) {
            if (activity.isFinishing() || activity.isDestroyed()) {
                b = false;
            }
            return b;
        }
        return activity.isFinishing() ^ true;
    }
    
    public static byte[] d(final Activity activity, final b b, final n0 n0, l0 l0) {
        if (b(activity, l0) && activity.getWindow() != null && activity.getWindow().getDecorView() != null && activity.getWindow().getDecorView().getRootView() != null) {
            final View rootView = activity.getWindow().getDecorView().getRootView();
            if (rootView.getWidth() > 0) {
                if (rootView.getHeight() > 0) {
                    try {
                        l0 = (l0)new ByteArrayOutputStream();
                        try {
                            final Bitmap bitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap$Config.ARGB_8888);
                            final Canvas canvas = new Canvas(bitmap);
                            if (b.c()) {
                                rootView.draw(canvas);
                            }
                            else {
                                final CountDownLatch countDownLatch = new CountDownLatch(1);
                                activity.runOnUiThread((Runnable)new o(rootView, canvas, countDownLatch, n0));
                                if (!countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                                    ((ByteArrayOutputStream)l0).close();
                                    return null;
                                }
                            }
                            bitmap.compress(Bitmap$CompressFormat.PNG, 0, (OutputStream)l0);
                            if (((ByteArrayOutputStream)l0).size() <= 0) {
                                n0.a(l4.DEBUG, "Screenshot is 0 bytes, not attaching the image.", new Object[0]);
                                ((ByteArrayOutputStream)l0).close();
                                return null;
                            }
                            final byte[] byteArray = ((ByteArrayOutputStream)l0).toByteArray();
                            ((ByteArrayOutputStream)l0).close();
                            return byteArray;
                        }
                        finally {
                            try {
                                ((ByteArrayOutputStream)l0).close();
                            }
                            finally {
                                final Throwable t;
                                ((Throwable)activity).addSuppressed(t);
                            }
                        }
                    }
                    finally {
                        final Throwable t2;
                        n0.d(l4.ERROR, "Taking screenshot failed.", t2);
                        return null;
                    }
                }
            }
            n0.a(l4.DEBUG, "View's width and height is zeroed, not taking screenshot.", new Object[0]);
            return null;
        }
        n0.a(l4.DEBUG, "Activity isn't valid, not taking screenshot.", new Object[0]);
        return null;
    }
}
