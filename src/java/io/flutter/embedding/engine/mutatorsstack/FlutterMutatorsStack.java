package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Path$Direction;
import android.graphics.RectF;
import android.graphics.Rect;
import java.util.ArrayList;
import android.graphics.Matrix;
import android.graphics.Path;
import java.util.List;

public class FlutterMutatorsStack
{
    private List<Path> finalClippingPaths;
    private Matrix finalMatrix;
    private List<a> mutators;
    
    public FlutterMutatorsStack() {
        this.mutators = (List<a>)new ArrayList();
        this.finalMatrix = new Matrix();
        this.finalClippingPaths = (List<Path>)new ArrayList();
    }
    
    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }
    
    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }
    
    public List<a> getMutators() {
        return this.mutators;
    }
    
    public void pushClipRRect(final int n, final int n2, final int n3, final int n4, final float[] array) {
        final Rect rect = new Rect(n, n2, n3, n4);
        this.mutators.add((Object)new a(rect, array));
        final Path path = new Path();
        path.addRoundRect(new RectF(rect), array, Path$Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add((Object)path);
    }
    
    public void pushClipRect(final int n, final int n2, final int n3, final int n4) {
        final Rect rect = new Rect(n, n2, n3, n4);
        this.mutators.add((Object)new a(rect));
        final Path path = new Path();
        path.addRect(new RectF(rect), Path$Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add((Object)path);
    }
    
    public void pushTransform(final float[] values) {
        final Matrix matrix = new Matrix();
        matrix.setValues(values);
        final a a = new a(matrix);
        this.mutators.add((Object)a);
        this.finalMatrix.preConcat(a.a());
    }
    
    public class a
    {
        private Matrix a;
        private Rect b;
        private float[] c;
        private b d;
        final FlutterMutatorsStack e;
        
        public a(final FlutterMutatorsStack e, final Matrix a) {
            this.e = e;
            this.d = FlutterMutatorsStack.b.h;
            this.a = a;
        }
        
        public a(final FlutterMutatorsStack e, final Rect b) {
            this.e = e;
            this.d = FlutterMutatorsStack.b.e;
            this.b = b;
        }
        
        public a(final FlutterMutatorsStack e, final Rect b, final float[] c) {
            this.e = e;
            this.d = FlutterMutatorsStack.b.f;
            this.b = b;
            this.c = c;
        }
        
        public Matrix a() {
            return this.a;
        }
    }
    
    public enum b
    {
        e, 
        f, 
        g, 
        h, 
        i;
        
        private static final b[] j;
    }
}
