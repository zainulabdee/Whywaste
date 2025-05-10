package c0;

import androidx.fragment.app.Fragment;
import android.content.DialogInterface;
import android.app.AlertDialog$Builder;
import android.content.Context;
import android.os.Bundle;
import android.content.DialogInterface$OnDismissListener;
import f0.i;
import android.content.DialogInterface$OnCancelListener;
import android.app.Dialog;
import androidx.fragment.app.c;

public class o extends c
{
    private Dialog n0;
    private DialogInterface$OnCancelListener o0;
    private Dialog p0;
    
    public static o N1(Dialog n0, final DialogInterface$OnCancelListener o0) {
        final o o2 = new o();
        n0 = (Dialog)i.j((Object)n0, (Object)"Cannot display null dialog");
        n0.setOnCancelListener((DialogInterface$OnCancelListener)null);
        n0.setOnDismissListener((DialogInterface$OnDismissListener)null);
        o2.n0 = n0;
        if (o0 != null) {
            o2.o0 = o0;
        }
        return o2;
    }
    
    public Dialog J1(final Bundle bundle) {
        Dialog dialog;
        if ((dialog = this.n0) == null) {
            this.K1(false);
            if (this.p0 == null) {
                this.p0 = (Dialog)new AlertDialog$Builder((Context)i.i((Object)((Fragment)this).s())).create();
            }
            dialog = this.p0;
        }
        return dialog;
    }
    
    public void M1(final androidx.fragment.app.i i, final String s) {
        super.M1(i, s);
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
        final DialogInterface$OnCancelListener o0 = this.o0;
        if (o0 != null) {
            o0.onCancel(dialogInterface);
        }
    }
}
