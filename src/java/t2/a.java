package t2;

import android.os.Looper;
import s2.v1;
import java.util.List;
import kotlinx.coroutines.internal.r;

public final class a implements r
{
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
    
    public v1 b(final List<? extends r> list) {
        final Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new c(e.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }
    
    public int c() {
        return 1073741823;
    }
}
