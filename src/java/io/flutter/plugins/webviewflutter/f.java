package io.flutter.plugins.webviewflutter;

import java.lang.reflect.AccessibleObject;
import android.os.Handler;
import java.util.Collection;
import java.util.Iterator;
import java.lang.reflect.Field;
import android.util.Log;
import android.os.Build$VERSION;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager$DisplayListener;
import java.util.ArrayList;

class f
{
    private ArrayList<DisplayManager$DisplayListener> a;
    
    private static ArrayList<DisplayManager$DisplayListener> c(DisplayManager declaredField) {
        if (Build$VERSION.SDK_INT >= 28) {
            return (ArrayList<DisplayManager$DisplayListener>)new ArrayList();
        }
        try {
            final Field declaredField2 = DisplayManager.class.getDeclaredField("mGlobal");
            ((AccessibleObject)declaredField2).setAccessible(true);
            final Object value = declaredField2.get((Object)declaredField);
            declaredField = (IllegalAccessException)value.getClass().getDeclaredField("mDisplayListeners");
            ((AccessibleObject)declaredField).setAccessible(true);
            final ArrayList list = (ArrayList)((Field)declaredField).get(value);
            declaredField = null;
            final ArrayList list2 = new ArrayList();
            for (final Object next : list) {
                Object field;
                if ((field = declaredField) == null) {
                    field = next.getClass().getField("mListener");
                    ((AccessibleObject)field).setAccessible(true);
                }
                list2.add((Object)((Field)field).get(next));
                declaredField = (IllegalAccessException)field;
            }
            return (ArrayList<DisplayManager$DisplayListener>)list2;
        }
        catch (final IllegalAccessException declaredField) {}
        catch (final NoSuchFieldException ex) {}
        final StringBuilder sb = new StringBuilder();
        sb.append("Could not extract WebView's display listeners. ");
        sb.append((Object)declaredField);
        Log.w("DisplayListenerProxy", sb.toString());
        return (ArrayList<DisplayManager$DisplayListener>)new ArrayList();
    }
    
    void a(final DisplayManager displayManager) {
        final ArrayList<DisplayManager$DisplayListener> c = c(displayManager);
        c.removeAll((Collection)this.a);
        if (c.isEmpty()) {
            return;
        }
        final Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            displayManager.unregisterDisplayListener((DisplayManager$DisplayListener)iterator.next());
            displayManager.registerDisplayListener((DisplayManager$DisplayListener)new DisplayManager$DisplayListener(this, c, displayManager) {
                final ArrayList a;
                final DisplayManager b;
                final f c;
                
                public void onDisplayAdded(final int n) {
                    final Iterator iterator = this.a.iterator();
                    while (iterator.hasNext()) {
                        ((DisplayManager$DisplayListener)iterator.next()).onDisplayAdded(n);
                    }
                }
                
                public void onDisplayChanged(final int n) {
                    if (this.b.getDisplay(n) == null) {
                        return;
                    }
                    final Iterator iterator = this.a.iterator();
                    while (iterator.hasNext()) {
                        ((DisplayManager$DisplayListener)iterator.next()).onDisplayChanged(n);
                    }
                }
                
                public void onDisplayRemoved(final int n) {
                    final Iterator iterator = this.a.iterator();
                    while (iterator.hasNext()) {
                        ((DisplayManager$DisplayListener)iterator.next()).onDisplayRemoved(n);
                    }
                }
            }, (Handler)null);
        }
    }
    
    void b(final DisplayManager displayManager) {
        this.a = c(displayManager);
    }
}
