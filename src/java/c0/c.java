package c0;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.AlertDialog$Builder;
import android.content.Context;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.DialogInterface$OnDismissListener;
import f0.i;
import android.content.DialogInterface$OnCancelListener;
import android.app.Dialog;
import android.app.DialogFragment;

public class c extends DialogFragment
{
    private Dialog e;
    private DialogInterface$OnCancelListener f;
    private Dialog g;
    
    public static c a(Dialog e, final DialogInterface$OnCancelListener f) {
        final c c = new c();
        e = i.j(e, "Cannot display null dialog");
        e.setOnCancelListener((DialogInterface$OnCancelListener)null);
        e.setOnDismissListener((DialogInterface$OnDismissListener)null);
        c.e = e;
        if (f != null) {
            c.f = f;
        }
        return c;
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
        final DialogInterface$OnCancelListener f = this.f;
        if (f != null) {
            f.onCancel(dialogInterface);
        }
    }
    
    public Dialog onCreateDialog(final Bundle bundle) {
        Dialog dialog;
        if ((dialog = this.e) == null) {
            this.setShowsDialog(false);
            if (this.g == null) {
                this.g = (Dialog)new AlertDialog$Builder((Context)i.i((Context)((Fragment)this).getActivity())).create();
            }
            dialog = this.g;
        }
        return dialog;
    }
    
    public void show(final FragmentManager fragmentManager, final String s) {
        super.show(fragmentManager, s);
    }
}
