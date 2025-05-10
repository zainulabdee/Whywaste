package io.sentry.android.core.internal.gestures;

import android.view.ActionMode$Callback;
import android.view.WindowManager$LayoutParams;
import android.view.SearchEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window$Callback;

public final class b implements Window$Callback
{
    public boolean dispatchGenericMotionEvent(final MotionEvent motionEvent) {
        return false;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return false;
    }
    
    public boolean dispatchKeyShortcutEvent(final KeyEvent keyEvent) {
        return false;
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        return false;
    }
    
    public boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        return false;
    }
    
    public boolean dispatchTrackballEvent(final MotionEvent motionEvent) {
        return false;
    }
    
    public void onActionModeFinished(final ActionMode actionMode) {
    }
    
    public void onActionModeStarted(final ActionMode actionMode) {
    }
    
    public void onAttachedToWindow() {
    }
    
    public void onContentChanged() {
    }
    
    public boolean onCreatePanelMenu(final int n, final Menu menu) {
        return false;
    }
    
    public View onCreatePanelView(final int n) {
        return null;
    }
    
    public void onDetachedFromWindow() {
    }
    
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        return false;
    }
    
    public boolean onMenuOpened(final int n, final Menu menu) {
        return false;
    }
    
    public void onPanelClosed(final int n, final Menu menu) {
    }
    
    public boolean onPreparePanel(final int n, final View view, final Menu menu) {
        return false;
    }
    
    public boolean onSearchRequested() {
        return false;
    }
    
    public boolean onSearchRequested(final SearchEvent searchEvent) {
        return false;
    }
    
    public void onWindowAttributesChanged(final WindowManager$LayoutParams windowManager$LayoutParams) {
    }
    
    public void onWindowFocusChanged(final boolean b) {
    }
    
    public ActionMode onWindowStartingActionMode(final ActionMode$Callback actionMode$Callback) {
        return null;
    }
    
    public ActionMode onWindowStartingActionMode(final ActionMode$Callback actionMode$Callback, final int n) {
        return null;
    }
}
