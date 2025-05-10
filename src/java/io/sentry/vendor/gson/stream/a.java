package io.sentry.vendor.gson.stream;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.io.Reader;
import java.io.Closeable;

public class a implements Closeable
{
    private final Reader e;
    private boolean f;
    private final char[] g;
    private int h;
    private int i;
    private int j;
    private int k;
    int l;
    private long m;
    private int n;
    private String o;
    private int[] p;
    private int q;
    private String[] r;
    private int[] s;
    
    public a(final Reader e) {
        this.f = false;
        this.g = new char[1024];
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        final int[] p = new int[32];
        this.p = p;
        this.q = 0 + 1;
        p[0] = 6;
        this.r = new String[32];
        this.s = new int[32];
        if (e != null) {
            this.e = e;
            return;
        }
        throw new NullPointerException("in == null");
    }
    
    private void A(final int n) {
        final int q = this.q;
        final int[] p = this.p;
        if (q == p.length) {
            final int n2 = q * 2;
            this.p = Arrays.copyOf(p, n2);
            this.s = Arrays.copyOf(this.s, n2);
            this.r = (String[])Arrays.copyOf((Object[])this.r, n2);
        }
        this.p[this.q++] = n;
    }
    
    private char B() {
        if (this.h == this.i && !this.i(1)) {
            throw this.H("Unterminated escape sequence");
        }
        final char[] g = this.g;
        final int h = this.h;
        final int n = h + 1;
        this.h = n;
        final char c = g[h];
        if (c != '\n') {
            if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
                if (c == 'b') {
                    return '\b';
                }
                if (c == 'f') {
                    return '\f';
                }
                if (c == 'n') {
                    return '\n';
                }
                if (c == 'r') {
                    return '\r';
                }
                if (c == 't') {
                    return '\t';
                }
                if (c != 'u') {
                    throw this.H("Invalid escape sequence");
                }
                if (n + 4 > this.i && !this.i(4)) {
                    throw this.H("Unterminated escape sequence");
                }
                char c2 = '\0';
                int h2 = this.h;
                while (true) {
                    final int n2 = h2;
                    if (n2 >= h2 + 4) {
                        this.h += 4;
                        return c2;
                    }
                    int n3 = this.g[n2];
                    final char c3 = (char)(c2 << 4);
                    if (n3 >= '0' && n3 <= '9') {
                        n3 -= 48;
                    }
                    else {
                        if (n3 >= 'a' && n3 <= 'f') {
                            n3 -= 97;
                        }
                        else {
                            if (n3 < 'A' || n3 > 'F') {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("\\u");
                                sb.append(new String(this.g, this.h, 4));
                                throw new NumberFormatException(sb.toString());
                            }
                            n3 -= 65;
                        }
                        n3 += '\n';
                    }
                    c2 = (char)(c3 + n3);
                    h2 = n2 + 1;
                }
            }
        }
        else {
            ++this.j;
            this.k = n;
        }
        return c;
    }
    
    private void C(final char c) {
        final char[] g = this.g;
        while (true) {
            int i = this.h;
            int n = this.i;
            while (i < n) {
                final int k = i + 1;
                final char c2 = g[i];
                if (c2 == c) {
                    this.h = k;
                    return;
                }
                if (c2 == '\\') {
                    this.h = k;
                    this.B();
                    i = this.h;
                    n = this.i;
                }
                else {
                    if (c2 == '\n') {
                        ++this.j;
                        this.k = k;
                    }
                    i = k;
                }
            }
            this.h = i;
            if (this.i(1)) {
                continue;
            }
            throw this.H("Unterminated string");
        }
    }
    
    private boolean D(final String s) {
        final int length = s.length();
        while (true) {
            final int h = this.h;
            final int i = this.i;
            int j = 0;
            if (h + length > i && !this.i(length)) {
                return false;
            }
            final char[] g = this.g;
            final int h2 = this.h;
            Label_0108: {
                if (g[h2] != '\n') {
                    while (j < length) {
                        if (this.g[this.h + j] != s.charAt(j)) {
                            break Label_0108;
                        }
                        ++j;
                    }
                    return true;
                }
                ++this.j;
                this.k = h2 + 1;
            }
            ++this.h;
        }
    }
    
    private void E() {
        while (this.h < this.i || this.i(1)) {
            final char[] g = this.g;
            final int h = this.h;
            final int n = h + 1;
            this.h = n;
            final char c = g[h];
            if (c == '\n') {
                ++this.j;
                this.k = n;
                break;
            }
            if (c == '\r') {
                break;
            }
        }
    }
    
    private void F() {
        do {
            int n = 0;
            Label_0142: {
                Label_0138: {
                    int h;
                    while (true) {
                        h = this.h;
                        if (h + n >= this.i) {
                            break;
                        }
                        final char c = this.g[h + n];
                        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                            break Label_0142;
                        }
                        if (c == '#') {
                            break Label_0138;
                        }
                        if (c == ',') {
                            break Label_0142;
                        }
                        if (c == '/' || c == '=') {
                            break Label_0138;
                        }
                        if (c == '{' || c == '}' || c == ':') {
                            break Label_0142;
                        }
                        if (c == ';') {
                            break Label_0138;
                        }
                        switch (c) {
                            default: {
                                ++n;
                                continue;
                            }
                            case 92: {
                                break Label_0138;
                            }
                            case 91:
                            case 93: {
                                break Label_0142;
                            }
                        }
                    }
                    this.h = h + n;
                    continue;
                }
                this.c();
            }
            this.h += n;
        } while (this.i(1));
    }
    
    private IOException H(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(this.m());
        throw new d(sb.toString());
    }
    
    private void c() {
        if (this.f) {
            return;
        }
        throw this.H("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
    
    private void d() {
        this.s(true);
        final int h = this.h - 1;
        this.h = h;
        if (h + 5 > this.i && !this.i(5)) {
            return;
        }
        final char[] g = this.g;
        if (g[h] == ')' && g[h + 1] == ']' && g[h + 2] == '}' && g[h + 3] == '\'') {
            if (g[h + 4] == '\n') {
                this.h += 5;
            }
        }
    }
    
    private boolean i(int n) {
        final char[] g = this.g;
        final int k = this.k;
        final int h = this.h;
        this.k = k - h;
        final int i = this.i;
        if (i != h) {
            System.arraycopy((Object)g, h, (Object)g, 0, this.i = i - h);
        }
        else {
            this.i = 0;
        }
        this.h = 0;
        int j;
        int n2;
        do {
            final Reader e = this.e;
            final int l = this.i;
            final int read = e.read(g, l, g.length - l);
            if (read == -1) {
                return false;
            }
            j = this.i + read;
            this.i = j;
            n2 = n;
            if (this.j != 0) {
                continue;
            }
            final int m = this.k;
            n2 = n;
            if (m != 0) {
                continue;
            }
            n2 = n;
            if (j <= 0) {
                continue;
            }
            n2 = n;
            if (g[0] != '\ufeff') {
                continue;
            }
            ++this.h;
            this.k = m + 1;
            n2 = n + 1;
        } while (j < (n = n2));
        return true;
    }
    
    private boolean l(final char c) {
        if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
            if (c != '#') {
                if (c == ',') {
                    return false;
                }
                if (c != '/' && c != '=') {
                    if (c == '{' || c == '}' || c == ':') {
                        return false;
                    }
                    if (c != ';') {
                        switch (c) {
                            default: {
                                return true;
                            }
                            case '\\': {
                                break;
                            }
                            case '[':
                            case ']': {
                                return false;
                            }
                        }
                    }
                }
            }
            this.c();
        }
        return false;
    }
    
    private int s(final boolean b) {
        final char[] g = this.g;
        int h = this.h;
        int n = this.i;
        while (true) {
            int h2 = h;
            int i = n;
            if (h == n) {
                this.h = h;
                if (!this.i(1)) {
                    if (!b) {
                        return -1;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("End of input");
                    sb.append(this.m());
                    throw new EOFException(sb.toString());
                }
                else {
                    h2 = this.h;
                    i = this.i;
                }
            }
            h = h2 + 1;
            final char c = g[h2];
            if (c == '\n') {
                ++this.j;
                this.k = h;
            }
            else if (c != ' ' && c != '\r') {
                if (c != '\t') {
                    if (c == '/') {
                        if ((this.h = h) == i) {
                            this.h = h - 1;
                            final boolean j = this.i(2);
                            ++this.h;
                            if (!j) {
                                return c;
                            }
                        }
                        this.c();
                        final int h3 = this.h;
                        final char c2 = g[h3];
                        if (c2 != '*') {
                            if (c2 != '/') {
                                return c;
                            }
                            this.h = h3 + 1;
                            this.E();
                            h = this.h;
                            n = this.i;
                            continue;
                        }
                        else {
                            this.h = h3 + 1;
                            if (this.D("*/")) {
                                h = this.h + 2;
                                n = this.i;
                                continue;
                            }
                            throw this.H("Unterminated comment");
                        }
                    }
                    else {
                        if (c == '#') {
                            this.h = h;
                            this.c();
                            this.E();
                            h = this.h;
                            n = this.i;
                            continue;
                        }
                        this.h = h;
                        return c;
                    }
                }
            }
            n = i;
        }
    }
    
    private String u(final char c) {
        final char[] g = this.g;
        StringBuilder sb = null;
    Label_0009:
        while (true) {
            while (true) {
                int n = this.h;
                int n2 = this.i;
                while (true) {
                    int k = n;
                    while (true) {
                        final int h = k;
                        if (h < n2) {
                            k = h + 1;
                            final char c2 = g[h];
                            if (c2 == c) {
                                this.h = k;
                                final int n3 = k - n - 1;
                                if (sb == null) {
                                    return new String(g, n, n3);
                                }
                                sb.append(g, n, n3);
                                return sb.toString();
                            }
                            else {
                                if (c2 == '\\') {
                                    this.h = k;
                                    final int n4 = k - n - 1;
                                    StringBuilder sb2;
                                    if ((sb2 = sb) == null) {
                                        sb2 = new StringBuilder(Math.max((n4 + 1) * 2, 16));
                                    }
                                    sb2.append(g, n, n4);
                                    sb2.append(this.B());
                                    n = this.h;
                                    n2 = this.i;
                                    sb = sb2;
                                    break;
                                }
                                if (c2 != '\n') {
                                    continue;
                                }
                                ++this.j;
                                this.k = k;
                            }
                        }
                        else {
                            StringBuilder sb3;
                            if ((sb3 = sb) == null) {
                                sb3 = new StringBuilder(Math.max((h - n) * 2, 16));
                            }
                            sb3.append(g, n, h - n);
                            this.h = h;
                            if (this.i(1)) {
                                sb = sb3;
                                continue Label_0009;
                            }
                            throw this.H("Unterminated string");
                        }
                    }
                }
            }
            break;
        }
    }
    
    private String w() {
        final int n = 0;
        StringBuilder sb = null;
    Label_0171:
        while (true) {
            StringBuilder sb2;
            do {
                int n2 = 0;
                Label_0142: {
                    while (true) {
                        final int h = this.h;
                        if (h + n2 < this.i) {
                            final char c = this.g[h + n2];
                            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                                break Label_0171;
                            }
                            if (c == '#') {
                                break Label_0142;
                            }
                            if (c == ',') {
                                break Label_0171;
                            }
                            if (c == '/' || c == '=') {
                                break Label_0142;
                            }
                            if (c == '{' || c == '}' || c == ':') {
                                break Label_0171;
                            }
                            if (c == ';') {
                                break Label_0142;
                            }
                            switch (c) {
                                default: {
                                    ++n2;
                                    continue;
                                }
                                case 92: {
                                    break Label_0142;
                                }
                                case 91:
                                case 93: {
                                    break Label_0171;
                                }
                            }
                        }
                        else {
                            if (n2 >= this.g.length) {
                                break;
                            }
                            if (this.i(n2 + 1)) {
                                continue;
                            }
                            break Label_0171;
                        }
                    }
                    if ((sb2 = sb) == null) {
                        sb2 = new StringBuilder(Math.max(n2, 16));
                    }
                    sb2.append(this.g, this.h, n2);
                    this.h += n2;
                    sb = sb2;
                    continue;
                }
                this.c();
                String string;
                if (sb == null) {
                    string = new String(this.g, this.h, n2);
                }
                else {
                    sb.append(this.g, this.h, n2);
                    string = sb.toString();
                }
                this.h += n2;
                return string;
            } while (this.i(1));
            sb = sb2;
            int n2 = n;
            continue Label_0171;
        }
    }
    
    private int y() {
        final char c = this.g[this.h];
        int l;
        String s;
        String s2;
        if (c != 't' && c != 'T') {
            if (c != 'f' && c != 'F') {
                if (c != 'n' && c != 'N') {
                    return 0;
                }
                l = 7;
                s = "null";
                s2 = "NULL";
            }
            else {
                l = 6;
                s = "false";
                s2 = "FALSE";
            }
        }
        else {
            l = 5;
            s = "true";
            s2 = "TRUE";
        }
        final int length = s.length();
        for (int i = 1; i < length; ++i) {
            if (this.h + i >= this.i && !this.i(i + 1)) {
                return 0;
            }
            final char c2 = this.g[this.h + i];
            if (c2 != s.charAt(i) && c2 != s2.charAt(i)) {
                return 0;
            }
        }
        if ((this.h + length < this.i || this.i(length + 1)) && this.l(this.g[this.h + length])) {
            return 0;
        }
        this.h += length;
        return this.l = l;
    }
    
    private int z() {
        final char[] g = this.g;
        int h = this.h;
        int i = this.i;
        int n = 0;
        int n2 = 0;
        int n3 = 1;
        long m = 0L;
        int n4 = 0;
        while (true) {
            int h2 = h;
            int j = i;
            if (h + n == i) {
                if (n == g.length) {
                    return 0;
                }
                if (!this.i(n + 1)) {
                    break;
                }
                h2 = this.h;
                j = this.i;
            }
            final char c = g[h2 + n];
            Label_0468: {
                if (c != '+') {
                    if (c != 'E' && c != 'e') {
                        if (c != '-') {
                            if (c != '.') {
                                if (c >= '0' && c <= '9') {
                                    Label_0283: {
                                        if (n2 != 1 && n2 != 0) {
                                            long n5 = 0L;
                                            int n7 = 0;
                                            Label_0257: {
                                                if (n2 == 2) {
                                                    if (m == 0L) {
                                                        return 0;
                                                    }
                                                    n5 = 10L * m - (c - '0');
                                                    final long n6 = lcmp(m, -922337203685477580L);
                                                    n7 = (n3 & ((n6 > 0 || (n6 == 0 && n5 < m)) ? 1 : 0));
                                                }
                                                else {
                                                    if (n2 == 3) {
                                                        n2 = 4;
                                                        break Label_0283;
                                                    }
                                                    if (n2 != 5) {
                                                        n7 = n3;
                                                        n5 = m;
                                                        if (n2 != 6) {
                                                            break Label_0257;
                                                        }
                                                    }
                                                    n2 = 7;
                                                    break Label_0283;
                                                }
                                            }
                                            n3 = n7;
                                            m = n5;
                                        }
                                        else {
                                            m = -(c - '0');
                                            n2 = 2;
                                        }
                                    }
                                    break Label_0468;
                                }
                                if (!this.l(c)) {
                                    break;
                                }
                                return 0;
                            }
                            else {
                                if (n2 == 2) {
                                    n2 = 3;
                                    break Label_0468;
                                }
                                return 0;
                            }
                        }
                        else {
                            if (n2 == 0) {
                                n2 = 1;
                                n4 = 1;
                                break Label_0468;
                            }
                            if (n2 != 5) {
                                return 0;
                            }
                        }
                    }
                    else {
                        if (n2 != 2 && n2 != 4) {
                            return 0;
                        }
                        n2 = 5;
                        break Label_0468;
                    }
                }
                else if (n2 != 5) {
                    return 0;
                }
                n2 = 6;
            }
            ++n;
            h = h2;
            i = j;
        }
        if (n2 == 2 && n3 && (m != Long.MIN_VALUE || n4 != 0) && (m != 0L || n4 == 0)) {
            if (n4 == 0) {
                m = -m;
            }
            this.m = m;
            this.h += n;
            return this.l = 15;
        }
        if (n2 != 2 && n2 != 4 && n2 != 7) {
            return 0;
        }
        this.n = n;
        return this.l = 16;
    }
    
    public void G() {
        int n = 0;
        int n2 = 0;
        do {
            int n3;
            if ((n3 = this.l) == 0) {
                n3 = this.f();
            }
            Label_0187: {
                if (n3 == 3) {
                    this.A(1);
                }
                else {
                    if (n3 != 1) {
                        if (n3 == 4) {
                            --this.q;
                        }
                        else if (n3 == 2) {
                            --this.q;
                        }
                        else {
                            if (n3 == 14 || n3 == 10) {
                                this.F();
                                n2 = n;
                                break Label_0187;
                            }
                            if (n3 == 8 || n3 == 12) {
                                this.C('\'');
                                n2 = n;
                                break Label_0187;
                            }
                            if (n3 == 9 || n3 == 13) {
                                this.C('\"');
                                n2 = n;
                                break Label_0187;
                            }
                            n2 = n;
                            if (n3 == 16) {
                                this.h += this.n;
                                n2 = n;
                            }
                            break Label_0187;
                        }
                        n2 = n - 1;
                        break Label_0187;
                    }
                    this.A(3);
                }
                n2 = n + 1;
            }
            this.l = 0;
        } while ((n = n2) != 0);
        final int[] s = this.s;
        final int q = this.q;
        final int n4 = q - 1;
        ++s[n4];
        this.r[q - 1] = "null";
    }
    
    public void a() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        if (n == 3) {
            this.A(1);
            this.s[this.q - 1] = 0;
            this.l = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append((Object)this.x());
        sb.append(this.m());
        throw new IllegalStateException(sb.toString());
    }
    
    public void b() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        if (n == 1) {
            this.A(3);
            this.l = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append((Object)this.x());
        sb.append(this.m());
        throw new IllegalStateException(sb.toString());
    }
    
    public void close() {
        this.l = 0;
        this.p[0] = 8;
        this.q = 1;
        this.e.close();
    }
    
    int f() {
        final int[] p = this.p;
        final int q = this.q;
        final int n = p[q - 1];
        if (n == 1) {
            p[q - 1] = 2;
        }
        else if (n == 2) {
            final int s = this.s(true);
            if (s != 44) {
                if (s != 59) {
                    if (s == 93) {
                        return this.l = 4;
                    }
                    throw this.H("Unterminated array");
                }
                else {
                    this.c();
                }
            }
        }
        else if (n != 3 && n != 5) {
            if (n == 4) {
                p[q - 1] = 5;
                final int s2 = this.s(true);
                if (s2 != 58) {
                    if (s2 != 61) {
                        throw this.H("Expected ':'");
                    }
                    this.c();
                    if (this.h < this.i || this.i(1)) {
                        final char[] g = this.g;
                        final int h = this.h;
                        if (g[h] == '>') {
                            this.h = h + 1;
                        }
                    }
                }
            }
            else if (n == 6) {
                if (this.f) {
                    this.d();
                }
                this.p[this.q - 1] = 7;
            }
            else if (n == 7) {
                if (this.s(false) == -1) {
                    return this.l = 17;
                }
                this.c();
                --this.h;
            }
            else if (n == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        else {
            p[q - 1] = 4;
            if (n == 5) {
                final int s3 = this.s(true);
                if (s3 != 44) {
                    if (s3 != 59) {
                        if (s3 == 125) {
                            return this.l = 2;
                        }
                        throw this.H("Unterminated object");
                    }
                    else {
                        this.c();
                    }
                }
            }
            final int s4 = this.s(true);
            if (s4 == 34) {
                return this.l = 13;
            }
            if (s4 == 39) {
                this.c();
                return this.l = 12;
            }
            if (s4 != 125) {
                this.c();
                --this.h;
                if (this.l((char)s4)) {
                    return this.l = 14;
                }
                throw this.H("Expected name");
            }
            else {
                if (n != 5) {
                    return this.l = 2;
                }
                throw this.H("Expected name");
            }
        }
        final int s5 = this.s(true);
        if (s5 == 34) {
            return this.l = 9;
        }
        if (s5 == 39) {
            this.c();
            return this.l = 8;
        }
        if (s5 != 44 && s5 != 59) {
            if (s5 == 91) {
                return this.l = 3;
            }
            if (s5 != 93) {
                if (s5 == 123) {
                    return this.l = 1;
                }
                --this.h;
                final int y = this.y();
                if (y != 0) {
                    return y;
                }
                final int z = this.z();
                if (z != 0) {
                    return z;
                }
                if (this.l(this.g[this.h])) {
                    this.c();
                    return this.l = 10;
                }
                throw this.H("Expected value");
            }
            else if (n == 1) {
                return this.l = 4;
            }
        }
        if (n != 1 && n != 2) {
            throw this.H("Unexpected value");
        }
        this.c();
        --this.h;
        return this.l = 7;
    }
    
    public void g() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        if (n == 4) {
            int q = this.q - 1;
            this.q = q;
            final int[] s = this.s;
            --q;
            ++s[q];
            this.l = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected END_ARRAY but was ");
        sb.append((Object)this.x());
        sb.append(this.m());
        throw new IllegalStateException(sb.toString());
    }
    
    public void h() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        if (n == 2) {
            int q = this.q - 1;
            this.q = q;
            this.r[q] = null;
            final int[] s = this.s;
            --q;
            ++s[q];
            this.l = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected END_OBJECT but was ");
        sb.append((Object)this.x());
        sb.append(this.m());
        throw new IllegalStateException(sb.toString());
    }
    
    public String j() {
        final StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int q = this.q, i = 0; i < q; ++i) {
            final int n = this.p[i];
            if (n != 1 && n != 2) {
                if (n == 3 || n == 4 || n == 5) {
                    sb.append('.');
                    final String s = this.r[i];
                    if (s != null) {
                        sb.append(s);
                    }
                }
            }
            else {
                sb.append('[');
                sb.append(this.s[i]);
                sb.append(']');
            }
        }
        return sb.toString();
    }
    
    String m() {
        final int j = this.j;
        final int h = this.h;
        final int k = this.k;
        final StringBuilder sb = new StringBuilder();
        sb.append(" at line ");
        sb.append(j + 1);
        sb.append(" column ");
        sb.append(h - k + 1);
        sb.append(" path ");
        sb.append(this.j());
        return sb.toString();
    }
    
    public boolean n() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        if (n == 5) {
            this.l = 0;
            final int[] s = this.s;
            final int n2 = this.q - 1;
            ++s[n2];
            return true;
        }
        if (n == 6) {
            this.l = 0;
            final int[] s2 = this.s;
            final int n3 = this.q - 1;
            ++s2[n3];
            return false;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected a boolean but was ");
        sb.append((Object)this.x());
        sb.append(this.m());
        throw new IllegalStateException(sb.toString());
    }
    
    public double o() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        if (n == 15) {
            this.l = 0;
            final int[] s = this.s;
            final int n2 = this.q - 1;
            ++s[n2];
            return (double)this.m;
        }
        if (n == 16) {
            this.o = new String(this.g, this.h, this.n);
            this.h += this.n;
        }
        else if (n != 8 && n != 9) {
            if (n == 10) {
                this.o = this.w();
            }
            else if (n != 11) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a double but was ");
                sb.append((Object)this.x());
                sb.append(this.m());
                throw new IllegalStateException(sb.toString());
            }
        }
        else {
            char c;
            if (n == 8) {
                c = '\'';
            }
            else {
                c = '\"';
            }
            this.o = this.u(c);
        }
        this.l = 11;
        final double double1 = Double.parseDouble(this.o);
        if (!this.f && (Double.isNaN(double1) || Double.isInfinite(double1))) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("JSON forbids NaN and infinities: ");
            sb2.append(double1);
            sb2.append(this.m());
            throw new d(sb2.toString());
        }
        this.o = null;
        this.l = 0;
        final int[] s2 = this.s;
        final int n3 = this.q - 1;
        ++s2[n3];
        return double1;
    }
    
    public int p() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        if (n == 15) {
            final long m = this.m;
            final int n2 = (int)m;
            if (m == n2) {
                this.l = 0;
                final int[] s = this.s;
                final int n3 = this.q - 1;
                ++s[n3];
                return n2;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected an int but was ");
            sb.append(this.m);
            sb.append(this.m());
            throw new NumberFormatException(sb.toString());
        }
        else {
            if (n == 16) {
                this.o = new String(this.g, this.h, this.n);
                this.h += this.n;
            }
            else {
                if (n != 8 && n != 9 && n != 10) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected an int but was ");
                    sb2.append((Object)this.x());
                    sb2.append(this.m());
                    throw new IllegalStateException(sb2.toString());
                }
                if (n == 10) {
                    this.o = this.w();
                }
                else {
                    char c;
                    if (n == 8) {
                        c = '\'';
                    }
                    else {
                        c = '\"';
                    }
                    this.o = this.u(c);
                }
                try {
                    final int int1 = Integer.parseInt(this.o);
                    this.l = 0;
                    final int[] s2 = this.s;
                    final int n4 = this.q - 1;
                    ++s2[n4];
                    return int1;
                }
                catch (final NumberFormatException ex) {}
            }
            this.l = 11;
            final double double1 = Double.parseDouble(this.o);
            final int n5 = (int)double1;
            if (n5 == double1) {
                this.o = null;
                this.l = 0;
                final int[] s3 = this.s;
                final int n6 = this.q - 1;
                ++s3[n6];
                return n5;
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Expected an int but was ");
            sb3.append(this.o);
            sb3.append(this.m());
            throw new NumberFormatException(sb3.toString());
        }
    }
    
    public long q() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        if (n == 15) {
            this.l = 0;
            final int[] s = this.s;
            final int n2 = this.q - 1;
            ++s[n2];
            return this.m;
        }
        if (n == 16) {
            this.o = new String(this.g, this.h, this.n);
            this.h += this.n;
        }
        else {
            if (n != 8 && n != 9 && n != 10) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a long but was ");
                sb.append((Object)this.x());
                sb.append(this.m());
                throw new IllegalStateException(sb.toString());
            }
            if (n == 10) {
                this.o = this.w();
            }
            else {
                char c;
                if (n == 8) {
                    c = '\'';
                }
                else {
                    c = '\"';
                }
                this.o = this.u(c);
            }
            try {
                final long long1 = Long.parseLong(this.o);
                this.l = 0;
                final int[] s2 = this.s;
                final int n3 = this.q - 1;
                ++s2[n3];
                return long1;
            }
            catch (final NumberFormatException ex) {}
        }
        this.l = 11;
        final double double1 = Double.parseDouble(this.o);
        final long n4 = (long)double1;
        if (n4 == double1) {
            this.o = null;
            this.l = 0;
            final int[] s3 = this.s;
            final int n5 = this.q - 1;
            ++s3[n5];
            return n4;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected a long but was ");
        sb2.append(this.o);
        sb2.append(this.m());
        throw new NumberFormatException(sb2.toString());
    }
    
    public String r() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        String s;
        if (n == 14) {
            s = this.w();
        }
        else if (n == 12) {
            s = this.u('\'');
        }
        else {
            if (n != 13) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a name but was ");
                sb.append((Object)this.x());
                sb.append(this.m());
                throw new IllegalStateException(sb.toString());
            }
            s = this.u('\"');
        }
        this.l = 0;
        return this.r[this.q - 1] = s;
    }
    
    public void t() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        if (n == 7) {
            this.l = 0;
            final int[] s = this.s;
            final int n2 = this.q - 1;
            ++s[n2];
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected null but was ");
        sb.append((Object)this.x());
        sb.append(this.m());
        throw new IllegalStateException(sb.toString());
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(this.m());
        return sb.toString();
    }
    
    public String v() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        String s;
        if (n == 10) {
            s = this.w();
        }
        else if (n == 8) {
            s = this.u('\'');
        }
        else if (n == 9) {
            s = this.u('\"');
        }
        else if (n == 11) {
            s = this.o;
            this.o = null;
        }
        else if (n == 15) {
            s = Long.toString(this.m);
        }
        else {
            if (n != 16) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a string but was ");
                sb.append((Object)this.x());
                sb.append(this.m());
                throw new IllegalStateException(sb.toString());
            }
            s = new String(this.g, this.h, this.n);
            this.h += this.n;
        }
        this.l = 0;
        final int[] s2 = this.s;
        final int n2 = this.q - 1;
        ++s2[n2];
        return s;
    }
    
    public b x() {
        int n;
        if ((n = this.l) == 0) {
            n = this.f();
        }
        switch (n) {
            default: {
                throw new AssertionError();
            }
            case 17: {
                return b.END_DOCUMENT;
            }
            case 15:
            case 16: {
                return b.NUMBER;
            }
            case 12:
            case 13:
            case 14: {
                return b.NAME;
            }
            case 8:
            case 9:
            case 10:
            case 11: {
                return b.STRING;
            }
            case 7: {
                return b.NULL;
            }
            case 5:
            case 6: {
                return b.BOOLEAN;
            }
            case 4: {
                return b.END_ARRAY;
            }
            case 3: {
                return b.BEGIN_ARRAY;
            }
            case 2: {
                return b.END_OBJECT;
            }
            case 1: {
                return b.BEGIN_OBJECT;
            }
        }
    }
}
