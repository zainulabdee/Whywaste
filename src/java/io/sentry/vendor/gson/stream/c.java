package io.sentry.vendor.gson.stream;

import java.io.IOException;
import java.util.Arrays;
import java.io.Writer;
import java.io.Flushable;
import java.io.Closeable;

public class c implements Closeable, Flushable
{
    private static final String[] n;
    private static final String[] o;
    private final Writer e;
    private int[] f;
    private int g;
    private String h;
    private String i;
    private boolean j;
    private boolean k;
    private String l;
    private boolean m;
    
    static {
        n = new String[128];
        for (int i = 0; i <= 31; ++i) {
            c.n[i] = String.format("\\u%04x", new Object[] { i });
        }
        final String[] n2 = c.n;
        n2[34] = "\\\"";
        n2[92] = "\\\\";
        n2[9] = "\\t";
        n2[8] = "\\b";
        n2[10] = "\\n";
        n2[13] = "\\r";
        n2[12] = "\\f";
        final String[] o2 = n2.clone();
        (o = o2)[60] = "\\u003c";
        o2[62] = "\\u003e";
        o2[38] = "\\u0026";
        o2[61] = "\\u003d";
        o2[39] = "\\u0027";
    }
    
    public c(final Writer e) {
        this.f = new int[32];
        this.g = 0;
        this.o(6);
        this.i = ":";
        this.m = true;
        if (e != null) {
            this.e = e;
            return;
        }
        throw new NullPointerException("out == null");
    }
    
    private void a() {
        final int n = this.n();
        if (n == 5) {
            this.e.write(44);
        }
        else if (n != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.j();
        this.p(4);
    }
    
    private void b() {
        final int n = this.n();
        if (n != 1) {
            if (n != 2) {
                if (n != 4) {
                    if (n != 6) {
                        if (n != 7) {
                            throw new IllegalStateException("Nesting problem.");
                        }
                        if (!this.j) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    }
                    this.p(7);
                }
                else {
                    this.e.append((CharSequence)this.i);
                    this.p(5);
                }
            }
            else {
                this.e.append(',');
                this.j();
            }
        }
        else {
            this.p(2);
            this.j();
        }
    }
    
    private c f(final int n, final int n2, final char c) {
        final int n3 = this.n();
        if (n3 != n2 && n3 != n) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.l == null) {
            --this.g;
            if (n3 == n2) {
                this.j();
            }
            this.e.write((int)c);
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Dangling name: ");
        sb.append(this.l);
        throw new IllegalStateException(sb.toString());
    }
    
    private void j() {
        if (this.h == null) {
            return;
        }
        this.e.write(10);
        for (int g = this.g, i = 1; i < g; ++i) {
            this.e.write(this.h);
        }
    }
    
    private c m(final int n, final char c) {
        this.b();
        this.o(n);
        this.e.write((int)c);
        return this;
    }
    
    private int n() {
        final int g = this.g;
        if (g != 0) {
            return this.f[g - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }
    
    private void o(final int n) {
        final int g = this.g;
        final int[] f = this.f;
        if (g == f.length) {
            this.f = Arrays.copyOf(f, g * 2);
        }
        this.f[this.g++] = n;
    }
    
    private void p(final int n) {
        this.f[this.g - 1] = n;
    }
    
    private void r(final String s) {
        String[] array;
        if (this.k) {
            array = c.o;
        }
        else {
            array = c.n;
        }
        this.e.write(34);
        final int length = s.length();
        int i = 0;
        int n = 0;
        while (i < length) {
            final char char1 = s.charAt(i);
            int n2 = 0;
            Label_0146: {
                String s2;
                if (char1 < '\u0080') {
                    if ((s2 = array[char1]) == null) {
                        n2 = n;
                        break Label_0146;
                    }
                }
                else if (char1 == '\u2028') {
                    s2 = "\\u2028";
                }
                else {
                    n2 = n;
                    if (char1 != '\u2029') {
                        break Label_0146;
                    }
                    s2 = "\\u2029";
                }
                if (n < i) {
                    this.e.write(s, n, i - n);
                }
                this.e.write(s2);
                n2 = i + 1;
            }
            ++i;
            n = n2;
        }
        if (n < length) {
            this.e.write(s, n, length - n);
        }
        this.e.write(34);
    }
    
    private void x() {
        if (this.l != null) {
            this.a();
            this.r(this.l);
            this.l = null;
        }
    }
    
    public c c() {
        this.x();
        return this.m(1, '[');
    }
    
    public void close() {
        this.e.close();
        final int g = this.g;
        if (g <= 1 && (g != 1 || this.f[g - 1] == 7)) {
            this.g = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }
    
    public c d() {
        this.x();
        return this.m(3, '{');
    }
    
    public void flush() {
        if (this.g != 0) {
            this.e.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }
    
    public c g() {
        return this.f(1, 2, ']');
    }
    
    public c h() {
        return this.f(3, 5, '}');
    }
    
    public c i(final String l) {
        if (l == null) {
            throw new NullPointerException("name == null");
        }
        if (this.l != null) {
            throw new IllegalStateException();
        }
        if (this.g != 0) {
            this.l = l;
            return this;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }
    
    public c l() {
        if (this.l != null) {
            if (!this.m) {
                this.l = null;
                return this;
            }
            this.x();
        }
        this.b();
        this.e.write("null");
        return this;
    }
    
    public final void q(final String h) {
        if (h.length() == 0) {
            this.h = null;
            this.i = ":";
        }
        else {
            this.h = h;
            this.i = ": ";
        }
    }
    
    public c s(final long n) {
        this.x();
        this.b();
        this.e.write(Long.toString(n));
        return this;
    }
    
    public c t(final Boolean b) {
        if (b == null) {
            return this.l();
        }
        this.x();
        this.b();
        final Writer e = this.e;
        String s;
        if (b) {
            s = "true";
        }
        else {
            s = "false";
        }
        e.write(s);
        return this;
    }
    
    public c u(final Number n) {
        if (n == null) {
            return this.l();
        }
        this.x();
        final String string = n.toString();
        if (!this.j && (string.equals((Object)"-Infinity") || string.equals((Object)"Infinity") || string.equals((Object)"NaN"))) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Numeric values must be finite, but was ");
            sb.append((Object)n);
            throw new IllegalArgumentException(sb.toString());
        }
        this.b();
        this.e.append((CharSequence)string);
        return this;
    }
    
    public c v(final String s) {
        if (s == null) {
            return this.l();
        }
        this.x();
        this.b();
        this.r(s);
        return this;
    }
    
    public c w(final boolean b) {
        this.x();
        this.b();
        final Writer e = this.e;
        String s;
        if (b) {
            s = "true";
        }
        else {
            s = "false";
        }
        e.write(s);
        return this;
    }
}
