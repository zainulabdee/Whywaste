package io.flutter.embedding.android;

import androidx.window.layout.WindowLayoutInfo;
import androidx.core.util.a;
import java.util.concurrent.Executor;
import android.app.Activity;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;

public class g0
{
    final WindowInfoTrackerCallbackAdapter a;
    
    public g0(final WindowInfoTrackerCallbackAdapter a) {
        this.a = a;
    }
    
    public void a(final Activity activity, final Executor executor, final a<WindowLayoutInfo> a) {
        this.a.addWindowLayoutInfoListener(activity, executor, (a)a);
    }
    
    public void b(final a<WindowLayoutInfo> a) {
        this.a.removeWindowLayoutInfoListener((a)a);
    }
}
