package io.sentry.android.core;

import android.database.Cursor;
import android.content.ContentValues;
import android.net.Uri;
import io.sentry.android.core.internal.util.g;
import android.content.ContentProvider;

abstract class r0 extends ContentProvider
{
    private final g e;
    
    r0() {
        this.e = new g();
    }
    
    public final int delete(final Uri uri, final String s, final String[] array) {
        this.e.a(this);
        return 0;
    }
    
    public final Uri insert(final Uri uri, final ContentValues contentValues) {
        this.e.a(this);
        return null;
    }
    
    public final Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        this.e.a(this);
        return null;
    }
    
    public final int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        this.e.a(this);
        return 0;
    }
}
