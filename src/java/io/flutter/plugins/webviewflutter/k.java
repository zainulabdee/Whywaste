package io.flutter.plugins.webviewflutter;

import android.content.res.AssetManager;

abstract class k
{
    final AssetManager a;
    
    public k(final AssetManager a) {
        this.a = a;
    }
    
    abstract String a(final String p0);
    
    public String[] b(final String s) {
        return this.a.list(s);
    }
}
