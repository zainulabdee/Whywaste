package n;

import android.os.Trace;

final class c
{
    public static void a(final String s) {
        Trace.beginSection(s);
    }
    
    public static void b() {
        Trace.endSection();
    }
}
