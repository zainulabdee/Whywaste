package q1;

import f1.b;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class a
{
    public static void a(final io.flutter.embedding.engine.a a) {
        try {
            GeneratedPluginRegistrant.class.getDeclaredMethod("registerWith", io.flutter.embedding.engine.a.class).invoke((Object)null, new Object[] { a });
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Tried to automatically register plugins with FlutterEngine (");
            sb.append((Object)a);
            sb.append(") but could not find or invoke the GeneratedPluginRegistrant.");
            b.b("GeneratedPluginsRegister", sb.toString());
            b.c("GeneratedPluginsRegister", "Received exception while registering", (Throwable)ex);
        }
    }
}
