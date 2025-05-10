package io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

class l implements k
{
    private final Map<String, j> a;
    
    l() {
        this.a = (Map<String, j>)new HashMap();
    }
    
    public boolean a(final String s, final j j) {
        if (this.a.containsKey((Object)s)) {
            return false;
        }
        this.a.put((Object)s, (Object)j);
        return true;
    }
    
    j b(final String s) {
        return (j)this.a.get((Object)s);
    }
}
