package j2;

import kotlin.jvm.internal.i;
import java.io.File;
import java.io.IOException;

public class e extends IOException
{
    private final File e;
    private final File f;
    private final String g;
    
    public e(final File e, final File f, final String g) {
        i.e((Object)e, "file");
        super(c.a(e, f, g));
        this.e = e;
        this.f = f;
        this.g = g;
    }
}
