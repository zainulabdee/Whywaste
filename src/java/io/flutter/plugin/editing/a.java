package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

class a
{
    private final FlutterJNI a;
    
    public a(final FlutterJNI a) {
        this.a = a;
    }
    
    public int a(final CharSequence charSequence, final int n) {
        final int length = charSequence.length();
        final int n2 = length - 1;
        if (n >= n2) {
            return length;
        }
        final int codePoint = Character.codePointAt(charSequence, n);
        final int charCount = Character.charCount(codePoint);
        int n3 = n + charCount;
        int n4 = 0;
        if (n3 == 0) {
            return 0;
        }
        if (codePoint == 10) {
            int n5 = charCount;
            if (Character.codePointAt(charSequence, n3) == 13) {
                n5 = charCount + 1;
            }
            return n + n5;
        }
        if (this.g(codePoint)) {
            if (n3 < n2 && this.g(Character.codePointAt(charSequence, n3))) {
                for (int n6 = n; n6 > 0 && this.g(Character.codePointBefore(charSequence, n)); n6 -= Character.charCount(Character.codePointBefore(charSequence, n)), ++n4) {}
                int n7 = charCount;
                if (n4 % 2 == 0) {
                    n7 = charCount + 2;
                }
                return n + n7;
            }
            return n3;
        }
        else {
            int n8 = charCount;
            if (this.f(codePoint)) {
                n8 = charCount + Character.charCount(codePoint);
            }
            if (codePoint == 8419) {
                final int codePointBefore = Character.codePointBefore(charSequence, n3);
                final int n9 = n3 + Character.charCount(codePointBefore);
                int n10;
                if (n9 < length && this.i(codePointBefore)) {
                    final int codePoint2 = Character.codePointAt(charSequence, n9);
                    n10 = n8;
                    if (this.f(codePoint2)) {
                        n10 = n8 + (Character.charCount(codePointBefore) + Character.charCount(codePoint2));
                    }
                }
                else {
                    n10 = n8;
                    if (this.f(codePointBefore)) {
                        n10 = n8 + Character.charCount(codePointBefore);
                    }
                }
                return n + n10;
            }
            int n11 = n8;
            if (this.c(codePoint)) {
                int n12 = 0;
                int n13 = 0;
                int n14 = n8;
                int n15 = codePoint;
                int n16;
                int n17;
                do {
                    n17 = n14;
                    int n18;
                    if ((n18 = n12) != 0) {
                        n17 = n14 + (Character.charCount(n15) + n13 + 1);
                        n18 = 0;
                    }
                    if (this.d(n15)) {
                        n11 = n17;
                        return n + n11;
                    }
                    n16 = n15;
                    int n19 = n3;
                    n12 = n18;
                    int charCount2 = 0;
                    Label_0657: {
                        Label_0650: {
                            if (n3 < length) {
                                final int codePoint3 = Character.codePointAt(charSequence, n3);
                                final int n20 = n3 + Character.charCount(codePoint3);
                                if (codePoint3 == 8419) {
                                    final int codePointBefore2 = Character.codePointBefore(charSequence, n20);
                                    final int n21 = n20 + Character.charCount(codePointBefore2);
                                    int n22;
                                    if (n21 < length && this.i(codePointBefore2)) {
                                        final int codePoint4 = Character.codePointAt(charSequence, n21);
                                        n22 = n17;
                                        if (this.f(codePoint4)) {
                                            n22 = n17 + (Character.charCount(codePointBefore2) + Character.charCount(codePoint4));
                                        }
                                    }
                                    else {
                                        n22 = n17;
                                        if (this.f(codePointBefore2)) {
                                            n22 = n17 + Character.charCount(codePointBefore2);
                                        }
                                    }
                                    return n + n22;
                                }
                                int n23;
                                if (this.d(codePoint3)) {
                                    n23 = Character.charCount(codePoint3);
                                }
                                else if (this.i(codePoint3)) {
                                    n23 = Character.charCount(codePoint3);
                                }
                                else {
                                    n16 = codePoint3;
                                    n19 = n20;
                                    n12 = n18;
                                    if (codePoint3 != 8205) {
                                        break Label_0650;
                                    }
                                    n16 = Character.codePointAt(charSequence, n20);
                                    n19 = n20 + Character.charCount(n16);
                                    if (n19 < length && this.i(n16)) {
                                        n16 = Character.codePointAt(charSequence, n19);
                                        charCount2 = Character.charCount(n16);
                                        n3 = n19 + Character.charCount(n16);
                                        n12 = 1;
                                        break Label_0657;
                                    }
                                    n12 = 1;
                                    break Label_0650;
                                }
                                n11 = n17 + (n23 + 0);
                                return n + n11;
                            }
                        }
                        charCount2 = 0;
                        n3 = n19;
                    }
                    if (n3 >= length) {
                        n11 = n17;
                        return n + n11;
                    }
                    n11 = n17;
                    if (n12 == 0) {
                        return n + n11;
                    }
                    n15 = n16;
                    n14 = n17;
                    n13 = charCount2;
                } while (this.c(n16));
                n11 = n17;
            }
            return n + n11;
        }
    }
    
    public int b(final CharSequence charSequence, final int n) {
        final int n2 = 0;
        int n3 = 1;
        if (n <= 1) {
            return 0;
        }
        final int codePointBefore = Character.codePointBefore(charSequence, n);
        final int charCount = Character.charCount(codePointBefore);
        int n4 = n - charCount;
        if (n4 == 0) {
            return 0;
        }
        if (codePointBefore == 10) {
            int n5 = charCount;
            if (Character.codePointBefore(charSequence, n4) == 13) {
                n5 = charCount + 1;
            }
            return n - n5;
        }
        if (this.g(codePointBefore)) {
            for (int n6 = Character.codePointBefore(charSequence, n4), n7 = n4 - Character.charCount(n6); n7 > 0 && this.g(n6); n6 = Character.codePointBefore(charSequence, n7), n7 -= Character.charCount(n6), ++n3) {}
            int n8 = charCount;
            if (n3 % 2 == 0) {
                n8 = charCount + 2;
            }
            return n - n8;
        }
        if (codePointBefore == 8419) {
            final int codePointBefore2 = Character.codePointBefore(charSequence, n4);
            final int n9 = n4 - Character.charCount(codePointBefore2);
            int n10;
            if (n9 > 0 && this.i(codePointBefore2)) {
                final int codePointBefore3 = Character.codePointBefore(charSequence, n9);
                n10 = charCount;
                if (this.f(codePointBefore3)) {
                    n10 = charCount + (Character.charCount(codePointBefore2) + Character.charCount(codePointBefore3));
                }
            }
            else {
                n10 = charCount;
                if (this.f(codePointBefore2)) {
                    n10 = charCount + Character.charCount(codePointBefore2);
                }
            }
            return n - n10;
        }
        int n11 = codePointBefore;
        int n12 = charCount;
        int n13 = n4;
        if (codePointBefore == 917631) {
            final int codePointBefore4 = Character.codePointBefore(charSequence, n4);
            int n14 = Character.charCount(codePointBefore4);
            int n15 = charCount;
            int codePointBefore5 = codePointBefore4;
            while (true) {
                n4 -= n14;
                if (n4 <= 0 || !this.h(codePointBefore5)) {
                    break;
                }
                n15 += Character.charCount(codePointBefore5);
                codePointBefore5 = Character.codePointBefore(charSequence, n4);
                n14 = Character.charCount(codePointBefore5);
            }
            if (!this.c(codePointBefore5)) {
                return n - 2;
            }
            n12 = n15 + Character.charCount(codePointBefore5);
            n13 = n4;
            n11 = codePointBefore5;
        }
        int codePointBefore6 = n11;
        int n16 = n12;
        int n17 = n13;
        if (this.i(n11)) {
            codePointBefore6 = Character.codePointBefore(charSequence, n13);
            if (!this.c(codePointBefore6)) {
                return n - n12;
            }
            n16 = n12 + Character.charCount(codePointBefore6);
            n17 = n13 - n16;
        }
        int n18 = n16;
        if (this.c(codePointBefore6)) {
            int n19 = 0;
            int n20 = 0;
            int n21 = n16;
            int n22 = codePointBefore6;
            int n23;
            int n24;
            do {
                n24 = n21;
                int n25;
                if ((n25 = n19) != 0) {
                    n24 = n21 + (Character.charCount(n22) + n20 + 1);
                    n25 = 0;
                }
                if (this.d(n22)) {
                    final int codePointBefore7 = Character.codePointBefore(charSequence, n17);
                    final int n26 = n17 - Character.charCount(codePointBefore7);
                    int charCount2 = n2;
                    int codePointBefore8 = codePointBefore7;
                    if (n26 > 0) {
                        charCount2 = n2;
                        codePointBefore8 = codePointBefore7;
                        if (this.i(codePointBefore7)) {
                            codePointBefore8 = Character.codePointBefore(charSequence, n26);
                            if (!this.c(codePointBefore8)) {
                                return n - n24;
                            }
                            charCount2 = Character.charCount(codePointBefore8);
                            Character.charCount(codePointBefore8);
                        }
                    }
                    n18 = n24;
                    if (this.e(codePointBefore8)) {
                        n18 = n24 + (charCount2 + Character.charCount(codePointBefore8));
                        return n - n18;
                    }
                    return n - n18;
                }
                else {
                    n23 = n22;
                    int n27 = n17;
                    n19 = n25;
                    int charCount3 = 0;
                    Label_0713: {
                        if (n17 > 0) {
                            final int codePointBefore9 = Character.codePointBefore(charSequence, n17);
                            final int n28 = n17 - Character.charCount(codePointBefore9);
                            n23 = codePointBefore9;
                            n27 = n28;
                            n19 = n25;
                            if (codePointBefore9 == 8205) {
                                n23 = Character.codePointBefore(charSequence, n28);
                                n27 = n28 - Character.charCount(n23);
                                if (n27 > 0 && this.i(n23)) {
                                    n23 = Character.codePointBefore(charSequence, n27);
                                    charCount3 = Character.charCount(n23);
                                    n17 = n27 - Character.charCount(n23);
                                    n19 = 1;
                                    break Label_0713;
                                }
                                n19 = 1;
                            }
                        }
                        charCount3 = 0;
                        n17 = n27;
                    }
                    if (n17 == 0) {
                        n18 = n24;
                        return n - n18;
                    }
                    n18 = n24;
                    if (n19 == 0) {
                        return n - n18;
                    }
                    n22 = n23;
                    n21 = n24;
                    n20 = charCount3;
                }
            } while (this.c(n23));
            n18 = n24;
        }
        return n - n18;
    }
    
    public boolean c(final int n) {
        return this.a.isCodePointEmoji(n);
    }
    
    public boolean d(final int n) {
        return this.a.isCodePointEmojiModifier(n);
    }
    
    public boolean e(final int n) {
        return this.a.isCodePointEmojiModifierBase(n);
    }
    
    public boolean f(final int n) {
        return (48 <= n && n <= 57) || n == 35 || n == 42;
    }
    
    public boolean g(final int n) {
        return this.a.isCodePointRegionalIndicator(n);
    }
    
    public boolean h(final int n) {
        return 917536 <= n && n <= 917630;
    }
    
    public boolean i(final int n) {
        return this.a.isCodePointVariantSelector(n);
    }
}
