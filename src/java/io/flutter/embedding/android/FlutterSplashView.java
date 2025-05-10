package io.flutter.embedding.android;

import android.view.AbsSavedState;
import android.view.ViewGroup;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.content.Context;
import r1.b;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

final class FlutterSplashView extends FrameLayout
{
    private static String n = "FlutterSplashView";
    private e0 e;
    private r f;
    private View g;
    Bundle h;
    private String i;
    private String j;
    private final r.f k;
    private final b l;
    private final Runnable m;
    
    public FlutterSplashView(final Context context) {
        this(context, null, 0);
    }
    
    public FlutterSplashView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.k = (r.f)new FlutterSplashView$a(this);
        this.l = (b)new FlutterSplashView$b(this);
        this.m = (Runnable)new Runnable() {
            final FlutterSplashView e;
            
            public void run() {
                final FlutterSplashView e = this.e;
                ((ViewGroup)e).removeView(e.g);
                final FlutterSplashView e2 = this.e;
                e2.j = e2.i;
            }
        };
        ((View)this).setSaveEnabled(true);
    }
    
    private boolean h() {
        final r f = this.f;
        if (f == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        }
        if (f.x()) {
            return this.f.getAttachedFlutterEngine().i().k() != null && this.f.getAttachedFlutterEngine().i().k().equals((Object)this.j);
        }
        throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }
    
    private boolean i() {
        final r f = this.f;
        return f != null && f.x() && !this.f.v() && !this.h();
    }
    
    private boolean j() {
        final r f = this.f;
        if (f != null && f.x()) {
            final e0 e = this.e;
            if (e != null && e.b() && this.l()) {
                return true;
            }
        }
        return false;
    }
    
    private void k() {
        this.i = this.f.getAttachedFlutterEngine().i().k();
        final String n = FlutterSplashView.n;
        final StringBuilder sb = new StringBuilder();
        sb.append("Transitioning splash screen to a Flutter UI. Isolate: ");
        sb.append(this.i);
        f1.b.f(n, sb.toString());
        this.e.a(this.m);
    }
    
    private boolean l() {
        final r f = this.f;
        if (f == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        }
        if (f.x()) {
            return this.f.v() && !this.h();
        }
        throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }
    
    public void g(final r f, final e0 e) {
        final r f2 = this.f;
        if (f2 != null) {
            f2.B(this.l);
            ((ViewGroup)this).removeView((View)this.f);
        }
        final View g = this.g;
        if (g != null) {
            ((ViewGroup)this).removeView(g);
        }
        ((ViewGroup)this).addView((View)(this.f = f));
        if ((this.e = e) != null) {
            if (this.i()) {
                f1.b.f(FlutterSplashView.n, "Showing splash screen UI.");
                ((ViewGroup)this).addView(this.g = e.c(((View)this).getContext(), this.h));
                f.m(this.l);
            }
            else if (this.j()) {
                f1.b.f(FlutterSplashView.n, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
                ((ViewGroup)this).addView(this.g = e.c(((View)this).getContext(), this.h));
                this.k();
            }
            else if (!f.x()) {
                f1.b.f(FlutterSplashView.n, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
                f.l(this.k);
            }
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(((AbsSavedState)savedState).getSuperState());
        this.j = savedState.previousCompletedSplashIsolate;
        this.h = savedState.splashScreenState;
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.previousCompletedSplashIsolate = this.j;
        final e0 e = this.e;
        Bundle d;
        if (e != null) {
            d = e.d();
        }
        else {
            d = null;
        }
        savedState.splashScreenState = d;
        return (Parcelable)savedState;
    }
    
    public static class SavedState extends View$BaseSavedState
    {
        public static Parcelable$Creator<SavedState> CREATOR;
        private String previousCompletedSplashIsolate;
        private Bundle splashScreenState;
        
        static {
            SavedState.CREATOR = (Parcelable$Creator<SavedState>)new Parcelable$Creator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] b(final int n) {
                    return new SavedState[n];
                }
            };
        }
        
        SavedState(final Parcel parcel) {
            super(parcel);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(this.getClass().getClassLoader());
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
        }
    }
}
