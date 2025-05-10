package j2;

import kotlin.jvm.internal.i;
import java.io.File;

public final class c
{
    private static final String b(final File file, final File file2, final String s) {
        final StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(" -> ");
            sb2.append((Object)file2);
            sb.append(sb2.toString());
        }
        if (s != null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(": ");
            sb3.append(s);
            sb.append(sb3.toString());
        }
        final String string = sb.toString();
        i.d((Object)string, "sb.toString()");
        return string;
    }
}
