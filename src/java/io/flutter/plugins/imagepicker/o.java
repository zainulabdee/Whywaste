package io.flutter.plugins.imagepicker;

import java.io.IOException;
import android.graphics.BitmapFactory;
import java.io.FileOutputStream;
import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import android.graphics.Bitmap;
import java.io.File;
import androidx.core.util.f;
import android.graphics.BitmapFactory$Options;
import android.content.Context;

class o
{
    private final Context a;
    private final a b;
    
    o(final Context a, final a b) {
        this.a = a;
        this.b = b;
    }
    
    private int a(final BitmapFactory$Options bitmapFactory$Options, final int n, final int n2) {
        final int outHeight = bitmapFactory$Options.outHeight;
        final int outWidth = bitmapFactory$Options.outWidth;
        int n3 = 1;
        int n4 = 1;
        if (outHeight > n2 || outWidth > n) {
            final int n5 = outHeight / 2;
            final int n6 = outWidth / 2;
            while (true) {
                n3 = n4;
                if (n5 / n4 < n2) {
                    break;
                }
                n3 = n4;
                if (n6 / n4 < n) {
                    break;
                }
                n4 *= 2;
            }
        }
        return n3;
    }
    
    private f b(final Double n, final Double n2, Double n3, Double n4) {
        final boolean b = true;
        final boolean b2 = n3 != null;
        final boolean b3 = n4 != null;
        double n5 = n;
        if (b2) {
            n5 = Math.min(n5, (double)n3);
        }
        final Double value = n5;
        double n6 = n2;
        if (b3) {
            n6 = Math.min(n6, (double)n4);
        }
        final Double value2 = n6;
        final boolean b4 = b2 && n3 < n;
        final boolean b5 = b3 && n4 < n2;
        int n7 = b ? 1 : 0;
        if (!b4) {
            if (b5) {
                n7 = (b ? 1 : 0);
            }
            else {
                n7 = 0;
            }
        }
        n3 = value;
        n4 = value2;
        if (n7 != 0) {
            final double n8 = value2 / n2 * n;
            final double n9 = value / n * n2;
            if (value < value2) {
                if (!b2) {
                    n3 = n8;
                    n4 = value2;
                }
                else {
                    n4 = n9;
                    n3 = value;
                }
            }
            else if (value2 < value) {
                if (!b3) {
                    n4 = n9;
                    n3 = value;
                }
                else {
                    n3 = n8;
                    n4 = value2;
                }
            }
            else if (n < n2) {
                n3 = n8;
                n4 = value2;
            }
            else {
                n3 = value;
                n4 = value2;
                if (n2 < n) {
                    n4 = n9;
                    n3 = value;
                }
            }
        }
        return new f(n3.floatValue(), n4.floatValue());
    }
    
    private void c(final String s, final String s2) {
        this.b.a(s, s2);
    }
    
    private File d(File file, final String s) {
        file = new File(file, s);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }
    
    private File e(final String s, final Bitmap bitmap, final int n) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final boolean hasAlpha = bitmap.hasAlpha();
        if (hasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        Bitmap$CompressFormat bitmap$CompressFormat;
        if (hasAlpha) {
            bitmap$CompressFormat = Bitmap$CompressFormat.PNG;
        }
        else {
            bitmap$CompressFormat = Bitmap$CompressFormat.JPEG;
        }
        bitmap.compress(bitmap$CompressFormat, n, (OutputStream)byteArrayOutputStream);
        final File d = this.d(this.a.getCacheDir(), s);
        final FileOutputStream f = this.f(d);
        f.write(byteArrayOutputStream.toByteArray());
        f.close();
        return d;
    }
    
    private FileOutputStream f(final File file) {
        return new FileOutputStream(file);
    }
    
    private Bitmap g(final Bitmap bitmap, final int n, final int n2, final boolean b) {
        return Bitmap.createScaledBitmap(bitmap, n, n2, b);
    }
    
    private Bitmap h(final String s, final BitmapFactory$Options bitmapFactory$Options) {
        return BitmapFactory.decodeFile(s, bitmapFactory$Options);
    }
    
    private f i(final String s) {
        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inJustDecodeBounds = true;
        this.h(s, bitmapFactory$Options);
        return new f((float)bitmapFactory$Options.outWidth, (float)bitmapFactory$Options.outHeight);
    }
    
    private File k(final Bitmap bitmap, final Double n, final Double n2, final int n3, final String s) {
        final Bitmap g = this.g(bitmap, n.intValue(), n2.intValue(), false);
        final StringBuilder sb = new StringBuilder();
        sb.append("/scaled_");
        sb.append(s);
        return this.e(sb.toString(), g, n3);
    }
    
    String j(String path, final Double n, final Double n2, final int n3) {
        final f i = this.i(path);
        if (i.b() != -1.0f) {
            if (i.a() != -1.0f) {
                if (n == null && n2 == null && n3 >= 100) {
                    return path;
                }
                try {
                    final String[] split = path.split("/");
                    final String s = split[split.length - 1];
                    final f b = this.b((double)i.b(), (double)i.a(), n, n2);
                    final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
                    bitmapFactory$Options.inSampleSize = this.a(bitmapFactory$Options, (int)b.b(), (int)b.a());
                    final Bitmap h = this.h(path, bitmapFactory$Options);
                    if (h == null) {
                        return path;
                    }
                    final File k = this.k(h, (double)b.b(), (double)b.a(), n3, s);
                    this.c(path, k.getPath());
                    path = k.getPath();
                    return path;
                }
                catch (final IOException ex) {
                    throw new RuntimeException((Throwable)ex);
                }
            }
        }
        return path;
    }
}
