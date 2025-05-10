package io.flutter.embedding.android;

import java.nio.Buffer;
import android.view.InputEvent;
import java.nio.ByteOrder;
import android.view.InputDevice$MotionRange;
import java.nio.ByteBuffer;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;
import android.graphics.Matrix;

public class a
{
    private static final Matrix e;
    private final r1.a a;
    private final b0 b;
    private final boolean c;
    private final Map<Integer, float[]> d;
    
    static {
        e = new Matrix();
    }
    
    public a(final r1.a a, final boolean c) {
        this.d = (Map<Integer, float[]>)new HashMap();
        this.a = a;
        this.b = b0.a();
        this.c = c;
    }
    
    private void a(final MotionEvent motionEvent, final int n, final int n2, final int n3, final Matrix matrix, final ByteBuffer byteBuffer) {
        if (n2 == -1) {
            return;
        }
        long d;
        if (this.c) {
            d = this.b.c(motionEvent).d();
        }
        else {
            d = 0L;
        }
        final int d2 = this.d(motionEvent.getToolType(n));
        final float[] array = { motionEvent.getX(n), motionEvent.getY(n) };
        matrix.mapPoints(array);
        long n5;
        if (d2 == 1) {
            final long n4 = n5 = (motionEvent.getButtonState() & 0x1F);
            if (n4 == 0L) {
                n5 = n4;
                if (motionEvent.getSource() == 8194) {
                    n5 = n4;
                    if (n2 == 4) {
                        this.d.put((Object)motionEvent.getPointerId(n), (Object)array);
                        n5 = n4;
                    }
                }
            }
        }
        else if (d2 == 2) {
            n5 = (motionEvent.getButtonState() >> 4 & 0xF);
        }
        else {
            n5 = 0L;
        }
        final boolean containsKey = this.d.containsKey((Object)motionEvent.getPointerId(n));
        final boolean b = motionEvent.getActionMasked() == 8;
        final long eventTime = motionEvent.getEventTime();
        byteBuffer.putLong(d);
        byteBuffer.putLong(eventTime * 1000L);
        if (containsKey) {
            byteBuffer.putLong((long)this.c(n2));
            byteBuffer.putLong(4L);
        }
        else {
            byteBuffer.putLong((long)n2);
            byteBuffer.putLong((long)d2);
        }
        byteBuffer.putLong((long)(b ? 1 : 0));
        byteBuffer.putLong((long)motionEvent.getPointerId(n));
        byteBuffer.putLong(0L);
        if (containsKey) {
            final float[] array2 = (float[])this.d.get((Object)motionEvent.getPointerId(n));
            byteBuffer.putDouble((double)array2[0]);
            byteBuffer.putDouble((double)array2[1]);
        }
        else {
            byteBuffer.putDouble((double)array[0]);
            byteBuffer.putDouble((double)array[1]);
        }
        byteBuffer.putDouble(0.0);
        byteBuffer.putDouble(0.0);
        byteBuffer.putLong(n5);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble((double)motionEvent.getPressure(n));
        double n6 = 0.0;
        double n7 = 0.0;
        Label_0480: {
            if (((InputEvent)motionEvent).getDevice() != null) {
                final InputDevice$MotionRange motionRange = ((InputEvent)motionEvent).getDevice().getMotionRange(2);
                if (motionRange != null) {
                    n6 = motionRange.getMin();
                    n7 = motionRange.getMax();
                    break Label_0480;
                }
            }
            n7 = 1.0;
            n6 = 0.0;
        }
        byteBuffer.putDouble(n6);
        byteBuffer.putDouble(n7);
        if (d2 == 2) {
            byteBuffer.putDouble((double)motionEvent.getAxisValue(24, n));
            byteBuffer.putDouble(0.0);
        }
        else {
            byteBuffer.putDouble(0.0);
            byteBuffer.putDouble(0.0);
        }
        byteBuffer.putDouble((double)motionEvent.getSize(n));
        byteBuffer.putDouble((double)motionEvent.getToolMajor(n));
        byteBuffer.putDouble((double)motionEvent.getToolMinor(n));
        byteBuffer.putDouble(0.0);
        byteBuffer.putDouble(0.0);
        byteBuffer.putDouble((double)motionEvent.getAxisValue(8, n));
        if (d2 == 2) {
            byteBuffer.putDouble((double)motionEvent.getAxisValue(25, n));
        }
        else {
            byteBuffer.putDouble(0.0);
        }
        byteBuffer.putLong((long)n3);
        if ((b ? 1 : 0) == 1) {
            byteBuffer.putDouble((double)(-motionEvent.getAxisValue(10)));
            byteBuffer.putDouble((double)(-motionEvent.getAxisValue(9)));
        }
        else {
            byteBuffer.putDouble(0.0);
            byteBuffer.putDouble(0.0);
        }
        if (containsKey) {
            final float[] array3 = (float[])this.d.get((Object)motionEvent.getPointerId(n));
            byteBuffer.putDouble((double)(array[0] - array3[0]));
            byteBuffer.putDouble((double)(array[1] - array3[1]));
        }
        else {
            byteBuffer.putDouble(0.0);
            byteBuffer.putDouble(0.0);
        }
        byteBuffer.putDouble(0.0);
        byteBuffer.putDouble(0.0);
        byteBuffer.putDouble(1.0);
        byteBuffer.putDouble(0.0);
        byteBuffer.putLong(0L);
        if (containsKey && this.c(n2) == 9) {
            this.d.remove((Object)motionEvent.getPointerId(n));
        }
    }
    
    private int b(final int n) {
        if (n == 0) {
            return 4;
        }
        if (n == 1) {
            return 6;
        }
        if (n == 5) {
            return 4;
        }
        if (n == 6) {
            return 6;
        }
        if (n == 2) {
            return 5;
        }
        if (n == 7) {
            return 3;
        }
        if (n == 3) {
            return 0;
        }
        if (n == 8) {
            return 3;
        }
        return -1;
    }
    
    private int c(final int n) {
        if (n == 4) {
            return 7;
        }
        if (n == 5) {
            return 8;
        }
        if (n != 6 && n != 0) {
            throw new AssertionError((Object)"Unexpected pointer change");
        }
        return 9;
    }
    
    private int d(final int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 1;
        }
        if (n != 4) {
            return 5;
        }
        return 3;
    }
    
    public boolean e(final MotionEvent motionEvent) {
        final boolean fromSource = ((InputEvent)motionEvent).isFromSource(2);
        final boolean b = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!fromSource || !b) {
            return false;
        }
        final int b2 = this.b(motionEvent.getActionMasked());
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 36 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        this.a(motionEvent, motionEvent.getActionIndex(), b2, 0, io.flutter.embedding.android.a.e, allocateDirect);
        if (((Buffer)allocateDirect).position() % 288 == 0) {
            this.a.i(allocateDirect, ((Buffer)allocateDirect).position());
            return true;
        }
        throw new AssertionError((Object)"Packet position is not on field boundary.");
    }
    
    public boolean f(final MotionEvent motionEvent) {
        return this.g(motionEvent, io.flutter.embedding.android.a.e);
    }
    
    public boolean g(final MotionEvent motionEvent, final Matrix matrix) {
        final int pointerCount = motionEvent.getPointerCount();
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pointerCount * 36 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        final int actionMasked = motionEvent.getActionMasked();
        final int b = this.b(motionEvent.getActionMasked());
        final boolean b2 = actionMasked == 0 || actionMasked == 5;
        final boolean b3 = !b2 && (actionMasked == 1 || actionMasked == 6);
        if (b2) {
            this.a(motionEvent, motionEvent.getActionIndex(), b, 0, matrix, allocateDirect);
        }
        else if (b3) {
            for (int i = 0; i < pointerCount; ++i) {
                if (i != motionEvent.getActionIndex() && motionEvent.getToolType(i) == 1) {
                    this.a(motionEvent, i, 5, 1, matrix, allocateDirect);
                }
            }
            this.a(motionEvent, motionEvent.getActionIndex(), b, 0, matrix, allocateDirect);
        }
        else {
            for (int j = 0; j < pointerCount; ++j) {
                this.a(motionEvent, j, b, 0, matrix, allocateDirect);
            }
        }
        if (((Buffer)allocateDirect).position() % 288 == 0) {
            this.a.i(allocateDirect, ((Buffer)allocateDirect).position());
            return true;
        }
        throw new AssertionError((Object)"Packet position is not on field boundary");
    }
}
