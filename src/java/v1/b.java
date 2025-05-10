package v1;

import java.util.AbstractMap;
import android.view.PointerIcon;
import s1.g;
import java.util.HashMap;

public class b
{
    private static HashMap<String, Integer> c;
    private final c a;
    private final g b;
    
    public b(final c a, final g b) {
        this.a = a;
        (this.b = b).b((g.b)new b$a(this));
    }
    
    private PointerIcon d(final String s) {
        if (v1.b.c == null) {
            v1.b.c = new HashMap<String, Integer>(this) {
                final b e;
                
                {
                    ((AbstractMap)this).put((Object)"alias", (Object)1010);
                    final Integer value = 1013;
                    ((AbstractMap)this).put((Object)"allScroll", (Object)value);
                    ((AbstractMap)this).put((Object)"basic", (Object)1000);
                    ((AbstractMap)this).put((Object)"cell", (Object)1006);
                    ((AbstractMap)this).put((Object)"click", (Object)1002);
                    ((AbstractMap)this).put((Object)"contextMenu", (Object)1001);
                    ((AbstractMap)this).put((Object)"copy", (Object)1011);
                    final Integer value2 = 1012;
                    ((AbstractMap)this).put((Object)"forbidden", (Object)value2);
                    ((AbstractMap)this).put((Object)"grab", (Object)1020);
                    ((AbstractMap)this).put((Object)"grabbing", (Object)1021);
                    ((AbstractMap)this).put((Object)"help", (Object)1003);
                    ((AbstractMap)this).put((Object)"move", (Object)value);
                    ((AbstractMap)this).put((Object)"none", (Object)0);
                    ((AbstractMap)this).put((Object)"noDrop", (Object)value2);
                    ((AbstractMap)this).put((Object)"precise", (Object)1007);
                    ((AbstractMap)this).put((Object)"text", (Object)1008);
                    final Integer value3 = 1014;
                    ((AbstractMap)this).put((Object)"resizeColumn", (Object)value3);
                    final Integer value4 = 1015;
                    ((AbstractMap)this).put((Object)"resizeDown", (Object)value4);
                    final Integer value5 = 1016;
                    ((AbstractMap)this).put((Object)"resizeUpLeft", (Object)value5);
                    final Integer value6 = 1017;
                    ((AbstractMap)this).put((Object)"resizeDownRight", (Object)value6);
                    ((AbstractMap)this).put((Object)"resizeLeft", (Object)value3);
                    ((AbstractMap)this).put((Object)"resizeLeftRight", (Object)value3);
                    ((AbstractMap)this).put((Object)"resizeRight", (Object)value3);
                    ((AbstractMap)this).put((Object)"resizeRow", (Object)value4);
                    ((AbstractMap)this).put((Object)"resizeUp", (Object)value4);
                    ((AbstractMap)this).put((Object)"resizeUpDown", (Object)value4);
                    ((AbstractMap)this).put((Object)"resizeUpLeft", (Object)value6);
                    ((AbstractMap)this).put((Object)"resizeUpRight", (Object)value5);
                    ((AbstractMap)this).put((Object)"resizeUpLeftDownRight", (Object)value6);
                    ((AbstractMap)this).put((Object)"resizeUpRightDownLeft", (Object)value5);
                    ((AbstractMap)this).put((Object)"verticalText", (Object)1009);
                    ((AbstractMap)this).put((Object)"wait", (Object)1004);
                    ((AbstractMap)this).put((Object)"zoomIn", (Object)1018);
                    ((AbstractMap)this).put((Object)"zoomOut", (Object)1019);
                }
            };
        }
        return this.a.b((int)v1.a.a((HashMap)v1.b.c, (Object)s, (Object)1000));
    }
    
    public void c() {
        this.b.b(null);
    }
    
    public interface c
    {
        PointerIcon b(final int p0);
        
        void setPointerIcon(final PointerIcon p0);
    }
}
