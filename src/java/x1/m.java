package x1;

import android.app.Activity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.a;
import com.google.android.gms.auth.api.signin.b;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import android.content.Context;

public class m
{
    b a(final Context context, final GoogleSignInOptions googleSignInOptions) {
        return a.a(context, googleSignInOptions);
    }
    
    GoogleSignInAccount b(final Context context) {
        return a.b(context);
    }
    
    boolean c(final GoogleSignInAccount googleSignInAccount, final Scope scope) {
        return a.d(googleSignInAccount, new Scope[] { scope });
    }
    
    void d(final Activity activity, final int n, final GoogleSignInAccount googleSignInAccount, final Scope[] array) {
        a.e(activity, n, googleSignInAccount, array);
    }
}
