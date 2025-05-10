package e0;

import android.content.Intent;
import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public interface f
{
    void b(final String p0, final LifecycleCallback p1);
    
     <T extends LifecycleCallback> T c(final String p0, final Class<T> p1);
    
    Activity d();
    
    void startActivityForResult(final Intent p0, final int p1);
}
