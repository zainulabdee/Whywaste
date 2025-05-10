package io.flutter.plugins.webviewflutter;

import java.util.Objects;
import android.webkit.WebStorage;

public class i5 implements n$e0
{
    private final c4 a;
    private final i5.i5$a b;
    
    public i5(final c4 a, final i5.i5$a b) {
        this.a = a;
        this.b = b;
    }
    
    public void a(final Long n) {
        this.a.b((Object)this.b.a(), (long)n);
    }
    
    public void b(final Long n) {
        final WebStorage webStorage = (WebStorage)this.a.i((long)n);
        Objects.requireNonNull((Object)webStorage);
        final WebStorage webStorage2 = webStorage;
        webStorage.deleteAllData();
    }
}
