package io.flutter.plugin.editing;

import android.text.SpannableStringBuilder;
import f1.b;
import android.text.Editable;
import android.view.KeyEvent;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.inputmethod.InputContentInfo;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import android.text.Spannable;
import android.view.inputmethod.CursorAnchorInfo;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.Selection;
import android.text.DynamicLayout;
import android.text.Layout$Alignment;
import android.text.TextPaint;
import io.flutter.embedding.engine.FlutterJNI;
import android.text.Layout;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.CursorAnchorInfo$Builder;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.EditorInfo;
import s1.p;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;

public class d extends BaseInputConnection implements e$b
{
    private final View a;
    private final int b;
    private final p c;
    private final e d;
    private final EditorInfo e;
    private ExtractedTextRequest f;
    private boolean g;
    private CursorAnchorInfo$Builder h;
    private ExtractedText i;
    private InputMethodManager j;
    private final Layout k;
    private a l;
    private final d.d$a m;
    private int n;
    
    public d(final View view, final int n, final p p6, final d.d$a d$a, final e e, final EditorInfo editorInfo) {
        this(view, n, p6, d$a, e, editorInfo, new FlutterJNI());
    }
    
    public d(final View a, final int b, final p c, final d.d$a m, final e d, final EditorInfo e, final FlutterJNI flutterJNI) {
        super(a, true);
        this.g = false;
        this.i = new ExtractedText();
        this.n = 0;
        this.a = a;
        this.b = b;
        this.c = c;
        (this.d = d).a((e$b)this);
        this.e = e;
        this.m = m;
        this.l = new a(flutterJNI);
        this.k = (Layout)new DynamicLayout((CharSequence)d, new TextPaint(), Integer.MAX_VALUE, Layout$Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.j = (InputMethodManager)a.getContext().getSystemService("input_method");
    }
    
    private boolean b(int n) {
        if (n == 16908319) {
            this.setSelection(0, ((SpannableStringBuilder)this.d).length());
            return true;
        }
        if (n == 16908320) {
            final int selectionStart = Selection.getSelectionStart((CharSequence)this.d);
            final int selectionEnd = Selection.getSelectionEnd((CharSequence)this.d);
            if (selectionStart != selectionEnd) {
                n = Math.min(selectionStart, selectionEnd);
                final int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager)this.a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence)"text label?", ((SpannableStringBuilder)this.d).subSequence(n, max)));
                ((SpannableStringBuilder)this.d).delete(n, max);
                this.setSelection(n, n);
            }
            return true;
        }
        if (n == 16908321) {
            n = Selection.getSelectionStart((CharSequence)this.d);
            final int selectionEnd2 = Selection.getSelectionEnd((CharSequence)this.d);
            if (n != selectionEnd2) {
                ((ClipboardManager)this.a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence)"text label?", ((SpannableStringBuilder)this.d).subSequence(Math.min(n, selectionEnd2), Math.max(n, selectionEnd2))));
            }
            return true;
        }
        if (n == 16908322) {
            final ClipData primaryClip = ((ClipboardManager)this.a.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null) {
                final CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.a.getContext());
                final int max2 = Math.max(0, Selection.getSelectionStart((CharSequence)this.d));
                final int max3 = Math.max(0, Selection.getSelectionEnd((CharSequence)this.d));
                n = Math.min(max2, max3);
                final int max4 = Math.max(max2, max3);
                if (n != max4) {
                    ((SpannableStringBuilder)this.d).delete(n, max4);
                }
                ((SpannableStringBuilder)this.d).insert(n, coerceToText);
                n += coerceToText.length();
                this.setSelection(n, n);
            }
            return true;
        }
        return false;
    }
    
    private CursorAnchorInfo c() {
        final CursorAnchorInfo$Builder h = this.h;
        if (h == null) {
            this.h = new CursorAnchorInfo$Builder();
        }
        else {
            h.reset();
        }
        this.h.setSelectionRange(this.d.i(), this.d.h());
        final int g = this.d.g();
        final int f = this.d.f();
        if (g >= 0 && f > g) {
            this.h.setComposingText(g, this.d.toString().subSequence(g, f));
        }
        else {
            this.h.setComposingText(-1, (CharSequence)"");
        }
        return this.h.build();
    }
    
    private ExtractedText d(final ExtractedTextRequest extractedTextRequest) {
        final ExtractedText i = this.i;
        i.startOffset = 0;
        i.partialStartOffset = -1;
        i.partialEndOffset = -1;
        i.selectionStart = this.d.i();
        this.i.selectionEnd = this.d.h();
        final ExtractedText j = this.i;
        Object text;
        if (extractedTextRequest != null && (extractedTextRequest.flags & 0x1) != 0x0) {
            text = this.d;
        }
        else {
            text = this.d.toString();
        }
        j.text = (CharSequence)text;
        return this.i;
    }
    
    private boolean e(final boolean b, final boolean b2) {
        final int selectionStart = Selection.getSelectionStart((CharSequence)this.d);
        final int selectionEnd = Selection.getSelectionEnd((CharSequence)this.d);
        final boolean b3 = false;
        if (selectionStart >= 0 && selectionEnd >= 0) {
            int n;
            if (b) {
                n = Math.max(this.l.b((CharSequence)this.d, selectionEnd), 0);
            }
            else {
                n = Math.min(this.l.a((CharSequence)this.d, selectionEnd), ((SpannableStringBuilder)this.d).length());
            }
            int n2 = b3 ? 1 : 0;
            if (selectionStart == selectionEnd) {
                n2 = (b3 ? 1 : 0);
                if (!b2) {
                    n2 = 1;
                }
            }
            if (n2 != 0) {
                this.setSelection(n, n);
            }
            else {
                this.setSelection(selectionStart, n);
            }
            return true;
        }
        return false;
    }
    
    private boolean g(final boolean b, final boolean b2) {
        final int selectionStart = Selection.getSelectionStart((CharSequence)this.d);
        final int selectionEnd = Selection.getSelectionEnd((CharSequence)this.d);
        final boolean b3 = false;
        if (selectionStart >= 0 && selectionEnd >= 0) {
            int n = b3 ? 1 : 0;
            if (selectionStart == selectionEnd) {
                n = (b3 ? 1 : 0);
                if (!b2) {
                    n = 1;
                }
            }
            this.beginBatchEdit();
            if (n != 0) {
                if (b) {
                    Selection.moveUp((Spannable)this.d, this.k);
                }
                else {
                    Selection.moveDown((Spannable)this.d, this.k);
                }
                final int selectionStart2 = Selection.getSelectionStart((CharSequence)this.d);
                this.setSelection(selectionStart2, selectionStart2);
            }
            else {
                if (b) {
                    Selection.extendUp((Spannable)this.d, this.k);
                }
                else {
                    Selection.extendDown((Spannable)this.d, this.k);
                }
                this.setSelection(Selection.getSelectionStart((CharSequence)this.d), Selection.getSelectionEnd((CharSequence)this.d));
            }
            this.endBatchEdit();
            return true;
        }
        return false;
    }
    
    private byte[] h(final InputStream inputStream, int read) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final byte[] array = new byte[read];
        while (true) {
            try {
                read = inputStream.read(array);
            }
            catch (final IOException ex) {
                read = -1;
            }
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(array, 0, read);
        }
        return byteArrayOutputStream.toByteArray();
    }
    
    public void a(final boolean b, final boolean b2, final boolean b3) {
        this.j.updateSelection(this.a, this.d.i(), this.d.h(), this.d.g(), this.d.f());
        final ExtractedTextRequest f = this.f;
        if (f != null) {
            this.j.updateExtractedText(this.a, f.token, this.d(f));
        }
        if (this.g) {
            this.j.updateCursorAnchorInfo(this.a, this.c());
        }
    }
    
    public boolean beginBatchEdit() {
        this.d.b();
        ++this.n;
        return super.beginBatchEdit();
    }
    
    public boolean clearMetaKeyStates(final int n) {
        return super.clearMetaKeyStates(n);
    }
    
    public void closeConnection() {
        super.closeConnection();
        this.d.l((e$b)this);
        while (this.n > 0) {
            this.endBatchEdit();
            --this.n;
        }
    }
    
    public boolean commitContent(final InputContentInfo inputContentInfo, final int n, final Bundle bundle) {
        if (Build$VERSION.SDK_INT < 25 || (n & 0x1) == 0x0) {
            return false;
        }
        try {
            inputContentInfo.requestPermission();
            if (inputContentInfo.getDescription().getMimeTypeCount() > 0) {
                inputContentInfo.requestPermission();
                final Uri contentUri = inputContentInfo.getContentUri();
                final String mimeType = inputContentInfo.getDescription().getMimeType(0);
                final Context context = this.a.getContext();
                if (contentUri != null) {
                    try {
                        final InputStream openInputStream = context.getContentResolver().openInputStream(contentUri);
                        if (openInputStream != null) {
                            final byte[] h = this.h(openInputStream, 65536);
                            final HashMap hashMap = new HashMap();
                            ((Map)hashMap).put((Object)"mimeType", (Object)mimeType);
                            ((Map)hashMap).put((Object)"data", (Object)h);
                            ((Map)hashMap).put((Object)"uri", (Object)contentUri.toString());
                            this.c.b(this.b, (Map<String, Object>)hashMap);
                            inputContentInfo.releasePermission();
                            return true;
                        }
                    }
                    catch (final FileNotFoundException ex) {
                        inputContentInfo.releasePermission();
                        return false;
                    }
                }
                inputContentInfo.releasePermission();
            }
            return false;
        }
        catch (final Exception ex2) {
            return false;
        }
    }
    
    public boolean commitText(final CharSequence charSequence, final int n) {
        return super.commitText(charSequence, n);
    }
    
    public boolean deleteSurroundingText(final int n, final int n2) {
        return this.d.i() == -1 || super.deleteSurroundingText(n, n2);
    }
    
    public boolean deleteSurroundingTextInCodePoints(final int n, final int n2) {
        return super.deleteSurroundingTextInCodePoints(n, n2);
    }
    
    public boolean endBatchEdit() {
        final boolean endBatchEdit = super.endBatchEdit();
        --this.n;
        this.d.d();
        return endBatchEdit;
    }
    
    public boolean f(final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 21) {
                return this.e(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 22) {
                return this.e(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return this.g(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return this.g(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                final EditorInfo e = this.e;
                if ((0x20000 & e.inputType) == 0x0) {
                    this.performEditorAction(e.imeOptions & 0xFF);
                    return true;
                }
            }
            final int selectionStart = Selection.getSelectionStart((CharSequence)this.d);
            final int selectionEnd = Selection.getSelectionEnd((CharSequence)this.d);
            final int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart >= 0 && selectionEnd >= 0 && unicodeChar != 0) {
                int min = Math.min(selectionStart, selectionEnd);
                final int max = Math.max(selectionStart, selectionEnd);
                this.beginBatchEdit();
                if (min != max) {
                    ((SpannableStringBuilder)this.d).delete(min, max);
                }
                ((SpannableStringBuilder)this.d).insert(min, (CharSequence)String.valueOf((char)unicodeChar));
                ++min;
                this.setSelection(min, min);
                this.endBatchEdit();
                return true;
            }
            return false;
        }
        else {
            if (keyEvent.getAction() == 1 && (keyEvent.getKeyCode() == 59 || keyEvent.getKeyCode() == 60)) {
                final int selectionEnd2 = Selection.getSelectionEnd((CharSequence)this.d);
                this.setSelection(selectionEnd2, selectionEnd2);
                return true;
            }
            return false;
        }
    }
    
    public boolean finishComposingText() {
        return super.finishComposingText();
    }
    
    public Editable getEditable() {
        return (Editable)this.d;
    }
    
    public ExtractedText getExtractedText(final ExtractedTextRequest extractedTextRequest, int n) {
        int n2 = 1;
        if ((n & 0x1) != 0x0) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (this.f != null) {
            n2 = 0;
        }
        if (n == n2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            String s;
            if (n != 0) {
                s = "on";
            }
            else {
                s = "off";
            }
            sb.append(s);
            f1.b.a("InputConnectionAdaptor", sb.toString());
        }
        ExtractedTextRequest f;
        if (n != 0) {
            f = extractedTextRequest;
        }
        else {
            f = null;
        }
        this.f = f;
        return this.d(extractedTextRequest);
    }
    
    public boolean performContextMenuAction(final int n) {
        this.beginBatchEdit();
        final boolean b = this.b(n);
        this.endBatchEdit();
        return b;
    }
    
    public boolean performEditorAction(final int n) {
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 4) {
                            if (n != 5) {
                                if (n != 7) {
                                    this.c.e(this.b);
                                }
                                else {
                                    this.c.j(this.b);
                                }
                            }
                            else {
                                this.c.h(this.b);
                            }
                        }
                        else {
                            this.c.m(this.b);
                        }
                    }
                    else {
                        this.c.l(this.b);
                    }
                }
                else {
                    this.c.f(this.b);
                }
            }
            else {
                this.c.g(this.b);
            }
        }
        else {
            this.c.o(this.b);
        }
        return true;
    }
    
    public boolean performPrivateCommand(final String s, final Bundle bundle) {
        this.c.i(this.b, s, bundle);
        return true;
    }
    
    public boolean requestCursorUpdates(final int n) {
        if ((n & 0x1) != 0x0) {
            this.j.updateCursorAnchorInfo(this.a, this.c());
        }
        final boolean g = (n & 0x2) != 0x0;
        if (g != this.g) {
            final StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            String s;
            if (g) {
                s = "on";
            }
            else {
                s = "off";
            }
            sb.append(s);
            f1.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.g = g;
        return true;
    }
    
    public boolean sendKeyEvent(final KeyEvent keyEvent) {
        return this.m.a(keyEvent);
    }
    
    public boolean setComposingRegion(final int n, final int n2) {
        return super.setComposingRegion(n, n2);
    }
    
    public boolean setComposingText(final CharSequence charSequence, final int n) {
        this.beginBatchEdit();
        boolean b;
        if (charSequence.length() == 0) {
            b = super.commitText(charSequence, n);
        }
        else {
            b = super.setComposingText(charSequence, n);
        }
        this.endBatchEdit();
        return b;
    }
    
    public boolean setSelection(final int n, final int n2) {
        this.beginBatchEdit();
        final boolean setSelection = super.setSelection(n, n2);
        this.endBatchEdit();
        return setSelection;
    }
}
